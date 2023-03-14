package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.Transporte;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTransporte extends Operation {

  public TraerTransporte() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Transporte transporte = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       transporte = Transporte.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       transporte = Transporte.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetTransporte = getDataSetTransporte();
    if (transporte != null) {
        cargarRegistroTransporte(datasetTransporte,
                         transporte.getOIDInteger(),
                         transporte.getCodigo(),
                         transporte.getDescripcion(),
                         transporte.isActivo());
    }
    writeCliente(datasetTransporte);
  }

  private IDataSet getDataSetTransporte() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTransporte");
    dataset.fieldDef(new Field("oid_transporte", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroTransporte(IDataSet dataset,
                         Integer oid_transporte,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_transporte", oid_transporte);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
