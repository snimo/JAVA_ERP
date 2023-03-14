package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.StockDia;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBStockDia;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryStockDia extends FactoryObjetoLogico { 

  public FactoryStockDia() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    StockDia stockdia = (StockDia) objLog;
    stockdia.setOID(db.getInteger(DBStockDia.OID_STK_DIA));
    stockdia.setDeposito(Deposito.findByOidProxy(db.getInteger(DBStockDia.OID_DEPOSITO),getSesion()));
    stockdia.setProducto(Producto.findByOidProxy(db.getInteger(DBStockDia.OID_PRODUCTO),getSesion()));
    stockdia.setUni_med(UnidadMedida.findByOidProxy(db.getInteger(DBStockDia.OID_UM_STK),getSesion()));
    stockdia.setEntradas(db.getDouble(DBStockDia.ENTRADAS));
    stockdia.setSalidas(db.getDouble(DBStockDia.SALIDAS));

  }
}

