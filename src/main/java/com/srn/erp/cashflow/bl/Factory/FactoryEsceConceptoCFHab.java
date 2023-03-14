package com.srn.erp.cashflow.bl.Factory;

import com.srn.erp.cashflow.bm.ConceptoCashFlow;
import com.srn.erp.cashflow.bm.EsceConceptoCFHab;
import com.srn.erp.cashflow.bm.EscenarioCashFlow;
import com.srn.erp.cashflow.da.DBEsceConceptoCFHab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEsceConceptoCFHab extends FactoryObjetoLogico { 

  public FactoryEsceConceptoCFHab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EsceConceptoCFHab esceconceptocfhab = (EsceConceptoCFHab) objLog;
    esceconceptocfhab.setOID(db.getInteger(DBEsceConceptoCFHab.OID_ESCE_CONC));
    esceconceptocfhab.setConcepto_cf(ConceptoCashFlow.findByOidProxy(db.getInteger(DBEsceConceptoCFHab.OID_CONCEPTO),getSesion()));
    esceconceptocfhab.setEscenario_cf(EscenarioCashFlow.findByOidProxy(db.getInteger(DBEsceConceptoCFHab.OID_ESCENARIO),getSesion()));
    esceconceptocfhab.setActivo(db.getBoolean(DBEsceConceptoCFHab.ACTIVO));

  }
}
