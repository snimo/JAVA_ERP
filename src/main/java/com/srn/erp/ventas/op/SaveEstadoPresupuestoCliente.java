package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveEstadoPresupuestoCliente extends Operation { 

  public SaveEstadoPresupuestoCliente() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TEstadoPresupuestoCliente"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        EstadoPresupuestoCliente estadopresupuestocliente = EstadoPresupuestoCliente.findByOid(dataset.getInteger("oid_estado"),getSesion());
        estadopresupuestocliente.setOID(dataset.getInteger("oid_estado"));
        estadopresupuestocliente.setCodigo(dataset.getString("codigo"));
        estadopresupuestocliente.setDescripcion(dataset.getString("descripcion"));
        estadopresupuestocliente.setActivo(dataset.getBoolean("activo"));
        addTransaccion(estadopresupuestocliente);
        dataset.next();
    }
  }
  
}
