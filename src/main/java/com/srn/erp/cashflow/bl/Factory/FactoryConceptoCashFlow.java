package com.srn.erp.cashflow.bl.Factory;

import com.srn.erp.cashflow.bm.ConceptoCashFlow;
import com.srn.erp.cashflow.bm.GrupoConceptoCF;
import com.srn.erp.cashflow.da.DBConceptoCashFlow;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConceptoCashFlow extends FactoryObjetoLogico { 

  public FactoryConceptoCashFlow() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConceptoCashFlow conceptocashflow = (ConceptoCashFlow) objLog;
    conceptocashflow.setOID(db.getInteger(DBConceptoCashFlow.OID_CONCEPTO));
    conceptocashflow.setCodigo(db.getString(DBConceptoCashFlow.CODIGO));
    conceptocashflow.setDescripcion(db.getString(DBConceptoCashFlow.DESCRIPCION));
    conceptocashflow.setActivo(db.getBoolean(DBConceptoCashFlow.ACTIVO));
    conceptocashflow.setGrupo_concepto(GrupoConceptoCF.findByOidProxy(db.getInteger(DBConceptoCashFlow.OID_GRUPO_CONCEPTO),getSesion()));

  }
}
