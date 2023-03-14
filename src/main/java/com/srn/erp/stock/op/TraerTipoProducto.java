package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.TipoProducto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoProducto extends Operation {

  public TraerTipoProducto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    TipoProducto tipoproducto = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       tipoproducto = TipoProducto.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       tipoproducto = TipoProducto.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetTipoProducto = getDataSetTipoProducto();
    if (tipoproducto != null) {
        cargarRegistroTipoProducto(datasetTipoProducto,
                         tipoproducto.getOIDInteger(),
                         tipoproducto.getCodigo(),
                         tipoproducto.getDescripcion(),
                         tipoproducto.getComportamiento(),
                         tipoproducto.isActivo());
    }

    writeCliente(datasetTipoProducto);
  }

  private IDataSet getDataSetTipoProducto() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoProducto");
    dataset.fieldDef(new Field("oid_tipo_prod", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("compo", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroTipoProducto(IDataSet dataset,
                         Integer oid_tipo_prod,
                         String codigo,
                         String descripcion,
                         String compo,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_tipo_prod", oid_tipo_prod);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("compo", compo);
    dataset.fieldValue("activo", activo);
  }


}
