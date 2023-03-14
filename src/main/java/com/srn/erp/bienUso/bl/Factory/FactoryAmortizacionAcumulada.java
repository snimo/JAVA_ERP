package com.srn.erp.bienUso.bl.Factory;

import com.srn.erp.bienUso.bm.AmortizacionAcumulada;
import com.srn.erp.bienUso.bm.SistemaValuacion;
import com.srn.erp.bienUso.da.DBAmortizacionAcumulada;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAmortizacionAcumulada extends FactoryObjetoLogico { 

  public FactoryAmortizacionAcumulada() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AmortizacionAcumulada amortizacionAcumulada = (AmortizacionAcumulada) objLog;
    amortizacionAcumulada.setOID(db.getInteger(DBAmortizacionAcumulada.OID_BIEN_ALTA));
    amortizacionAcumulada.setSistema_valuacion(SistemaValuacion.findByOidProxy(db.getInteger(DBAmortizacionAcumulada.OID_SIST_VAL),getSesion()));
    amortizacionAcumulada.setAmortizacionAcumuada(db.getMoney(DBAmortizacionAcumulada.AMORT_ACUM));
  }
}
