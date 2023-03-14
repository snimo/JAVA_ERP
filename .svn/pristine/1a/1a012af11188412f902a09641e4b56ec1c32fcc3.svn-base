package com.srn.erp.general.op;

import com.srn.erp.general.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveDirectorioBaseServidor extends Operation { 

  public SaveDirectorioBaseServidor() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TDirectorioBaseServidor"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        DirectorioBaseServidor directoriobaseservidor = DirectorioBaseServidor.findByOid(dataset.getInteger("oid_dir_base"),getSesion());
        directoriobaseservidor.setOID(dataset.getInteger("oid_dir_base"));
        directoriobaseservidor.setCodigo(dataset.getString("codigo"));
        directoriobaseservidor.setDescripcion(dataset.getString("descripcion"));
        directoriobaseservidor.setActivo(dataset.getBoolean("activo"));
        addTransaccion(directoriobaseservidor);
        dataset.next();
    }
  }
  
}
