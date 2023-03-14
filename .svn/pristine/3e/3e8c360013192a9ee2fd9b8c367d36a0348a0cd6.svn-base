package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.RasgoExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRasgoExcluido extends Operation {

	public SaveRasgoExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TRasgoExcluido");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			RasgoExcluido rasgoexcluido = RasgoExcluido.findByOid(dataset.getInteger("oid_rasgo"), getSesion());
			rasgoexcluido.setOID(dataset.getInteger("oid_rasgo"));
			rasgoexcluido.setCodigo(dataset.getString("codigo"));
			rasgoexcluido.setDescripcion(dataset.getString("descripcion"));
			rasgoexcluido.setActivo(dataset.getBoolean("activo"));
			addTransaccion(rasgoexcluido);
			dataset.next();
		}
	}

}
