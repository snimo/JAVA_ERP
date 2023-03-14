package com.srn.erp.stock.bl.Factory;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SaldoStockPorItemDepoEst;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBSaldoStockPorItemDepoEst;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySaldoStockPorItemDepoEst extends FactoryObjetoLogico { 

  public FactorySaldoStockPorItemDepoEst() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SaldoStockPorItemDepoEst saldostockporitemdepoest = (SaldoStockPorItemDepoEst) objLog;
    saldostockporitemdepoest.setOID(db.getInteger(DBSaldoStockPorItemDepoEst.OID_SAL_EST_ITEM));
    saldostockporitemdepoest.setDeposito(Deposito.findByOidProxy(db.getInteger(DBSaldoStockPorItemDepoEst.OID_DEPOSITO),getSesion()));
    saldostockporitemdepoest.setProducto(Producto.findByOidProxy(db.getInteger(DBSaldoStockPorItemDepoEst.OID_PRODUCTO),getSesion()));
    saldostockporitemdepoest.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBSaldoStockPorItemDepoEst.OID_UM_STK),getSesion()));
    saldostockporitemdepoest.setEstado_stock(EstadoStock.findByOidProxy(db.getInteger(DBSaldoStockPorItemDepoEst.OID_ESTADO_STOCK),getSesion()));
    saldostockporitemdepoest.setComprobante(ComproCab.findByOidProxyCompro(db.getInteger(DBSaldoStockPorItemDepoEst.OID_CCO_DEST),getSesion()));
    saldostockporitemdepoest.setOid_cco_det(db.getInteger(DBSaldoStockPorItemDepoEst.OID_CCO_DET_DEST));
    saldostockporitemdepoest.setSaldo(db.getMoney(DBSaldoStockPorItemDepoEst.SALDO));
    saldostockporitemdepoest.setTiene_saldo(db.getBoolean(DBSaldoStockPorItemDepoEst.TIENE_SALDO));
  }
}
