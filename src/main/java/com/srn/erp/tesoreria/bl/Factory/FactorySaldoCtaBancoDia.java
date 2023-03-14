package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.SaldoCtaBancoDia;
import com.srn.erp.tesoreria.da.DBSaldoCtaBancoDia;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySaldoCtaBancoDia extends FactoryObjetoLogico {

  public FactorySaldoCtaBancoDia() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SaldoCtaBancoDia saldoctabancodia = (SaldoCtaBancoDia) objLog;
    saldoctabancodia.setOID(db.getInteger(DBSaldoCtaBancoDia.OID_MOV_BCO_SFEC));
    saldoctabancodia.setFecha(db.getDate(DBSaldoCtaBancoDia.FECHA));
    saldoctabancodia.setDebitos(db.getMoney(DBSaldoCtaBancoDia.DEBITOS));
    saldoctabancodia.setCreditos(db.getMoney(DBSaldoCtaBancoDia.CREDITOS));
    saldoctabancodia.setCuentabancaria(CuentaBancaria.findByOidProxy(db.getInteger(DBSaldoCtaBancoDia.OID_CTA_BANCARIA),getSesion()));
    saldoctabancodia.setDebitoshist(db.getMoney(DBSaldoCtaBancoDia.DEBITOS_HIST));
    saldoctabancodia.setCreditoshist(db.getMoney(DBSaldoCtaBancoDia.CREDITOS_HIST));
    saldoctabancodia.setDebitosaju(db.getMoney(DBSaldoCtaBancoDia.DEBITOS_AJU));
    saldoctabancodia.setCreditosaju(db.getMoney(DBSaldoCtaBancoDia.CREDITOS_AJU));
    saldoctabancodia.setDebitosext1(db.getMoney(DBSaldoCtaBancoDia.DEBITOS_EXT1));
    saldoctabancodia.setCreditosext1(db.getMoney(DBSaldoCtaBancoDia.CREDITOS_EXT1));
    saldoctabancodia.setDebitosext2(db.getMoney(DBSaldoCtaBancoDia.DEBITOS_EXT2));
    saldoctabancodia.setCreditosext2(db.getMoney(DBSaldoCtaBancoDia.CREDITOS_EXT2));
  }
}
