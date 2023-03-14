package com.srn.erp.general.op;

import com.srn.erp.general.bm.TipoCambio;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoCambio extends Operation {

  public SaveTipoCambio() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TTipoCambio");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        TipoCambio tipocambio = TipoCambio.findByOid(dataset.getInteger("oid_tipo_cambio"),getSesion());
        tipocambio.setCodigo(dataset.getString("codigo"));
        tipocambio.setDescripcion(dataset.getString("descripcion"));
        tipocambio.setActivo(dataset.getBoolean("activo"));
        addTransaccion(tipocambio);
        dataset.next();
    }
  }

}
