package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.Leyenda;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerLeyenda extends Operation {

  public TraerLeyenda() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Leyenda leyenda = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       leyenda = Leyenda.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       leyenda = Leyenda.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetLeyenda = getDataSetLeyenda();
    if (leyenda != null) {
        cargarRegistroLeyenda(datasetLeyenda,
                         leyenda.getOIDInteger(),
                         leyenda.getCodigo(),
                         leyenda.getDescripcion(),
                         leyenda.isActivo());
    }
    writeCliente(datasetLeyenda);
  }

  private IDataSet getDataSetLeyenda() {
    IDataSet dataset = new TDataSet();
    dataset.create("TLeyenda");
    dataset.fieldDef(new Field("oid_leyenda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroLeyenda(IDataSet dataset,
                         Integer oid_leyenda,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_leyenda", oid_leyenda);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
