package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SavePeligrosidadExcluido extends Operation { 

  public SavePeligrosidadExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TPeligrosidadExcluido"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        PeligrosidadExcluido peligrosidadexcluido = PeligrosidadExcluido.findByOid(dataset.getInteger("oid_peligrosidad"),getSesion());
        peligrosidadexcluido.setOID(dataset.getInteger("oid_peligrosidad"));
        peligrosidadexcluido.setCodigo(dataset.getString("codigo"));
        peligrosidadexcluido.setDescripcion(dataset.getString("descripcion"));
        peligrosidadexcluido.setGrado(dataset.getInteger("grado"));
        peligrosidadexcluido.setActivo(dataset.getBoolean("activo"));
        peligrosidadexcluido.setColor(dataset.getString("color"));
        addTransaccion(peligrosidadexcluido);
        dataset.next();
    }
  }
  
}
