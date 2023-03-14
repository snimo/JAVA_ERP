package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.ClasifSujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveClasifSujeto extends Operation {

  public SaveClasifSujeto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TClasifSujeto");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        ClasifSujeto clasifsujeto = ClasifSujeto.findByOid(dataset.getInteger("oid_clasif_suj"),getSesion());
        clasifsujeto.setOID(dataset.getInteger("oid_clasif_suj"));
        clasifsujeto.setCodigo(dataset.getString("codigo"));
        clasifsujeto.setDescripcion(dataset.getString("descripcion"));
        clasifsujeto.setActivo(dataset.getBoolean("activo"));
        addTransaccion(clasifsujeto);
        dataset.next();
    }
  }

}
