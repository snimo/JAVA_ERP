package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluEstadoPostulante;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRecluEstadoPostulante extends Operation { 

  public SaveRecluEstadoPostulante() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluEstadoPostulante"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RecluEstadoPostulante recluestadopostulante = RecluEstadoPostulante.findByOid(dataset.getInteger("oid_estado_postu"),getSesion());
        recluestadopostulante.setOID(dataset.getInteger("oid_estado_postu"));
        recluestadopostulante.setCodigo(dataset.getString("codigo"));
        recluestadopostulante.setDescripcion(dataset.getString("descripcion"));
        recluestadopostulante.setActivo(dataset.getBoolean("activo"));
        recluestadopostulante.setColor(dataset.getInteger("color"));
        recluestadopostulante.setSeleccionado(dataset.getBoolean("seleccionado"));
        addTransaccion(recluestadopostulante);
        dataset.next();
    }
  }
  
}
