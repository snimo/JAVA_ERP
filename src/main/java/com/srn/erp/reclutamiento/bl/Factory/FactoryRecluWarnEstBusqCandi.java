package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluEstCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluEstadoProceso;
import com.srn.erp.reclutamiento.bm.RecluWarnEstBusqCandi;
import com.srn.erp.reclutamiento.da.DBRecluWarnEstBusqCandi;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluWarnEstBusqCandi extends FactoryObjetoLogico { 

  public FactoryRecluWarnEstBusqCandi() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluWarnEstBusqCandi recluwarnestbusqcandi = (RecluWarnEstBusqCandi) objLog;
    recluwarnestbusqcandi.setOID(db.getInteger(DBRecluWarnEstBusqCandi.OID_WARN_EST_CAND));
    recluwarnestbusqcandi.setEstado_busqueda(RecluEstCandidatoBusq.findByOidProxy(db.getInteger(DBRecluWarnEstBusqCandi.OID_EST_CAND_BUSQ),getSesion()));
    recluwarnestbusqcandi.setEstado_proceso(RecluEstadoProceso.findByOidProxy(db.getInteger(DBRecluWarnEstBusqCandi.OID_EST_PROC_SEL),getSesion()));
    recluwarnestbusqcandi.setActivo(db.getBoolean(DBRecluWarnEstBusqCandi.ACTIVO));

  }
}
