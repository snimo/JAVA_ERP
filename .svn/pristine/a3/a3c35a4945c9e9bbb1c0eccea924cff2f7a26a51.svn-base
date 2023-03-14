package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SavePrestMedidoRRHH extends Operation { 

  public SavePrestMedidoRRHH() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TPrestMedidoRRHH"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        PrestMedidoRRHH prestmedidorrhh = PrestMedidoRRHH.findByOid(dataset.getInteger("oid_prest_med"),getSesion());
        prestmedidorrhh.setOID(dataset.getInteger("oid_prest_med"));
        prestmedidorrhh.setCodigo(dataset.getString("codigo"));
        prestmedidorrhh.setDescripcion(dataset.getString("descripcion"));
        prestmedidorrhh.setActivo(dataset.getBoolean("activo"));
        addTransaccion(prestmedidorrhh);
        dataset.next();
    }
  }
  
}
