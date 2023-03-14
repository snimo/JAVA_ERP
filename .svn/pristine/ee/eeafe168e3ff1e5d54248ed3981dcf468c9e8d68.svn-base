package com.srn.erp.general.op;

import com.srn.erp.general.bm.Moneda;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveMoneda extends Operation {

  public SaveMoneda() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TMoneda");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {

        Moneda moneda = Moneda.findByOid(dataset.getInteger("oid_moneda"),getSesion());
        moneda.setOID(dataset.getInteger("oid_moneda"));
        moneda.setCodigo(dataset.getString("codigo"));
        moneda.setDescripcion(dataset.getString("descripcion"));
        moneda.setBase(dataset.getCotizacion("base"));
        moneda.setActivo(dataset.getBoolean("activo"));
        moneda.setSimbolo(dataset.getString("simbolo"));
        addTransaccion(moneda);
        dataset.next();
    }
  }

}
