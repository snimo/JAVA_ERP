package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.CargoLegajoExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCargoLegajoExcluido extends Operation { 

  public SaveCargoLegajoExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCargoLegajoExcluido"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        CargoLegajoExcluido cargolegajoexcluido = CargoLegajoExcluido.findByOid(dataset.getInteger("oid_cargo"),getSesion());
        cargolegajoexcluido.setOID(dataset.getInteger("oid_cargo"));
        cargolegajoexcluido.setCodigo(dataset.getString("codigo"));
        cargolegajoexcluido.setDescripcion(dataset.getString("descripcion"));
        cargolegajoexcluido.setActivo(dataset.getBoolean("activo"));
        addTransaccion(cargolegajoexcluido);
        dataset.next();
    }
  }
  
}
