package com.srn.erp.reclutamiento.bl;

import com.srn.erp.reclutamiento.bm.RecluEstAprobBusq;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluEstAprobBusq extends Operation { 

  public TraerRecluEstAprobBusq() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RecluEstAprobBusq recluestaprobbusq = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       recluestaprobbusq = RecluEstAprobBusq.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       recluestaprobbusq = RecluEstAprobBusq.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluEstAprobBusq = getDataSetRecluEstAprobBusq();
    if (recluestaprobbusq != null) { 
        cargarRegistroRecluEstAprobBusq(datasetRecluEstAprobBusq, 
                         recluestaprobbusq.getOIDInteger(),
                         recluestaprobbusq.getCodigo(),
                         recluestaprobbusq.getDescripcion(),
                         recluestaprobbusq.isAprobado(),
                         recluestaprobbusq.isActivo());
    }
    writeCliente(datasetRecluEstAprobBusq);
  }

  private IDataSet getDataSetRecluEstAprobBusq() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluEstAprobBusq");
    dataset.fieldDef(new Field("oid_est_aprob_busq", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("aprobado", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroRecluEstAprobBusq(IDataSet dataset, 
                         Integer oid_est_aprob_busq,
                         String codigo,
                         String descripcion,
                         Boolean aprobado,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_est_aprob_busq", oid_est_aprob_busq);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("aprobado", aprobado);
    dataset.fieldValue("activo", activo);
  }
}
