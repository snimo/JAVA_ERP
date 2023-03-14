package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveFormaEntrega extends Operation { 

  public SaveFormaEntrega() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TFormaEntrega"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        FormaEntrega formaentrega = FormaEntrega.findByOid(dataset.getInteger("oid_forma_entrega"),getSesion());
        formaentrega.setOID(dataset.getInteger("oid_forma_entrega"));
        formaentrega.setCodigo(dataset.getString("codigo"));
        formaentrega.setDescripcion(dataset.getString("descripcion"));
        formaentrega.setActivo(dataset.getBoolean("activo"));
        addTransaccion(formaentrega);
        dataset.next();
    }
  }
  
}
