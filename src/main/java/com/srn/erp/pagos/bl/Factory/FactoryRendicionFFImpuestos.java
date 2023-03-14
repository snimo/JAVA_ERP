package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.bm.RendicionFFImpuestos;
import com.srn.erp.pagos.bm.RendicionFondoFijoCompro;
import com.srn.erp.pagos.da.DBRendicionFFImpuestos;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRendicionFFImpuestos extends FactoryObjetoLogico { 

  public FactoryRendicionFFImpuestos() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RendicionFFImpuestos rendicionffimpuestos = (RendicionFFImpuestos) objLog;
    rendicionffimpuestos.setOID(db.getInteger(DBRendicionFFImpuestos.OID_CONC_IMPU_FP));
    rendicionffimpuestos.setRend_ff_det(RendicionFondoFijoCompro.findByOidProxy(db.getInteger(DBRendicionFFImpuestos.OID_REND_FF_DET),getSesion()));
    rendicionffimpuestos.setConcepto_impuesto(ConceptoImpuesto.findByOidProxy(db.getInteger(DBRendicionFFImpuestos.OID_CONC_IMPU),getSesion()));
    rendicionffimpuestos.setImporte(db.getMoney(DBRendicionFFImpuestos.IMPORTE));
    rendicionffimpuestos.setComportamiento(db.getString(DBRendicionFFImpuestos.COMPORTAMIENTO));

  }
}
