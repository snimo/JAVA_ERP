package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.LogMensajeCIP;
import com.srn.erp.cip.da.DBLogMensajeCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryLogMensajeCIP extends FactoryObjetoLogico { 

  public FactoryLogMensajeCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    LogMensajeCIP logmensajecip = (LogMensajeCIP) objLog;
    logmensajecip.setOID(db.getInteger(DBLogMensajeCIP.OID_LOG_MENS));
    logmensajecip.setFec_hor(db.getDateTime(DBLogMensajeCIP.FEC_HOR));
    logmensajecip.setId_equipo(db.getInteger(DBLogMensajeCIP.ID_EQUIPO));
    logmensajecip.setMensaje(db.getString(DBLogMensajeCIP.MENSAJE));
    logmensajecip.setActivo(db.getBoolean(DBLogMensajeCIP.ACTIVO));

  }
}
