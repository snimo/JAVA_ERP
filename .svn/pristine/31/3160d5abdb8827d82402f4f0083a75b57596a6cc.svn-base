package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.GrupoImportacionExcPeli;
import com.srn.erp.excluidos.bm.GrupoImportacionExcluido;
import com.srn.erp.excluidos.bm.PeligrosidadExcluido;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.da.DBGrupoImportacionExcPeli;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoImportacionExcPeli extends FactoryObjetoLogico { 

  public FactoryGrupoImportacionExcPeli() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoImportacionExcPeli grupoimportacionexcpeli = (GrupoImportacionExcPeli) objLog;
    grupoimportacionexcpeli.setOID(db.getInteger(DBGrupoImportacionExcPeli.OID_GRUPO_IMPO_PELI));
    grupoimportacionexcpeli.setGrupo_imp_esc(GrupoImportacionExcluido.findByOidProxy(db.getInteger(DBGrupoImportacionExcPeli.OID_GRUPO_IMP_EXC),getSesion()));
    grupoimportacionexcpeli.setPredio(PredioExcluido.findByOidProxy(db.getInteger(DBGrupoImportacionExcPeli.OID_PREDIO),getSesion()));
    grupoimportacionexcpeli.setPeligrosidad(PeligrosidadExcluido.findByOidProxy(db.getInteger(DBGrupoImportacionExcPeli.OID_PELIGROSIDAD),getSesion()));
    grupoimportacionexcpeli.setActivo(db.getBoolean(DBGrupoImportacionExcPeli.ACTIVO));

  }
}
