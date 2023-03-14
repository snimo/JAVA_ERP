package com.srn.erp.rrhh.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.rrhh.bm.Competencia;
import com.srn.erp.rrhh.da.DBCompetencia;

public class FactoryCompetencia extends FactoryObjetoLogico { 

  public FactoryCompetencia() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Competencia competencia = (Competencia) objLog;
    competencia.setOID(db.getInteger(DBCompetencia.OID_COMPETENCIA));
    competencia.setCodigo(db.getString(DBCompetencia.CODIGO));
    competencia.setTitulo(db.getString(DBCompetencia.TITULO));
    competencia.setDefinicion(db.getString(DBCompetencia.DEFINICION));
    competencia.setActivo(db.getBoolean(DBCompetencia.ACTIVO));
    competencia.setDescAbrev(db.getString(DBCompetencia.DESC_ABREV));
  }
}
