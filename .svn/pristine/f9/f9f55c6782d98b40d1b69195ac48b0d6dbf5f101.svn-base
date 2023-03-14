package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.MonedaPresu;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveMonedaPresu extends Operation { 

  public SaveMonedaPresu() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMonedaPresu"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        MonedaPresu monedapresu = MonedaPresu.findByOid(dataset.getInteger("oid_moneda"),getSesion());
        monedapresu.setOID(dataset.getInteger("oid_moneda"));
        monedapresu.setCodigo(dataset.getString("codigo"));
        monedapresu.setDescripcion(dataset.getString("descripcion"));
        monedapresu.setSimbolo(dataset.getString("simbol"));
        monedapresu.setActivo(dataset.getBoolean("activo"));
        addTransaccion(monedapresu);
        dataset.next();
    }
  }
  
}
