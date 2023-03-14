package com.srn.erp.pagos.op;

import com.srn.erp.pagos.bm.CatRetGan;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCatRetGan extends Operation {

  public TraerCatRetGan() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    CatRetGan catretgan = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       catretgan = CatRetGan.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       catretgan = CatRetGan.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetCatRetGan = getDataSetCatRetGan();
    if (catretgan != null) {
        cargarRegistroCatRetGan(datasetCatRetGan,
                         catretgan.getOIDInteger(),
                         catretgan.getCodigo(),
                         catretgan.getDescripcion(),
                         catretgan.isActivo());
    }
    writeCliente(datasetCatRetGan);
  }

  private IDataSet getDataSetCatRetGan() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCatRetGan");
    dataset.fieldDef(new Field("oid_cat_ret_gan", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCatRetGan(IDataSet dataset,
                         Integer oid_cat_ret_gan,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_cat_ret_gan", oid_cat_ret_gan);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
