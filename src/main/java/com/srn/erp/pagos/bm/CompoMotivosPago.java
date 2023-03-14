package com.srn.erp.pagos.bm;

import java.util.Hashtable;

import framework.request.bl.Utils.BaseException;

public class CompoMotivosPago  {

  private Hashtable comportamientos = new Hashtable();

  public static final String PAGO_A_PROV  = "PROV";
  public static final String PAGOS_VARIOS = "VARIOS";

  public CompoMotivosPago() {
    comportamientos = new Hashtable();
    comportamientos.put(PAGO_A_PROV,"Pago a Proveedores");
    comportamientos.put(PAGOS_VARIOS,"Pagos Varios");
  }

  public Hashtable getComportamientos() throws BaseException {
    return comportamientos;
  }


}
