package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.ctasAPagar.bm.AplicacionComproProvDet;
import com.srn.erp.ctasAPagar.bm.TranProvVto;
import com.srn.erp.ctasAPagar.da.DBAplicacionComproProvDet;
import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAplicacionComproProvDet extends FactoryObjetoLogico {

  public FactoryAplicacionComproProvDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AplicacionComproProvDet aplicacioncomproprovdet = (AplicacionComproProvDet) objLog;
    aplicacioncomproprovdet.setOID(db.getInteger(DBAplicacionComproProvDet.OID_COMPRO_APL_DET));
    aplicacioncomproprovdet.setComprocab(ComproCab.findByOidProxyCompro(db.getInteger(DBAplicacionComproProvDet.OID_CCO),getSesion()));
    aplicacioncomproprovdet.setTranprovvto(TranProvVto.findByOidProxy(db.getInteger(DBAplicacionComproProvDet.OID_TRAN_VTO),getSesion()));
    aplicacioncomproprovdet.setAplicmonedaori(db.getMoney(DBAplicacionComproProvDet.APLIC_MON_ORI));
    aplicacioncomproprovdet.setCotizmonoricont(db.getCotizacion(DBAplicacionComproProvDet.COTIZ_MON_ORI_C));
    aplicacioncomproprovdet.setCotizmonext1cont(db.getCotizacion(DBAplicacionComproProvDet.COTIZ_MON_EXT1_C));
    aplicacioncomproprovdet.setCotizmonext2cont(db.getCotizacion(DBAplicacionComproProvDet.COTIZ_MON_EXT2_C));
    aplicacioncomproprovdet.setCotizmonorihoy(db.getCotizacion(DBAplicacionComproProvDet.COTIZ_MON_ORI_H));
    aplicacioncomproprovdet.setCotizmonext1hoy(db.getCotizacion(DBAplicacionComproProvDet.COTIZ_MON_EXT1_H));
    aplicacioncomproprovdet.setCotizmonext2hoy(db.getCotizacion(DBAplicacionComproProvDet.COTIZ_MON_EXT2_H));
    aplicacioncomproprovdet.setNroRelacion(db.getInteger(DBAplicacionComproProvDet.NRO_RELACION));
    aplicacioncomproprovdet.setComproAplicOri(ComproCab.findByOidProxyCompro(db.getInteger(DBAplicacionComproProvDet.OID_COMPRO_APLIC),getSesion()));
    aplicacioncomproprovdet.setTranprovvtoAplic(TranProvVto.findByOidProxy(db.getInteger(DBAplicacionComproProvDet.OID_TRAN_VTO_APLIC),getSesion()));
  }
}
