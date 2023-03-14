package com.srn.erp.sueldos.op;

import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.DownLoadFile;
import framework.request.bl.Utils.MapDatos;

public class DownLoadImageLegajo extends Operation {

	public DownLoadImageLegajo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String fileName = mapaDatos.getString("file_name").trim();
		String extension = Legajo.getExtensionImagenLegajo(this.getSesion());
		
		DownLoadFile bajaArchivo = new DownLoadFile();
		bajaArchivo.setFieldPath(Legajo.getPathImagenesLegajo(this.getSesion()));
		
		if (extension.equals(""))
			bajaArchivo.setFileName(fileName);
		else
			bajaArchivo.setFileName(fileName+"."+extension);
		
		bajaArchivo.setHttpServletRequest(this.getHttpServletRequest());
		bajaArchivo.setHttpServletResponse(this.getHttpServletResponse());
		bajaArchivo.setServletContext(this.getServletContext());
		bajaArchivo.downLoad();
		
		
		
	}

}
