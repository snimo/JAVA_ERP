package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluFuente;
import com.srn.erp.reclutamiento.da.DBRecluFuente;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluFuente extends FactoryObjetoLogico { 

  public FactoryRecluFuente() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluFuente reclufuente = (RecluFuente) objLog;
    reclufuente.setOID(db.getInteger(DBRecluFuente.OID_FUENTE));
    reclufuente.setCodigo(db.getString(DBRecluFuente.CODIGO));
    reclufuente.setDescripcion(db.getString(DBRecluFuente.DESCRIPCION));
    reclufuente.setActivo(db.getBoolean(DBRecluFuente.ACTIVO));

  }
}
