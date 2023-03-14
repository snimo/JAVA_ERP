package com.srn.erp.cip.bm;

import framework.request.bl.Utils.HashTableDatos;

public class TiposEntradasRotas {

  public static String PERMITIDO = "PERMITIDO";
  public static String DENEGADO = "DENEGADO";
  public static String SEGUN_HORARIO = "SEGUN_HORARIO";
  
  public static HashTableDatos getTiposEntradas()  {
	  HashTableDatos cond = new HashTableDatos();
	  cond.put(PERMITIDO,"Permitido");
	  cond.put(DENEGADO,"Denegado");
	  cond.put(SEGUN_HORARIO,"Según Rota");
	  return cond;
  }
	
}
