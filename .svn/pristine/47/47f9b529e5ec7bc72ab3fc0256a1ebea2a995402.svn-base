package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveEstructuraPlan extends Operation { 

  public SaveEstructuraPlan() { 
  }
  
  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TEstructuraPlan"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        EstructuraPlan estructuraplan = EstructuraPlan.findByOid(dataset.getInteger("oid_estruc_plan"),getSesion());
        estructuraplan.setOID(dataset.getInteger("oid_estruc_plan"));
        estructuraplan.setCodigo(dataset.getString("codigo"));
        estructuraplan.setDescripcion(dataset.getString("descripcion"));
        estructuraplan.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsCompoEstrucPlan = dataset.getDataSet("TCompoEstructuraPlan");
        dsCompoEstrucPlan.first();
        while (!dsCompoEstrucPlan.EOF()) {
        	
        	CompoEstructuraPlan compoEstrucPlan = 
        		CompoEstructuraPlan.findByOid(dsCompoEstrucPlan.getInteger("oid_estruc_compo"),this.getSesion());
        	compoEstrucPlan.setCompo_presu(CompoPresupuestario.findByOidProxy(dsCompoEstrucPlan.getInteger("oid_compo_presu"),this.getSesion()));
        	compoEstrucPlan.setEstructura_plan(EstructuraPlan.findByOidProxy(dsCompoEstrucPlan.getInteger("oid_estruc_plan"),this.getSesion()));
        	compoEstrucPlan.setActivo(dsCompoEstrucPlan.getBoolean("activo"));
        	
        	dsCompoEstrucPlan.next();
        	
        	estructuraplan.addCompoEstrucPlan(compoEstrucPlan);
        	
        }               
        
        addTransaccion(estructuraplan);
        dataset.next();
    }
  }
  
}
