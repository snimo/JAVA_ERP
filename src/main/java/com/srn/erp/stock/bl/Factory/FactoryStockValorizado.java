package com.srn.erp.stock.bl.Factory;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.StockValorizado;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBStockValorizado;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryStockValorizado extends FactoryObjetoLogico { 

  public FactoryStockValorizado() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    StockValorizado stockvalorizado = (StockValorizado) objLog;
    stockvalorizado.setOID(db.getInteger(DBStockValorizado.OID_STOCK_VAL));
    stockvalorizado.setCompro_mov_stk(ComproCab.findByOidProxyCompro(db.getInteger(DBStockValorizado.OID_CCO_MOV_STOCK),getSesion()));
    stockvalorizado.setFecha(db.getDate(DBStockValorizado.FECHA));
    stockvalorizado.setProducto(Producto.findByOidProxy(db.getInteger(DBStockValorizado.OID_PRODUCTO),getSesion()));
    stockvalorizado.setCantidad(db.getDouble(DBStockValorizado.CANTIDAD));
    stockvalorizado.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBStockValorizado.OID_UM),getSesion()));
    stockvalorizado.setSigno(db.getInteger(DBStockValorizado.SIGNO));
    stockvalorizado.setCosto_total(db.getDouble(DBStockValorizado.COSTO_TOTAL));
    stockvalorizado.setMoneda(Moneda.findByOidProxy(db.getInteger(DBStockValorizado.OID_MONEDA),getSesion()));
    stockvalorizado.setCosto_unitario(db.getDouble(DBStockValorizado.COSTO_UNITARIO));
    stockvalorizado.setCompro_valorizador(ComproCab.findByOidProxyCompro(db.getInteger(DBStockValorizado.OID_CCO_VALORIZ),getSesion()));
    stockvalorizado.setActivo(db.getBoolean(DBStockValorizado.ACTIVO));
    stockvalorizado.setDeposito(Deposito.findByOidProxy(db.getInteger(DBStockValorizado.OID_DEPO),getSesion()));

  }
}
