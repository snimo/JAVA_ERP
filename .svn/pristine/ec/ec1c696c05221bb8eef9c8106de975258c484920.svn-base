package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.EstadoJuicio;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstadoJuicio extends Operation {

	public TraerEstadoJuicio() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		EstadoJuicio estadojuicio = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			estadojuicio = EstadoJuicio.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			estadojuicio = EstadoJuicio.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetEstadoJuicio = getDataSetEstadoJuicio();
		if (estadojuicio != null) {
			cargarRegistroEstadoJuicio(datasetEstadoJuicio, estadojuicio.getOIDInteger(), estadojuicio.getCodigo(), estadojuicio.getDescripcion(), estadojuicio.isActivo());
		}
		writeCliente(datasetEstadoJuicio);
	}

	private IDataSet getDataSetEstadoJuicio() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEstadoJuicio");
		dataset.fieldDef(new Field("oid_est_juicio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroEstadoJuicio(IDataSet dataset, Integer oid_est_juicio, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_est_juicio", oid_est_juicio);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
