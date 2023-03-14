package com.srn.erp.costos.bm;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class FormaCalcCosto {
	
	public static final String LP_PROV = "LP";
	public static final String PRECIO_UC = "UOC";
	public static final String COSTO_MANUAL = "MANUAL";
	public static final String LP_PROV_PRECIO_UC = "LP_UOC";
	public static final String LP_PROV_FACT_PROV = "LP_FP";
	public static final String FACT_PROV = "FP";
	
	
	public static HashTableDatos getFormasCalcCostos() throws BaseException {
		HashTableDatos formas = new HashTableDatos();
		formas.put(LP_PROV, "Lista de Precios Vigente Proveedor");
		formas.put(PRECIO_UC, "Ultima Orden de Compra");
		formas.put(FACT_PROV,"Ultima Factura Proveedor");
		formas.put(COSTO_MANUAL, "El costo se ingresa manual");
		formas.put(LP_PROV_PRECIO_UC,"L.P. Vig. Prov. / Ultima O.C.");
		formas.put(LP_PROV_FACT_PROV,"L.P. Vig. Prov. / Ult. Fact. Proveedor");
		
		return formas;
	}
	
	public static boolean isListaAcuerdoProveedor(String aFormaCalc) throws BaseException {
		if (aFormaCalc.equals(LP_PROV))
			return true;
		else
			return false;
	}
	
	public static boolean isPrecioUltimaCompra(String aFormaCalc) throws BaseException {
		if (aFormaCalc.equals(PRECIO_UC))
			return true;
		else
			return false;
	}
	
	public static boolean isPrecioUltimaCompra_ListaAcuerdoProv(String aFormaCalc) throws BaseException {
		if (aFormaCalc.equals(LP_PROV_PRECIO_UC))
			return true;
		else
			return false;
	}
	
	public static boolean isFacturaProveedor(String aFormaCalc) throws BaseException {
		if (aFormaCalc.equals(FACT_PROV))
			return true;
		else
			return false;
	}
	
	public static boolean isFacturaProveedorLPAcuerdoProv(String aFormaCalc) throws BaseException {
		if (aFormaCalc.equals(LP_PROV_FACT_PROV))
			return true;
		else
			return false;
	}
	
	
		

}
