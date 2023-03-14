package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.AgrupadorEstadoStock;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoDeposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.da.DBEstadoDeposito;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadoDeposito extends FactoryObjetoLogico {

  public FactoryEstadoDeposito() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstadoDeposito estadodeposito = (EstadoDeposito) objLog;
    estadodeposito.setOID(db.getInteger(DBEstadoDeposito.OID_ESTADO_DEPO));
    estadodeposito.setDeposito(Deposito.findByOidProxy(db.getInteger(DBEstadoDeposito.OID_DEPOSITO),getSesion()));
    estadodeposito.setEstado_stock(EstadoStock.findByOidProxy(db.getInteger(DBEstadoDeposito.OID_ESTADO_STOCK),getSesion()));
    estadodeposito.setAllow_saldo_neg(db.getBoolean(DBEstadoDeposito.ALLOW_SALDO_NEG));
    estadodeposito.setAgrupadorEstadoStock(AgrupadorEstadoStock.findByOidProxy(db.getInteger(DBEstadoDeposito.AGRUPADOR_ESTADO_STOCK),getSesion()));

  }
}
