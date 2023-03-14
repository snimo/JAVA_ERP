package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.EstadoProcesal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstadoProcesal extends Operation {

	public TraerEstadoProcesal() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		EstadoProcesal estadoprocesal = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			estadoprocesal = EstadoProcesal.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			estadoprocesal = EstadoProcesal.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetEstadoProcesal = getDataSetEstadoProcesal();
		if (estadoprocesal != null) {
			cargarRegistroEstadoProcesal(datasetEstadoProcesal, estadoprocesal.getOIDInteger(), estadoprocesal.getCodigo(), estadoprocesal.getDescripcion(), estadoprocesal.isActivo());
		}
		writeCliente(datasetEstadoProcesal);
	}

	private IDataSet getDataSetEstadoProcesal() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEstadoProcesal");
		dataset.fieldDef(new Field("oid_est_procesal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroEstadoProcesal(IDataSet dataset, Integer oid_est_procesal, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_est_procesal", oid_est_procesal);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
