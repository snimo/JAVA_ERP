package com.srn.erp.stock.bl.Factory;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.Partida;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.Serie;
import com.srn.erp.stock.bm.StockMovimiento;
import com.srn.erp.stock.bm.UbicacionDeposito;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBStockMovimiento;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryStockMovimiento extends FactoryObjetoLogico {

  public FactoryStockMovimiento() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    StockMovimiento stockmovimiento = (StockMovimiento) objLog;
    stockmovimiento.setOID(db.getInteger(DBStockMovimiento.OID_STOCK_MOV));
    stockmovimiento.setProducto(Producto.findByOidProxy(db.getInteger(DBStockMovimiento.OID_PRODUCTO),getSesion()));
    stockmovimiento.setUbicacion_deposito(UbicacionDeposito.findByOidProxy(db.getInteger(DBStockMovimiento.OID_UBI_DEPO),getSesion()));
    stockmovimiento.setFecha(db.getDate(DBStockMovimiento.FECHA));
    stockmovimiento.setSigno(db.getInteger(DBStockMovimiento.SIGNO));
    stockmovimiento.setCantidad(db.getDouble(DBStockMovimiento.CANTIDAD));
    stockmovimiento.setComprobante(ComproCab.findByOidProxyCompro(db.getInteger(DBStockMovimiento.OID_CCO),getSesion()));
    stockmovimiento.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBStockMovimiento.OID_UM_STK),getSesion()));
    stockmovimiento.setAfecta_stk_fisico(db.getBoolean(DBStockMovimiento.AFECTA_STK_FISICO));
    stockmovimiento.setPartida(Partida.findByOidProxy(db.getInteger(DBStockMovimiento.OID_PARTIDA),getSesion()));
    stockmovimiento.setSerie(Serie.findByOidProxy(db.getInteger(DBStockMovimiento.OID_SERIE),getSesion()));
    stockmovimiento.setFecha_arrivo(db.getDate(DBStockMovimiento.FECHA_ARRIVO));
    stockmovimiento.setCant_recibida(db.getDouble(DBStockMovimiento.CANT_RECIBIDA));
    stockmovimiento.setDeposito(Deposito.findByOidProxy(db.getInteger(DBStockMovimiento.OID_DEPOSITO),getSesion()));
    stockmovimiento.setEstado_stock(EstadoStock.findByOidProxy(db.getInteger(DBStockMovimiento.OID_ESTADO_STOCK),getSesion()));
    stockmovimiento.setPend_arrivo(db.getBoolean(DBStockMovimiento.PEND_ARRIVO));
    stockmovimiento.setActivo(db.getBoolean(DBStockMovimiento.ACTIVO));
    stockmovimiento.setOidComproDet(db.getInteger(DBStockMovimiento.OID_CCO_DET));
    stockmovimiento.setComprobanteDestino(ComproCab.findByOidProxyCompro(db.getInteger(DBStockMovimiento.OID_CCO_DEST),getSesion()));
    stockmovimiento.setOidComproDestinoDet(db.getInteger(DBStockMovimiento.OID_CCO_DET_DEST));
    
  }
}
