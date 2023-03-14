package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.pagos.bm.AnuladorRendFF;
import com.srn.erp.pagos.bm.AnuladorRendFFValores;
import com.srn.erp.pagos.bm.RendicionFondoFijoMedioPago;
import com.srn.erp.pagos.da.DBAnuladorRendFFValores;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorRendFFValores extends FactoryObjetoLogico { 

  public FactoryAnuladorRendFFValores() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorRendFFValores anuladorrendffvalores = (AnuladorRendFFValores) objLog;
    anuladorrendffvalores.setOID(db.getInteger(DBAnuladorRendFFValores.OID_ANU_FF_VALOR));
    anuladorrendffvalores.setAnulador_rend_ff(AnuladorRendFF.findByOidProxy(db.getInteger(DBAnuladorRendFFValores.OID_ANU_REND_FF),getSesion()));
    anuladorrendffvalores.setRend_medio_pago(RendicionFondoFijoMedioPago.findByOidProxy(db.getInteger(DBAnuladorRendFFValores.OID_REND_MED_PAGO),getSesion()));

  }
}
