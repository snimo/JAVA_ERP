package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.Relacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRelacion extends Operation {

  public TraerRelacion() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Relacion relacion = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       relacion = Relacion.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       relacion = Relacion.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetRelacion = getDataSetRelacion();
    if (relacion != null) {
        cargarRegistroRelacion(datasetRelacion,
                         relacion.getOIDInteger(),
                         relacion.getCodigo(),
                         relacion.getDescripcion(),
                         relacion.isActivo());
    }
    writeCliente(datasetRelacion);
  }

  private IDataSet getDataSetRelacion() {
    IDataSet dataset = new TDataSet();
    dataset.create("TRelacion");
    dataset.fieldDef(new Field("oid_relacion", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroRelacion(IDataSet dataset,
                         Integer oid_relacion,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_relacion", oid_relacion);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
