package com.srn.erp.produccion.op;

import com.srn.erp.produccion.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerTipoEstacionTrabajo extends Operation { 

  public TraerTipoEstacionTrabajo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    TipoEstacionTrabajo tipoestaciontrabajo = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       tipoestaciontrabajo = TipoEstacionTrabajo.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       tipoestaciontrabajo = TipoEstacionTrabajo.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetTipoEstacionTrabajo = getDataSetTipoEstacionTrabajo();
    if (tipoestaciontrabajo != null) { 
        cargarRegistroTipoEstacionTrabajo(datasetTipoEstacionTrabajo, 
                         tipoestaciontrabajo.getOIDInteger(),
                         tipoestaciontrabajo.getCodigo(),
                         tipoestaciontrabajo.getDescripcion(),
                         tipoestaciontrabajo.isActivo());
    }
    writeCliente(datasetTipoEstacionTrabajo);
  }

  private IDataSet getDataSetTipoEstacionTrabajo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoEstacionTrabajo");
    dataset.fieldDef(new Field("oid_tipo_estacion", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroTipoEstacionTrabajo(IDataSet dataset, 
                         Integer oid_tipo_estacion,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_tipo_estacion", oid_tipo_estacion);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
