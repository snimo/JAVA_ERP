package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerEstadoDesarrollo extends Operation { 

  public TraerEstadoDesarrollo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    EstadoDesarrollo estadodesarrollo = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       estadodesarrollo = EstadoDesarrollo.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       estadodesarrollo = EstadoDesarrollo.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetEstadoDesarrollo = getDataSetEstadoDesarrollo();
    if (estadodesarrollo != null) { 
        cargarRegistroEstadoDesarrollo(datasetEstadoDesarrollo, 
                         estadodesarrollo.getOIDInteger(),
                         estadodesarrollo.getCodigo(),
                         estadodesarrollo.getDescripcion(),
                         estadodesarrollo.isNo_promocionar(),
                         estadodesarrollo.isActivo());
    }
    writeCliente(datasetEstadoDesarrollo);
  }

  private IDataSet getDataSetEstadoDesarrollo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEstadoDesarrollo");
    dataset.fieldDef(new Field("oid_est_desa", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("no_promocionar", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroEstadoDesarrollo(IDataSet dataset, 
                         Integer oid_est_desa,
                         String codigo,
                         String descripcion,
                         Boolean no_promocionar,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_est_desa", oid_est_desa);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("no_promocionar", no_promocionar);
    dataset.fieldValue("activo", activo);
  }
}
