package com.srn.erp.cip.bm;

import framework.request.bl.Utils.HashTableDatos;

public class TiposSalidasRotas {

  public static String LIBRE = "LIBRE";
  public static String NO_EGRESA = "NO_EGRESA";
  public static String SEGUN_HORARIO = "SEGUN_HORARIO";
  
  public static HashTableDatos getTiposSalidas()  {
	  HashTableDatos cond = new HashTableDatos();
	  cond.put(LIBRE,"Libre");
	  cond.put(NO_EGRESA,"No Egresa");
	  cond.put(SEGUN_HORARIO,"Según Rota");
	  return cond;
  }
	
}
