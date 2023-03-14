package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.PredioExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePredioExcluido extends Operation { 

  public SavePredioExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TPredioExcluido"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        PredioExcluido predioexcluido = PredioExcluido.findByOid(dataset.getInteger("id_predio"),getSesion());
        predioexcluido.setOID(dataset.getInteger("id_predio"));
        predioexcluido.setCodigo(dataset.getString("codigo"));
        predioexcluido.setDescripcion(dataset.getString("descripcion"));
        predioexcluido.setActivo(dataset.getBoolean("activo"));
        addTransaccion(predioexcluido);
        dataset.next();
    }
  }
  
}
