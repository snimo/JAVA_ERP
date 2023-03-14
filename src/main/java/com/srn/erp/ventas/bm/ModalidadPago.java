package com.srn.erp.ventas.bm;

import java.util.Hashtable;

import framework.request.bl.Utils.BaseException;

public class ModalidadPago  {

  public static final String DEB_AUT = "DEB_AUT";
  public static final String CONTADO = "CONTADO";
  public static final String CTA_CTE = "CTA_CTE";

  public static final String DESC_DEB_AUT = "Débito Automático";
  public static final String DESC_CONTADO = "Contado";
  public static final String DESC_CTA_CTE = "Cuenta Corriente";


  public ModalidadPago() {
  }

  public static Hashtable getModalidades() throws BaseException {
    Hashtable lista = new Hashtable();
    lista.put(DEB_AUT,DESC_DEB_AUT);
    lista.put(CONTADO,DESC_CONTADO);
    lista.put(CTA_CTE,DESC_CTA_CTE);
    return lista;
  }


}
