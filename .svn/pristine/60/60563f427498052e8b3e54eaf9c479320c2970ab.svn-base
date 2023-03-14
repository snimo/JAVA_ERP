package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SaldoStockProducto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBSaldoStockProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySaldoStockProducto extends FactoryObjetoLogico {

  public FactorySaldoStockProducto() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SaldoStockProducto saldostockproducto = (SaldoStockProducto) objLog;
    saldostockproducto.setOID(db.getInteger(DBSaldoStockProducto.OID_SALDO_PROD));
    saldostockproducto.setProducto(Producto.findByOidProxy(db.getInteger(DBSaldoStockProducto.OID_PRODUCTO),getSesion()));
    saldostockproducto.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBSaldoStockProducto.OID_UM_STK),getSesion()));
    saldostockproducto.setDeposito(Deposito.findByOidProxy(db.getInteger(DBSaldoStockProducto.OID_DEPOSITO),getSesion()));
    saldostockproducto.setSaldo(db.getDouble(DBSaldoStockProducto.SALDO));
  }
}
