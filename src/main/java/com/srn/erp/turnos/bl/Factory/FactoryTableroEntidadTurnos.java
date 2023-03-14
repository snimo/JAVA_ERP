package com.srn.erp.turnos.bl.Factory;

import com.srn.erp.turnos.bm.EntidadTurno;
import com.srn.erp.turnos.bm.TableroEntidadTurnos;
import com.srn.erp.turnos.bm.TableroTurnos;
import com.srn.erp.turnos.da.DBEntidadParteTableroTurnos;
import com.srn.erp.turnos.da.DBTableroEntidadTurnos;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTableroEntidadTurnos extends FactoryObjetoLogico { 

  public FactoryTableroEntidadTurnos() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TableroEntidadTurnos tableroentidadturnos = (TableroEntidadTurnos) objLog;
    tableroentidadturnos.setOID(db.getInteger(DBTableroEntidadTurnos.OID_TABLERO_ENTIDAD));
    tableroentidadturnos.setTablero(TableroTurnos.findByOidProxy(db.getInteger(DBTableroEntidadTurnos.OID_TABLERO_CAB),getSesion()));
    tableroentidadturnos.setSecu(db.getInteger(DBTableroEntidadTurnos.SECU));
    tableroentidadturnos.setEntidad_turno(EntidadTurno.findByOidProxy(db.getInteger(DBTableroEntidadTurnos.OID_ENTIDAD_TURNO),getSesion()));
    tableroentidadturnos.setCambiarHorarioAlPonerTurno(db.getBoolean(DBEntidadParteTableroTurnos.CAM_HOR_PON_TURNO));
    tableroentidadturnos.setMinutosTurno1Suj(db.getInteger(DBEntidadParteTableroTurnos.MINUTOS_1_SUJ));
    tableroentidadturnos.setMinutosTurno2Suj(db.getInteger(DBEntidadParteTableroTurnos.MINUTOS_2_SUJ));
    tableroentidadturnos.setMinutosTurno3Suj(db.getInteger(DBEntidadParteTableroTurnos.MINUTOS_3_SUJ));
    tableroentidadturnos.setMinutosTurno4Suj(db.getInteger(DBEntidadParteTableroTurnos.MINUTOS_4_SUJ));

  }
}
