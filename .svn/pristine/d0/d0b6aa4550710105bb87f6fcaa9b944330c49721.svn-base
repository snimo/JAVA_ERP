package com.srn.erp.general.op;

import com.srn.erp.general.bm.Empresa;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.DownLoadFile;
import framework.request.bl.Utils.MapDatos;

public class DownLoadImageLogoEmpresa extends Operation {

	public DownLoadImageLogoEmpresa() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String fileName = mapaDatos.getString("file_name").trim();
		
		DownLoadFile bajaArchivo = new DownLoadFile();
		bajaArchivo.setFieldPath(Empresa.getPathLogoEmpresa(this.getSesion()));
		bajaArchivo.setFileName(fileName);
		bajaArchivo.setHttpServletRequest(this.getHttpServletRequest());
		bajaArchivo.setHttpServletResponse(this.getHttpServletResponse());
		bajaArchivo.setServletContext(this.getServletContext());
		bajaArchivo.downLoad();
		
		
		
	}

}
