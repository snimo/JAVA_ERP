package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.SolicitudCotizProvCab;
import com.srn.erp.compras.bm.SolicitudCotizProvDet;
import com.srn.erp.compras.da.DBSolicitudCotizProvDet;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySolicitudCotizProvDet extends FactoryObjetoLogico { 

  public FactorySolicitudCotizProvDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SolicitudCotizProvDet solicitudcotizprovdet = (SolicitudCotizProvDet) objLog;
    solicitudcotizprovdet.setOID(db.getInteger(DBSolicitudCotizProvDet.OID_SOL_COTIZ_DET));
    solicitudcotizprovdet.setSolicitud_cotiz_proveedor(SolicitudCotizProvCab.findByOidProxy(db.getInteger(DBSolicitudCotizProvDet.OID_CCO_SOL_COTIZ),getSesion()));
    solicitudcotizprovdet.setNro_item(db.getInteger(DBSolicitudCotizProvDet.NRO_ITEM));
    solicitudcotizprovdet.setProducto(Producto.findByOidProxy(db.getInteger(DBSolicitudCotizProvDet.OID_PRODUCTO),getSesion()));
    solicitudcotizprovdet.setDesc_adic_sku(db.getString(DBSolicitudCotizProvDet.DESC_ADIC_SKU));
    solicitudcotizprovdet.setFec_entrega(db.getDate(DBSolicitudCotizProvDet.FEC_ENT));
    solicitudcotizprovdet.setCant_requerida(db.getDouble(DBSolicitudCotizProvDet.CANT_REQUERIDA));
    solicitudcotizprovdet.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBSolicitudCotizProvDet.OID_UM),getSesion()));
    solicitudcotizprovdet.setObs_sol_cotiz(db.getString(DBSolicitudCotizProvDet.OBS_SOL_COTIZ));
    solicitudcotizprovdet.setAnulado(db.getBoolean(DBSolicitudCotizProvDet.ANULADO));

  }
}
