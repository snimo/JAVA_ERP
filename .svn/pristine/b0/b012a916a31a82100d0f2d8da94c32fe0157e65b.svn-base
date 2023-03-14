package com.srn.erp.cashflow.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.cashflow.bm.GrupoConceptoCF;
import com.srn.erp.cashflow.da.DBGrupoConceptoCF;

public class FactoryGrupoConceptoCF extends FactoryObjetoLogico { 

  public FactoryGrupoConceptoCF() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoConceptoCF grupoconceptocf = (GrupoConceptoCF) objLog;
    grupoconceptocf.setOID(db.getInteger(DBGrupoConceptoCF.OID_GRUPO_CONCEPTO));
    grupoconceptocf.setCodigo(db.getString(DBGrupoConceptoCF.CODIGO));
    grupoconceptocf.setDescripcion(db.getString(DBGrupoConceptoCF.DESCRIPCION));
    grupoconceptocf.setActivo(db.getBoolean(DBGrupoConceptoCF.ACTIVO));
    grupoconceptocf.setOrden(db.getInteger(DBGrupoConceptoCF.ORDEN));
    grupoconceptocf.setComporGrupo(db.getString(DBGrupoConceptoCF.COMPOR_GRUPO));

  }
}
