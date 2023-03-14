package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.ObsCodifEvalRH;
import com.srn.erp.rrhh.da.DBObsCodifEvalRH;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryObsCodifEvalRH extends FactoryObjetoLogico { 

  public FactoryObsCodifEvalRH() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ObsCodifEvalRH obscodifevalrh = (ObsCodifEvalRH) objLog;
    obscodifevalrh.setOID(db.getInteger(DBObsCodifEvalRH.OID_OBS_CODIF));
    obscodifevalrh.setCodigo(db.getString(DBObsCodifEvalRH.CODIGO));
    obscodifevalrh.setDescripcion(db.getString(DBObsCodifEvalRH.DESCRIPCION));
    obscodifevalrh.setActivo(db.getBoolean(DBObsCodifEvalRH.ACTIVO));

  }
}
