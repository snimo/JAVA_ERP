package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.ventas.bm.CotizacionCab;
import com.srn.erp.ventas.bm.CotizacionTotal;
import com.srn.erp.ventas.da.DBCotizacionTotal;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCotizacionTotal extends FactoryObjetoLogico { 

  public FactoryCotizacionTotal() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CotizacionTotal cotizaciontotal = (CotizacionTotal) objLog;
    cotizaciontotal.setOID(db.getInteger(DBCotizacionTotal.OID_COTIZ_TOTAL));
    cotizaciontotal.setCotizacioncab(CotizacionCab.findByOidProxy(db.getInteger(DBCotizacionTotal.OID_COTIZ_CAB),getSesion()));
    cotizaciontotal.setConceptoimpuesto(ConceptoImpuesto.findByOidProxy(db.getInteger(DBCotizacionTotal.OID_CONC_IMPU),getSesion()));
    cotizaciontotal.setSecu(db.getInteger(DBCotizacionTotal.SECU));
    cotizaciontotal.setComportamiento(db.getString(DBCotizacionTotal.COMPORTAMIENTO));
    cotizaciontotal.setConcepto(db.getString(DBCotizacionTotal.CONCEPTO));
    cotizaciontotal.setImporte(db.getMoney(DBCotizacionTotal.IMPORTE));

  }
}
