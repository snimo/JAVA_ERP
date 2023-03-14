package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.Banco;
import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.da.DBCuentaBancaria;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCuentaBancaria extends FactoryObjetoLogico {

  public FactoryCuentaBancaria() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CuentaBancaria cuentabancaria = (CuentaBancaria) objLog;
    cuentabancaria.setCodigo(db.getString(DBCuentaBancaria.CODIGO));
    cuentabancaria.setOID(db.getInteger(DBCuentaBancaria.OID_CTA_BANCARIA));
    cuentabancaria.setBanco(Banco.findByOidProxy(db.getInteger(DBCuentaBancaria.OID_BANCO),getSesion()));
    cuentabancaria.setNrocuenta(db.getString(DBCuentaBancaria.NRO_CUENTA));
    cuentabancaria.setDescripcion(db.getString(DBCuentaBancaria.DESCRIPCION));
    cuentabancaria.setActivo(db.getBoolean(DBCuentaBancaria.ACTIVO));
    cuentabancaria.setCompo(db.getString(DBCuentaBancaria.COMPO));
    cuentabancaria.setCuentaimputableAConciliar(CuentaImputable.findByOidProxy(db.getInteger(DBCuentaBancaria.OID_AI),getSesion()));
    cuentabancaria.setMoneda(Moneda.findByOidProxy(db.getInteger(DBCuentaBancaria.OID_MONEDA),getSesion()));
    cuentabancaria.setCuentaMovRealesBco(CuentaImputable.findByOidProxy(db.getInteger(DBCuentaBancaria.OID_AI_REAL),getSesion()));
    cuentabancaria.setClearingEnDias(db.getInteger(DBCuentaBancaria.CLEARING_EN_DIAS));
  }
}
