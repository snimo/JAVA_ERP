package com.srn.erp.ctacte.op;

import com.srn.erp.ctacte.bm.TipoCtaCteClie;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoCtaCteClie extends Operation {

  public TraerTipoCtaCteClie() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    TipoCtaCteClie tipoctacteclie = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       tipoctacteclie = TipoCtaCteClie.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       tipoctacteclie = TipoCtaCteClie.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetTipoCtaCteClie = getDataSetTipoCtaCteClie();
    if (tipoctacteclie != null) {
        cargarRegistroTipoCtaCteClie(datasetTipoCtaCteClie,
                         tipoctacteclie.getOIDInteger(),
                         tipoctacteclie.getCodigo(),
                         tipoctacteclie.getDescripcion(),
                         tipoctacteclie.isActivo());
    }
    writeCliente(datasetTipoCtaCteClie);
  }

  private IDataSet getDataSetTipoCtaCteClie() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoCtaCteClie");
    dataset.fieldDef(new Field("oid_tipo_cta_clie", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroTipoCtaCteClie(IDataSet dataset,
                         Integer oid_tipo_cta_clie,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_tipo_cta_clie", oid_tipo_cta_clie);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
