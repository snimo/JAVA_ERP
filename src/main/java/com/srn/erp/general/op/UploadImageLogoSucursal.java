package com.srn.erp.general.op;

import java.io.File;

import org.apache.commons.fileupload.FileItem;

import com.srn.erp.general.bm.Sucursal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class UploadImageLogoSucursal extends Operation {

	public UploadImageLogoSucursal() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String nombreArchivo = mapaDatos.getString("nuevo_nombre");
		File fNew = new File(
				Sucursal.getPathLogoSucursal(this.getSesion()),
				nombreArchivo.trim());

		FileItem fi = null;
		if (mapaDatos.containsKey("archivo"))
			fi = (FileItem) mapaDatos.getObject("archivo");
		if (fi != null) {
			// Quiere decir que enviaron un archivo
			try {
				fi.write(fNew);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Se produjo un error al quere grabar el archivo");
			}
		} else {
			// Se borrer el archivo, porque no se envio nada
			fNew.delete();
		}
		

	}

}
