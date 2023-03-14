package com.srn.erp.payroll.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.payroll.bm.PayRotas;
import com.srn.erp.payroll.da.DBPayRotas;

public class FactoryPayRotas extends FactoryObjetoLogico { 

  public FactoryPayRotas() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PayRotas payrotas = (PayRotas) objLog;
    payrotas.setTracodigo(db.getString(DBPayRotas.TRACODIGO));
    payrotas.setTradescrip(db.getString(DBPayRotas.TRADESCRIP));
    payrotas.setTrahoraini(db.getString(DBPayRotas.TRAHORAINI));
    payrotas.setTrahorafin(db.getString(DBPayRotas.TRAHORAFIN));

  }
}
