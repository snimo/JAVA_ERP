package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SaldoStockUbi;
import com.srn.erp.stock.bm.UbicacionDeposito;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBSaldoStockUbi;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySaldoStockUbi extends FactoryObjetoLogico {

  public FactorySaldoStockUbi() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SaldoStockUbi saldostockubi = (SaldoStockUbi) objLog;
    saldostockubi.setOID(db.getInteger(DBSaldoStockUbi.OID_SAL_STK_UBI));
    saldostockubi.setDeposito(Deposito.findByOidProxy(db.getInteger(DBSaldoStockUbi.OID_DEPOSITO),getSesion()));
    saldostockubi.setUbicacion_deposito(UbicacionDeposito.findByOidProxy(db.getInteger(DBSaldoStockUbi.OID_UBI_DEPO),getSesion()));
    saldostockubi.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBSaldoStockUbi.OID_UM_STK),getSesion()));
    saldostockubi.setProducto(Producto.findByOidProxy(db.getInteger(DBSaldoStockUbi.OID_PRODUCTO),getSesion()));
    saldostockubi.setSaldo(db.getDouble(DBSaldoStockUbi.SALDO));
  }
}
