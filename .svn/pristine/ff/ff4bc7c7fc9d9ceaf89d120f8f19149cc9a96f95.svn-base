package com.srn.erp.general.op;

import com.srn.erp.general.bm.FactorConversion;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveFactorConversion extends Operation {

  public SaveFactorConversion() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TFactorConversion");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        FactorConversion factorconversion = FactorConversion.findByOid(dataset.getInteger("oid_fact_conv"),getSesion());
        factorconversion.setOID(dataset.getInteger("oid_fact_conv"));
        factorconversion.setUni_med_ori(UnidadMedida.findByOidProxy(dataset.getInteger("oid_um_ori"),getSesion()));
        factorconversion.setUni_med_dest(UnidadMedida.findByOidProxy(dataset.getInteger("oid_um_dest"),getSesion()));
        factorconversion.setFactor(dataset.getDouble("factor"));
        factorconversion.setActivo(dataset.getBoolean("activo"));
        addTransaccion(factorconversion);
        dataset.next();
    }
  }

}
