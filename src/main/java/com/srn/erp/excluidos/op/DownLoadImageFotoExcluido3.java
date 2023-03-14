package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.IndividuoExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.DownLoadFile;
import framework.request.bl.Utils.MapDatos;

public class DownLoadImageFotoExcluido3 extends Operation {

	public DownLoadImageFotoExcluido3() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String fileName = mapaDatos.getString("file_name").trim();
		
		DownLoadFile bajaArchivo = new DownLoadFile();
		bajaArchivo.setFieldPath(IndividuoExcluido.getPathImagenPrincipalIndividuo(this.getSesion()));
		bajaArchivo.setFileName("FPE_3_"+fileName);
		bajaArchivo.setHttpServletRequest(this.getHttpServletRequest());
		bajaArchivo.setHttpServletResponse(this.getHttpServletResponse());
		bajaArchivo.setServletContext(this.getServletContext());
		bajaArchivo.downLoad();
		
		
		
	}

}
