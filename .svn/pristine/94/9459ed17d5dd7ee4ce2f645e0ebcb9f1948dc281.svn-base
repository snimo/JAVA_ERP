package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.ReservaTableroTurno;
import com.srn.erp.turnos.bm.TableroEntidadTurnos;
import com.srn.erp.turnos.bm.TableroHorarioTurnos;
import com.srn.erp.turnos.bm.TableroTurnos;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SaveEliminarTurno extends Operation { 
	
  public SaveEliminarTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	TableroTurnos tablero = TableroTurnos.findByOidProxy(mapaDatos.getInteger("oid_tablero"),this.getSesion());
	TableroEntidadTurnos tableroEntidadTurnos = TableroEntidadTurnos.findByOidProxy(mapaDatos.getInteger("oid_tablero_entidad"),this.getSesion());
	TableroHorarioTurnos tableroHorarioTurnos = TableroHorarioTurnos.findByOidProxy(mapaDatos.getInteger("oid_tablero_horario"),this.getSesion());
	
	ReservaTableroTurno reserva = tablero.getReserva(tableroEntidadTurnos, tableroHorarioTurnos);
	if (reserva!=null) {
		reserva.delete();
		this.addTransaccion(reserva);
	}
	
  } 

    
}
