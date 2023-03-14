package com.srn.erp.schedule.bl.Factory;

import com.srn.erp.schedule.bm.GrupoJobSchedule;
import com.srn.erp.schedule.bm.JobSchedule;
import com.srn.erp.schedule.da.DBJobSchedule;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryJobSchedule extends FactoryObjetoLogico { 

  public FactoryJobSchedule() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    JobSchedule jobschedule = (JobSchedule) objLog;
    jobschedule.setOID(db.getInteger(DBJobSchedule.OID_JOB));
    jobschedule.setCodigo(db.getString(DBJobSchedule.CODIGO));
    jobschedule.setDescripcion(db.getString(DBJobSchedule.DESCRIPCION));
    jobschedule.setOperacion(db.getString(DBJobSchedule.OPERACION));
    jobschedule.setActivo(db.getBoolean(DBJobSchedule.ACTIVO));
    jobschedule.setGrupo(GrupoJobSchedule.findByOidProxy(db.getInteger(DBJobSchedule.OID_GRUPO),getSesion()));

  }
}
