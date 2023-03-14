package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.EstadoProcesal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEstadoProcesal extends Operation {

	public SaveEstadoProcesal() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TEstadoProcesal");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			EstadoProcesal estadoprocesal = EstadoProcesal.findByOid(dataset.getInteger("oid_est_procesal"), getSesion());
			estadoprocesal.setOID(dataset.getInteger("oid_est_procesal"));
			estadoprocesal.setCodigo(dataset.getString("codigo"));
			estadoprocesal.setDescripcion(dataset.getString("descripcion"));
			estadoprocesal.setActivo(dataset.getBoolean("activo"));
			addTransaccion(estadoprocesal);
			dataset.next();
		}
	}

}
