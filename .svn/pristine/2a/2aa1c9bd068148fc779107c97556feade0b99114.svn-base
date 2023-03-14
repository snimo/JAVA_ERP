package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.Canal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCanal extends Operation {

  public SaveCanal() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCanal");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Canal canal = Canal.findByOid(dataset.getInteger("oid_canal"),getSesion());
        canal.setOID(dataset.getInteger("oid_canal"));
        canal.setCodigo(dataset.getString("codigo"));
        canal.setDescripcion(dataset.getString("descripcion"));
        canal.setActivo(dataset.getBoolean("activo"));
        addTransaccion(canal);
        dataset.next();
    }
  }

}
