package com.srn.erp.ctasACobrar.bl.Factory;

import com.srn.erp.ctasACobrar.bm.AplicacionComproClieDet;
import com.srn.erp.ctasACobrar.bm.TranClieVto;
import com.srn.erp.ctasACobrar.da.DBAplicacionComproClieDet;
import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAplicacionComproClieDet extends FactoryObjetoLogico {

  public FactoryAplicacionComproClieDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AplicacionComproClieDet aplicacioncomprocliedet = (AplicacionComproClieDet) objLog;
    aplicacioncomprocliedet.setOID(db.getInteger(DBAplicacionComproClieDet.OID_COMPRO_APL_DET));
    aplicacioncomprocliedet.setComprocab(ComproCab.findByOidProxyCompro(db.getInteger(DBAplicacionComproClieDet.OID_CCO),getSesion()));
    aplicacioncomprocliedet.setTranClieVto(TranClieVto.findByOidProxy(db.getInteger(DBAplicacionComproClieDet.OID_TRAN_VTO),getSesion()));
    aplicacioncomprocliedet.setAplicmonedaori(db.getMoney(DBAplicacionComproClieDet.APLIC_MON_ORI));
    aplicacioncomprocliedet.setCotizmonoricont(db.getCotizacion(DBAplicacionComproClieDet.COTIZ_MON_ORI_C));
    aplicacioncomprocliedet.setCotizmonext1cont(db.getCotizacion(DBAplicacionComproClieDet.COTIZ_MON_EXT1_C));
    aplicacioncomprocliedet.setCotizmonext2cont(db.getCotizacion(DBAplicacionComproClieDet.COTIZ_MON_EXT2_C));
    aplicacioncomprocliedet.setCotizmonorihoy(db.getCotizacion(DBAplicacionComproClieDet.COTIZ_MON_ORI_H));
    aplicacioncomprocliedet.setCotizmonext1hoy(db.getCotizacion(DBAplicacionComproClieDet.COTIZ_MON_EXT1_H));
    aplicacioncomprocliedet.setCotizmonext2hoy(db.getCotizacion(DBAplicacionComproClieDet.COTIZ_MON_EXT2_H));
    aplicacioncomprocliedet.setNroRelacion(db.getInteger(DBAplicacionComproClieDet.NRO_RELACION));
    aplicacioncomprocliedet.setComproAplicOri(ComproCab.findByOidProxyCompro(db.getInteger(DBAplicacionComproClieDet.OID_COMPRO_APLIC),getSesion()));
    aplicacioncomprocliedet.setTranClieVtoAplic(TranClieVto.findByOidProxy(db.getInteger(DBAplicacionComproClieDet.OID_TRAN_VTO_APLIC),getSesion()));
  }
}
