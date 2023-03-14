package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.ctasAPagar.bm.TranProv;
import com.srn.erp.ctasAPagar.bm.TranProvVto;
import com.srn.erp.ctasAPagar.da.DBTranProvVto;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTranProvVto extends FactoryObjetoLogico {

  public FactoryTranProvVto() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TranProvVto tranprovvto = (TranProvVto) objLog;
    tranprovvto.setOID(db.getInteger(DBTranProvVto.OID_TRAN_VTO));
    tranprovvto.setTranprov(TranProv.findByOidProxy(db.getInteger(DBTranProvVto.
        OID_TRAN_PROV), getSesion()));
    tranprovvto.setVencimiento(db.getDate(DBTranProvVto.VTO));
    tranprovvto.setImporte(db.getMoney(DBTranProvVto.IMPORTE));
    tranprovvto.setSaldo(db.getMoney(DBTranProvVto.SALDO));
    tranprovvto.setMoneda(Moneda.findByOidProxy(db.getInteger(DBTranProvVto.
        OID_MONEDA), getSesion()));
    tranprovvto.setPendiente(db.getBoolean(DBTranProvVto.PENDIENTE));
    tranprovvto.setNroCuota(db.getInteger(DBTranProvVto.NRO_CUOTA));
    tranprovvto.setFecConfPago(db.getDate(DBTranProvVto.FEC_CONF_PAGO));
  }

}
