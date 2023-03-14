package com.srn.erp.produccion.op;

import com.srn.erp.produccion.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveProcesoProductivo extends Operation { 

  public SaveProcesoProductivo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TProcesoProductivo"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ProcesoProductivo procesoproductivo = ProcesoProductivo.findByOid(dataset.getInteger("oid_proceso"),getSesion());
        procesoproductivo.setCodigo(dataset.getString("codigo"));
        procesoproductivo.setDescripcion(dataset.getString("descripcion"));
        procesoproductivo.setActivo(dataset.getBoolean("activo"));
        addTransaccion(procesoproductivo);
        dataset.next();
    }
  }
  
}
