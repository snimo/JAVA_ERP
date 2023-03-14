package com.srn.erp.cashflow.bl.Factory;

import com.srn.erp.cashflow.bm.CajaSaldoIniCF;
import com.srn.erp.cashflow.bm.EscenarioCashFlow;
import com.srn.erp.cashflow.da.DBCajaSaldoIniCF;
import com.srn.erp.tesoreria.bm.Caja;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCajaSaldoIniCF extends FactoryObjetoLogico { 

  public FactoryCajaSaldoIniCF() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CajaSaldoIniCF cajasaldoinicf = (CajaSaldoIniCF) objLog;
    cajasaldoinicf.setOID(db.getInteger(DBCajaSaldoIniCF.OID_SAL_INI_CAJA));
    cajasaldoinicf.setEscenariocf(EscenarioCashFlow.findByOidProxy(db.getInteger(DBCajaSaldoIniCF.OID_ESCENARIO),getSesion()));
    cajasaldoinicf.setCaja(Caja.findByOidProxy(db.getInteger(DBCajaSaldoIniCF.OID_CAJA),getSesion()));
    cajasaldoinicf.setActivo(db.getBoolean(DBCajaSaldoIniCF.ACTIVO));

  }
}
