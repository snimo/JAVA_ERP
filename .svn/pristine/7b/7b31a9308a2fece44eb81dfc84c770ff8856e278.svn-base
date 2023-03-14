package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.SaldoCuentaBanco;
import com.srn.erp.tesoreria.da.DBSaldoCuentaBanco;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySaldoCuentaBanco extends FactoryObjetoLogico { 

  public FactorySaldoCuentaBanco() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SaldoCuentaBanco saldocuentabanco = (SaldoCuentaBanco) objLog;
    saldocuentabanco.setOID(db.getInteger(DBSaldoCuentaBanco.OID));
    saldocuentabanco.setMoneda(Moneda.findByOidProxy(db.getInteger(DBSaldoCuentaBanco.OID_MONEDA),getSesion()));
    saldocuentabanco.setCuenta_bancaria(CuentaBancaria.findByOidProxy(db.getInteger(DBSaldoCuentaBanco.OID_CTA_BANCARIA),getSesion()));
    saldocuentabanco.setSaldo(db.getMoney(DBSaldoCuentaBanco.SALDO));

  }
}
