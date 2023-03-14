package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoTarjeta extends Operation { 

  public SaveGrupoTarjeta() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoTarjeta"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoTarjeta grupotarjeta = GrupoTarjeta.findByOid(dataset.getInteger("oid_grupo_tar"),getSesion());
        grupotarjeta.setOID(dataset.getInteger("oid_grupo_tar"));
        grupotarjeta.setCodigo(dataset.getString("codigo"));
        grupotarjeta.setDescripcion(dataset.getString("descripcion"));
        grupotarjeta.setActivo(dataset.getBoolean("activo"));
        addTransaccion(grupotarjeta);
        dataset.next();
    }
  }
  
}
