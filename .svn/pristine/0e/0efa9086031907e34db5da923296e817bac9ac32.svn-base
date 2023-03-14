package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.FiltroLegCab;
import com.srn.erp.rrhh.bm.PerfilFiltroLegajo;
import com.srn.erp.rrhh.da.DBPerfilFiltroLegajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Utils.BaseException;

public class FactoryPerfilFiltroLegajo extends FactoryObjetoLogico { 

  public FactoryPerfilFiltroLegajo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PerfilFiltroLegajo perfilfiltrolegajo = (PerfilFiltroLegajo) objLog;
    perfilfiltrolegajo.setOID(db.getInteger(DBPerfilFiltroLegajo.OID_PERFIL_LEG_FILTRO));
    perfilfiltrolegajo.setFiltro_legajo_cab(FiltroLegCab.findByOidProxy(db.getInteger(DBPerfilFiltroLegajo.OID_FILTRO_CAB),getSesion()));
    perfilfiltrolegajo.setPerfil(PerfilFuncional.findByOidProxy(db.getInteger(DBPerfilFiltroLegajo.OID_PERFIL),getSesion()));
    perfilfiltrolegajo.setActivo(db.getBoolean(DBPerfilFiltroLegajo.ACTIVO));

  }
}
