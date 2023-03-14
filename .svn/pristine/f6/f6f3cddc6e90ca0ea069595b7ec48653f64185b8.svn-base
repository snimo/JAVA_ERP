package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.ventas.bm.AplicDespachoPedido;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.da.DBAplicDespachoPedido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAplicDespachoPedido extends FactoryObjetoLogico { 

  public FactoryAplicDespachoPedido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AplicDespachoPedido aplicdespachopedido = (AplicDespachoPedido) objLog;
    aplicdespachopedido.setOID(db.getInteger(DBAplicDespachoPedido.OID_PED_ENT));
    aplicdespachopedido.setPedido_detalle(PedidoDet.findByOidProxy(db.getInteger(DBAplicDespachoPedido.OID_PED_DET),getSesion()));
    aplicdespachopedido.setCant_desp(db.getDouble(DBAplicDespachoPedido.CANT_DESP));
    aplicdespachopedido.setComportamiento_compro(db.getString(DBAplicDespachoPedido.COMPO_COMPRO));
    aplicdespachopedido.setComprobante_entrega(ComproCab.findByOidProxyCompro(db.getInteger(DBAplicDespachoPedido.OID_CCO_ENT),getSesion()));
    aplicdespachopedido.setOid_detalle_compro(db.getInteger(DBAplicDespachoPedido.OID_CCO_DET_ENT));
    aplicdespachopedido.setActivo(db.getBoolean(DBAplicDespachoPedido.ACTIVO));

  }
}
