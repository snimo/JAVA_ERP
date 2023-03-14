package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveMotivoEstadoPresuCliente extends Operation { 

  public SaveMotivoEstadoPresuCliente() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMotivoEstadoPresuCliente"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        MotivoEstadoPresuCliente motivoestadopresucliente = MotivoEstadoPresuCliente.findByOid(dataset.getInteger("oid_motivo"),getSesion());
        motivoestadopresucliente.setOID(dataset.getInteger("oid_motivo"));
        motivoestadopresucliente.setCodigo(dataset.getString("codigo"));
        motivoestadopresucliente.setDescripcion(dataset.getString("descripcion"));
        motivoestadopresucliente.setActivo(dataset.getBoolean("activo"));
        addTransaccion(motivoestadopresucliente);
        dataset.next();
    }
  }
  
}
