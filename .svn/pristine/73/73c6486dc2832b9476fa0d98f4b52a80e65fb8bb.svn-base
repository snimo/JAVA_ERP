package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerResultadoCacheo extends Operation { 

  public TraerResultadoCacheo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ResultadoCacheo resultadocacheo = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       resultadocacheo = ResultadoCacheo.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       resultadocacheo = ResultadoCacheo.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetResultadoCacheo = getDataSetResultadoCacheo();
    if (resultadocacheo != null)  
        cargarRegistroResultadoCacheo(datasetResultadoCacheo,resultadocacheo);
    
    writeCliente(datasetResultadoCacheo);
  }

  private IDataSet getDataSetResultadoCacheo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TResultadoCacheo");
    dataset.fieldDef(new Field("oid_est_res_cacheo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroResultadoCacheo(IDataSet dataset, 
                         ResultadoCacheo resultadoCahceo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_est_res_cacheo", resultadoCahceo.getOIDInteger());
    dataset.fieldValue("codigo", resultadoCahceo.getCodigo());
    dataset.fieldValue("descripcion", resultadoCahceo.getDescripcion());
    dataset.fieldValue("activo", resultadoCahceo.isActivo());
  }
}
