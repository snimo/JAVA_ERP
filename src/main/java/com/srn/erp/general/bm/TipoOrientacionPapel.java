package com.srn.erp.general.bm;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class TipoOrientacionPapel  {

  public static String VERTICAL   = "VERTICAL";
  public static String HORIZONTAL = "HORIZONTAL";

  public TipoOrientacionPapel() {
  }

  public static HashTableDatos getTipos() throws BaseException {
    HashTableDatos lista = new HashTableDatos();
    lista.put(VERTICAL,"Vertical");
    lista.put(HORIZONTAL,"Horizontal");
    return lista;
  }


}
