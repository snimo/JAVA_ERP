package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.da.DBCondicionCompra;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCondicionCompra extends FactoryObjetoLogico {

  public FactoryCondicionCompra() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CondicionCompra condicioncompra = (CondicionCompra) objLog;
    condicioncompra.setOID(db.getInteger(DBCondicionCompra.OID_COND_COMPRA));
    condicioncompra.setCodigo(db.getString(DBCondicionCompra.CODIGO));
    condicioncompra.setDescripcion(db.getString(DBCondicionCompra.DESCRIPCION));
    condicioncompra.setVtofijo(db.getBoolean(DBCondicionCompra.VTO_FIJO));
    condicioncompra.setActivo(db.getBoolean(DBCondicionCompra.ACTIVO));

  }
}
