package com.srn.erp.general.op;

import com.srn.erp.general.bm.Indice;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveIndice extends Operation {

  public SaveIndice() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TIndice");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Indice indice = Indice.findByOid(dataset.getInteger("oid_indice"),getSesion());
        indice.setOID(dataset.getInteger("oid_indice"));
        indice.setCodigo(dataset.getString("codigo"));
        indice.setDescripcion(dataset.getString("descripcion"));
        indice.setActivo(dataset.getBoolean("activo"));
        addTransaccion(indice);
        dataset.next();
    }
  }

}
