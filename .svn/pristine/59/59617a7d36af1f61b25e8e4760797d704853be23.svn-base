package com.srn.erp.cashflow.bl.Factory;

import com.srn.erp.cashflow.bm.EscenarioCashFlow;
import com.srn.erp.cashflow.bm.ProgFechasCF;
import com.srn.erp.cashflow.da.DBProgFechasCF;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryProgFechasCF extends FactoryObjetoLogico { 

  public FactoryProgFechasCF() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ProgFechasCF progfechascf = (ProgFechasCF) objLog;
    progfechascf.setOID(db.getInteger(DBProgFechasCF.OID_PROG_CF));
    progfechascf.setCodigo(db.getString(DBProgFechasCF.CODIGO));
    progfechascf.setDescripcion(db.getString(DBProgFechasCF.DESCRIPCION));
    progfechascf.setFec_desde(db.getDate(DBProgFechasCF.FEC_DESDE));
    progfechascf.setFec_hasta(db.getDate(DBProgFechasCF.FEC_HASTA));
    progfechascf.setActivo(db.getBoolean(DBProgFechasCF.ACTIVO));
    progfechascf.setEscenario(EscenarioCashFlow.findByOidProxy(db.getInteger(DBProgFechasCF.OID_ESCENARIO),getSesion()));

  }
}
