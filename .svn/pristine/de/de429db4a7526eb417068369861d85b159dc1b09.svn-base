package com.srn.erp.general.op;

import com.srn.erp.general.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerEntidad extends Operation { 

  public TraerEntidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    Entidad entidad = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       entidad = Entidad.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       entidad = Entidad.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetEntidad = getDataSetEntidad();
    if (entidad != null) { 
        cargarRegistroEntidad(datasetEntidad, 
                         entidad.getOIDInteger(),
                         entidad.getCodigo(),
                         entidad.getDescripcion(),
                         entidad.getNombre_nickname(),
                         entidad.isActivo(),
                         entidad.isComprobante());
    }
    writeCliente(datasetEntidad);
  }

  private IDataSet getDataSetEntidad() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEntidad");
    dataset.fieldDef(new Field("oid_entidad", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("nombre_nickname", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("es_comprobante", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroEntidad(IDataSet dataset, 
                         Integer oid_entidad,
                         String codigo,
                         String descripcion,
                         String nombre_nickname,
                         Boolean activo,
                         Boolean esComprobante) {
    dataset.append(); 
    dataset.fieldValue("oid_entidad", oid_entidad);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("nombre_nickname", nombre_nickname);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("es_comprobante", esComprobante);
  }
}
