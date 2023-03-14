package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.Categoria;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCategoria extends Operation {

  public SaveCategoria() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCategoria");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Categoria categoria = Categoria.findByOid(dataset.getInteger("oid_categoria"),getSesion());
        categoria.setOID(dataset.getInteger("oid_categoria"));
        categoria.setCodigo(dataset.getString("codigo"));
        categoria.setDescripcion(dataset.getString("descripcion"));
        categoria.setActivo(dataset.getBoolean("activo"));
        addTransaccion(categoria);
        dataset.next();
    }
  }

}
