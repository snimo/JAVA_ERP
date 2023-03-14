package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.ctasAPagar.bm.AnuladorComproProvAplic;
import com.srn.erp.ctasAPagar.bm.AplicacionComproProv;
import com.srn.erp.ctasAPagar.da.DBAnuladorComproProvAplic;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorComproProvAplic extends FactoryObjetoLogico { 

  public FactoryAnuladorComproProvAplic() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorComproProvAplic anuladorcomproprovaplic = (AnuladorComproProvAplic) objLog;
    anuladorcomproprovaplic.setOID(db.getInteger(DBAnuladorComproProvAplic.OID_CCO_ANU_APL));
    anuladorcomproprovaplic.setCompro_apl_prov(AplicacionComproProv.findByOidProxy(db.getInteger(DBAnuladorComproProvAplic.OID_CCO_APL_PROV),getSesion()));

  }
}
