package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.CondModEvalCab;
import com.srn.erp.rrhh.bm.ModeloEvalCab;
import com.srn.erp.rrhh.da.DBCondModEvalCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCondModEvalCab extends FactoryObjetoLogico { 

  public FactoryCondModEvalCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CondModEvalCab condmodevalcab = (CondModEvalCab) objLog;
    condmodevalcab.setOID(db.getInteger(DBCondModEvalCab.OID_COND_MOD));
    condmodevalcab.setModelo_eval_cab(ModeloEvalCab.findByOidProxy(db.getInteger(DBCondModEvalCab.OID_MOD_EVAL_CAB),getSesion()));
    condmodevalcab.setOrden(db.getInteger(DBCondModEvalCab.ORDEN));
    condmodevalcab.setCondicion(db.getString(DBCondModEvalCab.CONDICION));
    condmodevalcab.setActivo(db.getBoolean(DBCondModEvalCab.ACTIVO));

  }
}
