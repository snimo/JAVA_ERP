package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluConvenio;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRecluConvenio extends Operation { 

  public SaveRecluConvenio() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluConvenio"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RecluConvenio recluconvenio = RecluConvenio.findByOid(dataset.getInteger("oid_convenio"),getSesion());
        recluconvenio.setOID(dataset.getInteger("oid_convenio"));
        recluconvenio.setCodigo(dataset.getString("codigo"));
        recluconvenio.setDescripcion(dataset.getString("descripcion"));
        recluconvenio.setActivo(dataset.getBoolean("activo"));
        addTransaccion(recluconvenio);
        dataset.next();
    }
  }
  
}
