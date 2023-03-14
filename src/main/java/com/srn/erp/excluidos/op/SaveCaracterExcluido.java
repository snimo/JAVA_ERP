package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.CaracterExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCaracterExcluido extends Operation { 

  public SaveCaracterExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCaracterExcluido"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        CaracterExcluido caracterexcluido = CaracterExcluido.findByOid(dataset.getInteger("oid_caracter"),getSesion());
        caracterexcluido.setOID(dataset.getInteger("oid_caracter"));
        caracterexcluido.setCodigo(dataset.getString("codigo"));
        caracterexcluido.setDescripcion(dataset.getString("descripcion"));
        caracterexcluido.setActivo(dataset.getBoolean("activo"));
        addTransaccion(caracterexcluido);
        dataset.next();
    }
  }
  
}
