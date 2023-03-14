package com.srn.erp.produccion.op;

import com.srn.erp.produccion.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerOperacionProductiva extends Operation { 

  public TraerOperacionProductiva() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    OperacionProductiva operacionproductiva = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       operacionproductiva = OperacionProductiva.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       operacionproductiva = OperacionProductiva.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetOperacionProductiva = getDataSetOperacionProductiva();
    if (operacionproductiva != null) { 
        cargarRegistroOperacionProductiva(datasetOperacionProductiva, 
                         operacionproductiva.getOIDInteger(),
                         operacionproductiva.getCodigo(),
                         operacionproductiva.getDescripcion(),
                         operacionproductiva.isActivo());
    }
    writeCliente(datasetOperacionProductiva);
  }

  private IDataSet getDataSetOperacionProductiva() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TOperacionProductiva");
    dataset.fieldDef(new Field("oid_operacion", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroOperacionProductiva(IDataSet dataset, 
                         Integer oid_operacion,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_operacion", oid_operacion);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
