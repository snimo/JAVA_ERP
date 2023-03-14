package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveMotivoEgresoEmp extends Operation { 

  public SaveMotivoEgresoEmp() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMotivoEgresoEmp"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        MotivoEgresoEmp motivoegresoemp = MotivoEgresoEmp.findByOid(dataset.getInteger("oid"),getSesion());
        motivoegresoemp.setOID(dataset.getInteger("oid"));
        motivoegresoemp.setCodigo(dataset.getString("codigo"));
        motivoegresoemp.setDescripcion(dataset.getString("descripcion"));
        motivoegresoemp.setActivo(dataset.getBoolean("activo"));
        addTransaccion(motivoegresoemp);
        dataset.next();
    }
  }
  
}
