package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.ModeloEvalCompe;
import com.srn.erp.rrhh.bm.ModeloEvalGrados;
import com.srn.erp.rrhh.da.DBModeloEvalGrados;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryModeloEvalGrados extends FactoryObjetoLogico { 

  public FactoryModeloEvalGrados() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ModeloEvalGrados modeloevalgrados = (ModeloEvalGrados) objLog;
    modeloevalgrados.setOID(db.getInteger(DBModeloEvalGrados.OID_MOV_EVA_GRADOS));
    modeloevalgrados.setModelo_evaluacion(ModeloEvalCompe.findByOidProxy(db.getInteger(DBModeloEvalGrados.OID_MOD_EVAL_COMP),getSesion()));
    modeloevalgrados.setNro_grado(db.getInteger(DBModeloEvalGrados.NRO_GRADO));
    modeloevalgrados.setDesc_grados(db.getString(DBModeloEvalGrados.DESC_GRADOS));
    modeloevalgrados.setPeso(db.getMoney(DBModeloEvalGrados.PESO));
    modeloevalgrados.setActivo(db.getBoolean(DBModeloEvalGrados.ACTIVO));

  }
}
