package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.MotivoReservaTurno;
import com.srn.erp.turnos.bm.ReservaTableroTurno;
import com.srn.erp.turnos.bm.TableroEntidadTurnos;
import com.srn.erp.turnos.bm.TableroHorarioTurnos;
import com.srn.erp.turnos.bm.TableroTurnos;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveAsigMasivaMotivosReservas extends Operation { 
	
  public SaveAsigMasivaMotivosReservas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	MotivoReservaTurno motivo = MotivoReservaTurno.findByOid(mapaDatos.getInteger("oid_motivo"),this.getSesion());  
	IDataSet ds = mapaDatos.getDataSet("TCeldasSeleccionadas");
	ds.first();
	while (!ds.EOF()) {
		TableroTurnos tablero = TableroTurnos.findByOid(ds.getInteger("oid_tablero"),this.getSesion());
		TableroEntidadTurnos tableroEntidad = TableroEntidadTurnos.findByOid(ds.getInteger("oid_tablero_entidad"),this.getSesion());
		String horario = ds.getString("horario").trim();

		TableroHorarioTurnos tableroHorario = tableroEntidad.getHorario(horario);
		
		if (tableroHorario == null) {
			ds.next();
			continue;
		}
		
		ReservaTableroTurno reserva = tablero.getReserva(tableroEntidad,tableroHorario);
		
		if (reserva == null)
			reserva = (ReservaTableroTurno) ReservaTableroTurno.getNew(ReservaTableroTurno.NICKNAME, this.getSesion());
		reserva.setTablero(tablero);
		reserva.setEntidad_tablero(tableroEntidad);
		reserva.setHorario_tablero(tableroHorario);
		reserva.setCompo_tipo_res(ReservaTableroTurno.TIPO_RES_MOT);
		reserva.setMotivo(motivo);
		reserva.setSujeto1(null);
		reserva.setSujeto2(null);
		reserva.setSujeto3(null);
		reserva.setSujeto4(null);
		reserva.setComentario("");
		reserva.setDesc_1("");
		reserva.setDesc_2("");
		reserva.setDesc_3("");
		reserva.setDesc_4("");
		
		this.addTransaccion(reserva);
		
		
		ds.next();
	}
		
  } 

    
}
