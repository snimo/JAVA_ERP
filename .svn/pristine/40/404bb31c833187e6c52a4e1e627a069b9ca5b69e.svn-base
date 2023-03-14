package com.srn.erp.schedule.op;

import com.srn.erp.schedule.bm.JobSchedule;
import com.srn.erp.schedule.bm.ProgramarJobSchedule;
import com.srn.erp.schedule.bm.TriggerSchedule;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerProgramarJobSchedule extends Operation { 

  public TraerProgramarJobSchedule() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ProgramarJobSchedule programarjobschedule = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       programarjobschedule = ProgramarJobSchedule.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       programarjobschedule = ProgramarJobSchedule.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetProgramarJobSchedule = getDataSetProgramarJobSchedule();
    if (programarjobschedule != null) { 
        cargarRegistroProgramarJobSchedule(datasetProgramarJobSchedule, 
                         programarjobschedule.getOIDInteger(),
                         programarjobschedule.getOrden(),
                         programarjobschedule.getJob(),
                         programarjobschedule.getTrigger(),
                         programarjobschedule.isActivo());
    }
    writeCliente(datasetProgramarJobSchedule);
  }

  private IDataSet getDataSetProgramarJobSchedule() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TProgramarJobSchedule");
    dataset.fieldDef(new Field("oid_prog_job", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_job", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_job", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_job", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_trigger", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_trigger", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_trigger", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroProgramarJobSchedule(IDataSet dataset, 
                         Integer oid_prog_job,
                         Integer orden,
                         JobSchedule job,
                         TriggerSchedule trigger,
                         Boolean activo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_prog_job", oid_prog_job);
    dataset.fieldValue("orden", orden);
    dataset.fieldValue("oid_job", job.getOIDInteger());
    dataset.fieldValue("cod_job", job.getCodigo());
    dataset.fieldValue("desc_job", job.getDescripcion());
    dataset.fieldValue("oid_trigger", trigger.getOIDInteger());
    dataset.fieldValue("cod_trigger", trigger.getCodigo());
    dataset.fieldValue("desc_trigger", trigger.getDescripcion());
    dataset.fieldValue("activo", activo);
  }
}
