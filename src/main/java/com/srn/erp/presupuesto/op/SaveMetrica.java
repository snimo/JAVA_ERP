package com.srn.erp.presupuesto.op;


import com.srn.erp.presupuesto.bm.Metrica;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveMetrica extends Operation { 

  public SaveMetrica() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMetrica"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        Metrica metrica = Metrica.findByOid(dataset.getInteger("oid_metrica"),getSesion());
        metrica.setOID(dataset.getInteger("oid_metrica"));
        metrica.setCodigo(dataset.getString("codigo"));
        metrica.setDescripcion(dataset.getString("descripcion"));
        metrica.setTipo(dataset.getString("tipo"));
        metrica.setCant_decimales(dataset.getInteger("cant_decimales"));
        metrica.setMascara_display(dataset.getString("mascara_display"));
        metrica.setActivo(dataset.getBoolean("activo"));
        addTransaccion(metrica);
        dataset.next();
    }
  }
  
}
