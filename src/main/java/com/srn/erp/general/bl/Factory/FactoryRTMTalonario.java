package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.RTMTalonario;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.da.DBRTMTalonario;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRTMTalonario extends FactoryObjetoLogico { 

  public FactoryRTMTalonario() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RTMTalonario rtmtalonario = (RTMTalonario) objLog;
    rtmtalonario.setOID(db.getInteger(DBRTMTalonario.OID_RTM_TALONARIO));
    rtmtalonario.setTalonario(Talonario.findByOidProxy(db.getInteger(DBRTMTalonario.OID_TALONARIO),getSesion()));
    rtmtalonario.setCondicion(db.getString(DBRTMTalonario.CONDICION_COMPRO));
    rtmtalonario.setArchivo_rtm(db.getString(DBRTMTalonario.ARCHIVO_RTM));
    rtmtalonario.setActivo(db.getBoolean(DBRTMTalonario.ACTIVO));

  }
}
