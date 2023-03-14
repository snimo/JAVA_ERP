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

public class SaveMoverTurno extends Operation {

	private boolean esCopia = false;

	public SaveMoverTurno() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		TableroTurnos tablero = TableroTurnos.findByOidProxy(mapaDatos.getInteger("oid_tablero"), this.getSesion());

		if (mapaDatos.containsKey("es_copia"))
			esCopia = true;

		TableroEntidadTurnos tableroEntidadTurnosOri = TableroEntidadTurnos.findByOidProxy(mapaDatos.getInteger("oid_tablero_entidad_ori"),
				this.getSesion());
		String horarioOri = mapaDatos.getString("horario_ori").trim();
		TableroHorarioTurnos tableroHorarioOri = tableroEntidadTurnosOri.getHorario(horarioOri);

		TableroEntidadTurnos tableroEntidadTurnosDest = TableroEntidadTurnos.findByOidProxy(mapaDatos
				.getInteger("oid_tablero_entidad_dest"), this.getSesion());
		String horarioDest = mapaDatos.getString("horario_dest").trim();
		TableroHorarioTurnos tableroHorarioDest = tableroEntidadTurnosDest.getHorario(horarioDest);

		if (tableroEntidadTurnosOri == null)
			throw new ExceptionValidation(null, "No se pudo realizar el movimiento del Turno");
		if (tableroHorarioOri == null)
			throw new ExceptionValidation(null, "No se pudo realizar el movimiento del Turno");
		ReservaTableroTurno reservaOri = tablero.getReserva(tableroEntidadTurnosOri, tableroHorarioOri);
		if (reservaOri == null)
			throw new ExceptionValidation(null, "No se pudo realizar el movimiento del Turno");

		if (tableroHorarioDest == null)
			throw new ExceptionValidation(null, "La celda destino no tiene un horario definido");

		ReservaTableroTurno reservaDest = tablero.getReserva(tableroEntidadTurnosDest, tableroHorarioDest);
		if (reservaDest == null) {
			reservaDest = (ReservaTableroTurno) ReservaTableroTurno.getNew(ReservaTableroTurno.NICKNAME, this.getSesion());
			reservaDest.setTablero(tablero);
			reservaDest.setEntidad_tablero(tableroEntidadTurnosDest);
			reservaDest.setHorario_tablero(tableroHorarioDest);

		}
		reservaDest.asignar(reservaOri);
		if (mapaDatos.containsKey("AUTORIZADO")) {
			reservaDest.setAutorizado1(new Boolean(true));
			reservaDest.setAutorizado2(new Boolean(true));
			reservaDest.setAutorizado3(new Boolean(true));
			reservaDest.setAutorizado4(new Boolean(true));
		}

		if (!esCopia) {
			reservaOri.delete();
			this.addTransaccion(reservaOri);
		}

		this.addTransaccion(reservaDest);

