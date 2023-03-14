package com.srn.erp.pagos.op;

import com.srn.erp.pagos.bm.CatRetIVA;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCatRetIVA extends Operation {

  public SaveCatRetIVA() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCatRetIVA");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        CatRetIVA catretiva = CatRetIVA.findByOid(dataset.getInteger("oid_cat_ret_iva"),getSesion());
        catretiva.setOID(dataset.getInteger("oid_cat_ret_iva"));
        catretiva.setCodigo(dataset.getString("codigo"));
        catretiva.setDescripcion(dataset.getString("descripcion"));
        catretiva.setActivo(dataset.getBoolean("activo"));
        addTransaccion(catretiva);
        dataset.next();
    }
  }

}
