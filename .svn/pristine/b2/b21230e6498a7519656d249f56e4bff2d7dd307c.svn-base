package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.MotivosEquivCIP;
import com.srn.erp.cip.bm.MotivosNovCIP;
import com.srn.erp.cip.da.DBMotivosEquivCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivosEquivCIP extends FactoryObjetoLogico { 

  public FactoryMotivosEquivCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivosEquivCIP motivosequivcip = (MotivosEquivCIP) objLog;
    motivosequivcip.setOID(db.getInteger(DBMotivosEquivCIP.OID_MOT_EQUIV));
    motivosequivcip.setMotivo(MotivosNovCIP.findByOidProxy(db.getInteger(DBMotivosEquivCIP.OID_MOTIVO),getSesion()));
    motivosequivcip.setCodigo_externo(db.getString(DBMotivosEquivCIP.CODIGO_EXTERNO));
    motivosequivcip.setActivo(db.getBoolean(DBMotivosEquivCIP.ACTIVO));
  }
}
