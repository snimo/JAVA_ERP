package com.srn.erp.cip.bm;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;


public class TiposAlimListaBlanca {

	public static final String TIP_ALI_TODOS = "TODOS";
	
	public TiposAlimListaBlanca() {
	}
	
	public static HashTableDatos getTiposAlimentacion() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TIP_ALI_TODOS, "Todos");
		return condiciones;
	}

}
