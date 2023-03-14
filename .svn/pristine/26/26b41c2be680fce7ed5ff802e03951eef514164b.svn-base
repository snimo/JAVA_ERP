package com.srn.erp.impuestos.bl.Factory;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.TasaIVA;
import com.srn.erp.impuestos.da.DBTasaIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTasaIVA extends FactoryObjetoLogico {

  public FactoryTasaIVA() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TasaIVA tasaiva = (TasaIVA) objLog;
    tasaiva.setOID(db.getInteger(DBTasaIVA.OID_TASA_IVA));
    tasaiva.setConcimpuesto(ConceptoImpuesto.findByOidProxy(db.getInteger(DBTasaIVA.OID_CONC_IMPU),getSesion()));
    tasaiva.setFechavigencia(db.getDate(DBTasaIVA.FEC_VIGENCIA));
    tasaiva.setPorcentaje(db.getDouble(DBTasaIVA.PORC));
    tasaiva.setActivo(db.getBoolean(DBTasaIVA.ACTIVO));

  }
}
