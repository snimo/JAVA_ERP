package com.srn.erp.pagos.op;

import com.srn.erp.pagos.bm.CatRetIVA;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCatRetIVA extends Operation {

  public TraerCatRetIVA() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    CatRetIVA catretiva = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       catretiva = CatRetIVA.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       catretiva = CatRetIVA.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetCatRetIVA = getDataSetCatRetIVA();
    if (catretiva != null) {
        cargarRegistroCatRetIVA(datasetCatRetIVA,
                         catretiva.getOIDInteger(),
                         catretiva.getCodigo(),
                         catretiva.getDescripcion(),
                         catretiva.isActivo());
    }
    writeCliente(datasetCatRetIVA);
  }

  private IDataSet getDataSetCatRetIVA() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCatRetIVA");
    dataset.fieldDef(new Field("oid_cat_ret_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCatRetIVA(IDataSet dataset,
                         Integer oid_cat_ret_iva,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_cat_ret_iva", oid_cat_ret_iva);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
