package com.srn.erp.excluidos.op;

import java.io.File;

import org.apache.commons.fileupload.FileItem;

import com.srn.erp.excluidos.bm.IndividuoExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class UploadFotoRelExc4 extends Operation {

	public UploadFotoRelExc4() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String nombreArchivo = "RE_4_"+mapaDatos.getString("nuevo_nombre");
		File fNew = new File(IndividuoExcluido.getPathImagenPrincipalIndividuo(this.getSesion()), nombreArchivo);

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
