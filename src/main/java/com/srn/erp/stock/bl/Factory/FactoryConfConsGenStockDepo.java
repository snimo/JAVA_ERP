package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.ConfConsGenStock;
import com.srn.erp.stock.bm.ConfConsGenStockDepo;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.da.DBConfConsGenStockDepo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConfConsGenStockDepo extends FactoryObjetoLogico { 

  public FactoryConfConsGenStockDepo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConfConsGenStockDepo confconsgenstockdepo = (ConfConsGenStockDepo) objLog;
    confconsgenstockdepo.setOID(db.getInteger(DBConfConsGenStockDepo.OID_DEP_CONF_CONS_STK));
    confconsgenstockdepo.setDeposito(Deposito.findByOidProxy(db.getInteger(DBConfConsGenStockDepo.OID_DEPOSITO),getSesion()));
    confconsgenstockdepo.setConf_cons_stk(ConfConsGenStock.findByOidProxy(db.getInteger(DBConfConsGenStockDepo.OID_CONF_CONS_STK),getSesion()));
    confconsgenstockdepo.setActivo(db.getBoolean(DBConfConsGenStockDepo.ACTIVO));
    confconsgenstockdepo.setOrden(db.getInteger(DBConfConsGenStockDepo.ORDEN));

  }
}
