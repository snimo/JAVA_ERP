package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.ViaDespacho;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveViaDespacho extends Operation { 

  public SaveViaDespacho() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TViaDespacho"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ViaDespacho viadespacho = ViaDespacho.findByOid(dataset.getInteger("oid_via_despacho"),getSesion());
        viadespacho.setOID(dataset.getInteger("oid_via_despacho"));
        viadespacho.setCodigo(dataset.getString("codigo"));
        viadespacho.setDescripcion(dataset.getString("descripcion"));
        viadespacho.setActivo(dataset.getBoolean("activo"));
        addTransaccion(viadespacho);
        dataset.next();
    }
  }
  
}
