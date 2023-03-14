package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.Fuero;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveFuero extends Operation {

	public SaveFuero() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TFuero");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			Fuero fuero = Fuero.findByOid(dataset.getInteger("oid_fuero"), getSesion());
			fuero.setOID(dataset.getInteger("oid_fuero"));
			fuero.setCodigo(dataset.getString("codigo"));
			fuero.setDescripcion(dataset.getString("descripcion"));
			fuero.setActivo(dataset.getBoolean("activo"));
			addTransaccion(fuero);
			dataset.next();
		}
	}

}
