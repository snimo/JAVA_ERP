package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveGerenteExcluido extends Operation { 

  public SaveGerenteExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGerenteExcluido"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GerenteExcluido gerenteexcluido = GerenteExcluido.findByOid(dataset.getInteger("oid_gerente"),getSesion());
        gerenteexcluido.setOID(dataset.getInteger("oid_gerente"));
        gerenteexcluido.setCodigo(dataset.getString("codigo"));
        gerenteexcluido.setDescripcion(dataset.getString("descripcion"));
        gerenteexcluido.setActivo(dataset.getBoolean("activo"));
        addTransaccion(gerenteexcluido);
        dataset.next();
    }
  }
  
}
