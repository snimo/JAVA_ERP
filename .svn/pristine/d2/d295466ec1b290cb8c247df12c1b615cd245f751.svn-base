package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.EstadoSituacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstadoSituacion extends Operation {

  public TraerEstadoSituacion() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    EstadoSituacion estadosituacion = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       estadosituacion = EstadoSituacion.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       estadosituacion = EstadoSituacion.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetEstadoSituacion = getDataSetEstadoSituacion();
    if (estadosituacion != null) {
        cargarRegistroEstadoSituacion(datasetEstadoSituacion,
                         estadosituacion.getOIDInteger(),
                         estadosituacion.getCodigo(),
                         estadosituacion.getDescripcion(),
                         estadosituacion.getComportamiento(),
                         estadosituacion.isActivo());
    }
    writeCliente(datasetEstadoSituacion);
  }

  private IDataSet getDataSetEstadoSituacion() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEstadoSituacion");
    dataset.fieldDef(new Field("oid_est_situacion", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("compo", Field.STRING, 20));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroEstadoSituacion(IDataSet dataset,
                         Integer oid_est_situacion,
                         String codigo,
                         String descripcion,
                         String compo,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_est_situacion", oid_est_situacion);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("compo", compo);
    dataset.fieldValue("activo", activo);
  }
}
