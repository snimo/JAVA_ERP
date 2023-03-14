package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.GrupoImportacionExcluido;
import com.srn.erp.excluidos.da.DBGrupoImportacionExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoImportacionExcluido extends FactoryObjetoLogico { 

  public FactoryGrupoImportacionExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoImportacionExcluido grupoimportacionexcluido = (GrupoImportacionExcluido) objLog;
    grupoimportacionexcluido.setOID(db.getInteger(DBGrupoImportacionExcluido.OID_GRUPO_IMP_EXC));
    grupoimportacionexcluido.setCodigo(db.getString(DBGrupoImportacionExcluido.CODIGO));
    grupoimportacionexcluido.setDescripcion(db.getString(DBGrupoImportacionExcluido.DESCRIPCION));
    grupoimportacionexcluido.setTipo_individuo(db.getString(DBGrupoImportacionExcluido.TIPO_INDIVIDUO));
    grupoimportacionexcluido.setActivo(db.getBoolean(DBGrupoImportacionExcluido.ACTIVO));

  }
}
