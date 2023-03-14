package com.srn.erp.ctasACobrar.bl.Factory;

import com.srn.erp.ctasACobrar.bm.SaldoCtaCteClie;
import com.srn.erp.ctasACobrar.da.DBSaldoCtaCteClie;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySaldoCtaCteClie extends FactoryObjetoLogico { 

  public FactorySaldoCtaCteClie() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SaldoCtaCteClie saldoctacteclie = (SaldoCtaCteClie) objLog;
    saldoctacteclie.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBSaldoCtaCteClie.OID_SUJETO),getSesion()));
    saldoctacteclie.setSaldo(db.getMoney(DBSaldoCtaCteClie.SALDO));
    saldoctacteclie.setMoneda(Moneda.findByOidProxy(db.getInteger(DBSaldoCtaCteClie.OID_MONEDA),getSesion()));
  }
}
