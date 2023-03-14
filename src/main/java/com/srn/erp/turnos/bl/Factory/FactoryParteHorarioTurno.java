package com.srn.erp.turnos.bl.Factory;

import com.srn.erp.turnos.bm.ParteHorarioTurno;
import com.srn.erp.turnos.bm.ParteTablero;
import com.srn.erp.turnos.da.DBParteHorarioTurno;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryParteHorarioTurno extends FactoryObjetoLogico { 

  public FactoryParteHorarioTurno() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ParteHorarioTurno partehorarioturno = (ParteHorarioTurno) objLog;
    partehorarioturno.setOID(db.getInteger(DBParteHorarioTurno.OID_PARTE_HOR));
    partehorarioturno.setParte_tablero(ParteTablero.findByOidProxy(db.getInteger(DBParteHorarioTurno.OID_PARTE_TABLERO),getSesion()));
    partehorarioturno.setHorario(db.getString(DBParteHorarioTurno.HORARIO));
    partehorarioturno.setActivo(db.getBoolean(DBParteHorarioTurno.ACTIVO));

  }
}
