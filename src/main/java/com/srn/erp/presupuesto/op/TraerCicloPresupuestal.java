package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerCicloPresupuestal extends Operation { 

  public TraerCicloPresupuestal() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    CicloPresupuestal ciclopresupuestal = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       ciclopresupuestal = CicloPresupuestal.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       ciclopresupuestal = CicloPresupuestal.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetCicloPresupuestal = getDataSetCicloPresupuestal();
    if (ciclopresupuestal != null) { 
        cargarRegistroCicloPresupuestal(datasetCicloPresupuestal, 
                         								ciclopresupuestal);
    }
    writeCliente(datasetCicloPresupuestal);
  }

  private IDataSet getDataSetCicloPresupuestal() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCicloPresupuestal");
    dataset.fieldDef(new Field("oid_ciclo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("observacion", Field.STRING, 255)); 
    dataset.fieldDef(new Field("nro_orden_visual", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("oid_tipo_ciclo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("fecha_inicio_planif", Field.DATE, 0));
    return dataset;
  }

  private void cargarRegistroCicloPresupuestal(IDataSet dataset, 
                         CicloPresupuestal cicloPresupuestal) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_ciclo", cicloPresupuestal.getOIDInteger());
    dataset.fieldValue("codigo", cicloPresupuestal.getCodigo());
    dataset.fieldValue("descripcion", cicloPresupuestal.getDescripcion());
    dataset.fieldValue("observacion", cicloPresupuestal.getObservacion());
    dataset.fieldValue("nro_orden_visual", cicloPresupuestal.getNro_orden_visual());
    dataset.fieldValue("activo", cicloPresupuestal.isActivo());
    dataset.fieldValue("oid_tipo_ciclo", cicloPresupuestal.getTipo_ciclo().getOIDInteger());
    dataset.fieldValue("fecha_inicio_planif", cicloPresupuestal.getFechaInicioPlanif());
    
  }
}
