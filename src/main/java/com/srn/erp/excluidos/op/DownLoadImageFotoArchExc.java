package com.srn.erp.excluidos.op;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.DownLoadFile;
import framework.request.bl.Utils.MapDatos;

public class DownLoadImageFotoArchExc extends Operation {
	
	public static int i = 0;
	
	public DownLoadImageFotoArchExc() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String fileName = mapaDatos.getString("file_name").trim();
		
		DownLoadFile bajaArchivo = new DownLoadFile();
		//bajaArchivo.setFieldPath(IndividuoExcluido.getPathImagenPrincipalIndividuo(this.getSesion()));
		bajaArchivo.setFieldPath(this.getServicios().getValueParameter("PATH_IMAGEN_INDI_EXC"));
		bajaArchivo.setFileName(fileName);
		bajaArchivo.setHttpServletRequest(this.getHttpServletRequest());
		bajaArchivo.setHttpServletResponse(this.getHttpServletResponse());
		bajaArchivo.setServletContext(this.getServletContext());
		bajaArchivo.downLoad();
		bajaArchivo = null;
		
		++i;
		
		if (i>50) {
			i = 0;
			System.gc();
		}
		
	}

}
