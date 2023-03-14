package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.ctasAPagar.bm.ComproProvTotImpu;
import com.srn.erp.ctasAPagar.da.DBComproProvTotImpu;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComproProvTotImpu extends FactoryObjetoLogico {

  public FactoryComproProvTotImpu() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproProvTotImpu comproprovtotimpu = (ComproProvTotImpu) objLog;
    comproprovtotimpu.setOID(db.getInteger(DBComproProvTotImpu.OID_COMPRO_TOT_IMP));
    comproprovtotimpu.setComprobante(ComproCab.findByOidProxyCompro(db.getInteger(DBComproProvTotImpu.OID_CCO),getSesion()));
    comproprovtotimpu.setConceptoImpuesto(ConceptoImpuesto.findByOidProxy(db.getInteger(DBComproProvTotImpu.OID_CONC_IMP),getSesion()));
    comproprovtotimpu.setImporteMonedaOri(db.getMoney(DBComproProvTotImpu.IMPORTE_MONEDA_ORI));
    comproprovtotimpu.setImporteMonedaLocal(db.getMoney(DBComproProvTotImpu.IMPORTE_MONEDA_LOC));
  }
}
