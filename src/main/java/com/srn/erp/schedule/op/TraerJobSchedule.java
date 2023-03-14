package com.srn.erp.schedule.op;

import com.srn.erp.schedule.bm.GrupoJobSchedule;
import com.srn.erp.schedule.bm.JobSchedule;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerJobSchedule extends Operation { 

  public TraerJobSchedule() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    JobSchedule jobschedule = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       jobschedule = JobSchedule.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       jobschedule = JobSchedule.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetJobSchedule = getDataSetJobSchedule();
    if (jobschedule != null) { 
        cargarRegistroJobSchedule(datasetJobSchedule, 
                         jobschedule.getOIDInteger(),
                         jobschedule.getCodigo(),
                         jobschedule.getDescripcion(),
                         jobschedule.getOperacion(),
                         jobschedule.isActivo(),
                         jobschedule.getGrupo());
    }
    writeCliente(datasetJobSchedule);
  }

  private IDataSet getDataSetJobSchedule() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TJobSchedule");
    dataset.fieldDef(new Field("oid_job", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("operacion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("oid_grupo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_grupo", Field.STRING, 20));
    dataset.fieldDef(new Field("desc_grupo", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroJobSchedule(IDataSet dataset, 
                         Integer oid_job,
                         String codigo,
                         String descripcion,
                         String operacion,
                         Boolean activo,
                         GrupoJobSchedule grupoJobSchedule) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_job", oid_job);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("operacion", operacion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("oid_grupo", grupoJobSchedule.getOIDInteger());
    dataset.fieldValue("cod_grupo", grupoJobSchedule.getCodigo());
    dataset.fieldValue("desc_grupo", grupoJobSchedule.getDescripcion());
    
  }
}
