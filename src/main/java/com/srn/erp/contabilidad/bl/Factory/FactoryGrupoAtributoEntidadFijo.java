package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadFijo;
import com.srn.erp.contabilidad.bm.GrupoDeAtributos;
import com.srn.erp.contabilidad.da.DBGrupoAtributoEntidadFijo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoAtributoEntidadFijo extends FactoryObjetoLogico { 

  public FactoryGrupoAtributoEntidadFijo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoAtributoEntidadFijo grupoatributoentidadfijo = (GrupoAtributoEntidadFijo) objLog;
    grupoatributoentidadfijo.setOID(db.getInteger(DBGrupoAtributoEntidadFijo.OID_GRUPO_ATRI_FIJ));
    grupoatributoentidadfijo.setNickname(db.getString(DBGrupoAtributoEntidadFijo.NICKNAME));
    grupoatributoentidadfijo.setNombre(db.getString(DBGrupoAtributoEntidadFijo.NOMBRE));
    grupoatributoentidadfijo.setOrden(db.getInteger(DBGrupoAtributoEntidadFijo.ORDEN));
    grupoatributoentidadfijo.setGrupo_atributo(GrupoDeAtributos.findByOidProxy(db.getInteger(DBGrupoAtributoEntidadFijo.OID_GRUPOS_ATRI),getSesion()));
    grupoatributoentidadfijo.setActivo(db.getBoolean(DBGrupoAtributoEntidadFijo.ACTIVO));
  }
}
