package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.ventas.bm.ConfProdGralPorLP;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.da.DBConfProdGralPorLP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConfProdGralPorLP extends FactoryObjetoLogico { 

  public FactoryConfProdGralPorLP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConfProdGralPorLP confprodgralporlp = (ConfProdGralPorLP) objLog;
    confprodgralporlp.setOID(db.getInteger(DBConfProdGralPorLP.OID_CONF_PROD_LP));
    confprodgralporlp.setLista_precios(ListaPrecios.findByOidProxy(db.getInteger(DBConfProdGralPorLP.OID_LISTA_PRECIO),getSesion()));
    confprodgralporlp.setClasificador(ClasificadorEntidad.findByOidProxy(db.getInteger(DBConfProdGralPorLP.OID_CLASIF_ENT),getSesion()));
    confprodgralporlp.setPorc_rent_sug(db.getMoney(DBConfProdGralPorLP.PORC_RENT_SUG));
    confprodgralporlp.setValor_clasif_ent(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBConfProdGralPorLP.OID_VAL_CLASIF_ENT),getSesion()));

  }
}
