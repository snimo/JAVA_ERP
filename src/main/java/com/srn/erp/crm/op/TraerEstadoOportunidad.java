package com.srn.erp.crm.op;

import com.srn.erp.crm.bm.EstadoOportunidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstadoOportunidad extends Operation { 

  public TraerEstadoOportunidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    EstadoOportunidad estadooportunidad = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       estadooportunidad = EstadoOportunidad.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       estadooportunidad = EstadoOportunidad.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetEstadoOportunidad = getDataSetEstadoOportunidad();
    if (estadooportunidad != null) { 
        cargarRegistroEstadoOportunidad(datasetEstadoOportunidad, 
                         estadooportunidad.getOIDInteger(),
                         estadooportunidad.getCodigo(),
                         estadooportunidad.getDescripcion(),
                         estadooportunidad.getComportamiento(),
                         estadooportunidad.isActivo());
    }
    writeCliente(datasetEstadoOportunidad);
  }

  private IDataSet getDataSetEstadoOportunidad() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEstadoOportunidad");
    dataset.fieldDef(new Field("oid_estado_opor", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 10)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("compo_oportunidad", Field.STRING, 20)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroEstadoOportunidad(IDataSet dataset, 
                         Integer oid_estado_opor,
                         String codigo,
                         String descripcion,
                         String compo_comportunidad,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_estado_opor", oid_estado_opor);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("compo_comportunidad", compo_comportunidad);
    dataset.fieldValue("activo", activo);
  }
}
