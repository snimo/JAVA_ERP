package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.ctasAPagar.bm.ComproProveedorDet;
import com.srn.erp.ctasAPagar.bm.ComproProveedorImpu;
import com.srn.erp.ctasAPagar.da.DBComproProveedorImpu;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComproProveedorImpu extends FactoryObjetoLogico {

  public FactoryComproProveedorImpu() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproProveedorImpu comproproveedorimpu = (ComproProveedorImpu) objLog;
    comproproveedorimpu.setOID(db.getInteger(DBComproProveedorImpu.OID_CONC_IMPU));
    comproproveedorimpu.setComproProveedorDet(ComproProveedorDet.findByOidProxy(db.getInteger(DBComproProveedorImpu.OID_CCO_PROV_DET),getSesion()));
    comproproveedorimpu.setConceptoImpuesto(ConceptoImpuesto.findByOidProxy(db.getInteger(DBComproProveedorImpu.OID_CONC_IMPU),getSesion()));
    comproproveedorimpu.setActivo(db.getBoolean(DBComproProveedorImpu.ACTIVO));
  }
}
