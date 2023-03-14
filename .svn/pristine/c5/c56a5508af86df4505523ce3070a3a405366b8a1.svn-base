package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadVar;
import com.srn.erp.contabilidad.bm.GrupoDeAtributos;
import com.srn.erp.contabilidad.bm.GrupoHabilitadoEntidad;
import com.srn.erp.contabilidad.da.DBGrupoHabilitadoEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoHabilitadoEntidad extends FactoryObjetoLogico { 

  public FactoryGrupoHabilitadoEntidad() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoHabilitadoEntidad grupohabilitadoentidad = (GrupoHabilitadoEntidad) objLog;
    grupohabilitadoentidad.setOID(db.getInteger(DBGrupoHabilitadoEntidad.OID_GRUPOS_HAB_ENT));
    grupohabilitadoentidad.setGrupo_atributo_entidad_var(GrupoAtributoEntidadVar.findByOidProxy(db.getInteger(DBGrupoHabilitadoEntidad.OID_GRUPO_ATRI_VAR),getSesion()));
    grupohabilitadoentidad.setGrupo_atributo(GrupoDeAtributos.findByOidProxy(db.getInteger(DBGrupoHabilitadoEntidad.OID_GRUPOS_ATRI),getSesion()));
    grupohabilitadoentidad.setActivo(db.getBoolean(DBGrupoHabilitadoEntidad.ACTIVO));

  }
}
