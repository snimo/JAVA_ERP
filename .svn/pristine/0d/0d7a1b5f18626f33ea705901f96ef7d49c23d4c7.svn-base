package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.PrepararStatus;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.da.DBPrepararStatus;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPrepararStatus extends FactoryObjetoLogico { 

  public FactoryPrepararStatus() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PrepararStatus prepararStatus = (PrepararStatus) objLog;
    prepararStatus.setOID(db.getInteger(DBPrepararStatus.OID_PUERTA));
    prepararStatus.setPuerta(Puerta.findByOidProxy(db.getInteger(DBPrepararStatus.OID_PUERTA),getSesion()));
    prepararStatus.setFecha_ultstatus(db.getDate(DBPrepararStatus.FEC_ULT_STATUS));
    prepararStatus.setHora_ultStatus(db.getString(DBPrepararStatus.HORA_ULT_STATUS));
    prepararStatus.setActivo(db.getBoolean(DBPrepararStatus.ACTIVO));
  }
}
