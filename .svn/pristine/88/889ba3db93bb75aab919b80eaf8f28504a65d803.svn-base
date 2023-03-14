package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.pagos.bm.AnuladorRendFF;
import com.srn.erp.pagos.bm.AnuladorRendFFComproProv;
import com.srn.erp.pagos.bm.RendicionFondoFijoCompro;
import com.srn.erp.pagos.da.DBAnuladorRendFFComproProv;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorRendFFComproProv extends FactoryObjetoLogico { 

  public FactoryAnuladorRendFFComproProv() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorRendFFComproProv anuladorrendffcomproprov = (AnuladorRendFFComproProv) objLog;
    anuladorrendffcomproprov.setOID(db.getInteger(DBAnuladorRendFFComproProv.OID_ANU_FF_PROV));
    anuladorrendffcomproprov.setAnulador_rend_ff(AnuladorRendFF.findByOidProxy(db.getInteger(DBAnuladorRendFFComproProv.OID_ANU_REND_FF),getSesion()));
    anuladorrendffcomproprov.setRendicion_ff_det(RendicionFondoFijoCompro.findByOidProxy(db.getInteger(DBAnuladorRendFFComproProv.OID_REND_FF_DET),getSesion()));

  }
}
