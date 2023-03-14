package com.srn.erp.cubo.bl.Factory;

import com.srn.erp.cubo.bm.GrupoModeloCubo;
import com.srn.erp.cubo.da.DBGrupoModeloCubo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoModeloCubo extends FactoryObjetoLogico { 

  public FactoryGrupoModeloCubo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoModeloCubo grupomodelocubo = (GrupoModeloCubo) objLog;
    grupomodelocubo.setOID(db.getInteger(DBGrupoModeloCubo.OID_GRUPO_MODELO));
    grupomodelocubo.setCodigo(db.getString(DBGrupoModeloCubo.CODIGO));
    grupomodelocubo.setDescripcion(db.getString(DBGrupoModeloCubo.DESCRIPCION));
    grupomodelocubo.setActivo(db.getBoolean(DBGrupoModeloCubo.ACTIVO));

  }
}
