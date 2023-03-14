package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveRecluPuesto extends Operation { 

  public SaveRecluPuesto() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluPuesto"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RecluPuesto reclupuesto = RecluPuesto.findByOid(dataset.getInteger("oid_puesto_busqueda"),getSesion());
        reclupuesto.setOID(dataset.getInteger("oid_puesto_busqueda"));
        reclupuesto.setCodigo(dataset.getString("codigo"));
        reclupuesto.setDescripcion(dataset.getString("descripcion"));
        reclupuesto.setActivo(dataset.getBoolean("activo"));
        addTransaccion(reclupuesto);
        dataset.next();
    }
  }
  
}
