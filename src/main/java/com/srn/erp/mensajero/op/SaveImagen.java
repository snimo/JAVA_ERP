package com.srn.erp.mensajero.op;

import com.srn.erp.mensajero.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveImagen extends Operation { 

  public SaveImagen() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TImagen"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        Imagen imagen = Imagen.findByOid(dataset.getInteger("oid_imagen"),getSesion());
        imagen.setOID(dataset.getInteger("oid_imagen"));
        imagen.setCodigo(dataset.getString("codigo"));
        imagen.setDescripcion(dataset.getString("descripcion"));
        imagen.setActivo(dataset.getBoolean("activo"));
        addTransaccion(imagen);
        dataset.next();
    }
  }
  
}
