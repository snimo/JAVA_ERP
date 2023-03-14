package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SaldoStockUbiEstado;
import com.srn.erp.stock.bm.UbicacionDeposito;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBSaldoStockUbiEstado;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySaldoStockUbiEstado extends FactoryObjetoLogico {

  public FactorySaldoStockUbiEstado() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SaldoStockUbiEstado saldostockubiestado = (SaldoStockUbiEstado) objLog;
    saldostockubiestado.setOID(db.getInteger(DBSaldoStockUbiEstado.OID_SAL_STK_UBI_E));
    saldostockubiestado.setDeposito(Deposito.findByOidProxy(db.getInteger(DBSaldoStockUbiEstado.OID_DEPOSITO),getSesion()));
    saldostockubiestado.setUbicacion_deposito(UbicacionDeposito.findByOidProxy(db.getInteger(DBSaldoStockUbiEstado.OID_UBI_DEPO),getSesion()));
    saldostockubiestado.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBSaldoStockUbiEstado.OID_UM_STK),getSesion()));
    saldostockubiestado.setProducto(Producto.findByOidProxy(db.getInteger(DBSaldoStockUbiEstado.OID_PRODUCTO),getSesion()));
    saldostockubiestado.setEstado_stock(EstadoStock.findByOidProxy(db.getInteger(DBSaldoStockUbiEstado.OID_ESTADO_STOCK),getSesion()));
    saldostockubiestado.setSaldo(db.getDouble(DBSaldoStockUbiEstado.SALDO));
  }
}
