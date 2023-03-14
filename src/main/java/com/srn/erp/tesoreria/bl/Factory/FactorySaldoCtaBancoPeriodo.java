package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.SaldoCtaBancoPeriodo;
import com.srn.erp.tesoreria.da.DBSaldoCtaBancoPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySaldoCtaBancoPeriodo extends FactoryObjetoLogico {

  public FactorySaldoCtaBancoPeriodo() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SaldoCtaBancoPeriodo saldoctabancoperiodo = (SaldoCtaBancoPeriodo) objLog;
    saldoctabancoperiodo.setOID(db.getInteger(DBSaldoCtaBancoPeriodo.OID_MOV_BCO_SPERI));
    saldoctabancoperiodo.setPeriodo(Periodo.findByOidProxy(db.getInteger(DBSaldoCtaBancoPeriodo.OID_PERI),getSesion()));
    saldoctabancoperiodo.setDebitos(db.getMoney(DBSaldoCtaBancoPeriodo.DEBITOS));
    saldoctabancoperiodo.setCreditos(db.getMoney(DBSaldoCtaBancoPeriodo.CREDITOS));
    saldoctabancoperiodo.setCuentabancaria(CuentaBancaria.findByOidProxy(db.getInteger(DBSaldoCtaBancoPeriodo.OID_CTA_BANCARIA),getSesion()));
    saldoctabancoperiodo.setDebitoshist(db.getMoney(DBSaldoCtaBancoPeriodo.DEBITOS_HIST));
    saldoctabancoperiodo.setCreditoshist(db.getMoney(DBSaldoCtaBancoPeriodo.CREDITOS_HIST));
    saldoctabancoperiodo.setDebitosaju(db.getMoney(DBSaldoCtaBancoPeriodo.DEBITOS_AJU));
    saldoctabancoperiodo.setCreditosaju(db.getMoney(DBSaldoCtaBancoPeriodo.CREDITOS_AJU));
    saldoctabancoperiodo.setDebitosext1(db.getMoney(DBSaldoCtaBancoPeriodo.DEBITOS_EXT1));
    saldoctabancoperiodo.setCreditosext1(db.getMoney(DBSaldoCtaBancoPeriodo.CREDITOS_EXT1));
    saldoctabancoperiodo.setDebitosext2(db.getMoney(DBSaldoCtaBancoPeriodo.DEBITOS_EXT2));
    saldoctabancoperiodo.setCreditosext2(db.getMoney(DBSaldoCtaBancoPeriodo.CREDITOS_EXT2));

  }
}
