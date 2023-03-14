package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerPlanPresupuestario extends Operation { 

  public TraerPlanPresupuestario() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    PlanPresupuestario planpresupuestario = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       planpresupuestario = PlanPresupuestario.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       planpresupuestario = PlanPresupuestario.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetPlanPresupuestario = getDataSetPlanPresupuestario();
    if (planpresupuestario != null) { 
        cargarRegistroPlanPresupuestario(datasetPlanPresupuestario, 
                         								 planpresupuestario);
    }
    writeCliente(datasetPlanPresupuestario);
  }

  private IDataSet getDataSetPlanPresupuestario() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TPlanPresupuestario");
    dataset.fieldDef(new Field("oid_plan_presu ", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255)); 
    dataset.fieldDef(new Field("oid_estruc_plan", Field.STRING, 0)); 
    dataset.fieldDef(new Field("cod_estruc_plan", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_estruc_plan", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroPlanPresupuestario(IDataSet dataset, 
                         PlanPresupuestario planPresu) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_plan_presu ", planPresu.getOIDInteger() );
    dataset.fieldValue("codigo", planPresu.getCodigo());
    dataset.fieldValue("descripcion", planPresu.getDescripcion());
    dataset.fieldValue("oid_estruc_plan", planPresu.getEstructura_plan().getOIDInteger());
    dataset.fieldValue("cod_estruc_plan", planPresu.getEstructura_plan().getCodigo());
    dataset.fieldValue("desc_estruc_plan", planPresu.getEstructura_plan().getDescripcion());
    dataset.fieldValue("activo", planPresu.isActivo());
  }
}
