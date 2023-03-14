package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.UnidadMedida;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveUnidadMedida extends Operation {

  public SaveUnidadMedida() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TUnidadMedida");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        UnidadMedida unidadmedida = UnidadMedida.findByOid(dataset.getInteger("oid_um"),getSesion());
        unidadmedida.setOID(dataset.getInteger("oid_um"));
        unidadmedida.setCodigo(dataset.getString("codigo"));
        unidadmedida.setDescripcion(dataset.getString("descripcion"));
        unidadmedida.setActivo(dataset.getBoolean("activo"));
        unidadmedida.setLabelImpresion(dataset.getString("etiqueta_impresion"));
        addTransaccion(unidadmedida);
        dataset.next();
    }
  }

}
