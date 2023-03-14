package com.srn.erp.payroll.bl.Factory;

import com.srn.erp.payroll.bm.PayConsultaAusentismo;
import com.srn.erp.payroll.da.DBPayConsultaAusentismo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPayConsultaAusentismo extends FactoryObjetoLogico { 

  public FactoryPayConsultaAusentismo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PayConsultaAusentismo payconsultaausentismo = (PayConsultaAusentismo) objLog;
    payconsultaausentismo.setLejago(db.getString(DBPayConsultaAusentismo.LEGAJO));
    payconsultaausentismo.setNombre(db.getString(DBPayConsultaAusentismo.NOMBRE));
    payconsultaausentismo.setSector(db.getString(DBPayConsultaAusentismo.SECTOR));
    payconsultaausentismo.setPuesto(db.getString(DBPayConsultaAusentismo.PUESTO));
    payconsultaausentismo.setFechaIniLicencia(db.getDate(DBPayConsultaAusentismo.FECHA_INI_LIC));
    payconsultaausentismo.setFechaAusensia(db.getDate(DBPayConsultaAusentismo.FECHA_AUSENSIA));
    payconsultaausentismo.settAusencia(db.getString(DBPayConsultaAusentismo.TAUSENCIA));
    payconsultaausentismo.setObservacion(db.getString(DBPayConsultaAusentismo.OBSERVACION));
    payconsultaausentismo.setTramo(db.getString(DBPayConsultaAusentismo.TRAMO));
  }
}