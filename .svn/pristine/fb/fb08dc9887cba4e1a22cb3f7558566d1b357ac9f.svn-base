package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.AgrupadorEstadoStock;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveAgrupadorEstadoStock extends Operation { 

  public SaveAgrupadorEstadoStock() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TAgrupadorEstadoStock"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        AgrupadorEstadoStock agrupadorestadostock = AgrupadorEstadoStock.findByOid(dataset.getInteger("oid_agrup_estado"),getSesion());
        agrupadorestadostock.setOID(dataset.getInteger("oid_agrup_estado"));
        agrupadorestadostock.setCodigo(dataset.getString("codigo"));
        agrupadorestadostock.setDescripcion(dataset.getString("descripcion"));
        agrupadorestadostock.setActivo(dataset.getBoolean("activo"));
        addTransaccion(agrupadorestadostock);
        dataset.next();
    }
  }
  
}
