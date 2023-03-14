package com.srn.erp.ventas.op;


import com.srn.erp.ventas.bm.EstadoSituacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEstadoSituacion extends Operation {

  public SaveEstadoSituacion() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TEstadoSituacion");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        EstadoSituacion estadosituacion = EstadoSituacion.findByOid(dataset.getInteger("oid_est_situacion"),getSesion());
        estadosituacion.setOID(dataset.getInteger("oid_est_situacion"));
        estadosituacion.setCodigo(dataset.getString("codigo"));
        estadosituacion.setDescripcion(dataset.getString("descripcion"));
        estadosituacion.setComportamiento(dataset.getString("compo"));
        estadosituacion.setActivo(dataset.getBoolean("activo"));
        addTransaccion(estadosituacion);
        dataset.next();
    }
  }

}
