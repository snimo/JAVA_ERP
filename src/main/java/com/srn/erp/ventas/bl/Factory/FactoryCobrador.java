package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.Cobrador;
import com.srn.erp.ventas.da.DBCobrador;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCobrador extends FactoryObjetoLogico {

  public FactoryCobrador() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Cobrador cobrador = (Cobrador) objLog;
    cobrador.setOID(db.getInteger(DBCobrador.OID_COBRADOR));
    cobrador.setCodigo(db.getString(DBCobrador.CODIGO));
    cobrador.setApellido(db.getString(DBCobrador.APELLIDO));
    cobrador.setNombre(db.getString(DBCobrador.NOMBRE));
    cobrador.setActivo(db.getBoolean(DBCobrador.ACTIVO));
  }
}
