package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.SaldoTipoValor;
import com.srn.erp.tesoreria.da.DBSaldoTipoValor;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySaldoTipoValor extends FactoryObjetoLogico { 

  public FactorySaldoTipoValor() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SaldoTipoValor saldotipovalor = (SaldoTipoValor) objLog;
    saldotipovalor.setOID(db.getInteger(DBSaldoTipoValor.OID_TIPO_VALOR));
    saldotipovalor.setMoneda(Moneda.findByOidProxy(db.getInteger(DBSaldoTipoValor.OID_MONEDA),getSesion()));
    saldotipovalor.setSaldo_inicial(db.getMoney(DBSaldoTipoValor.SALDO_INICIAL));
    saldotipovalor.setEntradas(db.getMoney(DBSaldoTipoValor.ENTRADAS));
    saldotipovalor.setSalidas(db.getMoney(DBSaldoTipoValor.SALIDAS));
    saldotipovalor.setSaldo_final(db.getMoney(DBSaldoTipoValor.SALDO_FINAL));
    saldotipovalor.setCaja(Caja.findByOidProxy(db.getInteger(DBSaldoTipoValor.OID_CAJA),getSesion()));
  }
}
