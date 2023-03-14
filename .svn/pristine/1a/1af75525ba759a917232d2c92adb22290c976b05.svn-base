package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.AgrupadorEstadoStock;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAgrupadorEstadoStock extends Operation { 

  public TraerAgrupadorEstadoStock() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    AgrupadorEstadoStock agrupadorestadostock = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       agrupadorestadostock = AgrupadorEstadoStock.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       agrupadorestadostock = AgrupadorEstadoStock.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetAgrupadorEstadoStock = getDataSetAgrupadorEstadoStock();
    if (agrupadorestadostock != null) { 
        cargarRegistroAgrupadorEstadoStock(datasetAgrupadorEstadoStock, 
                         agrupadorestadostock.getOIDInteger(),
                         agrupadorestadostock.getCodigo(),
                         agrupadorestadostock.getDescripcion(),
                         agrupadorestadostock.isActivo());
    }
    writeCliente(datasetAgrupadorEstadoStock);
  }

  private IDataSet getDataSetAgrupadorEstadoStock() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TAgrupadorEstadoStock");
    dataset.fieldDef(new Field("oid_agrup_estado", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroAgrupadorEstadoStock(IDataSet dataset, 
                         Integer oid_agrup_estado,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_agrup_estado", oid_agrup_estado);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
