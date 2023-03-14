package com.srn.erp.ctacte.op;

import com.srn.erp.ctacte.bm.TipoCtaCteClie;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoCtaCteClie extends Operation {

  public SaveTipoCtaCteClie() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TTipoCtaCteClie");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        TipoCtaCteClie tipoctacteclie = TipoCtaCteClie.findByOid(dataset.getInteger("oid_tipo_cta_clie"),getSesion());
        tipoctacteclie.setOID(dataset.getInteger("oid_tipo_cta_clie"));
        tipoctacteclie.setCodigo(dataset.getString("codigo"));
        tipoctacteclie.setDescripcion(dataset.getString("descripcion"));
        tipoctacteclie.setActivo(dataset.getBoolean("activo"));
        addTransaccion(tipoctacteclie);
        dataset.next();
    }
  }

}
