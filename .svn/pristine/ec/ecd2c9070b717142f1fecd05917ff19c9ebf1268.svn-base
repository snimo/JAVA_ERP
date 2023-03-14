package com.srn.erp.turnos.bl.Factory;

import com.srn.erp.turnos.bm.EntidadParteTableroTurnos;
import com.srn.erp.turnos.bm.MotivoReservaTurno;
import com.srn.erp.turnos.bm.ParteHorarioTurno;
import com.srn.erp.turnos.bm.ParteTablero;
import com.srn.erp.turnos.bm.ReservaParteTablero;
import com.srn.erp.turnos.da.DBReservaParteTablero;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryReservaParteTablero extends FactoryObjetoLogico { 

  public FactoryReservaParteTablero() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ReservaParteTablero reservapartetablero = (ReservaParteTablero) objLog;
    reservapartetablero.setOID(db.getInteger(DBReservaParteTablero.OID_RESERVA));
    reservapartetablero.setParte_tablero(ParteTablero.findByOidProxy(db.getInteger(DBReservaParteTablero.OID_PARTE_TABLERO),getSesion()));
    reservapartetablero.setParte_entidad(EntidadParteTableroTurnos.findByOidProxy(db.getInteger(DBReservaParteTablero.OID_PARTE_ENTIDAD),getSesion()));
    reservapartetablero.setParte_horario(ParteHorarioTurno.findByOidProxy(db.getInteger(DBReservaParteTablero.OID_PARTE_HOR),getSesion()));
    reservapartetablero.setMotivo(MotivoReservaTurno.findByOidProxy(db.getInteger(DBReservaParteTablero.OID_MOTIVO),getSesion()));
    reservapartetablero.setComentario(db.getString(DBReservaParteTablero.COMENTARIO));
    reservapartetablero.setActivo(db.getBoolean(DBReservaParteTablero.ACTIVO));

  }
}
