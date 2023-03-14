package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SaldoStkProdPorEstado;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBSaldoStkProdPorEstado;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySaldoStkProdPorEstado extends FactoryObjetoLogico {

  public FactorySaldoStkProdPorEstado() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SaldoStkProdPorEstado saldostkprodporestado = (SaldoStkProdPorEstado) objLog;
    saldostkprodporestado.setOID(db.getInteger(DBSaldoStkProdPorEstado.OID_SALDO_STK_EST));
    saldostkprodporestado.setProducto(Producto.findByOidProxy(db.getInteger(DBSaldoStkProdPorEstado.OID_PRODUCTO),getSesion()));
    saldostkprodporestado.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBSaldoStkProdPorEstado.OID_UM_STK),getSesion()));
    saldostkprodporestado.setDeposito(Deposito.findByOidProxy(db.getInteger(DBSaldoStkProdPorEstado.OID_DEPOSITO),getSesion()));
    saldostkprodporestado.setEstado_stock(EstadoStock.findByOidProxy(db.getInteger(DBSaldoStkProdPorEstado.OID_ESTADO_STOCK),getSesion()));
    saldostkprodporestado.setSaldo(db.getDouble(DBSaldoStkProdPorEstado.SALDO));
}
}
