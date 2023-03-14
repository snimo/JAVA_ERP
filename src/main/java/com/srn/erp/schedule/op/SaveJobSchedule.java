package com.srn.erp.schedule.op;

import com.srn.erp.schedule.bm.GrupoJobSchedule;
import com.srn.erp.schedule.bm.JobSchedule;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveJobSchedule extends Operation { 

  public SaveJobSchedule() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TJobSchedule"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        JobSchedule jobschedule = JobSchedule.findByOid(dataset.getInteger("oid_job"),getSesion());
        jobschedule.setOID(dataset.getInteger("oid_job"));
        jobschedule.setCodigo(dataset.getString("codigo"));
        jobschedule.setDescripcion(dataset.getString("descripcion"));
        jobschedule.setOperacion(dataset.getString("operacion"));
        jobschedule.setActivo(dataset.getBoolean("activo"));
        jobschedule.setGrupo(GrupoJobSchedule.findByOidProxy(dataset.getInteger("oid_grupo"),this.getSesion()));
        addTransaccion(jobschedule);
        dataset.next();
    }
  }
  
}
