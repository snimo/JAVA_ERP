package com.srn.erp.impuestos.op;

import com.srn.erp.impuestos.bm.CategoriaIB;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCategoriaIB extends Operation {

  public SaveCategoriaIB() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCategoriaIB");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        CategoriaIB categoriaib = CategoriaIB.findByOid(dataset.getInteger("oid_cat_ib"),getSesion());
        categoriaib.setOID(dataset.getInteger("oid_cat_ib"));
        categoriaib.setCodigo(dataset.getString("codigo"));
        categoriaib.setDescripcion(dataset.getString("descripcion"));
        categoriaib.setComportamiento(dataset.getString("compo_cat_ib"));
        categoriaib.setActivo(dataset.getBoolean("activo"));
        categoriaib.setCalcPercIBBsAs(dataset.getBoolean("calc_perc_ib_ba").booleanValue());
        categoriaib.setCalcPercIBCapFed(dataset.getBoolean("calc_perc_ib_cf").booleanValue());
        addTransaccion(categoriaib);
        dataset.next();
    }
  }

}
