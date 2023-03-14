package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoEstructuraPlanif extends Operation { 

  public SaveGrupoEstructuraPlanif() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoEstructuraPlanif"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoEstructuraPlanif grupoestructuraplanif = GrupoEstructuraPlanif.findByOid(dataset.getInteger("oid_grupo_est"),getSesion());
        grupoestructuraplanif.setOID(dataset.getInteger("oid_grupo_est"));
        grupoestructuraplanif.setCodigo(dataset.getString("codigo"));
        grupoestructuraplanif.setDescripcion(dataset.getString("descripcion"));
        grupoestructuraplanif.setActivo(dataset.getBoolean("activo"));
        grupoestructuraplanif.setOrden(dataset.getInteger("orden"));
        addTransaccion(grupoestructuraplanif);
        dataset.next();
    }
  }
  
}
