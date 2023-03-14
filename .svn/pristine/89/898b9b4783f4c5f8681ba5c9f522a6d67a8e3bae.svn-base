package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.EvalFirma;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;
import com.srn.erp.rrhh.da.DBEvalFirma;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEvalFirma extends FactoryObjetoLogico { 

  public FactoryEvalFirma() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EvalFirma evalfirma = (EvalFirma) objLog;
    evalfirma.setOID(db.getInteger(DBEvalFirma.OID_FIRMA_EVAL));
    evalfirma.setEvaluacion(EvaluacionLegajoCab.findByOidProxy(db.getInteger(DBEvalFirma.OID_EVAL_CAB),getSesion()));
    evalfirma.setNro_firma(db.getInteger(DBEvalFirma.NRO_FIRMA));
    evalfirma.setLegajo_firma(Legajo.findByOidProxy(db.getInteger(DBEvalFirma.OID_LEGAJO_FIRMA),getSesion()));
    evalfirma.setFirmo(db.getBoolean(DBEvalFirma.FIRMO));
    evalfirma.setFec_firma(db.getDate(DBEvalFirma.FEC_FIRMA));
    evalfirma.setActivo(db.getBoolean(DBEvalFirma.ACTIVO));
    evalfirma.setTitulo(db.getString(DBEvalFirma.TITULO));
  }
}
