package com.srn.erp.turnos.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.turnos.bm.TurnoPlantillaHorCab;
import com.srn.erp.turnos.da.DBTurnoPlantillaHorCab;

public class FactoryTurnoPlantillaHorCab extends FactoryObjetoLogico { 

  public FactoryTurnoPlantillaHorCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TurnoPlantillaHorCab turnoplantillahorcab = (TurnoPlantillaHorCab) objLog;
    turnoplantillahorcab.setOID(db.getInteger(DBTurnoPlantillaHorCab.OID_PLANT_HOR));
    turnoplantillahorcab.setDescripcion(db.getString(DBTurnoPlantillaHorCab.DESCRIPCION));
    turnoplantillahorcab.setActivo(db.getBoolean(DBTurnoPlantillaHorCab.ACTIVO));
  }
}
