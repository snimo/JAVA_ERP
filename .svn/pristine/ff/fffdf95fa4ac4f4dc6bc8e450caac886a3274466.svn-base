package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveElementoUPC extends Operation { 

  public SaveElementoUPC() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TElementoUPC"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ElementoUPC elementoupc = ElementoUPC.findByOid(dataset.getInteger("oid_elemento_upc"),getSesion());
        elementoupc.setOID(dataset.getInteger("oid_elemento_upc"));
        elementoupc.setCodigo(dataset.getString("codigo"));
        elementoupc.setDescripcion(dataset.getString("descripcion"));
        elementoupc.setTipo(dataset.getString("tipo"));
        elementoupc.setNro_interno(dataset.getInteger("nro_interno"));
        elementoupc.setActivo(dataset.getBoolean("activo"));
        addTransaccion(elementoupc);
        dataset.next();
    }
  }
  
}
