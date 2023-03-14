package com.srn.erp.cip.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.cip.bm.RotaPayroll;
import com.srn.erp.cip.da.DBRotaPayroll;

public class FactoryRotaPayroll extends FactoryObjetoLogico { 

  public FactoryRotaPayroll() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RotaPayroll rotapayroll = (RotaPayroll) objLog;
    rotapayroll.setOID(db.getInteger(DBRotaPayroll.OID_ROTA));
    rotapayroll.setTracodigo(db.getString(DBRotaPayroll.TRACODIGO));
    rotapayroll.setTradescrip(db.getString(DBRotaPayroll.TRADESCRIP));
    rotapayroll.setTrahoraini(db.getString(DBRotaPayroll.TRAHORAINI));
    rotapayroll.setTrahorafin(db.getString(DBRotaPayroll.TRAHORAFIN));
    rotapayroll.setActivo(db.getBoolean(DBRotaPayroll.ACTIVO));
  }
}
