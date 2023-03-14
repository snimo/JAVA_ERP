package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.CondModEvalCab;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;
import com.srn.erp.rrhh.bm.ModeloEvalCab;
import com.srn.erp.rrhh.da.DBEvaluacionLegajoCab;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryEvaluacionLegajoCab extends FactoryObjetoLogico { 

  public FactoryEvaluacionLegajoCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EvaluacionLegajoCab evaluacionlegajocab = (EvaluacionLegajoCab) objLog;
    evaluacionlegajocab.setOID(db.getInteger(DBEvaluacionLegajoCab.OID_EVAL_CAB));
    evaluacionlegajocab.setVersion_eval(db.getInteger(DBEvaluacionLegajoCab.VERSION_EVAL));
    evaluacionlegajocab.setModelo_eval_cab(ModeloEvalCab.findByOidProxy(db.getInteger(DBEvaluacionLegajoCab.OID_MOD_EVAL_CAB),getSesion()));
    evaluacionlegajocab.setLegajo(Legajo.findByOidProxy(db.getInteger(DBEvaluacionLegajoCab.OID_LEGAJO),getSesion()));
    evaluacionlegajocab.setFec_eval(db.getDate(DBEvaluacionLegajoCab.FEC_EVAL));
    evaluacionlegajocab.setFec_puntuacion(db.getDate(DBEvaluacionLegajoCab.FEC_PUNTUACION));
    evaluacionlegajocab.setUsuario_alta(Usuario.findByOidProxy(db.getInteger(DBEvaluacionLegajoCab.OID_USU_CARGA),getSesion()));
    evaluacionlegajocab.setFec_alta_carga(db.getDate(DBEvaluacionLegajoCab.FEC_ALTA_CARGA));
    evaluacionlegajocab.setUsuario_modif(Usuario.findByOidProxy(db.getInteger(DBEvaluacionLegajoCab.OID_USU_MODIF),getSesion()));
    evaluacionlegajocab.setFec_ult_modif(db.getDate(DBEvaluacionLegajoCab.FEC_ULT_MODIF));
    evaluacionlegajocab.setPuntaje(db.getMoney(DBEvaluacionLegajoCab.PUNTAJE));
    evaluacionlegajocab.setFirmado(db.getBoolean(DBEvaluacionLegajoCab.FIRMADO));
    evaluacionlegajocab.setFec_firmado(db.getDate(DBEvaluacionLegajoCab.FEC_FIRMADO));
    evaluacionlegajocab.setComen_del_evaluado(db.getString(DBEvaluacionLegajoCab.COMEN_DEL_EVALUADO));
    evaluacionlegajocab.setActivo(db.getBoolean(DBEvaluacionLegajoCab.ACTIVO));
    evaluacionlegajocab.setCondModEvalCab(CondModEvalCab.findByOidProxy(db.getInteger(DBEvaluacionLegajoCab.OID_COND_MOD), this.getSesion()));
    evaluacionlegajocab.setVigente(db.getBoolean(DBEvaluacionLegajoCab.VIGENTE));
    evaluacionlegajocab.setValClasifPueFut(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBEvaluacionLegajoCab.OID_VAL_PUE_FUT),getSesion()));
  }
}
