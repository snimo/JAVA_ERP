package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.Cobrador;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCobrador extends Operation {

  public SaveCobrador() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCobrador");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Cobrador cobrador = Cobrador.findByOid(dataset.getInteger("oid_cobrador"),getSesion());
        cobrador.setOID(dataset.getInteger("oid_cobrador"));
        cobrador.setCodigo(dataset.getString("codigo"));
        cobrador.setApellido(dataset.getString("apellido"));
        cobrador.setNombre(dataset.getString("nombre"));
        cobrador.setActivo(dataset.getBoolean("activo"));
        addTransaccion(cobrador);
        dataset.next();
    }
  }

}
