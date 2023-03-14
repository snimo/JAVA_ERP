package com.srn.erp.stock.op;

import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.stock.bm.ExtensionProdGen;
import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.DownLoadFile;
import framework.request.bl.Utils.MapDatos;

public class DownLoadImageProductoAsig extends Operation {

	public DownLoadImageProductoAsig() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String fileName = mapaDatos.getString("file_name").trim();
		
		DownLoadFile bajaArchivo = new DownLoadFile();
		bajaArchivo.setHttpServletRequest(this.getHttpServletRequest());
		bajaArchivo.setHttpServletResponse(this.getHttpServletResponse());
		bajaArchivo.setServletContext(this.getServletContext());
		bajaArchivo.setFieldPath(Producto.getPathImagenesProducto(this.getSesion()));
		bajaArchivo.setFileName(fileName);
		
		if (bajaArchivo.fileExist()) {
			bajaArchivo.downLoad();
			return;
		}
		
		// Buscar imagen del clasificador
		Producto producto = Producto.findByOidProxy(new Integer(fileName), this.getSesion());
		
		ValorClasifEntProdGen valClasifProdGen = producto.getValorClasifProdGen();
		
		if (valClasifProdGen == null) return;
		
		bajaArchivo.setFieldPath(ExtensionProdGen.getPathImagenesProducto(this.getSesion()));
		bajaArchivo.setFileName(valClasifProdGen.getOIDInteger().toString());
		if (bajaArchivo.fileExist()) 
			bajaArchivo.downLoad();
		
	}

}
