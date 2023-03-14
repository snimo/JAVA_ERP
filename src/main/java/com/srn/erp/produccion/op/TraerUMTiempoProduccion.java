package com.srn.erp.produccion.op;

import com.srn.erp.produccion.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerUMTiempoProduccion extends Operation { 

  public TraerUMTiempoProduccion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    UMTiempoProduccion umtiempoproduccion = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       umtiempoproduccion = UMTiempoProduccion.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       umtiempoproduccion = UMTiempoProduccion.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetUMTiempoProduccion = getDataSetUMTiempoProduccion();
    if (umtiempoproduccion != null) { 
        cargarRegistroUMTiempoProduccion(datasetUMTiempoProduccion, 
                         umtiempoproduccion.getOIDInteger(),
                         umtiempoproduccion.getCodigo(),
                         umtiempoproduccion.getDescripcion(),
                         umtiempoproduccion.isActivo(),
                         umtiempoproduccion.getComportamiento());
    }
    writeCliente(datasetUMTiempoProduccion);
  }

  private IDataSet getDataSetUMTiempoProduccion() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TUMTiempoProduccion");
    dataset.fieldDef(new Field("oid_um_tiempo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("comportamiento", Field.STRING, 20)); 
    return dataset;
  }

  private void cargarRegistroUMTiempoProduccion(IDataSet dataset, 
                         Integer oid_um_tiempo,
                         String codigo,
                         String descripcion,
                         Boolean activo,
                         String comportamiento) {
    dataset.append(); 
    dataset.fieldValue("oid_um_tiempo", oid_um_tiempo);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("comportamiento", comportamiento);
  }
}
