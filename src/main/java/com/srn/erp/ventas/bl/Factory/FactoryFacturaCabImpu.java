package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.FacturaCabImpu;
import com.srn.erp.ventas.da.DBFacturaCabImpu;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFacturaCabImpu extends FactoryObjetoLogico { 

  public FactoryFacturaCabImpu() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FacturaCabImpu facturacabimpu = (FacturaCabImpu) objLog;
    facturacabimpu.setOID(db.getInteger(DBFacturaCabImpu.OID_FACT_CAB_IMPU));
    facturacabimpu.setFacturacab(FacturaCab.findByOidProxy(db.getInteger(DBFacturaCabImpu.OID_CCO_FACT),getSesion()));
    facturacabimpu.setConcepto_impuesto(ConceptoImpuesto.findByOidProxy(db.getInteger(DBFacturaCabImpu.OID_CONC_IMPU),getSesion()));
    facturacabimpu.setImporte_mon_ori(db.getMoney(DBFacturaCabImpu.IMPU_MON_ORI));
    facturacabimpu.setImporte_mon_local(db.getMoney(DBFacturaCabImpu.IMPO_MON_LOCAL));
  }
}
