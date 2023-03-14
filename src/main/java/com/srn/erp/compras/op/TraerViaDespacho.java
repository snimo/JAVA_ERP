package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.ViaDespacho;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerViaDespacho extends Operation { 

  public TraerViaDespacho() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ViaDespacho viadespacho = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       viadespacho = ViaDespacho.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       viadespacho = ViaDespacho.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetViaDespacho = getDataSetViaDespacho();
    if (viadespacho != null) { 
        cargarRegistroViaDespacho(datasetViaDespacho, 
                         viadespacho.getOIDInteger(),
                         viadespacho.getCodigo(),
                         viadespacho.getDescripcion(),
                         viadespacho.isActivo());
    }
    writeCliente(datasetViaDespacho);
  }

  private IDataSet getDataSetViaDespacho() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TViaDespacho");
    dataset.fieldDef(new Field("oid_via_despacho", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroViaDespacho(IDataSet dataset, 
                         Integer oid_via_despacho,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_via_despacho", oid_via_despacho);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
