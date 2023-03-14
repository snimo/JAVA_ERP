package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.AutorizadorCompra;
import com.srn.erp.compras.bm.EsquemaAutorizCompras;
import com.srn.erp.compras.da.DBAutorizadorCompra;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAutorizadorCompra extends FactoryObjetoLogico { 

  public FactoryAutorizadorCompra() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AutorizadorCompra autorizadorcompra = (AutorizadorCompra) objLog;
    autorizadorcompra.setOID(db.getInteger(DBAutorizadorCompra.OID_AUTORIZ_CPRA));
    autorizadorcompra.setEsquema_autoriz(EsquemaAutorizCompras.findByOidProxy(db.getInteger(DBAutorizadorCompra.OID_ESQ_AUTORIZ),getSesion()));
    autorizadorcompra.setValor_clasificador(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBAutorizadorCompra.OID_VAL_CLASIF_ENT),getSesion()));
    autorizadorcompra.setMoneda(Moneda.findByOidProxy(db.getInteger(DBAutorizadorCompra.OID_MONEDA),getSesion()));

  }
}
