package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.PedidoDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class ValidarBajaItemPedido extends Operation {

  public ValidarBajaItemPedido() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  Integer oidPedDet = mapaDatos.getInteger("oid_ped_det");
	  if (oidPedDet == null) return;
	  if (oidPedDet.intValue()<=0) return;
	  
	  PedidoDet pedidoDet = PedidoDet.findByOid(oidPedDet, this.getSesion());
	  pedidoDet.validarBajaItem();
	
  }

}
