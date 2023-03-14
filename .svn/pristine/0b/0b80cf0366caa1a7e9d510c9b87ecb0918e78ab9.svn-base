package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.PeriodoStockReal;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.StockPeriodo;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBStockPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryStockPeriodo extends FactoryObjetoLogico {

  public FactoryStockPeriodo() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    StockPeriodo stockperiodo = (StockPeriodo) objLog;
    stockperiodo.setOID(db.getInteger(DBStockPeriodo.OID_STOCK_PERI));
    stockperiodo.setPeri_stock_real(PeriodoStockReal.findByOidProxy(db.getInteger(DBStockPeriodo.OID_PERI_STK_REAL),getSesion()));
    stockperiodo.setDeposito(Deposito.findByOidProxy(db.getInteger(DBStockPeriodo.OID_DEPOSITO),getSesion()));
    stockperiodo.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBStockPeriodo.OID_UM_STK),getSesion()));
    stockperiodo.setProducto(Producto.findByOidProxy(db.getInteger(DBStockPeriodo.OID_PRODUCTO),getSesion()));
    stockperiodo.setEntradas(db.getDouble(DBStockPeriodo.ENTRADAS));
    stockperiodo.setSalidas(db.getDouble(DBStockPeriodo.SALIDAS));

  }
}
