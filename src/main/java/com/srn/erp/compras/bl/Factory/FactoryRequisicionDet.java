package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.RequisicionCab;
import com.srn.erp.compras.bm.RequisicionDet;
import com.srn.erp.compras.da.DBRequisicionDet;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRequisicionDet extends FactoryObjetoLogico { 

  public FactoryRequisicionDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RequisicionDet requisiciondet = (RequisicionDet) objLog;
   requisiciondet.setOID(db.getInteger(DBRequisicionDet.OID_REQ_DET));
    requisiciondet.setRequisicion(RequisicionCab.findByOidProxy(db.getInteger(DBRequisicionDet.OID_CCO_REQUI),getSesion()));
    requisiciondet.setProducto(Producto.findByOidProxy(db.getInteger(DBRequisicionDet.OID_PRODUCTO),getSesion()));
    requisiciondet.setRenglon(db.getInteger(DBRequisicionDet.NRO_RENGLON));
    requisiciondet.setCant_solicitada(db.getDouble(DBRequisicionDet.CANT_SOLICITADA));
    requisiciondet.setUnidad_medida_req(UnidadMedida.findByOidProxy(db.getInteger(DBRequisicionDet.OID_UM_REQ),getSesion()));
    requisiciondet.setCan_comprada(db.getDouble(DBRequisicionDet.CANT_COMPRADA));
    requisiciondet.setFec_requerida(db.getDate(DBRequisicionDet.FEC_REQUERIDA));
    requisiciondet.setFec_entrega(db.getDate(DBRequisicionDet.FEC_ENTREGA));
    requisiciondet.setDecision_autoriz(db.getInteger(DBRequisicionDet.DECISION_AUTORIZ));
    requisiciondet.setAnulada(db.getBoolean(DBRequisicionDet.ANULADA));
    requisiciondet.setSolo_cotizar(db.getBoolean(DBRequisicionDet.SOLO_COTIZAR));
    requisiciondet.setComentario(db.getString(DBRequisicionDet.COMENTARIO));
    requisiciondet.setDesc_adic_sku(db.getString(DBRequisicionDet.DESC_ADIC_SKU));
    requisiciondet.setPend_sol_cotiz(db.getBoolean(DBRequisicionDet.PEND_SOL_COTIZ));
    requisiciondet.setFec_emision(db.getDate(DBRequisicionDet.FEC_EMISION));
    requisiciondet.setPendCompra(db.getBoolean(DBRequisicionDet.PEND_COMPRA));
    requisiciondet.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBRequisicionDet.OID_PROVEEDOR),getSesion()));
    requisiciondet.setNickNameTipoComproRef(db.getString(DBRequisicionDet.NICKNAME_REF_COMPRO));
    requisiciondet.setOidComproRef(db.getInteger(DBRequisicionDet.OID_CCO_REF));
    requisiciondet.setOidComproRefDet(db.getInteger(DBRequisicionDet.OID_CCO_DET_REF));
    
  }
}
