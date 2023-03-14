package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveAparatoRRHH extends Operation { 

  public SaveAparatoRRHH() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TAparatoRRHH"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        AparatoRRHH aparatorrhh = AparatoRRHH.findByOid(dataset.getInteger("oid_aparato"),getSesion());
        aparatorrhh.setOID(dataset.getInteger("oid_aparato"));
        aparatorrhh.setCosigo(dataset.getString("codigo"));
        aparatorrhh.setDescripcion(dataset.getString("descripcion"));
        aparatorrhh.setActivo(dataset.getBoolean("activo"));
        addTransaccion(aparatorrhh);
        dataset.next();
    }
  }
  
}
