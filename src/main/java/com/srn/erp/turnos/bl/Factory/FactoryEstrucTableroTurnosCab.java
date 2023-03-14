package com.srn.erp.turnos.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.turnos.bm.EstrucTableroTurnosCab;
import com.srn.erp.turnos.da.DBEstrucTableroTurnosCab;

public class FactoryEstrucTableroTurnosCab extends FactoryObjetoLogico { 

  public FactoryEstrucTableroTurnosCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstrucTableroTurnosCab estructableroturnoscab = (EstrucTableroTurnosCab) objLog;
    estructableroturnoscab.setOID(db.getInteger(DBEstrucTableroTurnosCab.OID_ESTRUC_TAB_TUR));
    estructableroturnoscab.setDescripcion(db.getString(DBEstrucTableroTurnosCab.DESCRIPCION));
    estructableroturnoscab.setActivo(db.getBoolean(DBEstrucTableroTurnosCab.ACTIVO));
    estructableroturnoscab.setComportamiento(db.getString(DBEstrucTableroTurnosCab.COMPORTAMIENTO));
  }
}
