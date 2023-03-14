package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.TipoUnidadEdilicia;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoUnidadEdilicia extends Operation {

  public TraerTipoUnidadEdilicia() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    TipoUnidadEdilicia tipounidadedilicia = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       tipounidadedilicia = TipoUnidadEdilicia.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       tipounidadedilicia = TipoUnidadEdilicia.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetTipoUnidadEdilicia = getDataSetTipoUnidadEdilicia();
    if (tipounidadedilicia != null) {
        cargarRegistroTipoUnidadEdilicia(datasetTipoUnidadEdilicia,
                         tipounidadedilicia.getOIDInteger(),
                         tipounidadedilicia.getCodigo(),
                         tipounidadedilicia.getDescripcion(),
                         tipounidadedilicia.getComportamiento(),
                         tipounidadedilicia.isActivo());
    }
    writeCliente(datasetTipoUnidadEdilicia);
  }

  private IDataSet getDataSetTipoUnidadEdilicia() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoUnidadEdilicia");
    dataset.fieldDef(new Field("oid_tipo_uni_edi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("compo", Field.STRING, 20));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroTipoUnidadEdilicia(IDataSet dataset,
                         Integer oid_tipo_uni_edi,
                         String codigo,
                         String descripcion,
                         String compo,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_tipo_uni_edi", oid_tipo_uni_edi);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("compo", compo);
    dataset.fieldValue("activo", activo);
  }
}
