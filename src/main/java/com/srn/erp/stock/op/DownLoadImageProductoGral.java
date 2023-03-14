package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.ExtensionProdGen;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.DownLoadFile;
import framework.request.bl.Utils.MapDatos;

public class DownLoadImageProductoGral extends Operation {

	public DownLoadImageProductoGral() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String fileName = mapaDatos.getString("file_name").trim();
		
		DownLoadFile bajaArchivo = new DownLoadFile();
		bajaArchivo.setFieldPath(ExtensionProdGen.getPathImagenesProducto(this.getSesion()));
		bajaArchivo.setFileName(fileName);
		bajaArchivo.setHttpServletRequest(this.getHttpServletRequest());
		bajaArchivo.setHttpServletResponse(this.getHttpServletResponse());
		bajaArchivo.setServletContext(this.getServletContext());
		bajaArchivo.downLoad();
		
		
		
	}

}
