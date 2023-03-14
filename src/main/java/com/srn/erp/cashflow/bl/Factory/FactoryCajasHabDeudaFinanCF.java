package com.srn.erp.cashflow.bl.Factory;

import com.srn.erp.cashflow.bm.CajasHabDeudaFinanCF;
import com.srn.erp.cashflow.bm.EscenarioCashFlow;
import com.srn.erp.cashflow.da.DBCajasHabDeudaFinanCF;
import com.srn.erp.tesoreria.bm.Caja;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCajasHabDeudaFinanCF extends FactoryObjetoLogico { 

  public FactoryCajasHabDeudaFinanCF() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CajasHabDeudaFinanCF cajashabdeudafinancf = (CajasHabDeudaFinanCF) objLog;
    cajashabdeudafinancf.setOID(db.getInteger(DBCajasHabDeudaFinanCF.OID_CAJA_DEUDA));
    cajashabdeudafinancf.setEscenario_cf(EscenarioCashFlow.findByOidProxy(db.getInteger(DBCajasHabDeudaFinanCF.OID_ESCENARIO),getSesion()));
    cajashabdeudafinancf.setCaja(Caja.findByOidProxy(db.getInteger(DBCajasHabDeudaFinanCF.OID_CAJA),getSesion()));
    cajashabdeudafinancf.setActivo(db.getBoolean(DBCajasHabDeudaFinanCF.ACTIVO));

  }
}
