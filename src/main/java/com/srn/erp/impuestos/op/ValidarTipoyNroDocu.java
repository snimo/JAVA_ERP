package com.srn.erp.impuestos.op;

import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class ValidarTipoyNroDocu extends Operation {

  public ValidarTipoyNroDocu() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	TipoDocumento tipoDocu = 
  		TipoDocumento.findByOidProxy(mapaDatos.getInteger("oid_tipo_docu"),this.getSesion());
  	
  	if (tipoDocu.isCUIL() || tipoDocu.isCUIT()) {
  	  String cuit = mapaDatos.getString("nro_documento");
  	  SujetoImpositivo.validarCUIT(cuit);
  	} 
  	
  }

}
