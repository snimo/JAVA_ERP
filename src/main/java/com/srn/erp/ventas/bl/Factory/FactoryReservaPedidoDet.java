package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.ReservaPedidoDet;
import com.srn.erp.ventas.da.DBPedidoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryReservaPedidoDet extends FactoryObjetoLogico {

  public FactoryReservaPedidoDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ReservaPedidoDet reservaPedidodet = (ReservaPedidoDet) objLog;
    reservaPedidodet.setOID(db.getInteger(DBPedidoDet.OID_PED_DET));
    reservaPedidodet.setCant_um_ori_res(db.getDecimal(DBPedidoDet.CANT_UM_ORI_RES));    
    
  }
}
