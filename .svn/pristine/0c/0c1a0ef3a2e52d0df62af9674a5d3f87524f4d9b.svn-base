package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveClaseSindicato extends Operation { 

  public SaveClaseSindicato() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TClaseSindicato"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ClaseSindicato clasesindicato = ClaseSindicato.findByOid(dataset.getInteger("oid"),getSesion());
        clasesindicato.setOID(dataset.getInteger("oid"));
        clasesindicato.setCodigo(dataset.getString("codigo"));
        clasesindicato.setDescripcion(dataset.getString("descripcion"));
        clasesindicato.setActivo(dataset.getBoolean("activo"));
        addTransaccion(clasesindicato);
        dataset.next();
    }
  }
  
}
