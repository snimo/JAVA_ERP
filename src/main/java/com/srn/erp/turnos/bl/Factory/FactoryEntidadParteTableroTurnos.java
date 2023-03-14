package com.srn.erp.turnos.bl.Factory;

import com.srn.erp.turnos.bm.EntidadParteTableroTurnos;
import com.srn.erp.turnos.bm.EntidadTurno;
import com.srn.erp.turnos.bm.ParteTablero;
import com.srn.erp.turnos.da.DBEntidadParteTableroTurnos;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEntidadParteTableroTurnos extends FactoryObjetoLogico { 

  public FactoryEntidadParteTableroTurnos() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EntidadParteTableroTurnos entidadpartetableroturnos = (EntidadParteTableroTurnos) objLog;
    entidadpartetableroturnos.setOID(db.getInteger(DBEntidadParteTableroTurnos.OID_PARTE_ENTIDAD));
    entidadpartetableroturnos.setEntidad_turno(EntidadTurno.findByOidProxy(db.getInteger(DBEntidadParteTableroTurnos.OID_ENTIDAD_TURNO),getSesion()));
    entidadpartetableroturnos.setParte_tablero(ParteTablero.findByOidProxy(db.getInteger(DBEntidadParteTableroTurnos.OID_PARTE_TABLERO),getSesion()));
    entidadpartetableroturnos.setOrden(db.getInteger(DBEntidadParteTableroTurnos.ORDEN));
    entidadpartetableroturnos.setActivo(db.getBoolean(DBEntidadParteTableroTurnos.ACTIVO));
    entidadpartetableroturnos.setCambiarHorarioAlPonerTurno(db.getBoolean(DBEntidadParteTableroTurnos.CAM_HOR_PON_TURNO));
    entidadpartetableroturnos.setMinutosTurno1Suj(db.getInteger(DBEntidadParteTableroTurnos.MINUTOS_1_SUJ));
    entidadpartetableroturnos.setMinutosTurno2Suj(db.getInteger(DBEntidadParteTableroTurnos.MINUTOS_2_SUJ));
    entidadpartetableroturnos.setMinutosTurno3Suj(db.getInteger(DBEntidadParteTableroTurnos.MINUTOS_3_SUJ));
    entidadpartetableroturnos.setMinutosTurno4Suj(db.getInteger(DBEntidadParteTableroTurnos.MINUTOS_4_SUJ));
  }
}
