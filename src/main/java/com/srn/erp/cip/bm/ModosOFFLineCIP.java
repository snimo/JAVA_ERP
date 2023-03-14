package com.srn.erp.cip.bm;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class ModosOFFLineCIP {

	public static final Integer BLOQUEADO = 0;
	public static final Integer PANICO = 1;
	public static final Integer LISTA_BLANCA = 2;
	public static final Integer LISTA_NEGRA = 3;
	public static final Integer LIBERADO = 4;
	
	public static HashTableDatos getModos() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(BLOQUEADO, "Bloqueado");
		condiciones.put(PANICO, "Pánico");
		condiciones.put(LISTA_BLANCA, "Lista Blanca");
		condiciones.put(LISTA_NEGRA, "Lista Negra");
		condiciones.put(LIBERADO, "Liberado");
		return condiciones;
	}

}