package com.srn.erp.impuestos.bl.Factory;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.TasaPercIVA;
import com.srn.erp.impuestos.da.DBTasaPercIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTasaPercIVA extends FactoryObjetoLogico {

  public FactoryTasaPercIVA() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TasaPercIVA tasaperciva = (TasaPercIVA) objLog;
    tasaperciva.setOID(db.getInteger(DBTasaPercIVA.OID_TASA_PERC_IVA));
    tasaperciva.setConcimpuesto(ConceptoImpuesto.findByOidProxy(db.getInteger(DBTasaPercIVA.OID_CONC_IMPU),getSesion()));
    tasaperciva.setFechavigencia(db.getDate(DBTasaPercIVA.FEC_VIGENCIA));
    tasaperciva.setPorcentaje(db.getDouble(DBTasaPercIVA.PORC));
    tasaperciva.setActivo(db.getBoolean(DBTasaPercIVA.ACTIVO));
  }
}
