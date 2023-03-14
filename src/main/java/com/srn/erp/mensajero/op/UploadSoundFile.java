package com.srn.erp.mensajero.op;

import java.io.File;

import org.apache.commons.fileupload.FileItem;

import com.srn.erp.mensajero.bm.Ring;

import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class UploadSoundFile extends Operation {

	public UploadSoundFile() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		String nombreArchivo = mapaDatos.getString("nuevo_nombre");
		
		String path = Ring.getPathArchivos(this.getSesion());		
		
		File fNew = new File(path, nombreArchivo);

		FileItem fi = null;
		if (mapaDatos.containsKey("archivo"))
			fi = (FileItem) mapaDatos.getObject("archivo");
		if (fi != null) {
			// Quiere decir que enviaron un archivo
			try {
				fi.write(fNew);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null, "Se produjo un error al querer grabar el archivo");
			}
		} else {
			// Se borrer el archivo, porque no se envio nada
			fNew.delete();
		}

	}

}
