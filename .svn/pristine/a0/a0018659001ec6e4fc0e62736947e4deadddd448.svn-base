package com.srn.erp.schedule.bl.Factory;

import com.srn.erp.schedule.bm.TriggerSchedule;
import com.srn.erp.schedule.da.DBTriggerSchedule;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTriggerSchedule extends FactoryObjetoLogico { 

  public FactoryTriggerSchedule() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TriggerSchedule triggerschedule = (TriggerSchedule) objLog;
    triggerschedule.setOID(db.getInteger(DBTriggerSchedule.OID_TRIGGER));
    triggerschedule.setCodigo(db.getString(DBTriggerSchedule.CODIGO));
    triggerschedule.setDescripcion(db.getString(DBTriggerSchedule.DESCRIPCION));
    triggerschedule.setTipo(db.getString(DBTriggerSchedule.TIPO));
    triggerschedule.setActivo(db.getBoolean(DBTriggerSchedule.ACTIVO));
    triggerschedule.setHora(db.getInteger(DBTriggerSchedule.HORA));
    triggerschedule.setMinutos(db.getInteger(DBTriggerSchedule.MINUTOS));
    triggerschedule.setSegundos(db.getInteger(DBTriggerSchedule.SEGUNDOS));
  }
}
