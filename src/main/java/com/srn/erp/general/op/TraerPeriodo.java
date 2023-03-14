package com.srn.erp.general.op;

import java.util.Date;

import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPeriodo extends Operation {

  public TraerPeriodo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Periodo periodo = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       periodo = Periodo.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       periodo = Periodo.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetPeriodo = getDataSetPeriodo();
    if (periodo != null) {
        cargarRegistroPeriodo(datasetPeriodo,
                         periodo.getOIDInteger(),
                         periodo.getCodigo(),
                         periodo.getDescripcion(),
                         periodo.getFechadesde(),
                         periodo.getFechahasta(),
                         periodo.getTipo(),
                         periodo.isActivo());
    }
    writeCliente(datasetPeriodo);
  }

  private IDataSet getDataSetPeriodo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TPeriodo");
    dataset.fieldDef(new Field("oid_peri", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("fecha_desde", Field.STRING, 10));
    dataset.fieldDef(new Field("fecha_hasta", Field.STRING, 10));
    dataset.fieldDef(new Field("tipo", Field.STRING, 20));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroPeriodo(IDataSet dataset,
                         Integer oid_peri,
                         String codigo,
                         String descripcion,
                         Date fecha_desde,
                         Date fecha_hasta,
                         String tipo,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_peri", oid_peri);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("fecha_desde", Fecha.getddmmyyyy(fecha_desde));
    dataset.fieldValue("fecha_hasta", Fecha.getddmmyyyy(fecha_hasta));
    dataset.fieldValue("tipo", tipo);
    dataset.fieldValue("activo", activo);
  }
}
