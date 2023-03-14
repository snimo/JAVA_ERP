package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.EstadoCivil;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEstadoCivil extends Operation {

  public SaveEstadoCivil() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TEstadoCivil");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        EstadoCivil estadocivil = EstadoCivil.findByOid(dataset.getInteger("oid_estado_civil"),getSesion());
        estadocivil.setOID(dataset.getInteger("oid_estado_civil"));
        estadocivil.setCodigo(dataset.getString("codigo"));
        estadocivil.setDescripcion(dataset.getString("descripcion"));
        estadocivil.setActivo(dataset.getBoolean("activo"));
        addTransaccion(estadocivil);
        dataset.next();
    }
  }

}
