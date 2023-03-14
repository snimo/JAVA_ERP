package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.ConsSalEstStkPorAgrupDepo;
import com.srn.erp.stock.da.DBConsSalEstStkPorAgrupDepo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConsSalEstStkPorAgrupDepo extends FactoryObjetoLogico { 

  public FactoryConsSalEstStkPorAgrupDepo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConsSalEstStkPorAgrupDepo conssaleststkporagrupdepo = (ConsSalEstStkPorAgrupDepo) objLog;
    conssaleststkporagrupdepo.setOid_producto(db.getInteger(DBConsSalEstStkPorAgrupDepo.OID_PRODUCTO));
    conssaleststkporagrupdepo.setCod_producto(db.getString(DBConsSalEstStkPorAgrupDepo.COD_PRODUCTO));
    conssaleststkporagrupdepo.setDesc_producto(db.getString(DBConsSalEstStkPorAgrupDepo.DESC_PRODUCTO));
    conssaleststkporagrupdepo.setCantidad(db.getDouble(DBConsSalEstStkPorAgrupDepo.CANTIDAD));
    conssaleststkporagrupdepo.setOid_um(db.getInteger(DBConsSalEstStkPorAgrupDepo.OID_UM));
    conssaleststkporagrupdepo.setCod_um(db.getString(DBConsSalEstStkPorAgrupDepo.COD_UM));
    conssaleststkporagrupdepo.setOid_estado_stock(db.getInteger(DBConsSalEstStkPorAgrupDepo.OID_ESTADO_STOCK));

  }
}
