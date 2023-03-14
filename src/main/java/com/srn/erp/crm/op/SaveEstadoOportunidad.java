package com.srn.erp.crm.op;

import com.srn.erp.crm.bm.EstadoOportunidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEstadoOportunidad extends Operation { 

  public SaveEstadoOportunidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TEstadoOportunidad"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        EstadoOportunidad estadooportunidad = EstadoOportunidad.findByOid(dataset.getInteger("oid_estado_opor"),getSesion());
        estadooportunidad.setOID(dataset.getInteger("oid_estado_opor"));
        estadooportunidad.setCodigo(dataset.getString("codigo"));
        estadooportunidad.setDescripcion(dataset.getString("descripcion"));
        estadooportunidad.setComportamiento(dataset.getString("compo_oportunidad"));
        estadooportunidad.setActivo(dataset.getBoolean("activo"));
        addTransaccion(estadooportunidad);
        dataset.next();
    }
  }
  
}
