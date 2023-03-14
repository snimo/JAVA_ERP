package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveRecluMotiEstCandBusq extends Operation { 

  public SaveRecluMotiEstCandBusq() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluMotiEstCandBusq"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RecluMotiEstCandBusq reclumotiestcandbusq = RecluMotiEstCandBusq.findByOid(dataset.getInteger("oid_mot_est_cand"),getSesion());
        reclumotiestcandbusq.setOID(dataset.getInteger("oid_mot_est_cand"));
        reclumotiestcandbusq.setCodigo(dataset.getString("codigo"));
        reclumotiestcandbusq.setDescripcion(dataset.getString("descripcion"));
        reclumotiestcandbusq.setActivo(dataset.getBoolean("activo"));
        addTransaccion(reclumotiestcandbusq);
        dataset.next();
    }
  }
  
}
