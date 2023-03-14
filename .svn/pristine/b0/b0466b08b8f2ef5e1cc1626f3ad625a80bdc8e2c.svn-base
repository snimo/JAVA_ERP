package com.srn.erp.ctasACobrar.op;

import com.srn.erp.ctasACobrar.bm.AplicacionComproClie;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class AnularAplicacionComproCliente extends Operation {

  public AnularAplicacionComproCliente() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  Integer oidCCO = mapaDatos.getInteger("oid_cco");
	  AplicacionComproClie aplicComproClie =
		  AplicacionComproClie.findByOid(oidCCO, this.getSesion());
	  aplicComproClie.setActivo(false);
	  aplicComproClie.delete();
	  this.addTransaccion(aplicComproClie);
  	
  }
  


}
