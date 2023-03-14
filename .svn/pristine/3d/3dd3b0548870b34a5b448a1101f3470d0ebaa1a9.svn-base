package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveCompePotencial extends Operation { 

  public SaveCompePotencial() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCompePotencial"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        CompePotencial compepotencial = CompePotencial.findByOid(dataset.getInteger("oid_compe_pot"),getSesion());
        compepotencial.setOID(dataset.getInteger("oid_compe_pot"));
        compepotencial.setCosigo(dataset.getString("codigo"));
        compepotencial.setDescripcion(dataset.getString("descripcion"));
        compepotencial.setActivo(dataset.getBoolean("activo"));
        addTransaccion(compepotencial);
        dataset.next();
    }
  }
  
}
