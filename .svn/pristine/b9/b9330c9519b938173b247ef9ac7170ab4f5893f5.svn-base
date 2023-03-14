package com.srn.erp.schedule.op;

import com.srn.erp.schedule.bm.JobSchedule;
import com.srn.erp.schedule.bm.ProgramarJobSchedule;
import com.srn.erp.schedule.bm.TriggerSchedule;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveProgramarJobSchedule extends Operation { 

  public SaveProgramarJobSchedule() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TProgramarJobSchedule"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ProgramarJobSchedule programarjobschedule = ProgramarJobSchedule.findByOid(dataset.getInteger("oid_prog_job"),getSesion());
        programarjobschedule.setOID(dataset.getInteger("oid_prog_job"));
        programarjobschedule.setOrden(dataset.getInteger("orden"));
        programarjobschedule.setJob(JobSchedule.findByOidProxy(dataset.getInteger("oid_job"),this.getSesion()));
        programarjobschedule.setTrigger(TriggerSchedule.findByOidProxy(dataset.getInteger("oid_trigger"),this.getSesion()));
        programarjobschedule.setActivo(dataset.getBoolean("activo"));
        addTransaccion(programarjobschedule);
        dataset.next();
    }
  }
  
}
