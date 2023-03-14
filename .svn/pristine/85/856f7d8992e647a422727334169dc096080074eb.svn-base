package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluPuesto;
import com.srn.erp.reclutamiento.da.DBRecluPuesto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluPuesto extends FactoryObjetoLogico { 

  public FactoryRecluPuesto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluPuesto reclupuesto = (RecluPuesto) objLog;
    reclupuesto.setOID(db.getInteger(DBRecluPuesto.OID_PUESTO_BUSQUEDA));
    reclupuesto.setCodigo(db.getString(DBRecluPuesto.CODIGO));
    reclupuesto.setDescripcion(db.getString(DBRecluPuesto.DESCRIPCION));
    reclupuesto.setActivo(db.getBoolean(DBRecluPuesto.ACTIVO));

  }
}
