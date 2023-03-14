package com.srn.erp.cashflow.bl.Factory;

import com.srn.erp.cashflow.bm.CtaBcoSaldoIniCF;
import com.srn.erp.cashflow.bm.EscenarioCashFlow;
import com.srn.erp.cashflow.da.DBCtaBcoSaldoIniCF;
import com.srn.erp.tesoreria.bm.CuentaBancaria;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCtaBcoSaldoIniCF extends FactoryObjetoLogico { 

  public FactoryCtaBcoSaldoIniCF() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CtaBcoSaldoIniCF ctabcosaldoinicf = (CtaBcoSaldoIniCF) objLog;
    ctabcosaldoinicf.setOID(db.getInteger(DBCtaBcoSaldoIniCF.OID_SAL_INI_CTA));
    ctabcosaldoinicf.setEscenariocf(EscenarioCashFlow.findByOidProxy(db.getInteger(DBCtaBcoSaldoIniCF.OID_ESCENARIO),getSesion()));
    ctabcosaldoinicf.setCuenta_bancaria(CuentaBancaria.findByOidProxy(db.getInteger(DBCtaBcoSaldoIniCF.OID_CTA_BANCARIA),getSesion()));
    ctabcosaldoinicf.setActivo(db.getBoolean(DBCtaBcoSaldoIniCF.ACTIVO));

  }
}
