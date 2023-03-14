package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.compras.bm.InformeControlCalidadDet;
import com.srn.erp.compras.bm.MotivoRechazoCC;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.stock.bm.PedMercDepoDet;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.CompoStkTalonarioRto;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.RemitoDet;
import com.srn.erp.ventas.da.DBRemitoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRemitoDet extends FactoryObjetoLogico {

  public FactoryRemitoDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RemitoDet remitodet = (RemitoDet) objLog;
    remitodet.setOID(db.getInteger(DBRemitoDet.OID_REMITO_DET));
    remitodet.setRemito_cab(RemitoCab.findByOidProxy(db.getInteger(DBRemitoDet.OID_REMITO_CAB),getSesion()));
    remitodet.setProducto(Producto.findByOidProxy(db.getInteger(DBRemitoDet.OID_PRODUCTO),getSesion()));
    remitodet.setCant_desp(db.getDouble(DBRemitoDet.CANT_DESP));
    remitodet.setCant_fact(db.getDouble(DBRemitoDet.CANT_FACT));
    remitodet.setPend_fact(db.getBoolean(DBRemitoDet.PEND_FACT));
    remitodet.setUnidad_desp(UnidadMedida.findByOidProxy(db.getInteger(DBRemitoDet.OID_UM_DESP),getSesion()));
    remitodet.setComentario(db.getString(DBRemitoDet.COMENTARIO));
    remitodet.setCompoStkTalonarioRto(CompoStkTalonarioRto.findByOidProxy(db.getInteger(DBRemitoDet.OID_COMPO_STK_RTO),getSesion()));
    remitodet.setActivo(db.getBoolean(DBRemitoDet.ACTIVO));
    remitodet.setPedidoDet(PedidoDet.findByOidProxy(db.getInteger(DBRemitoDet.OID_PED_DET),getSesion()));
    remitodet.setInformeControlCalidadDet(InformeControlCalidadDet.findByOidProxy(db.getInteger(DBRemitoDet.OID_CC_DET),getSesion()));
    remitodet.setCant_NC(db.getDouble(DBRemitoDet.CANT_NC));
    remitodet.setMotivoDevolucion(MotivoRechazoCC.findByOidProxy(db.getInteger(DBRemitoDet.OID_MOTIVO_DEVOLUCION),getSesion()));
    remitodet.setOCDetPorDevolucion(OrdenDeCompraDet.findByOidProxy(db.getInteger(DBRemitoDet.OC_DET_POR_DEVOLUCION),getSesion()));
    remitodet.setCantDevuelta(db.getDouble(DBRemitoDet.CANT_DEVUELTA));
    remitodet.setPedidoDepositoDet(PedMercDepoDet.findByOidProxy(db.getInteger(DBRemitoDet.OID_PEDIDO_DEPO_DET),getSesion()));
    remitodet.setCantRecep(db.getDouble(DBRemitoDet.CANT_RECEP));
    remitodet.setPendRecep(db.getBoolean(DBRemitoDet.PEND_RECEP));
  }
}
