package com.srn.erp.cashflow.bl.Factory;

import com.srn.erp.cashflow.bm.ConceptoCashFlow;
import com.srn.erp.cashflow.bm.ConfProgConcCF;
import com.srn.erp.cashflow.da.DBConfProgConcCF;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConfProgConcCF extends FactoryObjetoLogico { 

  public FactoryConfProgConcCF() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConfProgConcCF confprogconccf = (ConfProgConcCF) objLog;
    confprogconccf.setOID(db.getInteger(DBConfProgConcCF.OID_PROG_CONC));
    confprogconccf.setConcepto(ConceptoCashFlow.findByOidProxy(db.getInteger(DBConfProgConcCF.OID_CONCEPTO),getSesion()));
    confprogconccf.setNro_mes(db.getInteger(DBConfProgConcCF.NRO_MES));
    confprogconccf.setDia(db.getInteger(DBConfProgConcCF.DIA));
    confprogconccf.setMonto(db.getDouble(DBConfProgConcCF.MONTO));
    confprogconccf.setMoneda(Moneda.findByOidProxy(db.getInteger(DBConfProgConcCF.OID_MONEDA),getSesion()));
    confprogconccf.setActivo(db.getBoolean(DBConfProgConcCF.ACTIVO));

  }
}
