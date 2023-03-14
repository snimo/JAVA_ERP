package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveMedicoRRHH extends Operation { 

  public SaveMedicoRRHH() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMedicoRRHH"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        MedicoRRHH medicorrhh = MedicoRRHH.findByOid(dataset.getInteger("oid_medico"),getSesion());
        medicorrhh.setOID(dataset.getInteger("oid_medico"));
        medicorrhh.setCodigo(dataset.getString("codigo"));
        medicorrhh.setDescripcion(dataset.getString("descripcion"));
        medicorrhh.setActivo(dataset.getBoolean("activo"));
        addTransaccion(medicorrhh);
        dataset.next();
    }
  }
  
}
