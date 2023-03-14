package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveTipoPlan extends Operation { 

  public SaveTipoPlan() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTipoPlan"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TipoPlan tipoplan = TipoPlan.findByOid(dataset.getInteger("oid_tipo_plan"),getSesion());
        tipoplan.setOID(dataset.getInteger("oid_tipo_plan"));
        tipoplan.setCodigo(dataset.getString("codigo"));
        tipoplan.setDescripcion(dataset.getString("descripcion"));
        tipoplan.setActivo(dataset.getBoolean("activo"));
        addTransaccion(tipoplan);
        dataset.next();
    }
  }
  
}
