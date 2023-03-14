package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.SaldoEfectivo;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.da.DBSaldoEfectivo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySaldoEfectivo extends FactoryObjetoLogico { 

  public FactorySaldoEfectivo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SaldoEfectivo saldoefectivo = (SaldoEfectivo) objLog;
    saldoefectivo.setCaja(Caja.findByOidProxy(db.getInteger(DBSaldoEfectivo.OID_CAJA),getSesion()));
    saldoefectivo.setMoneda(Moneda.findByOidProxy(db.getInteger(DBSaldoEfectivo.OID_MONEDA),getSesion()));
    saldoefectivo.setTipo_valor(TipoValor.findByOidProxy(db.getInteger(DBSaldoEfectivo.OID_TIPO_VALOR),getSesion()));
    saldoefectivo.setEntradas(db.getMoney(DBSaldoEfectivo.ENTRADAS));
    saldoefectivo.setSalidas(db.getMoney(DBSaldoEfectivo.SALIDAS));
  }
}
