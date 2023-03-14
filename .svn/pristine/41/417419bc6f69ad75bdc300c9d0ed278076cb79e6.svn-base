package com.srn.erp.cashflow.bl.Factory;

import com.srn.erp.cashflow.bm.ConceptoCashFlow;
import com.srn.erp.cashflow.bm.EscenarioCashFlow;
import com.srn.erp.cashflow.bm.GrupoConceptoCF;
import com.srn.erp.cashflow.bm.ProgFechasCF;
import com.srn.erp.cashflow.bm.VistaCashFlow;
import com.srn.erp.cashflow.da.DBVistaCashFlow;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryVistaCashFlow extends FactoryObjetoLogico { 

  public FactoryVistaCashFlow() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    VistaCashFlow vistacashflow = (VistaCashFlow) objLog;
    vistacashflow.setOID(db.getInteger(DBVistaCashFlow.OID_VISTA_CF));
    vistacashflow.setProg_cf(ProgFechasCF.findByOidProxy(db.getInteger(DBVistaCashFlow.OID_PROG_CF),getSesion()));
    vistacashflow.setConcepto_cf(ConceptoCashFlow.findByOidProxy(db.getInteger(DBVistaCashFlow.OID_CONCEPTO),getSesion()));
    vistacashflow.setFecha(db.getDate(DBVistaCashFlow.FECHA));
    vistacashflow.setFecha_original(db.getDate(DBVistaCashFlow.FEC_ORI));
    vistacashflow.setImporte(db.getDouble(DBVistaCashFlow.IMPORTE));
    vistacashflow.setMoneda(Moneda.findByOidProxy(db.getInteger(DBVistaCashFlow.OID_MONEDA),getSesion()));
    vistacashflow.setGrupo_concepto(GrupoConceptoCF.findByOidProxy(db.getInteger(DBVistaCashFlow.OID_GRUPO_CONCEPTO),getSesion()));
    vistacashflow.setEscenario_cf(EscenarioCashFlow.findByOidProxy(db.getInteger(DBVistaCashFlow.OID_ESCENARIO),getSesion()));
    vistacashflow.setActivo(db.getBoolean(DBVistaCashFlow.ACTIVO));
    vistacashflow.setDescripcion(db.getString(DBVistaCashFlow.DESCRIPCION));
  }
}
