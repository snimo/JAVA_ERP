package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.Leyenda;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveLeyenda extends Operation {

  public SaveLeyenda() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TLeyenda");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Leyenda leyenda = Leyenda.findByOid(dataset.getInteger("oid_leyenda"),getSesion());
        leyenda.setOID(dataset.getInteger("oid_leyenda"));
        leyenda.setCodigo(dataset.getString("codigo"));
        leyenda.setDescripcion(dataset.getString("descripcion"));
        leyenda.setActivo(dataset.getBoolean("activo"));
        addTransaccion(leyenda);
        dataset.next();
    }
  }

}
