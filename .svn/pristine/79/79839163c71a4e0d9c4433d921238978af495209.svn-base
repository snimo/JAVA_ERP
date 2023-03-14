package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.CompoEstructuraPlan;
import com.srn.erp.presupuesto.bm.EstructuraPlan;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstructuraPlan extends Operation { 

  public TraerEstructuraPlan() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    EstructuraPlan estructuraplan = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       estructuraplan = EstructuraPlan.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       estructuraplan = EstructuraPlan.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetEstructuraPlan = getDataSetEstructuraPlan();
    IDataSet datasetCompoEstrucPlan = getDataSetCompoEstructuraPlan();
    
    if (estructuraplan != null) { 
    	
        cargarRegistroEstructuraPlan(datasetEstructuraPlan, 
                         estructuraplan.getOIDInteger(),
                         estructuraplan.getCodigo(),
                         estructuraplan.getDescripcion(),
                         estructuraplan.isActivo());
        
        Iterator iterCompoEstrucPlan = 
        	estructuraplan.getComponentesEstrucPlan().iterator();
        while (iterCompoEstrucPlan.hasNext()) {
        	CompoEstructuraPlan compoEstrucPlan = (CompoEstructuraPlan) iterCompoEstrucPlan.next();
        	cargarRegistroCompoEstructuraPlan(datasetCompoEstrucPlan,compoEstrucPlan);
        }
        
    }
    writeCliente(datasetEstructuraPlan);
    writeCliente(datasetCompoEstrucPlan);
  }

  private IDataSet getDataSetEstructuraPlan() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEstructuraPlan");
    dataset.fieldDef(new Field("oid_estruc_plan", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroEstructuraPlan(IDataSet dataset, 
                         Integer oid_estruc_plan,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_estruc_plan", oid_estruc_plan);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
  
  private IDataSet getDataSetCompoEstructuraPlan() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCompoEstructuraPlan");
    dataset.fieldDef(new Field("oid_estruc_compo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_estruc_plan", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_compo_presu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_compo_presu", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_compo_presu", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroCompoEstructuraPlan(IDataSet dataset, 
                         CompoEstructuraPlan compoEstrucPlan) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_estruc_compo", compoEstrucPlan.getOIDInteger());
    dataset.fieldValue("oid_estruc_plan", compoEstrucPlan.getEstructura_plan().getOIDInteger());
    dataset.fieldValue("oid_compo_presu", compoEstrucPlan.getCompo_presu().getOIDInteger());
    dataset.fieldValue("cod_compo_presu", compoEstrucPlan.getCompo_presu().getCodigo());
    dataset.fieldValue("desc_compo_presu", compoEstrucPlan.getCompo_presu().getDescripcion());
    dataset.fieldValue("activo", compoEstrucPlan.isActivo());
  }  
  
}
