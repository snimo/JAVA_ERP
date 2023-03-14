package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.StockEstadoDia;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBStockEstadoDia;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryStockEstadoDia extends FactoryObjetoLogico { 

  public FactoryStockEstadoDia() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    StockEstadoDia stockestadodia = (StockEstadoDia) objLog;
    stockestadodia.setOID(db.getInteger(DBStockEstadoDia.OID_STOCK_EST_DIA));
    stockestadodia.setFecha(db.getDate(DBStockEstadoDia.FECHA));
    stockestadodia.setDeposito(Deposito.findByOidProxy(db.getInteger(DBStockEstadoDia.OID_DEPOSITO),getSesion()));
    stockestadodia.setProducto(Producto.findByOidProxy(db.getInteger(DBStockEstadoDia.OID_PRODUCTO),getSesion()));
    stockestadodia.setEstado_stock(EstadoStock.findByOidProxy(db.getInteger(DBStockEstadoDia.OID_ESTADO_STOCK),getSesion()));
    stockestadodia.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBStockEstadoDia.OID_UM_STK),getSesion()));
    stockestadodia.setEntradas(db.getDouble(DBStockEstadoDia.ENTRADAS));
    stockestadodia.setSalidas(db.getDouble(DBStockEstadoDia.SALIDAS));
  }
}
