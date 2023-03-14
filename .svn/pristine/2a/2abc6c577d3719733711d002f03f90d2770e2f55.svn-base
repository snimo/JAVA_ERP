package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluMotiEstCandBusq;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluMotiEstCandBusq extends Operation { 

  public TraerRecluMotiEstCandBusq() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RecluMotiEstCandBusq reclumotiestcandbusq = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       reclumotiestcandbusq = RecluMotiEstCandBusq.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       reclumotiestcandbusq = RecluMotiEstCandBusq.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluMotiEstCandBusq = getDataSetRecluMotiEstCandBusq();
    if (reclumotiestcandbusq != null) { 
        cargarRegistroRecluMotiEstCandBusq(datasetRecluMotiEstCandBusq, 
                         reclumotiestcandbusq.getOIDInteger(),
                         reclumotiestcandbusq.getCodigo(),
                         reclumotiestcandbusq.getDescripcion(),
                         reclumotiestcandbusq.isActivo());
    }
    writeCliente(datasetRecluMotiEstCandBusq);
  }

  private IDataSet getDataSetRecluMotiEstCandBusq() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluMotiEstCandBusq");
    dataset.fieldDef(new Field("oid_mot_est_cand", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroRecluMotiEstCandBusq(IDataSet dataset, 
                         Integer oid_mot_est_cand,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_mot_est_cand", oid_mot_est_cand);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
