package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveSubGrupoCategAcceso extends Operation { 

  public SaveSubGrupoCategAcceso() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TSubGrupoCategAcceso"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        SubGrupoCategAcceso subgrupocategacceso = SubGrupoCategAcceso.findByOid(dataset.getInteger("oid_sub_grupo"),getSesion());
        subgrupocategacceso.setOID(dataset.getInteger("oid_sub_grupo"));
        subgrupocategacceso.setCodigo(dataset.getString("codigo"));
        subgrupocategacceso.setDescripcion(dataset.getString("descripcion"));
        subgrupocategacceso.setActivo(dataset.getBoolean("activo"));
        subgrupocategacceso.setOrden(dataset.getInteger("orden"));
        subgrupocategacceso.setGrupo_categoria(GrupoCategAcceso.findByOidProxy(dataset.getInteger("oid_grupo_categ"), this.getSesion()));
        addTransaccion(subgrupocategacceso);
        dataset.next();
    }
  }
  
}
