package com.srn.erp.general.op;

import com.srn.erp.general.bm.TipoCambio;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoCambio extends Operation {

  public TraerTipoCambio() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    TipoCambio tipocambio = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       tipocambio = TipoCambio.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       tipocambio = TipoCambio.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetTipoCambio = getDataSetTipoCambio();
    if (tipocambio != null) {
        cargarRegistroTipoCambio(datasetTipoCambio,
                         tipocambio.getOIDInteger(),
                         tipocambio.getCodigo(),
                         tipocambio.getDescripcion(),
                         tipocambio.isActivo());
    }
    writeCliente(datasetTipoCambio);
  }

  private IDataSet getDataSetTipoCambio() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoCambio");
    dataset.fieldDef(new Field("oid_tipo_cambio", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroTipoCambio(IDataSet dataset,
                         Integer oid_tipo_cambio,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_tipo_cambio", oid_tipo_cambio);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
