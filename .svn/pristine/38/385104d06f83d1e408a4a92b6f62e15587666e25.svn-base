package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoDetalleVenta extends Operation { 

  public SaveGrupoDetalleVenta() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoDetalleVenta"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoDetalleVenta grupodetalleventa = GrupoDetalleVenta.findByOid(dataset.getInteger("oid"),getSesion());
        grupodetalleventa.setOID(dataset.getInteger("oid"));
        grupodetalleventa.setCodigo(dataset.getString("codigo"));
        grupodetalleventa.setDescripcion(dataset.getString("descripcion"));
        grupodetalleventa.setActivo(dataset.getBoolean("activo"));
        addTransaccion(grupodetalleventa);
        dataset.next();
    }
  }
  
}
