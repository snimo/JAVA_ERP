package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.CabAsiTarjACobrar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class AnularAsiCobTarj extends Operation { 

  public AnularAsiCobTarj() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    Integer oidCabAsiCob = mapaDatos.getInteger("oid_cab_asi_acob");
    CabAsiTarjACobrar cabAsiento = CabAsiTarjACobrar.findByOid(oidCabAsiCob, this.getSesion());
    cabAsiento.anularAsiento();
  } 

  
}
