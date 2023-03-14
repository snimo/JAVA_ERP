package com.srn.erp.produccion.op;

import com.srn.erp.produccion.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerProcesoProductivo extends Operation { 

  public TraerProcesoProductivo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ProcesoProductivo procesoproductivo = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       procesoproductivo = ProcesoProductivo.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       procesoproductivo = ProcesoProductivo.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetProcesoProductivo = getDataSetProcesoProductivo();
    if (procesoproductivo != null) { 
        cargarRegistroProcesoProductivo(datasetProcesoProductivo, 
                         procesoproductivo.getOIDInteger(),
                         procesoproductivo.getCodigo(),
                         procesoproductivo.getDescripcion(),
                         procesoproductivo.isActivo());
    }
    writeCliente(datasetProcesoProductivo);
  }

  private IDataSet getDataSetProcesoProductivo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TProcesoProductivo");
    dataset.fieldDef(new Field("oid_proceso", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroProcesoProductivo(IDataSet dataset, 
                         Integer oid_planta,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_proceso", oid_planta);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
