package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.EstadoSeclo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEstadoSeclo extends Operation { 

  public SaveEstadoSeclo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TEstadoSeclo"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        EstadoSeclo estadoseclo = EstadoSeclo.findByOid(dataset.getInteger("oid_estado_seclo"),getSesion());
        estadoseclo.setOID(dataset.getInteger("oid_estado_seclo"));
        estadoseclo.setDescripcion(dataset.getString("descripcion"));
        estadoseclo.setActivo(dataset.getBoolean("activo"));
        addTransaccion(estadoseclo);
        dataset.next();
    }
  }
  
}
