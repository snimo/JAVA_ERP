package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluMotivoBusqueda;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRecluMotivoBusqueda extends Operation { 

  public SaveRecluMotivoBusqueda() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluMotivoBusqueda"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RecluMotivoBusqueda reclumotivobusqueda = RecluMotivoBusqueda.findByOid(dataset.getInteger("oid_motivo_busq"),getSesion());
        reclumotivobusqueda.setOID(dataset.getInteger("oid_motivo_busq"));
        reclumotivobusqueda.setCodigo(dataset.getString("codigo"));
        reclumotivobusqueda.setDescripcion(dataset.getString("descripcion"));
        reclumotivobusqueda.setActivo(dataset.getBoolean("activo"));
        addTransaccion(reclumotivobusqueda);
        dataset.next();
    }
  }
  
}
