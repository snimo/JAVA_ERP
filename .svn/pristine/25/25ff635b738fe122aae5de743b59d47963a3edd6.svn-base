package com.srn.erp.turnos.bl.Factory;

import com.srn.erp.turnos.bm.TableroEntidadTurnos;
import com.srn.erp.turnos.bm.TableroHorarioTurnos;
import com.srn.erp.turnos.bm.TableroTurnos;
import com.srn.erp.turnos.da.DBTableroHorarioTurnos;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTableroHorarioTurnos extends FactoryObjetoLogico { 

  public FactoryTableroHorarioTurnos() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TableroHorarioTurnos tablerohorarioturnos = (TableroHorarioTurnos) objLog;
    tablerohorarioturnos.setOID(db.getInteger(DBTableroHorarioTurnos.OID_TABLERO_HORARIO));
    tablerohorarioturnos.setTablero(TableroTurnos.findByOidProxy(db.getInteger(DBTableroHorarioTurnos.OID_TABLERO_CAB),getSesion()));
    tablerohorarioturnos.setHorario(db.getString(DBTableroHorarioTurnos.HORARIO));
    tablerohorarioturnos.setEntidad_tablero(TableroEntidadTurnos.findByOidProxy(db.getInteger(DBTableroHorarioTurnos.OID_TABLERO_ENTIDAD),getSesion()));
    tablerohorarioturnos.setHoraDesdeEnMinutos(db.getInteger(DBTableroHorarioTurnos.HORA_DESDE_EN_MIN));
    tablerohorarioturnos.setHoraHastaEnMinutos(db.getInteger(DBTableroHorarioTurnos.HORA_HASTA_EN_MIN));
  }
}
