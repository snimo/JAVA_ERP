
package com.srn.erp.schedule.op;

import com.srn.erp.schedule.bm.TriggerSchedule;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTriggerSchedule extends Operation { 

  public TraerTriggerSchedule() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    TriggerSchedule triggerschedule = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       triggerschedule = TriggerSchedule.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       triggerschedule = TriggerSchedule.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetTriggerSchedule = getDataSetTriggerSchedule();
    if (triggerschedule != null) { 
        cargarRegistroTriggerSchedule(datasetTriggerSchedule, 
                         triggerschedule.getOIDInteger(),
                         triggerschedule.getCodigo(),
                         triggerschedule.getDescripcion(),
                         triggerschedule.getTipo(),
                         triggerschedule.isActivo(),
                         triggerschedule.getHora(),
                         triggerschedule.getMinutos(),
                         triggerschedule.getSegundos()
                         );
    }
    writeCliente(datasetTriggerSchedule);
  }

  private IDataSet getDataSetTriggerSchedule() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTriggerSchedule");
    dataset.fieldDef(new Field("oid_trigger", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("tipo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("hora", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("minutos", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("segundos", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistroTriggerSchedule(IDataSet dataset, 
                         Integer oid_trigger,
                         String codigo,
                         String descripcion,
                         String tipo,
                         Boolean activo,
                         Integer hora,
                         Integer minutos,
                         Integer segundos) {
    dataset.append(); 
    dataset.fieldValue("oid_trigger", oid_trigger);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("tipo", tipo);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("hora", hora);
    dataset.fieldValue("minutos", minutos);
    dataset.fieldValue("segundos", segundos);
  }
}
