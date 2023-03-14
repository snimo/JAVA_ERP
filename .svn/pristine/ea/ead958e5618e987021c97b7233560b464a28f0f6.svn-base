package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.CondModEvalCab;
import com.srn.erp.rrhh.bm.RangoPtajeObsCodif;
import com.srn.erp.rrhh.da.DBRangoPtajeObsCodif;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRangoPtajeObsCodif extends FactoryObjetoLogico { 

  public FactoryRangoPtajeObsCodif() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RangoPtajeObsCodif rangoptajeobscodif = (RangoPtajeObsCodif) objLog;
    rangoptajeobscodif.setOID(db.getInteger(DBRangoPtajeObsCodif.OID_MOD_OBS_CODIF));
    rangoptajeobscodif.setCond_modelo(CondModEvalCab.findByOidProxy(db.getInteger(DBRangoPtajeObsCodif.OID_COND_MOD),getSesion()));
    rangoptajeobscodif.setPuntaje_desde(db.getMoney(DBRangoPtajeObsCodif.PUNTAJE_DESDE));
    rangoptajeobscodif.setPuntaje_hasta(db.getMoney(DBRangoPtajeObsCodif.PUNTAJE_HASTA));
    rangoptajeobscodif.setActivo(db.getBoolean(DBRangoPtajeObsCodif.ACTIVO));
  }
}
