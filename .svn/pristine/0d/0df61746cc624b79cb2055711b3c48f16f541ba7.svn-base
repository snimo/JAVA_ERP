package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.Partida;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SaldoStockPartidaSerie;
import com.srn.erp.stock.bm.Serie;
import com.srn.erp.stock.bm.UbicacionDeposito;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBSaldoStockPartidaSerie;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySaldoStockPartidaSerie extends FactoryObjetoLogico {

  public FactorySaldoStockPartidaSerie() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SaldoStockPartidaSerie saldostockpartidaserie = (SaldoStockPartidaSerie) objLog;
    saldostockpartidaserie.setOID(db.getInteger(DBSaldoStockPartidaSerie.OID_STK_SAL_P_S));
    saldostockpartidaserie.setPartida(Partida.findByOidProxy(db.getInteger(DBSaldoStockPartidaSerie.OID_PARTIDA),getSesion()));
    saldostockpartidaserie.setProducto(Producto.findByOidProxy(db.getInteger(DBSaldoStockPartidaSerie.OID_PRODUCTO),getSesion()));
    saldostockpartidaserie.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBSaldoStockPartidaSerie.OID_UM_STK),getSesion()));
    saldostockpartidaserie.setSaldo_cero(db.getBoolean(DBSaldoStockPartidaSerie.SALDO_CERO));
    saldostockpartidaserie.setSerie(Serie.findByOidProxy(db.getInteger(DBSaldoStockPartidaSerie.OID_SERIE),getSesion()));
    saldostockpartidaserie.setUbicacion_deposito(UbicacionDeposito.findByOidProxy(db.getInteger(DBSaldoStockPartidaSerie.OID_UBI_DEPO),getSesion()));
    saldostockpartidaserie.setEstado_stock(EstadoStock.findByOidProxy(db.getInteger(DBSaldoStockPartidaSerie.OID_ESTADO_STOCK),getSesion()));
    saldostockpartidaserie.setDeposito(Deposito.findByOidProxy(db.getInteger(DBSaldoStockPartidaSerie.OID_DEPOSITO),getSesion()));
    saldostockpartidaserie.setSaldo(db.getDouble(DBSaldoStockPartidaSerie.SALDO));
  }
}
