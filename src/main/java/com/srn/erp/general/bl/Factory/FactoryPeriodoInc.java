package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.general.da.DBPeriodoInc;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPeriodoInc extends FactoryObjetoLogico {

  public FactoryPeriodoInc() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PeriodoInc periodoinc = (PeriodoInc) objLog;
    periodoinc.setOID(db.getInteger(DBPeriodoInc.OID_PERI_INC_CAB));
    periodoinc.setPeriodo(Periodo.findByOidProxy(db.getInteger(DBPeriodo.OID_PERI),getSesion()));
    periodoinc.setTipo(db.getString(DBPeriodoInc.TIPO));
    periodoinc.setCodigo(db.getString(DBPeriodoInc.CODIGO));
    periodoinc.setActivo(db.getBoolean(DBPeriodoInc.ACTIVO));

  }
}
