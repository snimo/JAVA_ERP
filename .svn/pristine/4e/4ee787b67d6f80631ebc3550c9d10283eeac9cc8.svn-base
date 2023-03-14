package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveRecluFuente extends Operation { 

  public SaveRecluFuente() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluFuente"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RecluFuente reclufuente = RecluFuente.findByOid(dataset.getInteger("oid_fuente"),getSesion());
        reclufuente.setOID(dataset.getInteger("oid_fuente"));
        reclufuente.setCodigo(dataset.getString("codigo"));
        reclufuente.setDescripcion(dataset.getString("descripcion"));
        reclufuente.setActivo(dataset.getBoolean("activo"));
        addTransaccion(reclufuente);
        dataset.next();
    }
  }
  
}
