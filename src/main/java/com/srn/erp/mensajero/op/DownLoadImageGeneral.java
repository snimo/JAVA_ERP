package com.srn.erp.mensajero.op;

import com.srn.erp.mensajero.bm.Imagen;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.DownLoadFile;
import framework.request.bl.Utils.MapDatos;

public class DownLoadImageGeneral extends Operation {

	public DownLoadImageGeneral() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String fileName = mapaDatos.getString("file_name").trim();
		
		DownLoadFile bajaArchivo = new DownLoadFile();
		
		if (mapaDatos.containsKey("path_archivo"))
			bajaArchivo.setFieldPath(mapaDatos.getString("path_archivo"));
		else
			bajaArchivo.setFieldPath(Imagen.getPathArchivos(this.getSesion()));
		
		
		bajaArchivo.setFileName(fileName);
		bajaArchivo.setHttpServletRequest(this.getHttpServletRequest());
		bajaArchivo.setHttpServletResponse(this.getHttpServletResponse());
		bajaArchivo.setServletContext(this.getServletContext());
		bajaArchivo.downLoad();
		
		
		
	}

}
