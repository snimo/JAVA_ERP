package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.EstadoPredioExc;
import com.srn.erp.excluidos.bm.GrupoImportacionExcEst;
import com.srn.erp.excluidos.bm.GrupoImportacionExcluido;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.da.DBGrupoImportacionExcEst;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoImportacionExcEst extends FactoryObjetoLogico { 

  public FactoryGrupoImportacionExcEst() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoImportacionExcEst grupoimportacionexcest = (GrupoImportacionExcEst) objLog;
    grupoimportacionexcest.setOID(db.getInteger(DBGrupoImportacionExcEst.OID_GRUPO_IMPO_EST));
    grupoimportacionexcest.setGrupo_imp_esc(GrupoImportacionExcluido.findByOidProxy(db.getInteger(DBGrupoImportacionExcEst.OID_GRUPO_IMP_EXC),getSesion()));
    grupoimportacionexcest.setPredio(PredioExcluido.findByOidProxy(db.getInteger(DBGrupoImportacionExcEst.OID_PREDIO),getSesion()));
    grupoimportacionexcest.setEstado(EstadoPredioExc.findByOidProxy(db.getInteger(DBGrupoImportacionExcEst.OID_ESTADO),getSesion()));
    grupoimportacionexcest.setActivo(db.getBoolean(DBGrupoImportacionExcEst.ACTIVO));

  }
}
