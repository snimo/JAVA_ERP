package com.srn.erp.produccion.op;

import com.srn.erp.produccion.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SavePlanta extends Operation { 

  public SavePlanta() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TPlanta"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        Planta planta = Planta.findByOid(dataset.getInteger("oid_planta"),getSesion());
        planta.setOID(dataset.getInteger("oid_planta"));
        planta.setCodigo(dataset.getString("codigo"));
        planta.setDescripcion(dataset.getString("descripcion"));
        planta.setActivo(dataset.getBoolean("activo"));
        addTransaccion(planta);
        dataset.next();
    }
  }
  
}
