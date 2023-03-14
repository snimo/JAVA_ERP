package com.srn.erp.crm.bl.Factory;

import com.srn.erp.crm.bm.SensacionCierreOportunidad;
import com.srn.erp.crm.da.DBSensacionCierreOportunidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySensacionCierreOportunidad extends FactoryObjetoLogico { 

  public FactorySensacionCierreOportunidad() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SensacionCierreOportunidad sensacioncierreoportunidad = (SensacionCierreOportunidad) objLog;
    sensacioncierreoportunidad.setOID(db.getInteger(DBSensacionCierreOportunidad.OID));
    sensacioncierreoportunidad.setCodigo(db.getString(DBSensacionCierreOportunidad.CODIGO));
    sensacioncierreoportunidad.setDescripcion(db.getString(DBSensacionCierreOportunidad.DESCRIPCION));
    sensacioncierreoportunidad.setActivo(db.getBoolean(DBSensacionCierreOportunidad.ACTIVO));

  }
}
