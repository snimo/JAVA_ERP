package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveMotivoFaltaRRHH extends Operation { 

  public SaveMotivoFaltaRRHH() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMotivoFaltaRRHH"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        MotivoFaltaRRHH motivofaltarrhh = MotivoFaltaRRHH.findByOid(dataset.getInteger("oid_mot_falta"),getSesion());
        motivofaltarrhh.setOID(dataset.getInteger("oid_mot_falta"));
        motivofaltarrhh.setCodigo(dataset.getString("codigo"));
        motivofaltarrhh.setDescripcion(dataset.getString("descripcion"));
        motivofaltarrhh.setActivo(dataset.getBoolean("activo"));
        addTransaccion(motivofaltarrhh);
        dataset.next();
    }
  }
  
}
