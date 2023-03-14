package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.CondicionVentaExpoImpo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCondicionVentaExpoImpo extends Operation { 

  public SaveCondicionVentaExpoImpo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCondicionVentaExpoImpo"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        CondicionVentaExpoImpo condicionventaexpoimpo = CondicionVentaExpoImpo.findByOid(dataset.getInteger("oid_cond_vta_ei"),getSesion());
        condicionventaexpoimpo.setOID(dataset.getInteger("oid_cond_vta_ei"));
        condicionventaexpoimpo.setCodigo(dataset.getString("codigo"));
        condicionventaexpoimpo.setDescripcion(dataset.getString("descripcion"));
        condicionventaexpoimpo.setActivo(dataset.getBoolean("activo"));
        addTransaccion(condicionventaexpoimpo);
        dataset.next();
    }
  }
  
}
