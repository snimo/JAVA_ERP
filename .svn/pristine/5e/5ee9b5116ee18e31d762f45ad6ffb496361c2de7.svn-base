package com.srn.erp.pagos.op;

import com.srn.erp.pagos.bm.CatRetIB;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCatRetIB extends Operation {

  public SaveCatRetIB() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCatRetIB");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        CatRetIB catretib = CatRetIB.findByOid(dataset.getInteger("oid_cat_ret_ib"),getSesion());
        catretib.setOID(dataset.getInteger("oid_cat_ret_ib"));
        catretib.setCodigo(dataset.getString("codigo"));
        catretib.setDescripcion(dataset.getString("descripcion"));
        catretib.setActivo(dataset.getBoolean("activo"));
        addTransaccion(catretib);
        dataset.next();
    }
  }

}
