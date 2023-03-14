package com.srn.erp.impuestos.bl.Factory;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.ListadoIVACab;
import com.srn.erp.impuestos.bm.ListadoIVAConcImpu;
import com.srn.erp.impuestos.da.DBListadoIVAConcImpu;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryListadoIVAConcImpu extends FactoryObjetoLogico { 

  public FactoryListadoIVAConcImpu() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ListadoIVAConcImpu listadoivaconcimpu = (ListadoIVAConcImpu) objLog;
    listadoivaconcimpu.setOID(db.getInteger(DBListadoIVAConcImpu.OID_IMPU_IVA));
    listadoivaconcimpu.setListado_iva(ListadoIVACab.findByOidProxy(db.getInteger(DBListadoIVAConcImpu.OID_LISTADO_IVA),getSesion()));
    listadoivaconcimpu.setConcepto_impuesto(ConceptoImpuesto.findByOidProxy(db.getInteger(DBListadoIVAConcImpu.OID_CONC_IMPU),getSesion()));
    listadoivaconcimpu.setImporte(db.getMoney(DBListadoIVAConcImpu.IMPORTE));
  }
}
