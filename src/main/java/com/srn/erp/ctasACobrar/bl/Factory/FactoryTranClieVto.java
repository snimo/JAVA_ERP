package com.srn.erp.ctasACobrar.bl.Factory;

import com.srn.erp.ctasACobrar.bm.TranClie;
import com.srn.erp.ctasACobrar.bm.TranClieVto;
import com.srn.erp.ctasACobrar.da.DBTranClieVto;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTranClieVto extends FactoryObjetoLogico { 

  public FactoryTranClieVto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TranClieVto tranclievto = (TranClieVto) objLog;
    tranclievto.setOID(db.getInteger(DBTranClieVto.OID_TRAN_VTO));
    tranclievto.setTran_clie(TranClie.findByOidProxy(db.getInteger(DBTranClieVto.OID_TRAN_CLIE),getSesion()));
    tranclievto.setVto(db.getDate(DBTranClieVto.VTO));
    tranclievto.setImporte(db.getMoney(DBTranClieVto.IMPORTE));
    tranclievto.setSaldo(db.getMoney(DBTranClieVto.SALDO));
    tranclievto.setMoneda(Moneda.findByOidProxy(db.getInteger(DBTranClieVto.OID_MONEDA),getSesion()));
    tranclievto.setPendiente(db.getBoolean(DBTranClieVto.PENDIENTE));
    tranclievto.setNroCuota(db.getInteger(DBTranClieVto.NRO_CUOTA));
    tranclievto.setFechaConfirmacionCobror(db.getDate(DBTranClieVto.FEC_CONF_COBRO));
  }
}
