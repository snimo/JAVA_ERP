package com.srn.erp.general.op;

import com.srn.erp.general.bm.Idioma;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveIdioma extends Operation {

  public SaveIdioma() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TIdioma");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Idioma idioma = Idioma.findByOid(dataset.getInteger("oid_idioma"),getSesion());
        idioma.setOID(dataset.getInteger("oid_idioma"));
        idioma.setCodigo(dataset.getString("codigo"));
        idioma.setDescripcion(dataset.getString("descripcion"));
        idioma.setActivo(dataset.getBoolean("activo"));
        addTransaccion(idioma);
        dataset.next();
    }
  }

}
