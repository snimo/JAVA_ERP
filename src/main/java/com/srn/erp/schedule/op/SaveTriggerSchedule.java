package com.srn.erp.schedule.op;

import com.srn.erp.schedule.bm.TriggerSchedule;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTriggerSchedule extends Operation { 

  public SaveTriggerSchedule() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTriggerSchedule"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TriggerSchedule triggerschedule = TriggerSchedule.findByOid(dataset.getInteger("oid_trigger"),getSesion());
        triggerschedule.setOID(dataset.getInteger("oid_trigger"));
        triggerschedule.setCodigo(dataset.getString("codigo"));
        triggerschedule.setDescripcion(dataset.getString("descripcion"));
        triggerschedule.setTipo(dataset.getString("tipo"));
        triggerschedule.setActivo(dataset.getBoolean("activo"));
        triggerschedule.setHora(dataset.getInteger("hora"));
        triggerschedule.setMinutos(dataset.getInteger("minutos"));
        triggerschedule.setSegundos(dataset.getInteger("segundos"));
        addTransaccion(triggerschedule);
        dataset.next();
    }
  }
  
}
