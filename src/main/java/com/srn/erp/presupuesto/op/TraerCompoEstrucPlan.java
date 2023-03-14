package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.CompoEstructuraPlan;
import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.EstructuraPlan;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCompoEstrucPlan extends Operation { 

  public TraerCompoEstrucPlan() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

  	IDataSet dsCompoPresu = this.getDataSetCompoPresu();
  	
    EstructuraPlan estructuraPlan = 
    	EstructuraPlan.findByOidProxy(mapaDatos.getInteger("oid_estruc_plan"),this.getSesion());
    
    Iterator iterCompoEstruc = 
    	estructuraPlan.getComponentesEstrucPlan().iterator();
    while (iterCompoEstruc.hasNext()) {
    	CompoEstructuraPlan compoEstrucPlan = (CompoEstructuraPlan) iterCompoEstruc.next();
    	cargarRegistroCompoPresupuestario(dsCompoPresu, compoEstrucPlan.getCompo_presu());
    }
    
    writeCliente(dsCompoPresu);
  }

  private IDataSet getDataSetCompoPresu() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCompoEstrucPlan");
    dataset.fieldDef(new Field("oid_compo_presu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("oid_val_compo", Field.INTEGER, 10)); 
    dataset.fieldDef(new Field("cod_val_compo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("desc_val_compo", Field.STRING, 255)); 
    return dataset;
  }

  private void cargarRegistroCompoPresupuestario(IDataSet dataset, 
                         												 CompoPresupuestario compoPresupuestario) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_compo_presu", compoPresupuestario.getOIDInteger());    		
    dataset.fieldValue("codigo", compoPresupuestario.getCodigo());
    dataset.fieldValue("descripcion", compoPresupuestario.getDescripcion());
    dataset.fieldValue("oid_val_compo", 0);
    dataset.fieldValue("cod_val_compo", ""); 
    dataset.fieldValue("desc_val_compo", ""); 
  }
  
}
