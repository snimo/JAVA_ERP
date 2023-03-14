package com.srn.erp.general.op;

import java.io.File;

import org.apache.commons.fileupload.FileItem;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class UploadFileDirBaseServ extends Operation {

	public UploadFileDirBaseServ() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		
		String nombreArchivo = mapaDatos.getString("nuevo_nombre");

		File fNew = new File(mapaDatos.getString("path").trim(), nombreArchivo.trim());

		FileItem fi = null;
		if (mapaDatos.containsKey("archivo"))
			fi = (FileItem) mapaDatos.getObject("archivo");
		if (fi != null) {
			// Quiere decir que enviaron un archivo
			try {
				fi.write(fNew);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null, "Se produjo un error al quere grabar el archivo");
			}
		} else {
			// Se borrer el archivo, porque no se envio nada
			fNew.delete();
		}
		

	}

	private IDataSet getDataSet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRespUpload");
		dataset.fieldDef(new Field("nombre", Field.STRING, 100));
		return dataset;
	}
	
	private void cargarRegistro(IDataSet ds,String nombre) throws BaseException {
		ds.append();
		ds.fieldValue("nombre", nombre);
	}

}
