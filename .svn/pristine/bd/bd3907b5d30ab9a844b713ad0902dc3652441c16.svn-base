package com.srn.erp.contabilidad.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadVar;
import com.srn.erp.contabilidad.da.DBGrupoAtributoEntidadVar;

public class FactoryGrupoAtributoEntidadVar extends FactoryObjetoLogico { 

  public FactoryGrupoAtributoEntidadVar() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoAtributoEntidadVar grupoatributoentidadvar = (GrupoAtributoEntidadVar) objLog;
    grupoatributoentidadvar.setOID(db.getInteger(DBGrupoAtributoEntidadVar.OID_GRUPO_ATRI_VAR));
    grupoatributoentidadvar.setNickname(db.getString(DBGrupoAtributoEntidadVar.NICKNAME));
    grupoatributoentidadvar.setNombre(db.getString(DBGrupoAtributoEntidadVar.NOMBRE));
    grupoatributoentidadvar.setActivo(db.getBoolean(DBGrupoAtributoEntidadVar.ACTIVO));
  }
}
