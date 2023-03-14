package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.Canal;
import com.srn.erp.ventas.da.DBCanal;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCanal extends FactoryObjetoLogico {

  public FactoryCanal() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Canal canal = (Canal) objLog;
    canal.setOID(db.getInteger(DBCanal.OID_CANAL));
    canal.setCodigo(db.getString(DBCanal.CODIGO));
    canal.setDescripcion(db.getString(DBCanal.DESCRIPCION));
    canal.setActivo(db.getBoolean(DBCanal.ACTIVO));
  }
}
