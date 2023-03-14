package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.da.DBGrupoPuerta;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoPuerta extends FactoryObjetoLogico { 

  public FactoryGrupoPuerta() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoPuerta grupopuerta = (GrupoPuerta) objLog;
    grupopuerta.setOID(db.getInteger(DBGrupoPuerta.OID_GRUPO_PUERTA));
    grupopuerta.setCodigo(db.getString(DBGrupoPuerta.CODIGO));
    grupopuerta.setDescripcion(db.getString(DBGrupoPuerta.DESCRIPCION));
    grupopuerta.setActivo(db.getBoolean(DBGrupoPuerta.ACTIVO));
    grupopuerta.setIsParaCacheo(db.getBoolean(DBGrupoPuerta.ES_PARA_CACHEO));
    grupopuerta.setHabParaIngVisita(db.getBoolean(DBGrupoPuerta.HAB_PARA_ING_VISITA));
  }
}
