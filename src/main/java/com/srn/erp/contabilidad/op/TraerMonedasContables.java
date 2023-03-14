package com.srn.erp.contabilidad.op;

import com.srn.erp.general.bm.Moneda;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class TraerMonedasContables extends Operation {

  public TraerMonedasContables() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    writeCliente(Moneda.getLas3MonedasContablesMasTodos(getSesion()));
  }
}
