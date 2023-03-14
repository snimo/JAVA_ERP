package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveEmpresaCIP extends Operation { 

  public SaveEmpresaCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TEmpresaCIP"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        EmpresaCIP empresacip = EmpresaCIP.findByOid(dataset.getInteger("oid_empresa"),getSesion());
        empresacip.setOID(dataset.getInteger("oid_empresa"));
        empresacip.setRazon_social(dataset.getString("razon_social"));
        empresacip.setActivo(dataset.getBoolean("activo"));
        addTransaccion(empresacip);
        dataset.next();
    }
  }
  
}
