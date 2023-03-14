package com.srn.erp.ctacte.op;

import com.srn.erp.ctacte.bm.TipoCtaCteProv;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoCtaCteProv extends Operation {

  public SaveTipoCtaCteProv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TTipoCtaCteProv");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        TipoCtaCteProv tipoctacteprov = TipoCtaCteProv.findByOid(dataset.getInteger("oid_tipo_cta_prov"),getSesion());
        tipoctacteprov.setOID(dataset.getInteger("oid_tipo_cta_prov"));
        tipoctacteprov.setCodigo(dataset.getString("codigo"));
        tipoctacteprov.setDescripcion(dataset.getString("descripcion"));
        tipoctacteprov.setActivo(dataset.getBoolean("activo"));
        addTransaccion(tipoctacteprov);
        dataset.next();
    }
  }

}