		// Verificar si es necesario realizar corriminto por el origen
		// Verificar si esta activado el cambio de horario
		if (tableroEntidadTurnosDest.isCambiarHorarioAlPonerTurno()) {

			int cantMinutosTurno = 0;

			if (reservaDest.isTiene1Sujeto())
				cantMinutosTurno = tableroEntidadTurnosDest.getMinutosTur1Suj();
			else if (reservaDest.isTiene2Sujetos())
				cantMinutosTurno = tableroEntidadTurnosDest.getMinutosTur2Suj();
			else if (reservaDest.isTiene3Sujetos())
				cantMinutosTurno = tableroEntidadTurnosDest.getMinutosTur3Suj();
			else if (reservaDest.isTiene4Sujetos())
				cantMinutosTurno = tableroEntidadTurnosDest.getMinutosTur4Suj();

			if ((reservaDest.isTiene1Sujeto() || reservaDest.isTiene2Sujetos() || reservaDest.isTiene3Sujetos() || reservaDest
					.isTiene4Sujetos())
					&& (cantMinutosTurno != 0)) {

				// Si algun jugador cargado y el turno esta definido en Minutos
				int difEnMinutos = 0;
				int duracionTurno = 0;
				boolean procesarHorario = false;
				Iterator iterHorarios = tableroEntidadTurnosDest.getHorarios().iterator();
				while (iterHorarios.hasNext()) {
					TableroHorarioTurnos tableroHorario = (TableroHorarioTurnos) iterHorarios.next();
					if (tableroHorario.getOID() == tableroHorarioDest.getOID()) {

						// Si el Turno nuevo es mas chico que el turno actual,
						// entonces abrirlo en dos turnos
						if (cantMinutosTurno == tableroHorario.getDuracionTurnoEnMinutos())
							return;

						if (cantMinutosTurno < tableroHorario.getDuracionTurnoEnMinutos()) {

							String horaHastaSegTur = tableroHorario.getHoraHasta();

							// El turno actual abrilo en dos turnos
							String primerHorarioTurno = ManejadorHorario.getNuevaHoraCambioHasta(tableroHorario.getHorario(),
									cantMinutosTurno * -1);
							tableroHorario.setHorario(primerHorarioTurno);
							this.addTransaccion(tableroHorario);

							String horaDesdeSegTur = tableroHorario.getHoraHasta();

							// Dar de alta el Nuevo Turno con el horario por el
							// restante
							TableroHorarioTurnos segundoHorarioTurno = (TableroHorarioTurnos) TableroHorarioTurnos.getNew(
									TableroHorarioTurnos.NICKNAME, this.getSesion());
							segundoHorarioTurno.setTablero(tablero);
							segundoHorarioTurno.setEntidad_tablero(tableroHorarioDest.getEntidad_tablero());

							String horarioSegTur = horaDesdeSegTur + " a " + horaHastaSegTur;
							segundoHorarioTurno.setHorario(horarioSegTur);
							this.addTransaccion(segundoHorarioTurno);

							return;
						}

						// Si el turno siguiente esta ocupado entonces no hacer
						// ningun cambio en el horario
						TableroHorarioTurnos proxTabHorTur = tableroHorario.getProximoHorario();
						if (proxTabHorTur!=null) {
							ReservaTableroTurno proxReserva = tablero.getReserva(tableroHorarioDest.getEntidad_tablero(), proxTabHorTur);
							if (proxReserva != null)
								return;
						}

						if (cantMinutosTurno > tableroHorario.getDuracionTurnoEnMinutos()) {
							// Se asume que el proximo turno esta libre
							// El turno actual abrilo en dos turnos

							TableroHorarioTurnos defHorTabHorTur = tableroHorario.getProximoHorario();
							
							if (defHorTabHorTur == null) return;

							difEnMinutos = cantMinutosTurno - tableroHorario.getDuracionTurnoEnMinutos();

							String primerHorarioTurno = ManejadorHorario.getNuevaHoraCambioHasta(tableroHorario.getHorario(), difEnMinutos);
							tableroHorario.setHorario(primerHorarioTurno);
							this.addTransaccion(tableroHorario);

							String horaDesdeSegTur = tableroHorario.getHoraHasta();

							String horaHastaSegTur = defHorTabHorTur.getHoraHasta();
							String horarioSegTur = horaDesdeSegTur + " a " + horaHastaSegTur;
							defHorTabHorTur.setHorario(horarioSegTur);
							if (defHorTabHorTur.getDuracionTurnoEnMinutos() == 0)
								defHorTabHorTur.delete();
							this.addTransaccion(defHorTabHorTur);
							return;

						}

						/*
						 * procesarHorario = true; duracionTurno =
						 * tableroHorario.getDuracionTurnoEnMinutos();
						 * 
						 * // Sumar o sacarle minutos segun configuración
						 * difEnMinutos = cantMinutosTurno - duracionTurno;
						 * String nuevoHorarioTurno =
						 * ManejadorHorario.getNuevaHoraCambioHasta
						 * (tableroHorario.getHorario(),difEnMinutos);
						 * tableroHorario.setHorario(nuevoHorarioTurno);
						 * 
						 * this.addTransaccion(tableroHorario); continue;
						 */

						return;
					}
				}
			}

		}

	}

}
