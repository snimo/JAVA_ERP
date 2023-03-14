package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.DownLoadFile;
import framework.request.bl.Utils.MapDatos;

public class DownLoadLogoRepEval extends Operation {

	public DownLoadLogoRepEval() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		String fileName = EvaluacionLegajoCab.getArchLogoRepEval(this.getSesion());
		DownLoadFile bajaArchivo = new DownLoadFile();
		bajaArchivo.setFileName(fileName);
		bajaArchivo.setFieldPath("");
		bajaArchivo.setHttpServletRequest(this.getHttpServletRequest());
		bajaArchivo.setHttpServletResponse(this.getHttpServletResponse());
		bajaArchivo.setServletContext(this.getServletContext());
		bajaArchivo.downLoad();
	}

}
