package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluTipoContrato;
import com.srn.erp.reclutamiento.da.DBRecluTipoContrato;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluTipoContrato extends FactoryObjetoLogico { 

  public FactoryRecluTipoContrato() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluTipoContrato reclutipocontrato = (RecluTipoContrato) objLog;
    reclutipocontrato.setOID(db.getInteger(DBRecluTipoContrato.OID_TIPO_CONTRATO));
    reclutipocontrato.setCodigo(db.getString(DBRecluTipoContrato.CODIGO));
    reclutipocontrato.setDescripcion(db.getString(DBRecluTipoContrato.DESCRIPCION));
    reclutipocontrato.setActivo(db.getBoolean(DBRecluTipoContrato.ACTIVO));

  }
}
