package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.AnuladorAsientoManual;
import com.srn.erp.contabilidad.bm.AsientoManual;
import com.srn.erp.contabilidad.da.DBAnuladorAsientoManual;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorAsientoManual extends FactoryObjetoLogico { 

  public FactoryAnuladorAsientoManual() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorAsientoManual anuladorasientomanual = (AnuladorAsientoManual) objLog;
    anuladorasientomanual.setOID(db.getInteger(DBAnuladorAsientoManual.OID_CAB_ASI_MAN));
    anuladorasientomanual.setAsiento_manual(AsientoManual.findByOidProxy(db.getInteger(DBAnuladorAsientoManual.OID_CCO),getSesion()));

  }
}
