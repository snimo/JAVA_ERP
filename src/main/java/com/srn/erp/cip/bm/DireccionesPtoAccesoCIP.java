package com.srn.erp.cip.bm;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;


public class DireccionesPtoAccesoCIP {
	
	public static final Integer SALIDA = 0;
	public static final Integer ENTRADA = 1;
	
	public DireccionesPtoAccesoCIP() {
	}
	
	public static HashTableDatos getDirecciones() throws BaseException {
		HashTableDatos direcciones = new HashTableDatos();
		direcciones.put(SALIDA, "Salida");
		direcciones.put(ENTRADA, "Entrada");
		return direcciones;
	}

}
