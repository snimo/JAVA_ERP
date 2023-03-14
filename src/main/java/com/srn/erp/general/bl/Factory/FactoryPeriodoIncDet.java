package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPeriodoIncDet extends FactoryObjetoLogico {

  public FactoryPeriodoIncDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PeriodoIncDet periodoincdet = (PeriodoIncDet) objLog;
    periodoincdet.setOID(db.getInteger(DBPeriodoIncDet.OID_PERI_INC_DET));
    periodoincdet.setPeriinc(PeriodoInc.findByOidProxy(db.getInteger(DBPeriodoIncDet.OID_PERI_INC_CAB),getSesion()));
    periodoincdet.setSecu(db.getInteger(DBPeriodoIncDet.SECU));
    periodoincdet.setPeriodo(Periodo.findByOidProxy(db.getInteger(DBPeriodoIncDet.OID_PERI),getSesion()));
    periodoincdet.setActivo(db.getBoolean(DBPeriodoIncDet.ACTIVO));

  }
}
