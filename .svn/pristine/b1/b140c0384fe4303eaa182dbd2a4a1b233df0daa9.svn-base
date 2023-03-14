package com.srn.erp.mensajero.bl.Factory;

import com.srn.erp.mensajero.bm.GruDetUsuMens;
import com.srn.erp.mensajero.bm.GrupoUsuMens;
import com.srn.erp.mensajero.da.DBGruDetUsuMens;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryGruDetUsuMens extends FactoryObjetoLogico { 

  public FactoryGruDetUsuMens() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GruDetUsuMens grudetusumens = (GruDetUsuMens) objLog;
    grudetusumens.setOID(db.getInteger(DBGruDetUsuMens.OID_GRUPO_DEST_DET));
    grudetusumens.setGrupo_dest_cab(GrupoUsuMens.findByOid(db.getInteger(DBGruDetUsuMens.OID_GRUPO_DEST_CAB),this.getSesion()));
    grudetusumens.setUsuario(Usuario.findByOidProxy(db.getInteger(DBGruDetUsuMens.OID_USUARIO),this.getSesion()));
    grudetusumens.setActivo(db.getBoolean(DBGruDetUsuMens.ACTIVO));

  }
}
