package com.srn.erp.ctasACobrar.bl.Factory;

import com.srn.erp.ctasACobrar.bm.AnuladorComproClieAplic;
import com.srn.erp.ctasACobrar.bm.AplicacionComproClie;
import com.srn.erp.ctasACobrar.da.DBAnuladorComproClieAplic;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorComproClieAplic extends FactoryObjetoLogico { 

  public FactoryAnuladorComproClieAplic() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorComproClieAplic anuladorcomproclieaplic = (AnuladorComproClieAplic) objLog;
    anuladorcomproclieaplic.setOID(db.getInteger(DBAnuladorComproClieAplic.OID_CCO_ANU_APL));
    anuladorcomproclieaplic.setCompro_aplic_cliente(AplicacionComproClie.findByOidProxy(db.getInteger(DBAnuladorComproClieAplic.OID_CCO_COMPRO_APL),getSesion()));

  }
}
