package com.srn.erp.tesoreria.op;

import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.CajaCierreApertura;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCajaCierreApertura extends Operation {

  public SaveCajaCierreApertura() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCajaCierreApertura");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        CajaCierreApertura cajacierreapertura = CajaCierreApertura.findByOid(dataset.getInteger("oid_caja_ape_cie"),getSesion());
        cajacierreapertura.setOID(dataset.getInteger("oid_caja_ape_cie"));
        Caja caja = Caja.findByOidProxy(dataset.getInteger("oid_caja"),getSesion());
        cajacierreapertura.setCaja(caja);
        cajacierreapertura.setFeccierreant(dataset.getDate("nue_fec_aper"));
        cajacierreapertura.setNuefecaper(dataset.getDate("nueva_fecha"));
        cajacierreapertura.setActivo(dataset.getBoolean("activo"));
        addTransaccion(cajacierreapertura);
        dataset.next();
    }
  }

}
