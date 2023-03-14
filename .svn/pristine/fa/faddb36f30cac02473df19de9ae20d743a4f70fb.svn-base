package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.Relacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRelacion extends Operation {

  public SaveRelacion() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TRelacion");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Relacion relacion = Relacion.findByOid(dataset.getInteger("oid_relacion"),getSesion());
        relacion.setOID(dataset.getInteger("oid_relacion"));
        relacion.setCodigo(dataset.getString("codigo"));
        relacion.setDescripcion(dataset.getString("descripcion"));
        relacion.setActivo(dataset.getBoolean("activo"));
        addTransaccion(relacion);
        dataset.next();
    }
  }

}
