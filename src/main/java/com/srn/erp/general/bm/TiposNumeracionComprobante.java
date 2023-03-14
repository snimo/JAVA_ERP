package com.srn.erp.general.bm;

import java.util.Hashtable;

public class TiposNumeracionComprobante  {

  private Hashtable listaTiposNumeracion = new Hashtable();
  public static final String MANUAL     = "MANU";
  public static final String AUTOMATICA = "AUTO";

  public TiposNumeracionComprobante() {
    listaTiposNumeracion.put(MANUAL,"Manual");
    listaTiposNumeracion.put(AUTOMATICA,"Automática");
  }

  public Hashtable getListaTiposNumeracion() {
    return listaTiposNumeracion;
  }

}
