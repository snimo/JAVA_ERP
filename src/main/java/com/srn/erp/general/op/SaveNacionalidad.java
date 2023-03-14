package com.srn.erp.general.op;

import com.srn.erp.general.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveNacionalidad extends Operation { 

  public SaveNacionalidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TNacionalidad"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        Nacionalidad nacionalidad = Nacionalidad.findByOid(dataset.getInteger("oid_nacionalidad"),getSesion());
        nacionalidad.setOID(dataset.getInteger("oid_nacionalidad"));
        nacionalidad.setCodigo(dataset.getString("codigo"));
        nacionalidad.setDescripcion(dataset.getString("descripcion"));
        nacionalidad.setActivo(dataset.getBoolean("activo"));
        addTransaccion(nacionalidad);
        dataset.next();
    }
  }
  
}
