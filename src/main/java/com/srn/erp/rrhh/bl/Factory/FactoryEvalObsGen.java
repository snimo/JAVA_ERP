package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.EvalObsGen;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;
import com.srn.erp.rrhh.da.DBEvalObsGen;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryEvalObsGen extends FactoryObjetoLogico { 

  public FactoryEvalObsGen() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EvalObsGen evalobsgen = (EvalObsGen) objLog;
    evalobsgen.setOID(db.getInteger(DBEvalObsGen.OID_OBS_GEN));
    evalobsgen.setEvaluacion(EvaluacionLegajoCab.findByOidProxy(db.getInteger(DBEvalObsGen.OID_EVAL_CAB),getSesion()));
    evalobsgen.setObservacion(db.getString(DBEvalObsGen.OBSERVACION));
    evalobsgen.setFec_alta(db.getDate(DBEvalObsGen.FEC_ALTA));
    evalobsgen.setUsuario_alta(Usuario.findByOidProxy(db.getInteger(DBEvalObsGen.OID_USU_ALTA),getSesion()));
    evalobsgen.setFec_utl_modif(db.getDate(DBEvalObsGen.FEC_UTL_MODIF));
    evalobsgen.setUsuario_modif(Usuario.findByOidProxy(db.getInteger(DBEvalObsGen.OID_USU_MODIF),getSesion()));
    evalobsgen.setActivo(db.getBoolean(DBEvalObsGen.ACTIVO));

  }
}
