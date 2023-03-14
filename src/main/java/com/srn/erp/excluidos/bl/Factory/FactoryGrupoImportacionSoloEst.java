package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.GrupoImportacionExcluido;
import com.srn.erp.excluidos.bm.GrupoImportacionSoloEst;
import com.srn.erp.excluidos.da.DBGrupoImportacionSoloEst;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoImportacionSoloEst extends FactoryObjetoLogico { 

  public FactoryGrupoImportacionSoloEst() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoImportacionSoloEst grupoimportacionsoloest = (GrupoImportacionSoloEst) objLog;
    grupoimportacionsoloest.setOID(db.getInteger(DBGrupoImportacionSoloEst.OID_GRUPO_SOLO_EST));
    grupoimportacionsoloest.setGrupo_imp_exc(GrupoImportacionExcluido.findByOidProxy(db.getInteger(DBGrupoImportacionSoloEst.OID_GRUPO_IMP_EXC),getSesion()));
    grupoimportacionsoloest.setEstado(EstadoExcluido.findByOidProxy(db.getInteger(DBGrupoImportacionSoloEst.OID_ESTADO),getSesion()));
    grupoimportacionsoloest.setActivo(db.getBoolean(DBGrupoImportacionSoloEst.ACTIVO));

  }
}
