package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.ctasAPagar.bm.AplicStockValInfRecOC;
import com.srn.erp.ctasAPagar.bm.ComproProvInfRecOC;
import com.srn.erp.ctasAPagar.da.DBAplicStockValInfRecOC;
import com.srn.erp.stock.bm.StockValorizado;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAplicStockValInfRecOC extends FactoryObjetoLogico { 

  public FactoryAplicStockValInfRecOC() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AplicStockValInfRecOC aplicstockvalinfrecoc = (AplicStockValInfRecOC) objLog;
    aplicstockvalinfrecoc.setOID(db.getInteger(DBAplicStockValInfRecOC.OID_APLIC));
    aplicstockvalinfrecoc.setStock_valorizado(StockValorizado.findByOidProxy(db.getInteger(DBAplicStockValInfRecOC.OID_STOCK_VAL),getSesion()));
    aplicstockvalinfrecoc.setCompro_prov_infrec_oc(ComproProvInfRecOC.findByOidProxy(db.getInteger(DBAplicStockValInfRecOC.OID_DET_IR_OC),getSesion()));
    aplicstockvalinfrecoc.setCantidad(db.getDouble(DBAplicStockValInfRecOC.CANTIDAD));
    aplicstockvalinfrecoc.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBAplicStockValInfRecOC.OID_UM),getSesion()));
    aplicstockvalinfrecoc.setActivo(db.getBoolean(DBAplicStockValInfRecOC.ACTIVO));

  }
}
