package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.bm.ListaPrecioCondPago;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.da.DBListaPrecioCondPago;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryListaPrecioCondPago extends FactoryObjetoLogico { 

  public FactoryListaPrecioCondPago() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ListaPrecioCondPago listapreciocondpago = (ListaPrecioCondPago) objLog;
    listapreciocondpago.setOID(db.getInteger(DBListaPrecioCondPago.OID_LP_CP));
    listapreciocondpago.setCondicionpago(CondicionPago.findByOidProxy(db.getInteger(DBListaPrecioCondPago.OID_COND_PAGO),getSesion()));
    listapreciocondpago.setListaprecio(ListaPrecios.findByOidProxy(db.getInteger(DBListaPrecioCondPago.OID_PRECIO_CAB),getSesion()));

  }
}
