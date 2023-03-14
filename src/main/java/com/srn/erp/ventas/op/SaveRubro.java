package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.Rubro;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRubro extends Operation {

  public SaveRubro() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TRubro");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Rubro rubro = Rubro.findByOid(dataset.getInteger("oid_rubro"),getSesion());
        rubro.setOID(dataset.getInteger("oid_rubro"));
        rubro.setCodigo(dataset.getString("codigo"));
        rubro.setDescripcion(dataset.getString("descripcion"));
        rubro.setActivo(dataset.getBoolean("activo"));
        addTransaccion(rubro);
        dataset.next();
    }
  }

}
