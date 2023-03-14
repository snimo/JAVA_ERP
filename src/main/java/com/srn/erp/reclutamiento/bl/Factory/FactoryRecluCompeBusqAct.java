package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluCompeBusqAct;
import com.srn.erp.reclutamiento.bm.RecluCompetencias;
import com.srn.erp.reclutamiento.da.DBRecluCompeBusqAct;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluCompeBusqAct extends FactoryObjetoLogico { 

  public FactoryRecluCompeBusqAct() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluCompeBusqAct reclucompebusqact = (RecluCompeBusqAct) objLog;
    reclucompebusqact.setOID(db.getInteger(DBRecluCompeBusqAct.OID_COMP_BUSQ_ACT));
    reclucompebusqact.setCompetencia(RecluCompetencias.findByOidProxy(db.getInteger(DBRecluCompeBusqAct.OID_COMPETENCIA),getSesion()));
    reclucompebusqact.setBusqueda(RecluBusqueda.findByOidProxy(db.getInteger(DBRecluCompeBusqAct.OID_BUSQUEDA_ACT),getSesion()));
    reclucompebusqact.setActivo(db.getBoolean(DBRecluCompeBusqAct.ACTIVO));

  }
}
