package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.Fuero;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFuero extends Operation {

	public TraerFuero() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Fuero fuero = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			fuero = Fuero.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			fuero = Fuero.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetFuero = getDataSetFuero();
		if (fuero != null) {
			cargarRegistroFuero(datasetFuero, fuero.getOIDInteger(), fuero.getCodigo(), fuero.getDescripcion(), fuero.isActivo());
		}
		writeCliente(datasetFuero);
	}

	private IDataSet getDataSetFuero() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFuero");
		dataset.fieldDef(new Field("oid_fuero", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroFuero(IDataSet dataset, Integer oid_fuero, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_fuero", oid_fuero);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
