package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.CondModEvalCab;
import com.srn.erp.rrhh.bm.ValClasifCondModEval;
import com.srn.erp.rrhh.da.DBValClasifCondModEval;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryValClasifCondModEval extends FactoryObjetoLogico { 

  public FactoryValClasifCondModEval() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ValClasifCondModEval valclasifcondmodeval = (ValClasifCondModEval) objLog;
    valclasifcondmodeval.setOID(db.getInteger(DBValClasifCondModEval.OID_VAL_CLASIF_COND));
    valclasifcondmodeval.setClasificador(ClasificadorEntidad.findByOidProxy(db.getInteger(DBValClasifCondModEval.OID_CLASIFICADOR),getSesion()));
    valclasifcondmodeval.setValor_clasificador(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBValClasifCondModEval.OID_VAL_CLASIF),getSesion()));
    valclasifcondmodeval.setCondicion_modelo(CondModEvalCab.findByOidProxy(db.getInteger(DBValClasifCondModEval.OID_COND_MOD),getSesion()));
    valclasifcondmodeval.setActivo(db.getBoolean(DBValClasifCondModEval.ACTIVO));

  }
}
