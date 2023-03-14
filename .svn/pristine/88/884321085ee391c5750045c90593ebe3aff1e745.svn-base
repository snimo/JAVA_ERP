package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.InformeControlCalidad;
import com.srn.erp.compras.bm.InformeControlCalidadDet;
import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.compras.da.DBInformeControlCalidadDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryInformeControlCalidadDet extends FactoryObjetoLogico { 

  public FactoryInformeControlCalidadDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    InformeControlCalidadDet informecontrolcalidaddet = (InformeControlCalidadDet) objLog;
    informecontrolcalidaddet.setOID(db.getInteger(DBInformeControlCalidadDet.OID_CC_DET));
    informecontrolcalidaddet.setInforme_cc(InformeControlCalidad.findByOidProxy(db.getInteger(DBInformeControlCalidadDet.OID_CC),getSesion()));
    informecontrolcalidaddet.setInforme_recepcion_det(InformeRecepcionDet.findByOidProxy(db.getInteger(DBInformeControlCalidadDet.OID_INF_REC_DET),getSesion()));
    informecontrolcalidaddet.setCant_ok_us(db.getDouble(DBInformeControlCalidadDet.CANT_OK_US));
    informecontrolcalidaddet.setCant_ok_uc(db.getDouble(DBInformeControlCalidadDet.CANT_OK_UC));
    informecontrolcalidaddet.setCant_mal_us(db.getDouble(DBInformeControlCalidadDet.CANT_MAL_US));
    informecontrolcalidaddet.setCant_mal_uc(db.getDouble(DBInformeControlCalidadDet.CANT_MAL_UC));
    informecontrolcalidaddet.setObservaciones(db.getString(DBInformeControlCalidadDet.OBSERVACIONES));
    informecontrolcalidaddet.setCant_ret_prov_uc(db.getDouble(DBInformeControlCalidadDet.CANT_RET_PROV_UC));
    informecontrolcalidaddet.setCant_ret_prov_us(db.getDouble(DBInformeControlCalidadDet.CANT_RET_PROV_US));
    informecontrolcalidaddet.setPend_ret_prov(db.getBoolean(DBInformeControlCalidadDet.PEND_RET_PROV));
    informecontrolcalidaddet.setAnulado(db.getBoolean(DBInformeControlCalidadDet.ANULADO));

  }
}
