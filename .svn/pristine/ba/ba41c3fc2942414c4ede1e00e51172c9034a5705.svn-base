package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.GrupoRepositorioReal;
import com.srn.erp.presupuesto.bm.RepositorioReal;
import com.srn.erp.presupuesto.da.DBRepositorioReal;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRepositorioReal extends FactoryObjetoLogico { 

  public FactoryRepositorioReal() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RepositorioReal repositorioreal = (RepositorioReal) objLog;
    repositorioreal.setOID(db.getInteger(DBRepositorioReal.OID_REPO_REAL));
    repositorioreal.setCodigo(db.getString(DBRepositorioReal.CODIGO));
    repositorioreal.setDescripcion(db.getString(DBRepositorioReal.DESCRIPCION));
    repositorioreal.setActivo(db.getBoolean(DBRepositorioReal.ACTIVO));
    repositorioreal.setGrupoRepositorioReal(GrupoRepositorioReal.findByOidProxy(db.getInteger(DBRepositorioReal.GRUPO_REPO_REAL),this.getSesion()));
  }
}
