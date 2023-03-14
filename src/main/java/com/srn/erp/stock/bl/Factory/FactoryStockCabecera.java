package com.srn.erp.stock.bl.Factory;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.stock.bm.StockCabecera;
import com.srn.erp.stock.da.DBStockCabecera;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryStockCabecera extends FactoryObjetoLogico {

  public FactoryStockCabecera() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    StockCabecera stockcabecera = (StockCabecera) objLog;
    stockcabecera.setOID(db.getInteger(DBStockCabecera.OID_STOCK_CAB));
    stockcabecera.setComprobante(ComproCab.findByOidProxyCompro(db.getInteger(DBStockCabecera.OID_CCO),getSesion()));
  }
}
