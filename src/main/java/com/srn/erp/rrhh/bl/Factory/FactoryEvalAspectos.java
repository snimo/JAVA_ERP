package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.EvalAspectos;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;
import com.srn.erp.rrhh.da.DBEvalAspectos;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryEvalAspectos extends FactoryObjetoLogico { 

  public FactoryEvalAspectos() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EvalAspectos evalaspectos = (EvalAspectos) objLog;
    evalaspectos.setOID(db.getInteger(DBEvalAspectos.OID_EVAL_ASP));
    evalaspectos.setEvaluacion(EvaluacionLegajoCab.findByOidProxy(db.getInteger(DBEvalAspectos.OID_EVAL_CAB),getSesion()));
    evalaspectos.setTipo_aspecto(db.getString(DBEvalAspectos.TIPO_ASPECTO));
    evalaspectos.setActivo(db.getBoolean(DBEvalAspectos.ACTIVO));
    evalaspectos.setFec_alta(db.getDate(DBEvalAspectos.FEC_ALTA));
    evalaspectos.setAspecto(db.getString(DBEvalAspectos.ASPECTO));
    evalaspectos.setUsuario_alta(Usuario.findByOidProxy(db.getInteger(DBEvalAspectos.OID_USU_ALTA),getSesion()));
    evalaspectos.setFec_modif(db.getDate(DBEvalAspectos.FEC_MODIF));
    evalaspectos.setUsuario_modif(Usuario.findByOidProxy(db.getInteger(DBEvalAspectos.OID_USU_MODIF),getSesion()));

  }
}
