package com.srn.erp.mensajero.bl.Factory;

import com.srn.erp.mensajero.bm.GrupoUsuMens;
import com.srn.erp.mensajero.da.DBGrupoUsuMens;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoUsuMens extends FactoryObjetoLogico { 

  public FactoryGrupoUsuMens() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoUsuMens grupousumens = (GrupoUsuMens) objLog;
    grupousumens.setOID(db.getInteger(DBGrupoUsuMens.OID_GRUPO_DEST_CAB));
    grupousumens.setNombre(db.getString(DBGrupoUsuMens.NOMBRE));
    grupousumens.setScope(db.getString(DBGrupoUsuMens.SCOPE));
    grupousumens.setUsuario_priveado(Usuario.findByOidProxy(db.getInteger(DBGrupoUsuMens.OID_USU_PRIV),getSesion()));
    grupousumens.setActivo(db.getBoolean(DBGrupoUsuMens.ACTIVA));

  }
}
