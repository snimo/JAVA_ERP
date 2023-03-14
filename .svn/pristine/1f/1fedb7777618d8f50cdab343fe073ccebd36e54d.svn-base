package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.ReporteContable;
import com.srn.erp.contabilidad.da.DBReporteContable;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryReporteContable extends FactoryObjetoLogico {

  public FactoryReporteContable() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ReporteContable reportecontable = (ReporteContable) objLog;
    reportecontable.setOID(db.getInteger(DBReporteContable.OID_REP_CONTA));
    reportecontable.setCodigo(db.getString(DBReporteContable.CODIGO));
    reportecontable.setDescripcion(db.getString(DBReporteContable.DESCRIPCION));
    reportecontable.setActivo(db.getBoolean(DBReporteContable.ACTIVO));
    reportecontable.setShowEnABMCtas(db.getBoolean(DBReporteContable.SHOW_ABM_CTAS));

  }
}
