package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SavePlanPresupuestario extends Operation { 

  public SavePlanPresupuestario() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TPlanPresupuestario"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        PlanPresupuestario planpresupuestario = PlanPresupuestario.findByOid(dataset.getInteger("oid_plan_presu "),getSesion());
        planpresupuestario.setOID(dataset.getInteger("oid_plan_presu "));
        planpresupuestario.setCodigo(dataset.getString("codigo"));
        planpresupuestario.setDescripcion(dataset.getString("descripcion"));
        planpresupuestario.setEstructura_plan(EstructuraPlan.findByOidProxy(dataset.getInteger("oid_estruc_plan"),this.getSesion()));
        planpresupuestario.setActivo(dataset.getBoolean("activo"));
        addTransaccion(planpresupuestario);
        dataset.next();
    }
  }
  
}
