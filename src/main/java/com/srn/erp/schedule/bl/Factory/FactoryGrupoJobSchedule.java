package com.srn.erp.schedule.bl.Factory;

import com.srn.erp.schedule.bm.GrupoJobSchedule;
import com.srn.erp.schedule.da.DBGrupoJobSchedule;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoJobSchedule extends FactoryObjetoLogico { 

  public FactoryGrupoJobSchedule() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoJobSchedule grupojobschedule = (GrupoJobSchedule) objLog;
    grupojobschedule.setOID(db.getInteger(DBGrupoJobSchedule.OID_GRUPO));
    grupojobschedule.setCodigo(db.getString(DBGrupoJobSchedule.CODIGO));
    grupojobschedule.setDescripcion(db.getString(DBGrupoJobSchedule.DESCRIPCION));
    grupojobschedule.setActivo(db.getBoolean(DBGrupoJobSchedule.ACTIVO));

  }
}
