package com.srn.erp.produccion.op;

import com.srn.erp.produccion.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveUMTiempoProduccion extends Operation { 

  public SaveUMTiempoProduccion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TUMTiempoProduccion"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        UMTiempoProduccion umtiempoproduccion = UMTiempoProduccion.findByOid(dataset.getInteger("oid_um_tiempo"),getSesion());
        umtiempoproduccion.setOID(dataset.getInteger("oid_um_tiempo"));
        umtiempoproduccion.setCodigo(dataset.getString("codigo"));
        umtiempoproduccion.setDescripcion(dataset.getString("descripcion"));
        umtiempoproduccion.setActivo(dataset.getBoolean("activo"));
        umtiempoproduccion.setComportamiento(dataset.getString("comportamiento"));
        addTransaccion(umtiempoproduccion);
        dataset.next();
    }
  }
  
}
