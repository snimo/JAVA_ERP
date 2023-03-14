package com.srn.erp.excelReport.op;

import com.srn.erp.excelReport.bm.ExcelReport;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.DownLoadFile;
import framework.request.bl.Utils.MapDatos;

public class DownLoadExcelReport extends Operation {

	public DownLoadExcelReport() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String fileName = mapaDatos.getString("file_name").trim();
		
		DownLoadFile bajaArchivo = new DownLoadFile();
		bajaArchivo.setHttpServletRequest(this.getHttpServletRequest());
		bajaArchivo.setHttpServletResponse(this.getHttpServletResponse());
		bajaArchivo.setServletContext(this.getServletContext());
		bajaArchivo.setFieldPath(ExcelReport.getPathAlmacenamientoServidor(this.getSesion()));
		bajaArchivo.setFileName(fileName);
		
		if (bajaArchivo.fileExist()) {
			bajaArchivo.downLoad();
			return;
		}
		
	}

}
