package com.srn.erp.ctasAPagar.op;

import com.srn.erp.ctasAPagar.bm.AplicacionComproProv;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class AnularAplicacionComproProveedor extends Operation {

  public AnularAplicacionComproProveedor() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  Integer oidCCO = mapaDatos.getInteger("oid_cco");
	  AplicacionComproProv aplicComproProv =
		  AplicacionComproProv.findByOid(oidCCO, this.getSesion());
	  aplicComproProv.setActivo(false);
	  aplicComproProv.delete();
	  this.addTransaccion(aplicComproProv);
  	
  }
  


}
