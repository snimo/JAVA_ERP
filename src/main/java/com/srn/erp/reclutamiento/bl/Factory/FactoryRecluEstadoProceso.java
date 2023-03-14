package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluEstadoProceso;
import com.srn.erp.reclutamiento.da.DBRecluEstadoProceso;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluEstadoProceso extends FactoryObjetoLogico { 

  public FactoryRecluEstadoProceso() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluEstadoProceso recluestadoproceso = (RecluEstadoProceso) objLog;
    recluestadoproceso.setOID(db.getInteger(DBRecluEstadoProceso.OID_EST_PROC_SEL));
    recluestadoproceso.setCodigo(db.getString(DBRecluEstadoProceso.CODIGO));
    recluestadoproceso.setDescripcion(db.getString(DBRecluEstadoProceso.DESCRIPCION));
    recluestadoproceso.setIniciar_prox_proc(db.getBoolean(DBRecluEstadoProceso.INICIAR_PROX_PROC));
    recluestadoproceso.setActivo(db.getBoolean(DBRecluEstadoProceso.ACTIVO));
    recluestadoproceso.setFecPlanifOblig(db.getBoolean(DBRecluEstadoProceso.FEC_PLANIF_OBLIG));
  }
}
