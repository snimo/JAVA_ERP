package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoCategAcceso extends Operation { 

  public SaveGrupoCategAcceso() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoCategAcceso"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoCategAcceso grupocategacceso = GrupoCategAcceso.findByOid(dataset.getInteger("oid_grupo_categ"),getSesion());
        grupocategacceso.setOID(dataset.getInteger("oid_grupo_categ"));
        grupocategacceso.setCodigo(dataset.getString("codigo"));
        grupocategacceso.setDescripcion(dataset.getString("descripcion"));
        grupocategacceso.setActivo(dataset.getBoolean("activo"));
        grupocategacceso.setOrden(dataset.getInteger("orden"));
        addTransaccion(grupocategacceso);
        dataset.next();
    }
  }
  
}
