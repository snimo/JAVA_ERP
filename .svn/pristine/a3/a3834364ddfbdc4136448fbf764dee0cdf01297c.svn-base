package com.srn.erp.ctacte.op;

import com.srn.erp.ctacte.bm.TipoCtaCteProv;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoCtaCteProv extends Operation {

  public TraerTipoCtaCteProv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    TipoCtaCteProv tipoctacteprov = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       tipoctacteprov = TipoCtaCteProv.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       tipoctacteprov = TipoCtaCteProv.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetTipoCtaCteProv = getDataSetTipoCtaCteProv();
    if (tipoctacteprov != null) {
        cargarRegistroTipoCtaCteProv(datasetTipoCtaCteProv,
                         tipoctacteprov.getOIDInteger(),
                         tipoctacteprov.getCodigo(),
                         tipoctacteprov.getDescripcion(),
                         tipoctacteprov.isActivo());
    }
    writeCliente(datasetTipoCtaCteProv);
  }

  private IDataSet getDataSetTipoCtaCteProv() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoCtaCteProv");
    dataset.fieldDef(new Field("oid_tipo_cta_prov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroTipoCtaCteProv(IDataSet dataset,
                         Integer oid_tipo_cta_prov,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_tipo_cta_prov", oid_tipo_cta_prov);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
