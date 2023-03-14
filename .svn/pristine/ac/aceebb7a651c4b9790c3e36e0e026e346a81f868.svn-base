package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveMotivoDevolucionCliente extends Operation { 

  public SaveMotivoDevolucionCliente() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMotivoDevolucionCliente"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        MotivoDevolucionCliente motivodevolucioncliente = MotivoDevolucionCliente.findByOid(dataset.getInteger("oid"),getSesion());
        motivodevolucioncliente.setOID(dataset.getInteger("oid"));
        motivodevolucioncliente.setCodigo(dataset.getString("codigo"));
        motivodevolucioncliente.setDescripcion(dataset.getString("descripcion"));
        motivodevolucioncliente.setActivo(dataset.getBoolean("activo"));
        addTransaccion(motivodevolucioncliente);
        dataset.next();
    }
  }
  
}
