package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.SolicitudCotizDetPorProv;
import com.srn.erp.compras.bm.SolicitudCotizProvCab;
import com.srn.erp.compras.bm.SolicitudCotizProvDet;
import com.srn.erp.compras.bm.SolicitudCotizProveedor;
import com.srn.erp.compras.da.DBSolicitudCotizDetPorProv;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySolicitudCotizDetPorProv extends FactoryObjetoLogico { 

  public FactorySolicitudCotizDetPorProv() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SolicitudCotizDetPorProv solicitudcotizdetporprov = (SolicitudCotizDetPorProv) objLog;
    solicitudcotizdetporprov.setOID(db.getInteger(DBSolicitudCotizDetPorProv.OID_COTIZ_DET_PROV));
    solicitudcotizdetporprov.setSolicitud_cotiz_prov(SolicitudCotizProveedor.findByOidProxy(db.getInteger(DBSolicitudCotizDetPorProv.OID_SOL_COTIZ_PROV),getSesion()));
    solicitudcotizdetporprov.setSolicitud_cotiz_det(SolicitudCotizProvDet.findByOidProxy(db.getInteger(DBSolicitudCotizDetPorProv.OID_SOL_COTIZ_DET),getSesion()));
    solicitudcotizdetporprov.setCant_a_cotizar(db.getDouble(DBSolicitudCotizDetPorProv.CANT_A_COTIZAR));
    solicitudcotizdetporprov.setOid_um_cpra(UnidadMedida.findByOidProxy(db.getInteger(DBSolicitudCotizDetPorProv.OID_UM_CPRA),getSesion()));
    solicitudcotizdetporprov.setCotizar(db.getBoolean(DBSolicitudCotizDetPorProv.COTIZAR));
    solicitudcotizdetporprov.setObs_art_prov(db.getString(DBSolicitudCotizDetPorProv.OBS_ART_PROV));
    solicitudcotizdetporprov.setSolicitudCotizacion(SolicitudCotizProvCab.findByOidProxy(db.getInteger(DBSolicitudCotizDetPorProv.OID_CCO_SOL_COTIZ),getSesion()));
  }
}
