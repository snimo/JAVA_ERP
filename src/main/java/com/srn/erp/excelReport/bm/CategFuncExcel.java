package com.srn.erp.excelReport.bm;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class CategFuncExcel {
	
	public static final String TODAS = "TODAS";
	public static final String CTAS  = "CTAS_CON";
	public static final String CC_CLIE  = "CTA_CLIE";
	public static final String CC_PROV  = "CTA_PROV";
	
	public static HashTableDatos getCategoriasFunciones() throws BaseException {
		HashTableDatos categorias = new HashTableDatos();
		categorias.put(TODAS, "Todas");
		categorias.put(CTAS, "Cuentas Contables");
		categorias.put(CC_CLIE, "Cta. Cte. Clientes");
		categorias.put(CC_PROV, "Cta. Cte. Proveedores");
		return categorias;
	}
	

}
