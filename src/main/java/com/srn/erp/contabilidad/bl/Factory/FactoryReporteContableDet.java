package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.ReporteContable;
import com.srn.erp.contabilidad.bm.ReporteContableDet;
import com.srn.erp.contabilidad.da.DBReporteContableDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryReporteContableDet extends FactoryObjetoLogico {

  public FactoryReporteContableDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ReporteContableDet reportecontabledet = (ReporteContableDet) objLog;
    reportecontabledet.setOID(db.getInteger(DBReporteContableDet.OID_REP_CONTA_DET));
    reportecontabledet.setReporteContable(ReporteContable.findByOidProxy(db.getInteger(DBReporteContableDet.OID_REP_CONTA),getSesion()));
    reportecontabledet.setOidtitulo(db.getInteger(DBReporteContableDet.OID_TITU));
    reportecontabledet.setOidtitulopadre(db.getInteger(DBReporteContableDet.OID_TITU_PADRE));
    reportecontabledet.setDesctitulo(db.getString(DBReporteContableDet.DESC_TITULO));
    reportecontabledet.setCuenta(Cuenta.findByOidProxy(db.getInteger(DBReporteContableDet.OID_ANA_CON),getSesion()));
    reportecontabledet.setCodigodesde(db.getString(DBReporteContableDet.CODIGO_DESDE));
    reportecontabledet.setCodigohasta(db.getString(DBReporteContableDet.CODIGO_HASTA));
    reportecontabledet.setTipo(db.getString(DBReporteContableDet.TIPO));
    reportecontabledet.setOrden(db.getInteger(DBReporteContableDet.ORDEN));
    reportecontabledet.setActivo(db.getBoolean(DBReporteContableDet.ACTIVO));

  }
}
