package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveFormaExtincion extends Operation { 

  public SaveFormaExtincion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TFormaExtincion"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        FormaExtincion formaextincion = FormaExtincion.findByOid(dataset.getInteger("oid_forma_extincion"),getSesion());
        formaextincion.setOID(dataset.getInteger("oid_forma_extincion"));
        formaextincion.setCodigo(dataset.getString("codigo"));
        formaextincion.setDescripcion(dataset.getString("descripcion"));
        formaextincion.setActivo(dataset.getBoolean("activo"));
        addTransaccion(formaextincion);
        dataset.next();
    }
  }
  
}
