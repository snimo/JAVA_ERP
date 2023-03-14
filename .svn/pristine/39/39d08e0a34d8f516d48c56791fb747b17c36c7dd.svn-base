package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.EstadoStock;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEstadoStock extends Operation {

  public SaveEstadoStock() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TEstadoStock");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        EstadoStock estadostock = EstadoStock.findByOid(dataset.getInteger("oid_estado_stock"),getSesion());
        estadostock.setOID(dataset.getInteger("oid_estado_stock"));
        estadostock.setCodigo(dataset.getString("codigo"));
        estadostock.setDescripcion(dataset.getString("descripcion"));
        estadostock.setActivo(dataset.getBoolean("activo"));
        addTransaccion(estadostock);
        dataset.next();
    }
  }

}
