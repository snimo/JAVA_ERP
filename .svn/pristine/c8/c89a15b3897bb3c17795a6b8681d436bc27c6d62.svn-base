package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.RolAutorizadorCompras;
import com.srn.erp.compras.da.DBRolAutorizadorCompras;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRolAutorizadorCompras extends FactoryObjetoLogico { 

  public FactoryRolAutorizadorCompras() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RolAutorizadorCompras rolautorizadorcompras = (RolAutorizadorCompras) objLog;
    rolautorizadorcompras.setOID(db.getInteger(DBRolAutorizadorCompras.OID_ROL_AUTORIZ));
    rolautorizadorcompras.setCodigo(db.getString(DBRolAutorizadorCompras.CODIGO));
    rolautorizadorcompras.setDescripcion(db.getString(DBRolAutorizadorCompras.DESCRIPCION));
    rolautorizadorcompras.setActivo(db.getBoolean(DBRolAutorizadorCompras.ACTIVO));
  }
}
