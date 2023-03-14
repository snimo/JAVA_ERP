package com.srn.erp.turnos.bl.Factory;

import com.srn.erp.turnos.bm.TurnoPlantillaHorCab;
import com.srn.erp.turnos.bm.TurnoPlantillaHorDet;
import com.srn.erp.turnos.da.DBTurnoPlantillaHorDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTurnoPlantillaHorDet extends FactoryObjetoLogico { 

  public FactoryTurnoPlantillaHorDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TurnoPlantillaHorDet turnoplantillahordet = (TurnoPlantillaHorDet) objLog;
    turnoplantillahordet.setOID(db.getInteger(DBTurnoPlantillaHorDet.OID_PLANT_HOR_DET));
    turnoplantillahordet.setPlantilla_horario(TurnoPlantillaHorCab.findByOidProxy(db.getInteger(DBTurnoPlantillaHorDet.OID_PLANT_HOR),getSesion()));
    turnoplantillahordet.setHorario(db.getString(DBTurnoPlantillaHorDet.HORARIO));
    turnoplantillahordet.setActivo(db.getBoolean(DBTurnoPlantillaHorDet.ACTIVO));

  }
}
