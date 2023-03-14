package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveEnfermedadRRHH extends Operation { 

  public SaveEnfermedadRRHH() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TEnfermedadRRHH"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        EnfermedadRRHH enfermedadrrhh = EnfermedadRRHH.findByOid(dataset.getInteger("oid_enfermedad"),getSesion());
        enfermedadrrhh.setOID(dataset.getInteger("oid_enfermedad"));
        enfermedadrrhh.setCodigo(dataset.getString("codigo"));
        enfermedadrrhh.setDescripcion(dataset.getString("descripcion"));
        enfermedadrrhh.setActivo(dataset.getBoolean("activo"));
        addTransaccion(enfermedadrrhh);
        dataset.next();
    }
  }
  
}
