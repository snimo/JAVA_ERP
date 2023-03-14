package com.srn.erp.impuestos.op;

import com.srn.erp.impuestos.bm.SujetoImpositivo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class ValidarCUIT extends Operation {

  public ValidarCUIT() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	String cuit = mapaDatos.getString("cuit");
  	SujetoImpositivo.validarCUIT(cuit);
  	
  }

}
