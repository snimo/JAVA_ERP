package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.Categoria;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCategoria extends Operation {

  public TraerCategoria() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Categoria categoria = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       categoria = Categoria.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       categoria = Categoria.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetCategoria = getDataSetCategoria();
    if (categoria != null) {
        cargarRegistroCategoria(datasetCategoria,
                         categoria.getOIDInteger(),
                         categoria.getCodigo(),
                         categoria.getDescripcion(),
                         categoria.isActivo());
    }
    writeCliente(datasetCategoria);
  }

  private IDataSet getDataSetCategoria() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCategoria");
    dataset.fieldDef(new Field("oid_categoria", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCategoria(IDataSet dataset,
                         Integer oid_categoria,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_categoria", oid_categoria);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
