package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.ConceptoCtaContable;
import com.srn.erp.contabilidad.bm.CriterioSelCuenta;
import com.srn.erp.contabilidad.da.DBCriterioSelCuenta;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCriterioSelCuenta extends FactoryObjetoLogico { 

  public FactoryCriterioSelCuenta() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CriterioSelCuenta criterioselcuenta = (CriterioSelCuenta) objLog;
    criterioselcuenta.setOID(db.getInteger(DBCriterioSelCuenta.OID_CRI_SEL_CTA));
    criterioselcuenta.setConcepto_cuenta(ConceptoCtaContable.findByOidProxy(db.getInteger(DBCriterioSelCuenta.OID_CONC_CTA),getSesion()));
    criterioselcuenta.setOrden(db.getInteger(DBCriterioSelCuenta.ORDEN));
    criterioselcuenta.setCriterio(db.getString(DBCriterioSelCuenta.CRITERIO));
    criterioselcuenta.setActivo(db.getBoolean(DBCriterioSelCuenta.ACTIVO));

  }
}
