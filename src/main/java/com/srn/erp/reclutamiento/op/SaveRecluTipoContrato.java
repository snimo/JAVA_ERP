package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluTipoContrato;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRecluTipoContrato extends Operation { 

  public SaveRecluTipoContrato() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluTipoContrato"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RecluTipoContrato reclutipocontrato = RecluTipoContrato.findByOid(dataset.getInteger("oid_tipo_contrato"),getSesion());
        reclutipocontrato.setOID(dataset.getInteger("oid_tipo_contrato"));
        reclutipocontrato.setCodigo(dataset.getString("codigo"));
        reclutipocontrato.setDescripcion(dataset.getString("descripcion"));
        reclutipocontrato.setActivo(dataset.getBoolean("activo"));
        addTransaccion(reclutipocontrato);
        dataset.next();
    }
  }
  
}
