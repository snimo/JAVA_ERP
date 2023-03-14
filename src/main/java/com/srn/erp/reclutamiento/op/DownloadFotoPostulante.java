package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluPostulante;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.DownLoadFile;
import framework.request.bl.Utils.MapDatos;

public class DownloadFotoPostulante extends Operation {

	public DownloadFotoPostulante() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		String fileName = "POSTU_"+mapaDatos.getString("file_name").trim();

		DownLoadFile bajaArchivo = new DownLoadFile();
		bajaArchivo.setFieldPath(RecluPostulante.getPathFotoPostulantes(this.getSesion()));
		bajaArchivo.setFileName(fileName);
		bajaArchivo.setHttpServletRequest(this.getHttpServletRequest());
		bajaArchivo.setHttpServletResponse(this.getHttpServletResponse());
		bajaArchivo.setServletContext(this.getServletContext());
		bajaArchivo.downLoad();
		bajaArchivo = null;
	}

}
