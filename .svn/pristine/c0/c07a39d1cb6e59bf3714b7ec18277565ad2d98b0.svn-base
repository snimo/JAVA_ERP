package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.Competencia;
import com.srn.erp.rrhh.bm.EvalCargaResul;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;
import com.srn.erp.rrhh.da.DBEvalCargaResul;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEvalCargaResul extends FactoryObjetoLogico { 

  public FactoryEvalCargaResul() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EvalCargaResul evalcargaresul = (EvalCargaResul) objLog;
    evalcargaresul.setOID(db.getInteger(DBEvalCargaResul.OID_EVAL_CARGA));
    evalcargaresul.setEvaluacion(EvaluacionLegajoCab.findByOidProxy(db.getInteger(DBEvalCargaResul.OID_EVAL_CAB),getSesion()));
    evalcargaresul.setCompetencia(Competencia.findByOidProxy(db.getInteger(DBEvalCargaResul.OID_COMPETENCIA),getSesion()));
    evalcargaresul.setNro_grado(db.getInteger(DBEvalCargaResul.NRO_GRADO));
    evalcargaresul.setPorc_cumpli(db.getMoney(DBEvalCargaResul.PORC_CUMPLI));
    evalcargaresul.setActivo(db.getBoolean(DBEvalCargaResul.ACTIVO));
    evalcargaresul.setPuntaje(db.getMoney(DBEvalCargaResul.PUNTAJE));
  }
}
