package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.EstadoJuicio;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEstadoJuicio extends Operation {

	public SaveEstadoJuicio() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TEstadoJuicio");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			EstadoJuicio estadojuicio = EstadoJuicio.findByOid(dataset.getInteger("oid_est_juicio"), getSesion());
			estadojuicio.setOID(dataset.getInteger("oid_est_juicio"));
			estadojuicio.setCodigo(dataset.getString("codigo"));
			estadojuicio.setDescripcion(dataset.getString("descripcion"));
			estadojuicio.setActivo(dataset.getBoolean("activo"));
			addTransaccion(estadojuicio);
			dataset.next();
		}
	}

}
