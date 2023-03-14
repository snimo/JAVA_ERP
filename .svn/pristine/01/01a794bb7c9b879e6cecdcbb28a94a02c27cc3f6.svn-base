package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.EvalEvaluador;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;
import com.srn.erp.rrhh.da.DBEvalEvaluador;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEvalEvaluador extends FactoryObjetoLogico { 

  public FactoryEvalEvaluador() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EvalEvaluador evalevaluador = (EvalEvaluador) objLog;
    evalevaluador.setOID(db.getInteger(DBEvalEvaluador.OID_EVAL_EVALUADOR));
    evalevaluador.setEvaluacion(EvaluacionLegajoCab.findByOidProxy(db.getInteger(DBEvalEvaluador.OID_EVAL_CAB),getSesion()));
    evalevaluador.setActivo(db.getBoolean(DBEvalEvaluador.ACTIVO));
    evalevaluador.setFirmado(db.getBoolean(DBEvalEvaluador.FIRMADO));
    evalevaluador.setLegajo(Legajo.findByOidProxy(db.getInteger(DBEvalEvaluador.OID_LEGAJO),getSesion()));
    evalevaluador.setFec_firmado(db.getDate(DBEvalEvaluador.FEC_FIRMADO));

  }
}
