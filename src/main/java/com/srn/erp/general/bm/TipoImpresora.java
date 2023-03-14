package com.srn.erp.general.bm;

import java.util.ArrayList;
import java.util.List;

import framework.request.bl.Utils.BaseException;

public class TipoImpresora  {

  public static String COMUN = "Comun";
  public static String FISCAL = "Fiscal";

  public TipoImpresora() {
  }

  public static List getTipos() throws BaseException {
    List lista = new ArrayList();
    lista.add(COMUN);
    lista.add(FISCAL);
    return lista;
  }


}
