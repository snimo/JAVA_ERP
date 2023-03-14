package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.Competencia;
import com.srn.erp.rrhh.bm.CondModEvalCab;
import com.srn.erp.rrhh.bm.ModeloEvalCompe;
import com.srn.erp.rrhh.da.DBModeloEvalCompe;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryModeloEvalCompe extends FactoryObjetoLogico { 

  public FactoryModeloEvalCompe() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ModeloEvalCompe modeloevalcompe = (ModeloEvalCompe) objLog;
    modeloevalcompe.setOID(db.getInteger(DBModeloEvalCompe.OID_MOD_EVAL_COMP));
    modeloevalcompe.setCondicion_modelo(CondModEvalCab.findByOidProxy(db.getInteger(DBModeloEvalCompe.OID_COND_MOD),getSesion()));
    modeloevalcompe.setCompetencia(Competencia.findByOidProxy(db.getInteger(DBModeloEvalCompe.OID_COMPETENCIA),getSesion()));
    modeloevalcompe.setOrden(db.getInteger(DBModeloEvalCompe.ORDEN));
    modeloevalcompe.setCodigo_compe(db.getString(DBModeloEvalCompe.CODIGO_COMPE));
    modeloevalcompe.setTitulo_compe(db.getString(DBModeloEvalCompe.TITULO_COMPE));
    modeloevalcompe.setDefinicion_compe(db.getString(DBModeloEvalCompe.DEFINICION_COMPE));
    modeloevalcompe.setPeso_competencia(db.getMoney(DBModeloEvalCompe.PESO_COMPETENCIA));
    modeloevalcompe.setActivo(db.getBoolean(DBModeloEvalCompe.ACTIVO));

  }
}
