package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.AgrupadorEstadoStock;
import com.srn.erp.stock.da.DBAgrupadorEstadoStock;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAgrupadorEstadoStock extends FactoryObjetoLogico { 

  public FactoryAgrupadorEstadoStock() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AgrupadorEstadoStock agrupadorestadostock = (AgrupadorEstadoStock) objLog;
   agrupadorestadostock.setOID(db.getInteger(DBAgrupadorEstadoStock.OID_AGRUP_ESTADO));
    agrupadorestadostock.setCodigo(db.getString(DBAgrupadorEstadoStock.CODIGO));
    agrupadorestadostock.setDescripcion(db.getString(DBAgrupadorEstadoStock.DESCRIPCION));
    agrupadorestadostock.setActivo(db.getBoolean(DBAgrupadorEstadoStock.ACTIVO));

  }
}
