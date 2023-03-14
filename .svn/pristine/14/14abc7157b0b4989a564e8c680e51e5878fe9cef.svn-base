package com.srn.erp.rrhh.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.rrhh.bm.ModeloEvalCab;
import com.srn.erp.rrhh.da.DBModeloEvalCab;

public class FactoryModeloEvalCab extends FactoryObjetoLogico { 

  public FactoryModeloEvalCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ModeloEvalCab modeloevalcab = (ModeloEvalCab) objLog;
    modeloevalcab.setOID(db.getInteger(DBModeloEvalCab.OID_MOD_EVAL_CAB));
    modeloevalcab.setTitulo(db.getString(DBModeloEvalCab.TITULO));
    modeloevalcab.setDesc_abreviada(db.getString(DBModeloEvalCab.DESC_ABREVIADA));
    modeloevalcab.setFec_desde(db.getDate(DBModeloEvalCab.FEC_DESDE));
    modeloevalcab.setFec_hasta(db.getDate(DBModeloEvalCab.FEC_HASTA));
    modeloevalcab.setVigente(db.getBoolean(DBModeloEvalCab.VIGENTE));
    modeloevalcab.setActivo(db.getBoolean(DBModeloEvalCab.ACTIVO));
    modeloevalcab.setTipo(db.getString(DBModeloEvalCab.TIPO));
  }
}
