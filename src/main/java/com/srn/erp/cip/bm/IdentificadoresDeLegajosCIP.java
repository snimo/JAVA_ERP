package com.srn.erp.cip.bm;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;


public class IdentificadoresDeLegajosCIP {
	
	public static final String IDENTIF_LEGAJO = "IDENTIF_LEGAJO";
	public static final String NRO_TARJETA = "NRO_TARJETA";
	
	public IdentificadoresDeLegajosCIP() {
	}
	
	public static HashTableDatos getIdentificadores() throws BaseException {
		HashTableDatos medios = new HashTableDatos();
		medios.put(IDENTIF_LEGAJO, "ID LEGAJO");
		medios.put(NRO_TARJETA, "NRO. DE TARJETA");
		return medios;
	}
	
	public static String getDescripcion(String codigo) throws BaseException {
		return (String)getIdentificadores().get(codigo);
	}

}
