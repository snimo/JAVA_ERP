package com.srn.erp.presupuesto.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.presupuesto.bm.GrupoRepositorioReal;
import com.srn.erp.presupuesto.da.DBGrupoRepositorioReal;

public class FactoryGrupoRepositorioReal extends FactoryObjetoLogico { 

  public FactoryGrupoRepositorioReal() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoRepositorioReal gruporepositorioreal = (GrupoRepositorioReal) objLog;
    gruporepositorioreal.setOID(db.getInteger(DBGrupoRepositorioReal.OID_GRUPO_REPO));
    gruporepositorioreal.setCodigo(db.getString(DBGrupoRepositorioReal.CODIGO));
    gruporepositorioreal.setDescripcion(db.getString(DBGrupoRepositorioReal.DESCRIPCION));
    gruporepositorioreal.setActivo(db.getBoolean(DBGrupoRepositorioReal.ACTIVO));

  }
}
