package com.srn.erp.tesoreria.bm;

import java.util.Hashtable;

public class TiposCierreAperturaCaja  {

  public static final String MANUAL = "MANUAL";
  public static final String AUTOMATICO = "AUTO";

  private Hashtable tipos = new Hashtable();

  public TiposCierreAperturaCaja() {
    tipos.put(MANUAL,"Manual");
    tipos.put(AUTOMATICO,"Automático");
  }

  public Hashtable getTipos() {
    return tipos;
  }


}
