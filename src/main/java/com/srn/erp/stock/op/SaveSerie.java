package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.Serie;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveSerie extends Operation {

  public SaveSerie() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TSerie");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Serie serie = Serie.findByOid(dataset.getInteger("oid_serie"),getSesion());
        serie.setOID(dataset.getInteger("oid_serie"));
        serie.setCodigo(dataset.getString("codigo"));
        serie.setDescripcion(dataset.getString("descripcion"));
        serie.setNro(dataset.getInteger("nro"));
        serie.setFec_inicio(dataset.getDate("fec_inicio"));
        serie.setFec_vto(dataset.getDate("fec_vto"));
        serie.setActivo(dataset.getBoolean("activo"));
        addTransaccion(serie);
        dataset.next();
    }
  }

}
