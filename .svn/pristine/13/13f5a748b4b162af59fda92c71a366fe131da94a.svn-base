package com.srn.erp.stock.bl.Factory;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.stock.bm.ConfConsGenStock;
import com.srn.erp.stock.bm.ConfConsGenStockFil;
import com.srn.erp.stock.da.DBConfConsGenStockFil;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConfConsGenStockFil extends FactoryObjetoLogico { 

  public FactoryConfConsGenStockFil() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConfConsGenStockFil confconsgenstockfil = (ConfConsGenStockFil) objLog;
   confconsgenstockfil.setOID(db.getInteger(DBConfConsGenStockFil.OID_FIL_CONF_CONS));
    confconsgenstockfil.setConf_cons_stock(ConfConsGenStock.findByOidProxy(db.getInteger(DBConfConsGenStockFil.OID_CONF_CONS_STK),getSesion()));
    confconsgenstockfil.setClasificador_entidad(ClasificadorEntidad.findByOidProxy(db.getInteger(DBConfConsGenStockFil.OID_CLASIF_ENT),getSesion()));
    confconsgenstockfil.setFiltra_por_codigo(db.getBoolean(DBConfConsGenStockFil.FILTRA_POR_CODIGO));
    confconsgenstockfil.setFiltra_por_desc(db.getBoolean(DBConfConsGenStockFil.FILTRA_POR_DESC));
    confconsgenstockfil.setActivo(db.getBoolean(DBConfConsGenStockFil.ACTIVO));
    confconsgenstockfil.setOrdenPorCodigo(db.getInteger(DBConfConsGenStockFil.ORDEN_POR_CODIGO));
    confconsgenstockfil.setOrdenPorDesc(db.getInteger(DBConfConsGenStockFil.ORDEN_POR_DESC));

  }
}
