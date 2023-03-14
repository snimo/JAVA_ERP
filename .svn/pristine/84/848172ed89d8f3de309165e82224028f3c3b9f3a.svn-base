package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.GrupoAccesoCIP;
import com.srn.erp.cip.bm.PermisoSemanalCIP;
import com.srn.erp.cip.da.DBGrupoAccesoCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoAccesoCIP extends FactoryObjetoLogico { 

  public FactoryGrupoAccesoCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoAccesoCIP grupoaccesocip = (GrupoAccesoCIP) objLog;
    grupoaccesocip.setOID(db.getInteger(DBGrupoAccesoCIP.OID_GRUPO_ACCESO));
    grupoaccesocip.setCodigo(db.getString(DBGrupoAccesoCIP.CODIGO));
    grupoaccesocip.setDescripcion(db.getString(DBGrupoAccesoCIP.DESCRIPCION));
    grupoaccesocip.setActivo(db.getBoolean(DBGrupoAccesoCIP.ACTIVO));
    grupoaccesocip.setPermiso_semanal(PermisoSemanalCIP.findByOidProxy(db.getInteger(DBGrupoAccesoCIP.OID_PERM_SEMANAL),getSesion()));

  }
}
