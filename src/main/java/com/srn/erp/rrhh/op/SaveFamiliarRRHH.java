package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveFamiliarRRHH extends Operation { 

  public SaveFamiliarRRHH() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TFamiliarRRHH"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        FamiliarRRHH familiarrrhh = FamiliarRRHH.findByOid(dataset.getInteger("oid_familiar"),getSesion());
        familiarrrhh.setOID(dataset.getInteger("oid_familiar"));
        familiarrrhh.setCodigo(dataset.getString("codigo"));
        familiarrrhh.setDescripcion(dataset.getString("descripcion"));
        familiarrrhh.setActivo(dataset.getBoolean("activo"));
        addTransaccion(familiarrrhh);
        dataset.next();
    }
  }
  
}
