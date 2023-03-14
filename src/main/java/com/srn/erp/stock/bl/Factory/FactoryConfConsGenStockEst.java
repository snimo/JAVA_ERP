package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.ConfConsGenStock;
import com.srn.erp.stock.bm.ConfConsGenStockEst;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.da.DBConfConsGenStockEst;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConfConsGenStockEst extends FactoryObjetoLogico { 

  public FactoryConfConsGenStockEst() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConfConsGenStockEst confconsgenstockest = (ConfConsGenStockEst) objLog;
    confconsgenstockest.setOID(db.getInteger(DBConfConsGenStockEst.OID_EST_CONF_CONS_STK));
    confconsgenstockest.setEstado_stock(EstadoStock.findByOidProxy(db.getInteger(DBConfConsGenStockEst.OID_ESTADO_STOCK),getSesion()));
    confconsgenstockest.setConf_cons_stk(ConfConsGenStock.findByOidProxy(db.getInteger(DBConfConsGenStockEst.OID_CONF_CONS_STK),getSesion()));
    confconsgenstockest.setActivo(db.getBoolean(DBConfConsGenStockEst.ACTIVO));
    confconsgenstockest.setOrden(db.getInteger(DBConfConsGenStockEst.ORDEN));
  }
}
