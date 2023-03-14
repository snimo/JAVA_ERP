package com.srn.erp.stock.op;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class TraerInicializarProducto extends Operation {

  public TraerInicializarProducto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

  }

  private void cargarRegistroBienServicio(IDataSet dataset,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }


  private IDataSet getDataSetBienServicio() {
    return null;
  }


}
