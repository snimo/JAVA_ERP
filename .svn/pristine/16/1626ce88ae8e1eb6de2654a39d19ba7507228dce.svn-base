package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluEstAprobBusq;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRecluEstAprobBusq extends Operation { 

  public SaveRecluEstAprobBusq() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluEstAprobBusq"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RecluEstAprobBusq recluestaprobbusq = RecluEstAprobBusq.findByOid(dataset.getInteger("oid_est_aprob_busq"),getSesion());
        recluestaprobbusq.setOID(dataset.getInteger("oid_est_aprob_busq"));
        recluestaprobbusq.setCodigo(dataset.getString("codigo"));
        recluestaprobbusq.setDescripcion(dataset.getString("descripcion"));
        recluestaprobbusq.setAprobado(dataset.getBoolean("aprobado"));
        recluestaprobbusq.setActivo(dataset.getBoolean("activo"));
        addTransaccion(recluestaprobbusq);
        dataset.next();
    }
  }
  
}
