package com.srn.erp.cip.bm;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class TipoPermisoCIP {

	public static final String TP_PERMITIDO = "PERMITIDO";
	public static final String TP_DENEGADO = "DENEGADO";
	public static final String TP_SEGUN_PLANIF = "SEGUN_PLANIF";

	public static HashTableDatos getTipoPermisos() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TP_PERMITIDO, "Permitir Siempre");
		condiciones.put(TP_DENEGADO, "Denegado");
		condiciones.put(TP_SEGUN_PLANIF, "Según Planificación");
		return condiciones;
	}

}