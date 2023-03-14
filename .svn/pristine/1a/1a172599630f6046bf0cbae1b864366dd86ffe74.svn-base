package com.srn.erp.schedule.op;

import com.srn.erp.schedule.bm.GrupoJobSchedule;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoJobSchedule extends Operation { 

  public TraerGrupoJobSchedule() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    GrupoJobSchedule grupojobschedule = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       grupojobschedule = GrupoJobSchedule.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       grupojobschedule = GrupoJobSchedule.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetGrupoJobSchedule = getDataSetGrupoJobSchedule();
    if (grupojobschedule != null) { 
        cargarRegistroGrupoJobSchedule(datasetGrupoJobSchedule, 
                         grupojobschedule.getOIDInteger(),
                         grupojobschedule.getCodigo(),
                         grupojobschedule.getDescripcion(),
                         grupojobschedule.isActivo());
    }
    writeCliente(datasetGrupoJobSchedule);
  }

  private IDataSet getDataSetGrupoJobSchedule() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoJobSchedule");
    dataset.fieldDef(new Field("oid_grupo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroGrupoJobSchedule(IDataSet dataset, 
                         Integer oid_grupo,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_grupo", oid_grupo);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
