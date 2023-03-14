package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluMotiEstBusq;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRecluMotiEstBusq extends Operation { 

  public SaveRecluMotiEstBusq() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluMotiEstBusq"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RecluMotiEstBusq reclumotiestbusq = RecluMotiEstBusq.findByOid(dataset.getInteger("oid_mot_est_busq"),getSesion());
        reclumotiestbusq.setOID(dataset.getInteger("oid_mot_est_busq"));
        reclumotiestbusq.setCodigo(dataset.getString("codigo"));
        reclumotiestbusq.setDescripcion(dataset.getString("descripcion"));
        reclumotiestbusq.setActivo(dataset.getBoolean("activo"));
        addTransaccion(reclumotiestbusq);
        dataset.next();
    }
  }
  
}
