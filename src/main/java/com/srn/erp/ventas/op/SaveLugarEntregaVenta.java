package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveLugarEntregaVenta extends Operation { 

  public SaveLugarEntregaVenta() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TLugarEntregaVenta"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        LugarEntregaVenta lugarentregaventa = LugarEntregaVenta.findByOid(dataset.getInteger("oid_lugar_ent_vta"),getSesion());
        lugarentregaventa.setOID(dataset.getInteger("oid_lugar_ent_vta"));
        lugarentregaventa.setCodigo(dataset.getString("codigo"));
        lugarentregaventa.setDescripcion(dataset.getString("descripcion"));
        lugarentregaventa.setActivo(dataset.getBoolean("activo"));
        addTransaccion(lugarentregaventa);
        dataset.next();
    }
  }
  
}
