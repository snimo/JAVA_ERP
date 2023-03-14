package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.ManejadorHorario;
import com.srn.erp.turnos.bm.ReservaTableroTurno;
import com.srn.erp.turnos.bm.TableroEntidadTurnos;
import com.srn.erp.turnos.bm.TableroHorarioTurnos;
import com.srn.erp.turnos.bm.TableroTurnos;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class SaveCorrimientoTurnos extends Operation { 
	
  public SaveCorrimientoTurnos() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	TableroTurnos tablero = TableroTurnos.findByOidProxy(mapaDatos.getInteger("oid_tablero"),this.getSesion());
	
	TableroEntidadTurnos tableroEntidadTurnos = TableroEntidadTurnos.findByOidProxy(mapaDatos.getInteger("oid_tablero_entidad"),this.getSesion());
	TableroHorarioTurnos tableroHorarioOri = TableroHorarioTurnos.findByOidProxy(mapaDatos.getInteger("oid_tablero_horario"),this.getSesion());
	String nuevoHoraInicio = mapaDatos.getString("nueva_hora_inicio");
	
	if (ManejadorHorario.isHoraValida(nuevoHoraInicio)==false)
		throw new ExceptionValidation(null,"Horario Inválido:"+nuevoHoraInicio);
	
	int difEnMinutos = 0;
	boolean procesarHorario = false;
	Iterator iterHorarios = tableroEntidadTurnos.getHorarios().iterator();
	while (iterHorarios.hasNext()) {
		TableroHorarioTurnos tableroHorario = (TableroHorarioTurnos) iterHorarios.next();
		if (tableroHorario.getOID() == tableroHorarioOri.getOID()) {
			procesarHorario = true;
			difEnMinutos = ManejadorHorario.getDifEnMinutos(nuevoHoraInicio,tableroHorarioOri.getHorario());
		}
		if (procesarHorario) {
			String nuevoHorario = ManejadorHorario.getNuevaHoraDesdeHasta(tableroHorario.getHorario(),difEnMinutos);
			tableroHorario.setHorario(nuevoHorario);
			
			// Forzar la actualizacion de reservas para que se vuelvan a ejecutar las validacion del reglamento
			ReservaTableroTurno reserva = tablero.getReserva(tableroEntidadTurnos, tableroHorario);
			if (reserva!=null)
				this.addTransaccion(reserva);
			
			this.addTransaccion(tableroHorario);
		}
	}
	
	
	
  } 
    
}
