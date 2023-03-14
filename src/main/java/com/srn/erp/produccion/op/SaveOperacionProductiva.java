package com.srn.erp.produccion.op;

import com.srn.erp.produccion.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveOperacionProductiva extends Operation { 

  public SaveOperacionProductiva() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TOperacionProductiva"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        OperacionProductiva operacionproductiva = OperacionProductiva.findByOid(dataset.getInteger("oid_operacion"),getSesion());
        operacionproductiva.setOID(dataset.getInteger("oid_operacion"));
        operacionproductiva.setCodigo(dataset.getString("codigo"));
        operacionproductiva.setDescripcion(dataset.getString("descripcion"));
        operacionproductiva.setActivo(dataset.getBoolean("activo"));
        addTransaccion(operacionproductiva);
        dataset.next();
    }
  }
  
}
