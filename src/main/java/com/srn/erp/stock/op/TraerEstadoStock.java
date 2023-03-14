package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.EstadoStock;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstadoStock extends Operation {

  public TraerEstadoStock() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    EstadoStock estadostock = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       estadostock = EstadoStock.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       estadostock = EstadoStock.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetEstadoStock = getDataSetEstadoStock();
    if (estadostock != null) {
        cargarRegistroEstadoStock(datasetEstadoStock,
                         estadostock.getOIDInteger(),
                         estadostock.getCodigo(),
                         estadostock.getDescripcion(),
                         estadostock.isActivo());
    }
    writeCliente(datasetEstadoStock);
  }

  private IDataSet getDataSetEstadoStock() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEstadoStock");
    dataset.fieldDef(new Field("oid_estado_stock", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroEstadoStock(IDataSet dataset,
                         Integer oid_estado_stock,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_estado_stock", oid_estado_stock);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
