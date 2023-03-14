package com.srn.erp.impuestos.op;

import java.io.File;
import java.util.Iterator;

import org.apache.commons.fileupload.FileItem;

import com.srn.erp.impuestos.bm.GrabarTablaPercIBBsAs;
import com.srn.erp.ventas.bm.TablaPercIBBsAs;

import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class UploadFilePercIBBsAs extends Operation {

	public UploadFilePercIBBsAs() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String nombreArchivo = mapaDatos.getString("nuevo_nombre");
		boolean importarSoloClientes = false;
		if (mapaDatos.containsKey("importar_solo_clientes"))
			importarSoloClientes = true;
			
		
		String path =
			ValorParametro.findByCodigoParametro(
					"FILE_NAME_IIBBBSAS ", this.getSesion()).getValorCadena();		
		
		File fNew = new File(
				path,
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
		
		GrabarTablaPercIBBsAs grabarTabla = new GrabarTablaPercIBBsAs();
		grabarTabla.setSesion(this.getSesion());
		grabarTabla.setArchivo(nombreArchivo);
		grabarTabla.setImportarSoloClientes(importarSoloClientes);
		grabarTabla.comenzarImportacion();
		
		
	}



}
