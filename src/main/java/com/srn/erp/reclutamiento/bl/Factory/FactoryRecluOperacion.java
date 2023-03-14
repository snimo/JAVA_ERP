package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluOperacion;
import com.srn.erp.reclutamiento.da.DBRecluOperacion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluOperacion extends FactoryObjetoLogico { 

  public FactoryRecluOperacion() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluOperacion recluoperacion = (RecluOperacion) objLog;
    recluoperacion.setOID(db.getInteger(DBRecluOperacion.OID_OPERACION));
    recluoperacion.setCodigo(db.getString(DBRecluOperacion.CODIGO));
    recluoperacion.setDescripcion(db.getString(DBRecluOperacion.DESCRIPCION));
    recluoperacion.setActivo(db.getBoolean(DBRecluOperacion.ACTIVO));

  }
}
