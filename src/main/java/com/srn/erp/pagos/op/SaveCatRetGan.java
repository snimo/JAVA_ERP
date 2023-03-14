package com.srn.erp.pagos.op;

import com.srn.erp.pagos.bm.CatRetGan;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCatRetGan extends Operation {

  public SaveCatRetGan() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCatRetGan");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        CatRetGan catretgan = CatRetGan.findByOid(dataset.getInteger("oid_cat_ret_gan"),getSesion());
        catretgan.setOID(dataset.getInteger("oid_cat_ret_gan"));
        catretgan.setCodigo(dataset.getString("codigo"));
        catretgan.setDescripcion(dataset.getString("descripcion"));
        catretgan.setActivo(dataset.getBoolean("activo"));
        addTransaccion(catretgan);
        dataset.next();
    }
  }

}
