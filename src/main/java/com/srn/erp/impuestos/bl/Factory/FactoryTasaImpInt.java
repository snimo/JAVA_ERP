package com.srn.erp.impuestos.bl.Factory;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.TasaImpInt;
import com.srn.erp.impuestos.da.DBTasaImpInt;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTasaImpInt extends FactoryObjetoLogico {

  public FactoryTasaImpInt() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TasaImpInt tasaimpint = (TasaImpInt) objLog;
    tasaimpint.setOID(db.getInteger(DBTasaImpInt.OID_IMP_INT));
    tasaimpint.setConceptoimpuesto(ConceptoImpuesto.findByOidProxy(db.getInteger(DBTasaImpInt.OID_CONC_IMPU),getSesion()));
    tasaimpint.setFecvigencia(db.getDate(DBTasaImpInt.FEC_VIGENCIA));
    tasaimpint.setPorc(db.getDouble(DBTasaImpInt.PORC));
    tasaimpint.setMontominimo(db.getDouble(DBTasaImpInt.MONTO_MINIMO));
    tasaimpint.setActivo(db.getBoolean(DBTasaImpInt.ACTIVO));

  }
}
