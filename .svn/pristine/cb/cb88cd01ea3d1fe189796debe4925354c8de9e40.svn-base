package com.srn.erp.general.op;

import com.srn.erp.general.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveEntidad extends Operation { 

  public SaveEntidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TEntidad"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        Entidad entidad = Entidad.findByOid(dataset.getInteger("oid_entidad"),getSesion());
        entidad.setOID(dataset.getInteger("oid_entidad"));
        entidad.setCodigo(dataset.getString("codigo"));
        entidad.setDescripcion(dataset.getString("descripcion"));
        entidad.setNombre_nickname(dataset.getString("nombre_nickname"));
        entidad.setActivo(dataset.getBoolean("activo"));
        entidad.setIsComprobante(dataset.getBoolean("es_comprobante"));
        addTransaccion(entidad);
        dataset.next();
    }
  }
  
}
