package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.CondicionVentaExpoImpo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCondicionVentaExpoImpo extends Operation { 

  public TraerCondicionVentaExpoImpo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    CondicionVentaExpoImpo condicionventaexpoimpo = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       condicionventaexpoimpo = CondicionVentaExpoImpo.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       condicionventaexpoimpo = CondicionVentaExpoImpo.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetCondicionVentaExpoImpo = getDataSetCondicionVentaExpoImpo();
    if (condicionventaexpoimpo != null) { 
        cargarRegistroCondicionVentaExpoImpo(datasetCondicionVentaExpoImpo, 
                         condicionventaexpoimpo.getOIDInteger(),
                         condicionventaexpoimpo.getCodigo(),
                         condicionventaexpoimpo.getDescripcion(),
                         condicionventaexpoimpo.isActivo());
    }
    writeCliente(datasetCondicionVentaExpoImpo);
  }

  private IDataSet getDataSetCondicionVentaExpoImpo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCondicionVentaExpoImpo");
    dataset.fieldDef(new Field("oid_cond_vta_ei", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroCondicionVentaExpoImpo(IDataSet dataset, 
                         Integer oid_cond_vta_ei,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_cond_vta_ei", oid_cond_vta_ei);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
