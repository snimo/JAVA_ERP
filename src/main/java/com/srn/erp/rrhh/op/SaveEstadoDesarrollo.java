package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveEstadoDesarrollo extends Operation { 

  public SaveEstadoDesarrollo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TEstadoDesarrollo"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        EstadoDesarrollo estadodesarrollo = EstadoDesarrollo.findByOid(dataset.getInteger("oid_est_desa"),getSesion());
        estadodesarrollo.setOID(dataset.getInteger("oid_est_desa"));
        estadodesarrollo.setCodigo(dataset.getString("codigo"));
        estadodesarrollo.setDescripcion(dataset.getString("descripcion"));
        estadodesarrollo.setNo_promocionar(dataset.getBoolean("no_promocionar"));
        estadodesarrollo.setActivo(dataset.getBoolean("activo"));
        addTransaccion(estadodesarrollo);
        dataset.next();
    }
  }
  
}
