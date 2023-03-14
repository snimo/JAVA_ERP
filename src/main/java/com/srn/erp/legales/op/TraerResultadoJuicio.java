package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.ResultadoJuicio;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerResultadoJuicio extends Operation {

	public TraerResultadoJuicio() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		ResultadoJuicio resultadojuicio = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			resultadojuicio = ResultadoJuicio.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			resultadojuicio = ResultadoJuicio.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetResultadoJuicio = getDataSetResultadoJuicio();
		if (resultadojuicio != null) {
			cargarRegistroResultadoJuicio(datasetResultadoJuicio, resultadojuicio.getOIDInteger(), resultadojuicio.getCodigo(), resultadojuicio.getDescripcion(), resultadojuicio.isActivo());
		}
		writeCliente(datasetResultadoJuicio);
	}

	private IDataSet getDataSetResultadoJuicio() {
		IDataSet dataset = new TDataSet();
		dataset.create("TResultadoJuicio");
		dataset.fieldDef(new Field("oid_resul_juicio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroResultadoJuicio(IDataSet dataset, Integer oid_resul_juicio, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_resul_juicio", oid_resul_juicio);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
