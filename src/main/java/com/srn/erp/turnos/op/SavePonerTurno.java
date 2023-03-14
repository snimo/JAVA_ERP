package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.ManejadorHorario;
import com.srn.erp.turnos.bm.MotivoReservaTurno;
import com.srn.erp.turnos.bm.ReservaTableroTurno;
import com.srn.erp.turnos.bm.TableroEntidadTurnos;
import com.srn.erp.turnos.bm.TableroHorarioTurnos;
import com.srn.erp.turnos.bm.TableroTurnos;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SavePonerTurno extends Operation { 
	
  public SavePonerTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	TableroTurnos tablero = TableroTurnos.findByOidProxy(mapaDatos.getInteger("oid_tablero"),this.getSesion());
	TableroEntidadTurnos tableroEntidadTurnos = TableroEntidadTurnos.findByOidProxy(mapaDatos.getInteger("oid_tablero_entidad"),this.getSesion());
	TableroHorarioTurnos tableroHorarioTurnos = TableroHorarioTurnos.findByOidProxy(mapaDatos.getInteger("oid_tablero_horario"),this.getSesion());
	
	ReservaTableroTurno reserva = tablero.getReserva(tableroEntidadTurnos, tableroHorarioTurnos);
	if (reserva == null) {
		reserva = (ReservaTableroTurno) ReservaTableroTurno.getNew(ReservaTableroTurno.NICKNAME, this.getSesion());
		reserva.setTablero(tablero);
		reserva.setEntidad_tablero(tableroEntidadTurnos);
		reserva.setHorario_tablero(tableroHorarioTurnos);
	}
	
	reserva.setCompo_tipo_res(ReservaTableroTurno.TIPO_RES_TUR);
	reserva.setMotivo(MotivoReservaTurno.findByOidProxy(mapaDatos.getInteger("oid_motivo"), this.getSesion()));
	reserva.setComentario(mapaDatos.getString("observacion"));
	Sujeto sujeto1 = Sujeto.findByOidProxy(mapaDatos.getInteger("oid_suj_1"), this.getSesion());
	Sujeto sujeto2 = Sujeto.findByOidProxy(mapaDatos.getInteger("oid_suj_2"), this.getSesion());
	Sujeto sujeto3 = Sujeto.findByOidProxy(mapaDatos.getInteger("oid_suj_3"), this.getSesion());
	Sujeto sujeto4 = Sujeto.findByOidProxy(mapaDatos.getInteger("oid_suj_4"), this.getSesion());
	
	reserva.setAutorizado1(mapaDatos.getBoolean("autoriz_1"));
	reserva.setAutorizado2(mapaDatos.getBoolean("autoriz_2"));
	reserva.setAutorizado3(mapaDatos.getBoolean("autoriz_3"));
	reserva.setAutorizado4(mapaDatos.getBoolean("autoriz_4"));
	
	reserva.setReglaAct1(mapaDatos.getBoolean("regla_act_1"));
	reserva.setReglaAct2(mapaDatos.getBoolean("regla_act_2"));
	reserva.setReglaAct3(mapaDatos.getBoolean("regla_act_3"));
	reserva.setReglaAct4(mapaDatos.getBoolean("regla_act_4"));
	
		
	reserva.setSujeto1(sujeto1);
	reserva.setSujeto2(sujeto2);
	reserva.setSujeto3(sujeto3);
	reserva.setSujeto4(sujeto4);
	
	if (sujeto1!=null)
		reserva.setDesc_1(sujeto1.getCodigo()+" - "+sujeto1.getRazon_social());
	else
		reserva.setDesc_1("");
	if (sujeto2!=null)
		reserva.setDesc_2(sujeto2.getCodigo()+" - "+sujeto2.getRazon_social());
	else
		reserva.setDesc_2("");
	if (sujeto3!=null)
		reserva.setDesc_3(sujeto3.getCodigo()+" - "+sujeto3.getRazon_social());
	else
		reserva.setDesc_3("");
	if (sujeto4!=null)
		reserva.setDesc_4(sujeto4.getCodigo()+" - "+sujeto4.getRazon_social());
	else
		reserva.setDesc_4("");
	
	if ((reserva.getSujeto1()==null) &&
		(reserva.getSujeto2()==null) &&
		(reserva.getSujeto3()==null) &&
		(reserva.getSujeto4()==null) &&
		(reserva.getMotivo()==null) &&
		((reserva.getComentario()==null) || reserva.getComentario().length()==0)
			) {
		reserva.delete();
	}
	
	this.addTransaccion(reserva);
	
	// Verificar si esta activado el cambio de horario
	if (tableroEntidadTurnos.isCambiarHorarioAlPonerTurno()) {
		
		int cantMinutosTurno = 0;
		
		if (reserva.isTiene1Sujeto())
			cantMinutosTurno = tableroEntidadTurnos.getMinutosTur1Suj();
		else
			if (reserva.isTiene2Sujetos())
				cantMinutosTurno = tableroEntidadTurnos.getMinutosTur2Suj();
			else
				if (reserva.isTiene3Sujetos())
					cantMinutosTurno = tableroEntidadTurnos.getMinutosTur3Suj();		
				else
					if (reserva.isTiene4Sujetos())
						cantMinutosTurno = tableroEntidadTurnos.getMinutosTur4Suj();
		
		if ((reserva.isTiene1Sujeto() || reserva.isTiene2Sujetos() || reserva.isTiene3Sujetos() || reserva.isTiene4Sujetos()) && (cantMinutosTurno!=0)) {
			
			// Si algun jugador cargado y el turno esta definido en Minutos
			int difEnMinutos = 0;
			int duracionTurno = 0;
			boolean procesarHorario = false;
			Iterator iterHorarios = tableroEntidadTurnos.getHorarios().iterator();
			while (iterHorarios.hasNext()) {
				TableroHorarioTurnos tableroHorario = (TableroHorarioTurnos) iterHorarios.next();
				if (tableroHorario.getOID() == tableroHorarioTurnos.getOID()) {
					
					// Si el Turno nuevo es mas chico que el turno actual, entonces abrirlo en dos turnos
					if (cantMinutosTurno==tableroHorario.getDuracionTurnoEnMinutos()) 
						return;
					
					
					if (cantMinutosTurno<tableroHorario.getDuracionTurnoEnMinutos()) {
						
						String horaHastaSegTur = tableroHorario.getHoraHasta();
						
						// El turno actual abrilo en dos turnos
						String primerHorarioTurno = 
							ManejadorHorario.getNuevaHoraCambioHasta(tableroHorario.getHorario(),cantMinutosTurno*-1);
						tableroHorario.setHorario(primerHorarioTurno);
						this.addTransaccion(tableroHorario);
						
						String horaDesdeSegTur = tableroHorario.getHoraHasta();
						
						// Dar de alta el Nuevo Turno con el horario por el restante
						TableroHorarioTurnos segundoHorarioTurno =
							(TableroHorarioTurnos)TableroHorarioTurnos.getNew(TableroHorarioTurnos.NICKNAME, this.getSesion());
						segundoHorarioTurno.setTablero(tablero);
						segundoHorarioTurno.setEntidad_tablero(tableroEntidadTurnos);
						
						
						String horarioSegTur = horaDesdeSegTur+" a "+horaHastaSegTur;
						segundoHorarioTurno.setHorario(horarioSegTur);
						this.addTransaccion(segundoHorarioTurno);
						
						
						return;	
					}
					
					// Si el turno siguiente esta ocupado entonces no hacer ningun cambio en el horario
					TableroHorarioTurnos proxTabHorTur = tableroHorario.getProximoHorario();
					if (proxTabHorTur!=null) {
						ReservaTableroTurno proxReserva = tablero.getReserva(tableroEntidadTurnos, proxTabHorTur);
						if (proxReserva!=null) return;
					}
					
					
					if (cantMinutosTurno>tableroHorario.getDuracionTurnoEnMinutos()) {
						// Se asume que el proximo turno esta libre
						// El turno actual abrilo en dos turnos
						
						TableroHorarioTurnos defHorTabHorTur = tableroHorario.getProximoHorario();
						
						if (defHorTabHorTur == null) return;
						
						difEnMinutos = cantMinutosTurno - tableroHorario.getDuracionTurnoEnMinutos();
						
						String primerHorarioTurno = 
							ManejadorHorario.getNuevaHoraCambioHasta(tableroHorario.getHorario(),difEnMinutos);
						tableroHorario.setHorario(primerHorarioTurno);
						this.addTransaccion(tableroHorario);
						
						String horaDesdeSegTur = tableroHorario.getHoraHasta();
						
						String horaHastaSegTur = defHorTabHorTur.getHoraHasta();
						String horarioSegTur = horaDesdeSegTur+" a "+horaHastaSegTur;
						defHorTabHorTur.setHorario(horarioSegTur);
						if (defHorTabHorTur.getDuracionTurnoEnMinutos()==0)
							defHorTabHorTur.delete();
						this.addTransaccion(defHorTabHorTur);
						return;	
						
						
					}
					
					
				/*	procesarHorario = true;
					duracionTurno = tableroHorario.getDuracionTurnoEnMinutos();
					
					// Sumar o sacarle minutos segun configuracion					
					difEnMinutos = cantMinutosTurno - duracionTurno;  
					String nuevoHorarioTurno = ManejadorHorario.getNuevaHoraCambioHasta(tableroHorario.getHorario(),difEnMinutos);
					tableroHorario.setHorario(nuevoHorarioTurno);
			
					this.addTransaccion(tableroHorario);
					continue;*/
					
					return;
				}
				
			//	
				
			
				
			}
		
			
		}
			
	}
	
	
	
	
	
  } 

    
}
