package com.srn.erp.cip.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.cip.bm.LogImpDatosCIP;
import com.srn.erp.cip.da.DBLogImpDatosCIP;

public class FactoryLogImpDatosCIP extends FactoryObjetoLogico { 

  public FactoryLogImpDatosCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    LogImpDatosCIP logimpdatoscip = (LogImpDatosCIP) objLog;
    logimpdatoscip.setOID(db.getInteger(DBLogImpDatosCIP.OID_LOG_IMP));
    logimpdatoscip.setTipo_imp(db.getString(DBLogImpDatosCIP.TIPO_IMP));
    logimpdatoscip.setFecha(db.getDate(DBLogImpDatosCIP.FECHA));
    logimpdatoscip.setHora(db.getString(DBLogImpDatosCIP.HORA));
    logimpdatoscip.setSe_ejecuto(db.getBoolean(DBLogImpDatosCIP.SE_EJECUTO));
    logimpdatoscip.setHubo_error(db.getBoolean(DBLogImpDatosCIP.HUBO_ERROR));
    logimpdatoscip.setMot_no_ejecuto(db.getString(DBLogImpDatosCIP.MOT_NO_EJECUTO));
    logimpdatoscip.setObservacion(db.getString(DBLogImpDatosCIP.OBSERVACION));
    logimpdatoscip.setDesc_error(db.getString(DBLogImpDatosCIP.DESC_ERROR));
    logimpdatoscip.setActivo(db.getBoolean(DBLogImpDatosCIP.ACTIVO));

  }
}
