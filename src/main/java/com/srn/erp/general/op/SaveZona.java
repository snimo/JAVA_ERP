package com.srn.erp.general.op;

import com.srn.erp.general.bm.Zona;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveZona extends Operation {

  public SaveZona() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TZona");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Zona zona = Zona.findByOid(dataset.getInteger("oid_zona"),getSesion());
        zona.setOID(dataset.getInteger("oid_zona"));
        zona.setCodigo(dataset.getString("codigo"));
        zona.setDescripcion(dataset.getString("descripcion"));
        zona.setActivo(dataset.getBoolean("activo"));
        addTransaccion(zona);
        dataset.next();
    }
  }

}
