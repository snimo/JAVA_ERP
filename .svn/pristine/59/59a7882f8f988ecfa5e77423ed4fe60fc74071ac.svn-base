package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.da.DBEstadoStock;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadoStock extends FactoryObjetoLogico {

  public FactoryEstadoStock() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstadoStock estadostock = (EstadoStock) objLog;
  estadostock.setOID(db.getInteger(DBEstadoStock.OID_ESTADO_STOCK));
    estadostock.setCodigo(db.getString(DBEstadoStock.CODIGO));
    estadostock.setDescripcion(db.getString(DBEstadoStock.DESCRIPCION));
    estadostock.setActivo(db.getBoolean(DBEstadoStock.ACTIVO));

  }
}
