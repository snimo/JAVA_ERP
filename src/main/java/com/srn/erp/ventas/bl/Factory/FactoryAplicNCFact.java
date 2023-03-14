package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.AplicNCFact;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.FacturaDet;
import com.srn.erp.ventas.da.DBAplicNCFact;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAplicNCFact extends FactoryObjetoLogico { 

  public FactoryAplicNCFact() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AplicNCFact aplicncfact = (AplicNCFact) objLog;
    aplicncfact.setOID(db.getInteger(DBAplicNCFact.OID_NC_FACT));
    aplicncfact.setDetalle_nc(FacturaDet.findByOidProxy(db.getInteger(DBAplicNCFact.OID_DET_NC),getSesion()));
    aplicncfact.setCant_nc(db.getMoney(DBAplicNCFact.CANT_NC));
    aplicncfact.setFactura(FacturaCab.findByOidProxy(db.getInteger(DBAplicNCFact.OID_CCO_FACT),getSesion()));
    aplicncfact.setFactura_det(FacturaDet.findByOidProxy(db.getInteger(DBAplicNCFact.OID_CCO_FACT_DET),getSesion()));
    aplicncfact.setActivo(db.getBoolean(DBAplicNCFact.ACTIVO));

  }
}
