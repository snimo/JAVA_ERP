package com.srn.erp.general.op;

import com.srn.erp.general.bm.Pais;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePais extends Operation {

  public SavePais() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TPais");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Pais pais = Pais.findByOid(dataset.getInteger("oid_pais"),getSesion());
        pais.setOID(dataset.getInteger("oid_pais"));
        pais.setCodigo(dataset.getString("codigo"));
        pais.setDescripcion(dataset.getString("descripcion"));
        pais.setActivo(dataset.getBoolean("activo"));
        addTransaccion(pais);
        dataset.next();
    }
  }

}
