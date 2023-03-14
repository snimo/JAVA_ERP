package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.CuentaImputable;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class ValidarCtaImpSinSubSistema extends Operation {

  public ValidarCtaImpSinSubSistema() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    String codigo = mapaDatos.getString("codigo");
    CuentaImputable cuentaImputable = CuentaImputable.findByCodigo(codigo,getSesion());
    if (cuentaImputable!=null) {
      if (cuentaImputable.getCuenta().isEsctainterna().booleanValue())
        throw new ExceptionValidation(null,"La cuenta ingresada no puede utilizarse debido a que pertenece a un subsistema.");
    }
  }

}
