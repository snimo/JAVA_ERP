package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.ReservaTableroTurno;
import com.srn.erp.turnos.bm.TableroEntidadTurnos;
import com.srn.erp.turnos.bm.TableroHorarioTurnos;
import com.srn.erp.turnos.bm.TableroTurnos;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTableroProgTurnosLibres extends Operation {

	private String nombreTabla = null;

	public TraerTableroProgTurnosLibres() {
	}

	int secu = 0;

	public void execute(MapDatos mapaDatos) throws BaseException {

		

		if (mapaDatos.containsKey("nombre_tabla"))
			nombreTabla = mapaDatos.getString("nombre_tabla");
		
		IDataSet ds = getDataSetTabProg();

		java.util.Date fecha = mapaDatos.getDate("fecha");
		String comportamiento = mapaDatos.getString("comportamiento");

		TableroTurnos tablero = TableroTurnos.getTablero(fecha, comportamiento,
				this.getSesion());
		if (tablero == null) {
			writeCliente(ds);
			return;
		}

		if (mapaDatos.containsKey("SOLO_ENTIDAD")) {

			TableroEntidadTurnos tableroEntidad = TableroEntidadTurnos.findByOid(mapaDatos.getInteger("oid_tablero_entidad"), this.getSesion());
			cargaTurnos(ds, tablero, tableroEntidad);
			
		} else {

			Iterator iterEntidades = tablero.getEntidades().iterator();
			while (iterEntidades.hasNext()) {
				TableroEntidadTurnos entidad = (TableroEntidadTurnos) iterEntidades
						.next();

				cargaTurnos(ds, tablero, entidad);

			}
		}

		writeCliente(ds);
	}

	private IDataSet getDataSetTabProg() {
		IDataSet dataset = new TDataSet();
		if (nombreTabla == null)
			dataset.create("Tablero");
		else
			dataset.create(nombreTabla);
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tablero", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tablero_entidad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_entidad", Field.STRING, 50));
		dataset.fieldDef(new Field("es_titulo_horarios", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("read_only", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("es_turno", Field.BOOLEAN, 0));

		for (int i = 1; i <= 100; ++i) {
			dataset.fieldDef(new Field("ver_" + i, Field.STRING, 500));
			dataset.fieldDef(new Field("info_" + i, Field.STRING, 500));
		}

		return dataset;
	}

	private void cargaTurnos(IDataSet ds, TableroTurnos tablero,
			TableroEntidadTurnos entidad) throws BaseException {

		// ENVIAR REGISTRO POR EL HORARIO
		++secu;
		ds.append();
		ds.fieldValue("secu", secu);
		ds.fieldValue("oid_tablero", tablero.getOIDInteger());
		ds.fieldValue("oid_tablero_entidad", entidad.getOIDInteger());
		ds.fieldValue("desc_entidad", "");
		ds.fieldValue("es_titulo_horarios", true);
		ds.fieldValue("read_only", true);
		ds.fieldValue("es_turno", false);

		int i = 1;
		Iterator iterHorarios = tablero.getHorariosLibresActivos(entidad).iterator();
		while (iterHorarios.hasNext()) {
			TableroHorarioTurnos horario = (TableroHorarioTurnos) iterHorarios
					.next();

			ds.fieldValue("ver_" + i, "         " + horario.getHorario());
			ds.fieldValue("info_" + i, horario.getHorario());

			++i;
		}

		// Completar el rest
		while (i <= 100) {
			ds.fieldValue("ver_" + i, "");
			ds.fieldValue("info_" + i, "");
			++i;
		}

		// ENVIAR EL REGISTRO POR EL TURNO
		++secu;
		ds.append();
		ds.fieldValue("secu", secu);
		ds.fieldValue("oid_tablero", tablero.getOIDInteger());
		ds.fieldValue("oid_tablero_entidad", entidad.getOIDInteger());
		ds.fieldValue("desc_entidad", entidad.getEntidad_turno().getCodigo());
		ds.fieldValue("es_titulo_horarios", false);
		ds.fieldValue("read_only", true);
		ds.fieldValue("es_turno", true);

		i = 1;
		iterHorarios = tablero.getHorariosLibresActivos(entidad).iterator();
		while (iterHorarios.hasNext()) {
			TableroHorarioTurnos horario = (TableroHorarioTurnos) iterHorarios
					.next();

			ReservaTableroTurno reserva = tablero.getReserva(entidad, horario);
			if (reserva != null) {
				ds.fieldValue("ver_" + i, reserva.getPresentacion());
				ds.fieldValue("info_" + i, horario.getHorario());
			} else {
				ds.fieldValue("ver_" + i, "");
				ds.fieldValue("info_" + i, "");
			}

			++i;
		}

		while (i <= 100) {
			ds.fieldValue("ver_" + i, "");
			ds.fieldValue("info_" + i, "");
			++i;
		}

	}
}
