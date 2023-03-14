package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.TipoZona;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoZona extends Operation {

	public SaveTipoZona() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TTipoZona");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			TipoZona tipozona = TipoZona.findByOid(dataset.getInteger("oid_tipo_zona"), getSesion());
			tipozona.setOID(dataset.getInteger("oid_tipo_zona"));
			tipozona.setCodigo(dataset.getString("codigo"));
			tipozona.setDescripcion(dataset.getString("descripcion"));
			tipozona.setActivo(dataset.getBoolean("activo"));
			addTransaccion(tipozona);
			dataset.next();
		}
	}

}
