package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveResultadoJuicio extends Operation { 

  public SaveResultadoJuicio() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TResultadoJuicio"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ResultadoJuicio resultadojuicio = ResultadoJuicio.findByOid(dataset.getInteger("oid_resul_juicio"),getSesion());
        resultadojuicio.setOID(dataset.getInteger("oid_resul_juicio"));
        resultadojuicio.setCodigo(dataset.getString("codigo"));
        resultadojuicio.setDescripcion(dataset.getString("descripcion"));
        resultadojuicio.setActivo(dataset.getBoolean("activo"));
        addTransaccion(resultadojuicio);
        dataset.next();
    }
  }
  
}
