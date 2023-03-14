package com.srn.erp.pagos.op;

import com.srn.erp.pagos.bm.CatRetIB;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCatRetIB extends Operation {

  public TraerCatRetIB() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    CatRetIB catretib = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       catretib = CatRetIB.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       catretib = CatRetIB.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetCatRetIB = getDataSetCatRetIB();
    if (catretib != null) {
        cargarRegistroCatRetIB(datasetCatRetIB,
                         catretib.getOIDInteger(),
                         catretib.getCodigo(),
                         catretib.getDescripcion(),
                         catretib.isActivo());
    }
    writeCliente(datasetCatRetIB);
  }

  private IDataSet getDataSetCatRetIB() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCatRetIB");
    dataset.fieldDef(new Field("oid_cat_ret_ib", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCatRetIB(IDataSet dataset,
                         Integer oid_cat_ret_ib,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_cat_ret_ib", oid_cat_ret_ib);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
