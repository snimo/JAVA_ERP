package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerPrestMedidoRRHH extends Operation { 

  public TraerPrestMedidoRRHH() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    PrestMedidoRRHH prestmedidorrhh = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       prestmedidorrhh = PrestMedidoRRHH.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       prestmedidorrhh = PrestMedidoRRHH.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetPrestMedidoRRHH = getDataSetPrestMedidoRRHH();
    if (prestmedidorrhh != null) { 
        cargarRegistroPrestMedidoRRHH(datasetPrestMedidoRRHH, 
                         prestmedidorrhh.getOIDInteger(),
                         prestmedidorrhh.getCodigo(),
                         prestmedidorrhh.getDescripcion(),
                         prestmedidorrhh.isActivo());
    }
    writeCliente(datasetPrestMedidoRRHH);
  }

  private IDataSet getDataSetPrestMedidoRRHH() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TPrestMedidoRRHH");
    dataset.fieldDef(new Field("oid_prest_med", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroPrestMedidoRRHH(IDataSet dataset, 
                         Integer oid_prest_med,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_prest_med", oid_prest_med);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
