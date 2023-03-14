package com.srn.erp.tesoreria.op;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.Banco;
import com.srn.erp.tesoreria.bm.CuentaBancaria;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCuentaBancaria extends Operation {

  public SaveCuentaBancaria() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCuentaBancaria");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        CuentaBancaria cuentabancaria = CuentaBancaria.findByOid(dataset.getInteger("oid_cta_bancaria"),getSesion());
        cuentabancaria.setCodigo(dataset.getString("codigo"));
        cuentabancaria.setOID(dataset.getInteger("oid_cta_bancaria"));
        cuentabancaria.setBanco(Banco.findByOidProxy(dataset.getInteger("oid_banco"),getSesion()));
        cuentabancaria.setNrocuenta(dataset.getString("nro_cuenta"));
        cuentabancaria.setDescripcion(dataset.getString("descripcion"));
        cuentabancaria.setActivo(dataset.getBoolean("activo"));
        cuentabancaria.setCompo(dataset.getString("compo"));
        cuentabancaria.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),getSesion()));
        cuentabancaria.setCuentaimputableAConciliar(CuentaImputable.findByOidProxy(dataset.getInteger("oid_ai"),getSesion()));
        cuentabancaria.setCuentaMovRealesBco(CuentaImputable.findByOidProxy(dataset.getInteger("oid_ai_real"),getSesion()));
        cuentabancaria.setClearingEnDias(dataset.getInteger("clearing_en_dias"));
        addTransaccion(cuentabancaria);
        dataset.next();
    }
  }

}
