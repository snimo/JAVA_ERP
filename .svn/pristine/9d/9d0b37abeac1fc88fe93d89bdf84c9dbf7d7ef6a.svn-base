package com.srn.erp.contabilidad.bm;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class SubsistemasContables {

  public static final String COMPRAS = "COMPRAS";
  public static final String VENTAS  = "VENTAS";
  public static final String PAGOS   = "PAGOS";
  public static final String BANCOS  = "BANCOS";
  public static final String BUSO  = "BUSO";

  private HashTableDatos subsistemas = new HashTableDatos();

  public SubsistemasContables() {
    subsistemas.put(COMPRAS,"Compras");
    subsistemas.put(VENTAS,"Ventas");
    subsistemas.put(PAGOS,"Pagos");
    subsistemas.put(BANCOS,"Bancos");
    subsistemas.put(BUSO,"Bienes de Uso");
  }

  public HashTableDatos getSubsistemas() throws BaseException {
    return subsistemas;
  }


}
