package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.RolAutorizadorCompras;
import com.srn.erp.compras.bm.UsuarioRolAutorizadorCompras;
import com.srn.erp.compras.da.DBUsuarioRolAutorizadorCompras;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryUsuarioRolAutorizadorCompras extends FactoryObjetoLogico { 

  public FactoryUsuarioRolAutorizadorCompras() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    UsuarioRolAutorizadorCompras usuariorolautorizadorcompras = (UsuarioRolAutorizadorCompras) objLog;
    usuariorolautorizadorcompras.setOID(db.getInteger(DBUsuarioRolAutorizadorCompras.OID_USU_AUTORIZ));
    usuariorolautorizadorcompras.setRol_autorizador(RolAutorizadorCompras.findByOidProxy(db.getInteger(DBUsuarioRolAutorizadorCompras.OID_ROL_AUTORIZ),getSesion()));
    usuariorolautorizadorcompras.setUsuario(Usuario.findByOidProxy(db.getInteger(DBUsuarioRolAutorizadorCompras.OID_USUARIO),getSesion()));

  }
}
