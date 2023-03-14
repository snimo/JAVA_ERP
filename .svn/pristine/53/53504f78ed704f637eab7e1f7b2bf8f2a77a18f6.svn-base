package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.CondModEvalCab;
import com.srn.erp.rrhh.bm.LegjoCondModEval;
import com.srn.erp.rrhh.da.DBLegjoCondModEval;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryLegjoCondModEval extends FactoryObjetoLogico { 

  public FactoryLegjoCondModEval() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    LegjoCondModEval legjocondmodeval = (LegjoCondModEval) objLog;
    legjocondmodeval.setOID(db.getInteger(DBLegjoCondModEval.OID_LEG_COND_MOD));
    legjocondmodeval.setCondicion_modelo(CondModEvalCab.findByOidProxy(db.getInteger(DBLegjoCondModEval.OID_COND_MOD),getSesion()));
    legjocondmodeval.setLegajo(Legajo.findByOidProxy(db.getInteger(DBLegjoCondModEval.OID_LEGAJO),getSesion()));
    legjocondmodeval.setActivo(db.getBoolean(DBLegjoCondModEval.ACTIVO));

  }
}
