package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoCuentas extends Operation { 

  public SaveGrupoCuentas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoCuentas"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoCuentas grupocuentas = GrupoCuentas.findByOid(dataset.getInteger("oid_grupo_cta"),getSesion());
        grupocuentas.setOID(dataset.getInteger("oid_grupo_cta"));
        grupocuentas.setCodigo(dataset.getString("codigo"));
        grupocuentas.setDescripcion(dataset.getString("descripcion"));
        grupocuentas.setActivo(dataset.getBoolean("activo"));
        addTransaccion(grupocuentas);
        dataset.next();
    }
  }
  
}
