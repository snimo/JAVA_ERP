package com.srn.erp.produccion.op;

import com.srn.erp.produccion.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveTipoEstacionTrabajo extends Operation { 

  public SaveTipoEstacionTrabajo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTipoEstacionTrabajo"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TipoEstacionTrabajo tipoestaciontrabajo = TipoEstacionTrabajo.findByOid(dataset.getInteger("oid_tipo_estacion"),getSesion());
        tipoestaciontrabajo.setCodigo(dataset.getString("codigo"));
        tipoestaciontrabajo.setDescripcion(dataset.getString("descripcion"));
        tipoestaciontrabajo.setActivo(dataset.getBoolean("activo"));
        addTransaccion(tipoestaciontrabajo);
        dataset.next();
    }
  }
  
}
