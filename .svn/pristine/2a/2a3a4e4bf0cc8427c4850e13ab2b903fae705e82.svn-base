package com.srn.erp.impuestos.op;

import com.srn.erp.impuestos.bm.CategoriaGanancia;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCategoriaGanancia extends Operation {

  public SaveCategoriaGanancia() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCategoriaGanancia");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        CategoriaGanancia categoriaganancia = CategoriaGanancia.findByOid(dataset.getInteger("oid_cat_gan"),getSesion());
        categoriaganancia.setOID(dataset.getInteger("oid_cat_gan"));
        categoriaganancia.setCodigo(dataset.getString("codigo"));
        categoriaganancia.setDescripcion(dataset.getString("descripcion"));
        categoriaganancia.setCompo(dataset.getString("compo_cat_gan"));
        categoriaganancia.setActivo(dataset.getBoolean("activo"));
        addTransaccion(categoriaganancia);
        dataset.next();
    }
  }

}
