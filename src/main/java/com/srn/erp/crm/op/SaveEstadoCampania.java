package com.srn.erp.crm.op;

import com.srn.erp.crm.bm.EstadoCampania;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEstadoCampania extends Operation { 

  public SaveEstadoCampania() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TEstadoCampania"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        EstadoCampania estadocampania = EstadoCampania.findByOid(dataset.getInteger("oid_estado_camp"),getSesion());
        estadocampania.setCodigo(dataset.getString("codigo"));
        estadocampania.setDescripcion(dataset.getString("descripcion"));
        estadocampania.setActivo(dataset.getBoolean("activo"));
        estadocampania.setComportamiento(dataset.getString("compo_est_camp"));
        estadocampania.setOID(dataset.getInteger("oid_estado_camp"));
        addTransaccion(estadocampania);
        dataset.next();
    }
  }
  
}
