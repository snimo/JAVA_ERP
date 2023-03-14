package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.EvalValClasifLeg;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;
import com.srn.erp.rrhh.da.DBEvalValClasifLeg;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEvalValClasifLeg extends FactoryObjetoLogico { 

  public FactoryEvalValClasifLeg() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EvalValClasifLeg evalvalclasifleg = (EvalValClasifLeg) objLog;
    evalvalclasifleg.setOID(db.getInteger(DBEvalValClasifLeg.OID_EVAL_VAL_CLA));
    evalvalclasifleg.setEvaluacion(EvaluacionLegajoCab.findByOidProxy(db.getInteger(DBEvalValClasifLeg.OID_EVAL_CAB),getSesion()));
    evalvalclasifleg.setClasificador(ClasificadorEntidad.findByOidProxy(db.getInteger(DBEvalValClasifLeg.OID_CLASIFICADOR),getSesion()));
    evalvalclasifleg.setValor_clasificador(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBEvalValClasifLeg.OID_VAL_CLASIF),getSesion()));
    evalvalclasifleg.setActivo(db.getBoolean(DBEvalValClasifLeg.ACTIVO));

  }
}
