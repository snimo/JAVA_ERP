package com.srn.erp.cip.op;

import java.util.Date;
import java.util.List;

import com.srn.erp.cip.bm.CIPLogPuerta;
import com.srn.erp.cip.bm.Puerta;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCIPLogPuerta extends Operation {

	@Override
	public void execute(MapDatos mapaDatos) throws BaseException {
		Puerta puerta = Puerta.findByOid(mapaDatos.getInteger("oid_puerta"), this.getSesion());
		Date fechaDesde = mapaDatos.getDate("fecha_desde");
		Date fechaHasta = mapaDatos.getDate("fecha_hasta");

		List<CIPLogPuerta> registros = CIPLogPuerta.getRegistrosByPuertaFechaDesdeFechaHasta(puerta, fechaDesde, fechaHasta, this.getSesion());
		IDataSet ds = this.getDataSet();

		for (CIPLogPuerta registro : registros) {
			this.cargarDataSet(ds, registro);
		}

		writeCliente(ds);

	}

	private void cargarDataSet(IDataSet ds, CIPLogPuerta registro) throws BaseException {
		ds.append();
		ds.fieldValue("oid_log_puerta", registro.getPuerta().getOID());
		ds.fieldValue("oid_puerta", registro.getPuerta().getOID());
		ds.fieldValue("estado", registro.getEstado());
		ds.fieldValue("fec_hora", Fecha.getFormatoFecHoraMin(registro.getFechora()));
		ds.fieldValue("activo", registro.isActivo());
	}

	private IDataSet getDataSet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRegistros");
		dataset.fieldDef(new Field("oid_log_puerta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_puerta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("estado", Field.STRING, 50));
		dataset.fieldDef(new Field("fec_hora", Field.STRING, 10));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

}
