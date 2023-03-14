package com.srn.erp.rrhh.op;


import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveGradoLegajo extends Operation { 

  public SaveGradoLegajo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrados"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GradoLegajo gradolegajo = GradoLegajo.findByOid(dataset.getInteger("oid_grado_leg"),getSesion());
        gradolegajo.setOID(dataset.getInteger("oid_grado_leg"));
        gradolegajo.setCodigo(dataset.getString("codigo"));
        gradolegajo.setDescripcion(dataset.getString("descripcion"));
        gradolegajo.setActivo(dataset.getBoolean("activo"));
        gradolegajo.setCantJuegosA(dataset.getInteger("cant_juegos_a"));
        gradolegajo.setCantJuegosB(dataset.getInteger("cant_juegos_b"));
        addTransaccion(gradolegajo);
        dataset.next();
    }
  }
  
}
