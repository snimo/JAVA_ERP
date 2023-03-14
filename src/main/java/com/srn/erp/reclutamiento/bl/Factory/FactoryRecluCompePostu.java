package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluCompePostu;
import com.srn.erp.reclutamiento.bm.RecluCompetencias;
import com.srn.erp.reclutamiento.bm.RecluPostulante;
import com.srn.erp.reclutamiento.da.DBRecluCompePostu;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluCompePostu extends FactoryObjetoLogico { 

  public FactoryRecluCompePostu() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluCompePostu reclucompepostu = (RecluCompePostu) objLog;
    reclucompepostu.setOID(db.getInteger(DBRecluCompePostu.OID_COMPE_POSTU));
    reclucompepostu.setPostulante(RecluPostulante.findByOidProxy(db.getInteger(DBRecluCompePostu.OID_POSTULANTE),getSesion()));
    reclucompepostu.setCompetencia(RecluCompetencias.findByOidProxy(db.getInteger(DBRecluCompePostu.OID_COMPETENCIA),getSesion()));
    reclucompepostu.setActivo(db.getBoolean(DBRecluCompePostu.ACTIVO));

  }
}
