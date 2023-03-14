package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.ContadorCacheoLeg;
import com.srn.erp.cip.da.DBContadorCacheoLeg;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryContadorCacheoLeg extends FactoryObjetoLogico { 

  public FactoryContadorCacheoLeg() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ContadorCacheoLeg contadorcacheoleg = (ContadorCacheoLeg) objLog;
    contadorcacheoleg.setOID(db.getInteger(DBContadorCacheoLeg.OID_CONT_CACHEO));
    contadorcacheoleg.setLegajo(Legajo.findByOidProxy(db.getInteger(DBContadorCacheoLeg.OID_LEGAJO),getSesion()));
    contadorcacheoleg.setCantidad(db.getInteger(DBContadorCacheoLeg.CANTIDAD));
  }
}
