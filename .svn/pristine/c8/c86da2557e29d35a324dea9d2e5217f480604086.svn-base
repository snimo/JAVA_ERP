package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoRepositorioReal extends Operation { 

  public SaveGrupoRepositorioReal() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoRepositorioReal"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoRepositorioReal gruporepositorioreal = GrupoRepositorioReal.findByOid(dataset.getInteger("oid_grupo_repo"),getSesion());
        gruporepositorioreal.setOID(dataset.getInteger("oid_grupo_repo"));
        gruporepositorioreal.setCodigo(dataset.getString("codigo"));
        gruporepositorioreal.setDescripcion(dataset.getString("descripcion"));
        gruporepositorioreal.setActivo(dataset.getBoolean("activo"));
        addTransaccion(gruporepositorioreal);
        dataset.next();
    }
  }
  
}
