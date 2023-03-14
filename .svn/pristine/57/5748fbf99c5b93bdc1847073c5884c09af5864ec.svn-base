package com.srn.erp.impuestos.op;

import com.srn.erp.impuestos.bm.CategoriaGanancia;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCategoriaGanancia extends Operation {

  public TraerCategoriaGanancia() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    CategoriaGanancia categoriaganancia = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       categoriaganancia = CategoriaGanancia.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       categoriaganancia = CategoriaGanancia.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetCategoriaGanancia = getDataSetCategoriaGanancia();
    if (categoriaganancia != null) {
        cargarRegistroCategoriaGanancia(datasetCategoriaGanancia,
                         categoriaganancia.getOIDInteger(),
                         categoriaganancia.getCodigo(),
                         categoriaganancia.getDescripcion(),
                         categoriaganancia.getCompo(),
                         categoriaganancia.isActivo());
    }
    writeCliente(datasetCategoriaGanancia);
  }

  private IDataSet getDataSetCategoriaGanancia() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCategoriaGanancia");
    dataset.fieldDef(new Field("oid_cat_gan", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("compo_cat_gan", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCategoriaGanancia(IDataSet dataset,
                         Integer oid_cat_gan,
                         String codigo,
                         String descripcion,
                         String compo_cat_gan,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_cat_gan", oid_cat_gan);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("compo_cat_gan", compo_cat_gan);
    dataset.fieldValue("activo", activo);
  }
}
