package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveResultadoCacheo extends Operation { 

  public SaveResultadoCacheo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TResultadoCacheo"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ResultadoCacheo resultadocacheo = ResultadoCacheo.findByOid(dataset.getInteger("oid_est_res_cacheo"),getSesion());
        resultadocacheo.setOID(dataset.getInteger("oid_est_res_cacheo"));
        resultadocacheo.setCodigo(dataset.getString("codigo"));
        resultadocacheo.setDescripcion(dataset.getString("descripcion"));
        resultadocacheo.setActivo(dataset.getBoolean("activo"));
        addTransaccion(resultadocacheo);
        dataset.next();
    }
  }
  
}
