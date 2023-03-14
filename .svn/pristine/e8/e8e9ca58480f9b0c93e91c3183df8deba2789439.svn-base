package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.ListaPrecioSujeto;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.da.DBListaPrecioSujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryListaPrecioSujeto extends FactoryObjetoLogico {

  public FactoryListaPrecioSujeto() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ListaPrecioSujeto listapreciosujeto = (ListaPrecioSujeto) objLog;
    listapreciosujeto.setOID(db.getInteger(DBListaPrecioSujeto.OID_LP_SUJ));
    listapreciosujeto.setFecha_desde(db.getDate(DBListaPrecioSujeto.FEC_DESDE));
    listapreciosujeto.setFecha_hasta(db.getDate(DBListaPrecioSujeto.FEC_HASTA));
    listapreciosujeto.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBListaPrecioSujeto.OID_SUJETO),getSesion()));
    listapreciosujeto.setActivo(db.getBoolean(DBListaPrecioSujeto.ACTIVO));
    listapreciosujeto.setLista_precio(ListaPrecios.findByOidProxy(db.getInteger(DBListaPrecioSujeto.OID_PRECIO_CAB),getSesion()));
  }
}
