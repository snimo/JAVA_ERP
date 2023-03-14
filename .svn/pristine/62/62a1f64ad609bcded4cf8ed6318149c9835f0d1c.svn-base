package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveRazaExcluido extends Operation { 

  public SaveRazaExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRazaExcluido"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RazaExcluido razaexcluido = RazaExcluido.findByOid(dataset.getInteger("oid_raza"),getSesion());
        razaexcluido.setOID(dataset.getInteger("oid_raza"));
        razaexcluido.setCodigo(dataset.getString("codigo"));
        razaexcluido.setDescripcion(dataset.getString("descripcion"));
        razaexcluido.setActivo(dataset.getBoolean("activo"));
        addTransaccion(razaexcluido);
        dataset.next();
    }
  }
  
}
