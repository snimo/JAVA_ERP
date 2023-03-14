package com.srn.erp.schedule.op;

import com.srn.erp.schedule.bm.GrupoJobSchedule;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoJobSchedule extends Operation { 

  public SaveGrupoJobSchedule() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoJobSchedule"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoJobSchedule grupojobschedule = GrupoJobSchedule.findByOid(dataset.getInteger("oid_grupo"),getSesion());
        grupojobschedule.setOID(dataset.getInteger("oid_grupo"));
        grupojobschedule.setCodigo(dataset.getString("codigo"));
        grupojobschedule.setDescripcion(dataset.getString("descripcion"));
        grupojobschedule.setActivo(dataset.getBoolean("activo"));
        addTransaccion(grupojobschedule);
        dataset.next();
    }
  }
  
}
