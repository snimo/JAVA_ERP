package com.srn.erp.cashflow.bl.Factory;

import com.srn.erp.cashflow.bm.CtaSaldoIniCf;
import com.srn.erp.cashflow.bm.EscenarioCashFlow;
import com.srn.erp.cashflow.da.DBCtaSaldoIniCf;
import com.srn.erp.contabilidad.bm.Cuenta;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCtaSaldoIniCf extends FactoryObjetoLogico { 

  public FactoryCtaSaldoIniCf() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CtaSaldoIniCf ctasaldoinicf = (CtaSaldoIniCf) objLog;
    ctasaldoinicf.setOID(db.getInteger(DBCtaSaldoIniCf.OID_SALDO_INI_CTA));
    ctasaldoinicf.setEscenario(EscenarioCashFlow.findByOidProxy(db.getInteger(DBCtaSaldoIniCf.OID_ESCENARIO),getSesion()));
    ctasaldoinicf.setCuenta(Cuenta.findByOidProxy(db.getInteger(DBCtaSaldoIniCf.OID_ANA_CON),getSesion()));
    ctasaldoinicf.setActivo(db.getBoolean(DBCtaSaldoIniCf.ACTIVO));

  }
}
