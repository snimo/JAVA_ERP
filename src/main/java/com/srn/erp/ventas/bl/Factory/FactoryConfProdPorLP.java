package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.ConfProdPorLP;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.da.DBConfProdPorLP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConfProdPorLP extends FactoryObjetoLogico { 

  public FactoryConfProdPorLP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConfProdPorLP confprodporlp = (ConfProdPorLP) objLog;
    confprodporlp.setOID(db.getInteger(DBConfProdPorLP.OID_CONF_PROD_LP));
    confprodporlp.setProducto(Producto.findByOidProxy(db.getInteger(DBConfProdPorLP.OID_PRODUCTO),getSesion()));
    confprodporlp.setLista_precios(ListaPrecios.findByOidProxy(db.getInteger(DBConfProdPorLP.OID_PRECIO_CAB),getSesion()));
    confprodporlp.setPorc_rent_sug(db.getDouble(DBConfProdPorLP.PORC_RENT_SUG));

  }
}
