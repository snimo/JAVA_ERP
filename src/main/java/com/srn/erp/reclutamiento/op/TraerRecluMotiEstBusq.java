package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluMotiEstBusq;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluMotiEstBusq extends Operation { 

  public TraerRecluMotiEstBusq() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RecluMotiEstBusq reclumotiestbusq = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       reclumotiestbusq = RecluMotiEstBusq.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       reclumotiestbusq = RecluMotiEstBusq.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluMotiEstBusq = getDataSetRecluMotiEstBusq();
    if (reclumotiestbusq != null) { 
        cargarRegistroRecluMotiEstBusq(datasetRecluMotiEstBusq, 
                         reclumotiestbusq.getOIDInteger(),
                         reclumotiestbusq.getCodigo(),
                         reclumotiestbusq.getDescripcion(),
                         reclumotiestbusq.isActivo());
    }
    writeCliente(datasetRecluMotiEstBusq);
  }

  private IDataSet getDataSetRecluMotiEstBusq() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluMotiEstBusq");
    dataset.fieldDef(new Field("oid_mot_est_busq", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroRecluMotiEstBusq(IDataSet dataset, 
                         Integer oid_mot_est_busq,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_mot_est_busq", oid_mot_est_busq);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
