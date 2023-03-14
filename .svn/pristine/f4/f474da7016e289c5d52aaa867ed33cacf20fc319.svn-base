package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.bm.SaldoCtaCteProv;
import com.srn.erp.ctasAPagar.da.DBSaldoCtaCteProv;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySaldoCtaCteProv extends FactoryObjetoLogico { 

  public FactorySaldoCtaCteProv() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SaldoCtaCteProv saldoctacteprov = (SaldoCtaCteProv) objLog;
    saldoctacteprov.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBSaldoCtaCteProv.OID_PROVEEDOR),getSesion()));
    saldoctacteprov.setSaldo(db.getMoney(DBSaldoCtaCteProv.SALDO));
    saldoctacteprov.setMoneda(Moneda.findByOidProxy(db.getInteger(DBSaldoCtaCteProv.OID_MONEDA),getSesion()));
  }
}
