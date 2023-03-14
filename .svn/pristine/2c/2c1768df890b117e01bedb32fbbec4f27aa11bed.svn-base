package com.srn.erp.produccion.op;

import com.srn.erp.produccion.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveTipoRecurso extends Operation { 

  public SaveTipoRecurso() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTipoRecurso"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TipoRecurso tiporecurso = TipoRecurso.findByOid(dataset.getInteger("oid_tipo_recurso"),getSesion());
        tiporecurso.setOID(dataset.getInteger("oid_tipo_recurso"));
        tiporecurso.setCodigo(dataset.getString("codigo"));
        tiporecurso.setDescripcion(dataset.getString("descripcion"));
        tiporecurso.setActivo(dataset.getBoolean("activo"));
        addTransaccion(tiporecurso);
        dataset.next();
    }
  }
  
}
