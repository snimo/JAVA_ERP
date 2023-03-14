package com.srn.erp.cip.bm;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;


public class ModosFuncPlacaCIP {
	
	public static final Integer NORMAL = new Integer(0);
	public static final Integer LIBERADO = new Integer(1);
	public static final Integer PANICO = new Integer(2);
	public static final Integer BLOQUEADO = new Integer(3);
	
	public ModosFuncPlacaCIP() {
	}
	
	public static HashTableDatos getModosFuncPlacaCIP() throws BaseException {
		HashTableDatos modos = new HashTableDatos();
		modos.put(NORMAL, "Normal");
		modos.put(LIBERADO, "Liberado");
		modos.put(PANICO, "Pánico");
		modos.put(BLOQUEADO, "Bloqueado");
		return modos;
	}

}
