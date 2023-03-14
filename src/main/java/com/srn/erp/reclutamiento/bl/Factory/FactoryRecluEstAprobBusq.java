package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluEstAprobBusq;
import com.srn.erp.reclutamiento.da.DBRecluEstAprobBusq;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluEstAprobBusq extends FactoryObjetoLogico { 

  public FactoryRecluEstAprobBusq() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluEstAprobBusq recluestaprobbusq = (RecluEstAprobBusq) objLog;
    recluestaprobbusq.setOID(db.getInteger(DBRecluEstAprobBusq.OID_EST_APROB_BUSQ));
    recluestaprobbusq.setCodigo(db.getString(DBRecluEstAprobBusq.CODIGO));
    recluestaprobbusq.setDescripcion(db.getString(DBRecluEstAprobBusq.DESCRIPCION));
    recluestaprobbusq.setAprobado(db.getBoolean(DBRecluEstAprobBusq.APROBADO));
    recluestaprobbusq.setActivo(db.getBoolean(DBRecluEstAprobBusq.ACTIVO));

  }
}
