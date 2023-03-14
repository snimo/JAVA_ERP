package com.srn.erp.schedule.bl.Factory;

import com.srn.erp.schedule.bm.JobSchedule;
import com.srn.erp.schedule.bm.ProgramarJobSchedule;
import com.srn.erp.schedule.bm.TriggerSchedule;
import com.srn.erp.schedule.da.DBProgramarJobSchedule;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryProgramarJobSchedule extends FactoryObjetoLogico { 

  public FactoryProgramarJobSchedule() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ProgramarJobSchedule programarjobschedule = (ProgramarJobSchedule) objLog;
    programarjobschedule.setOID(db.getInteger(DBProgramarJobSchedule.OID_PROG_JOB));
    programarjobschedule.setOrden(db.getInteger(DBProgramarJobSchedule.ORDEN));
    programarjobschedule.setJob(JobSchedule.findByOidProxy(db.getInteger(DBProgramarJobSchedule.OID_JOB),getSesion()));
    programarjobschedule.setTrigger(TriggerSchedule.findByOidProxy(db.getInteger(DBProgramarJobSchedule.OID_TRIGGER),getSesion()));
    programarjobschedule.setActivo(db.getBoolean(DBProgramarJobSchedule.ACTIVO));

  }
}
