package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluFuente;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluFuente extends Operation { 

  public TraerRecluFuente() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RecluFuente reclufuente = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       reclufuente = RecluFuente.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       reclufuente = RecluFuente.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluFuente = getDataSetRecluFuente();
    if (reclufuente != null) { 
        cargarRegistroRecluFuente(datasetRecluFuente, 
                         reclufuente.getOIDInteger(),
                         reclufuente.getCodigo(),
                         reclufuente.getDescripcion(),
                         reclufuente.isActivo());
    }
    writeCliente(datasetRecluFuente);
  }

  private IDataSet getDataSetRecluFuente() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluFuente");
    dataset.fieldDef(new Field("oid_fuente", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroRecluFuente(IDataSet dataset, 
                         Integer oid_fuente,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_fuente", oid_fuente);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
