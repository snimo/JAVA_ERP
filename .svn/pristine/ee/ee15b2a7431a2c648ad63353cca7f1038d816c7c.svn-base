package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.ReservaTableroTurno;
import com.srn.erp.turnos.bm.TableroTurnos;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTurnosSujeto extends Operation {

	public TraerTurnosSujeto() {
	}

	int secu = 0;

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSetTurnosPuestos();
		TableroTurnos tablero = TableroTurnos.findByOid(mapaDatos.getInteger("oid_tablero"), this.getSesion());
		Sujeto sujeto = Sujeto.findByOid(mapaDatos.getInteger("oid_sujeto"), this.getSesion());
		Iterator iterReservas = tablero.getReservasSujeto(sujeto).iterator();
		while (iterReservas.hasNext()) {
			ReservaTableroTurno reserva = (ReservaTableroTurno) iterReservas.next();
			cargaTurno(ds, reserva);
		}
		writeCliente(ds);
		
	}

	private IDataSet getDataSetTurnosPuestos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTurnosPuestos");
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tablero_entidad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("entidad", Field.STRING, 50));
		dataset.fieldDef(new Field("horario", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_suj_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_suj_1", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_suj_1", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_suj_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_suj_2", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_suj_2", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_suj_3", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_suj_3", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_suj_3", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_suj_4", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_suj_4", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_suj_4", Field.STRING, 100));
		return dataset;
	}

	private void cargaTurno(IDataSet ds, ReservaTableroTurno reserva) throws BaseException {

		// ENVIAR REGISTRO POR EL HORARIO
		++secu;
		ds.append();
		ds.fieldValue("secu", secu);
		ds.fieldValue("oid_tablero_entidad", reserva.getEntidad_tablero().getOIDInteger());
		ds.fieldValue("entidad", reserva.getEntidad_tablero().getEntidad_turno().getDescripcion());
		ds.fieldValue("horario", reserva.getHorario_tablero().getHorario());
		if (reserva.getSujeto1()!=null) {
			ds.fieldValue("oid_suj_1", reserva.getSujeto1().getOIDInteger());
			ds.fieldValue("cod_suj_1", reserva.getSujeto1().getCodigo());
			ds.fieldValue("desc_suj_1", reserva.getSujeto1().getDescripcion());
		} else {
			ds.fieldValue("oid_suj_1", new Integer(0));
			ds.fieldValue("cod_suj_1", "");
			ds.fieldValue("desc_suj_1", "");
		}
		if (reserva.getSujeto2()!=null) {
			ds.fieldValue("oid_suj_2", reserva.getSujeto2().getOIDInteger());
			ds.fieldValue("cod_suj_2", reserva.getSujeto2().getCodigo());
			ds.fieldValue("desc_suj_2", reserva.getSujeto2().getDescripcion());
		} else {
			ds.fieldValue("oid_suj_2", new Integer(0));
			ds.fieldValue("cod_suj_2", "");
			ds.fieldValue("desc_suj_2", "");
		}
		if (reserva.getSujeto3()!=null) {
			ds.fieldValue("oid_suj_3", reserva.getSujeto3().getOIDInteger());
			ds.fieldValue("cod_suj_3", reserva.getSujeto3().getCodigo());
			ds.fieldValue("desc_suj_3", reserva.getSujeto3().getDescripcion());
		} else {
			ds.fieldValue("oid_suj_3", new Integer(0));
			ds.fieldValue("cod_suj_3", "");
			ds.fieldValue("desc_suj_3", "");
		}
		if (reserva.getSujeto4()!=null) {
			ds.fieldValue("oid_suj_4", reserva.getSujeto4().getOIDInteger());
			ds.fieldValue("cod_suj_4", reserva.getSujeto4().getCodigo());
			ds.fieldValue("desc_suj_4", reserva.getSujeto4().getDescripcion());
		} else {
			ds.fieldValue("oid_suj_4", new Integer(0));
			ds.fieldValue("cod_suj_4", "");
			ds.fieldValue("desc_suj_4", "");
		}

	}
}
