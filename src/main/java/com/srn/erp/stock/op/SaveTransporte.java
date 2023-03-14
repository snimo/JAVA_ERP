package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.Transporte;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTransporte extends Operation {

  public SaveTransporte() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TTransporte");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Transporte transporte = Transporte.findByOid(dataset.getInteger("oid_transporte"),getSesion());
        transporte.setOID(dataset.getInteger("oid_transporte"));
        transporte.setCodigo(dataset.getString("codigo"));
        transporte.setDescripcion(dataset.getString("descripcion"));
        transporte.setActivo(dataset.getBoolean("activo"));
        addTransaccion(transporte);
        dataset.next();
    }
  }

}
