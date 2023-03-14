package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.AgrupadorDeposito;
import com.srn.erp.stock.bm.AgrupadorDepositoDet;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.da.DBAgrupadorDepositoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAgrupadorDepositoDet extends FactoryObjetoLogico { 

  public FactoryAgrupadorDepositoDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AgrupadorDepositoDet agrupadordepositodet = (AgrupadorDepositoDet) objLog;
    agrupadordepositodet.setOID(db.getInteger(DBAgrupadorDepositoDet.OID_AGRUPADOR_DET));
    agrupadordepositodet.setAgrupador_deposito(AgrupadorDeposito.findByOidProxy(db.getInteger(DBAgrupadorDepositoDet.OID_AGRUPADOR_DEPO),getSesion()));
    agrupadordepositodet.setDeposito(Deposito.findByOidProxy(db.getInteger(DBAgrupadorDepositoDet.OID_DEPOSITO),getSesion()));
    agrupadordepositodet.setActivo(db.getBoolean(DBAgrupadorDepositoDet.ACTIVO));

  }
}
