package com.srn.erp.turnos.bl.Factory;

import com.srn.erp.turnos.bm.MotivoReservaTurno;
import com.srn.erp.turnos.bm.ReservaTableroTurno;
import com.srn.erp.turnos.bm.TableroEntidadTurnos;
import com.srn.erp.turnos.bm.TableroHorarioTurnos;
import com.srn.erp.turnos.bm.TableroTurnos;
import com.srn.erp.turnos.da.DBReservaTableroTurno;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryReservaTableroTurno extends FactoryObjetoLogico { 

  public FactoryReservaTableroTurno() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ReservaTableroTurno reservatableroturno = (ReservaTableroTurno) objLog;
    reservatableroturno.setOID(db.getInteger(DBReservaTableroTurno.OID_RESERVA));
    reservatableroturno.setTablero(TableroTurnos.findByOidProxy(db.getInteger(DBReservaTableroTurno.OID_TABLERO_CAB),getSesion()));
    reservatableroturno.setEntidad_tablero(TableroEntidadTurnos.findByOidProxy(db.getInteger(DBReservaTableroTurno.OID_TABLERO_ENTIDAD),getSesion()));
    reservatableroturno.setHorario_tablero(TableroHorarioTurnos.findByOidProxy(db.getInteger(DBReservaTableroTurno.OID_TABLERO_HORARIO),getSesion()));
    reservatableroturno.setMotivo(MotivoReservaTurno.findByOidProxy(db.getInteger(DBReservaTableroTurno.OID_MOTIVO),getSesion()));
    reservatableroturno.setSujeto1(Sujeto.findByOidProxy(db.getInteger(DBReservaTableroTurno.OID_SUJETO_1),getSesion()));
    reservatableroturno.setSujeto2(Sujeto.findByOidProxy(db.getInteger(DBReservaTableroTurno.OID_SUJETO_2),getSesion()));
    reservatableroturno.setSujeto3(Sujeto.findByOidProxy(db.getInteger(DBReservaTableroTurno.OID_SUJETO_3),getSesion()));
    reservatableroturno.setSujeto4(Sujeto.findByOidProxy(db.getInteger(DBReservaTableroTurno.OID_SUJETO_4),getSesion()));
    reservatableroturno.setCompo_tipo_res(db.getString(DBReservaTableroTurno.COMPO_TIPO_RES));
    reservatableroturno.setDesc_1(db.getString(DBReservaTableroTurno.DESC_1));
    reservatableroturno.setDesc_2(db.getString(DBReservaTableroTurno.DESC_2));
    reservatableroturno.setDesc_3(db.getString(DBReservaTableroTurno.DESC_3));
    reservatableroturno.setDesc_4(db.getString(DBReservaTableroTurno.DESC_4));
    reservatableroturno.setComentario(db.getString(DBReservaTableroTurno.COMENTARIO));
    reservatableroturno.setInvitado1(db.getBoolean(DBReservaTableroTurno.INVITADO_1));
    reservatableroturno.setInvitado2(db.getBoolean(DBReservaTableroTurno.INVITADO_2));
    reservatableroturno.setInvitado3(db.getBoolean(DBReservaTableroTurno.INVITADO_3));
    reservatableroturno.setInvitado4(db.getBoolean(DBReservaTableroTurno.INVITADO_4));
    reservatableroturno.setAutorizado1(db.getBoolean(DBReservaTableroTurno.AUTORIZ_1));
    reservatableroturno.setAutorizado2(db.getBoolean(DBReservaTableroTurno.AUTORIZ_2));
    reservatableroturno.setAutorizado3(db.getBoolean(DBReservaTableroTurno.AUTORIZ_3));
    reservatableroturno.setAutorizado4(db.getBoolean(DBReservaTableroTurno.AUTORIZ_4));
    reservatableroturno.setReglaAct1(db.getBoolean(DBReservaTableroTurno.REGLA_ACT_1));
    reservatableroturno.setReglaAct2(db.getBoolean(DBReservaTableroTurno.REGLA_ACT_2));
    reservatableroturno.setReglaAct3(db.getBoolean(DBReservaTableroTurno.REGLA_ACT_3));
    reservatableroturno.setReglaAct4(db.getBoolean(DBReservaTableroTurno.REGLA_ACT_4));
    

  }
}
