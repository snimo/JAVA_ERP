package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveMotVisFalRRHH extends Operation { 

  public SaveMotVisFalRRHH() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMotVisFalRRHH"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        MotVisFalRRHH motvisfalrrhh = MotVisFalRRHH.findByOid(dataset.getInteger("oid_mot_vis_fall"),getSesion());
        motvisfalrrhh.setOID(dataset.getInteger("oid_mot_vis_fall"));
        motvisfalrrhh.setCodigo(dataset.getString("codigo"));
        motvisfalrrhh.setDescripcion(dataset.getString("descripcion"));
        motvisfalrrhh.setActivo(dataset.getBoolean("activo"));
        addTransaccion(motvisfalrrhh);
        dataset.next();
    }
  }
  
}
