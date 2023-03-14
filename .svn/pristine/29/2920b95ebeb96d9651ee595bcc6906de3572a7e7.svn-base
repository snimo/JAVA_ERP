package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.Canal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCanal extends Operation {

  public TraerCanal() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Canal canal = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       canal = Canal.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       canal = Canal.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetCanal = getDataSetCanal();
    if (canal != null) {
        cargarRegistroCanal(datasetCanal,
                         canal.getOIDInteger(),
                         canal.getCodigo(),
                         canal.getDescripcion(),
                         canal.isActivo());
    }
    writeCliente(datasetCanal);
  }

  private IDataSet getDataSetCanal() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCanal");
    dataset.fieldDef(new Field("oid_canal", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("ativo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCanal(IDataSet dataset,
                         Integer oid_canal,
                         String codigo,
                         String descripcion,
                         Boolean ativo) {
    dataset.append();
    dataset.fieldValue("oid_canal", oid_canal);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("ativo", ativo);
  }
}
