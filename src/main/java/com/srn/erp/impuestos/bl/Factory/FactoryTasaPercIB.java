package com.srn.erp.impuestos.bl.Factory;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.impuestos.bm.CategoriaIB;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.TasaPercIB;
import com.srn.erp.impuestos.da.DBTasaPercIB;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTasaPercIB extends FactoryObjetoLogico {

  public FactoryTasaPercIB() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TasaPercIB tasapercib = (TasaPercIB) objLog;
    tasapercib.setOID(db.getInteger(DBTasaPercIB.OID_TASA_PERC_IB));
    tasapercib.setConceptoImpuesto(ConceptoImpuesto.findByOidProxy(db.getInteger(DBTasaPercIB.OID_CONC_IMPU),getSesion()));
    tasapercib.setFecVigencia(db.getDate(DBTasaPercIB.FEC_VIGENCIA));
    tasapercib.setPorc(db.getDouble(DBTasaPercIB.PORC));
    tasapercib.setProvincia(Provincia.findByOidProxy(db.getInteger(DBTasaPercIB.OID_PROVINCIA),getSesion()));
    tasapercib.setMontoMinimo(db.getDouble(DBTasaPercIB.MONTO_MINIMO));
    tasapercib.setCategIB(CategoriaIB.findByOidProxy(db.getInteger(DBTasaPercIB.OID_CAT_IB),getSesion()));
    tasapercib.setActivo(db.getBoolean(DBTasaPercIB.ACTIVO));
    tasapercib.setCuentaImputable(CuentaImputable.findByOidProxy(db.getInteger(DBTasaPercIB.OID_ANA_IMP),getSesion()));
  }
}
