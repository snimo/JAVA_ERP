package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.EdadExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEdadExcluido extends Operation {

	public SaveEdadExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TEdadExcluido");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			EdadExcluido edadexcluido = EdadExcluido.findByOid(dataset.getInteger("oid_edad"), getSesion());
			edadexcluido.setOID(dataset.getInteger("oid_edad"));
			edadexcluido.setCodigo(dataset.getString("codigo"));
			edadexcluido.setDescripcion(dataset.getString("descripcion"));
			edadexcluido.setActivo(dataset.getBoolean("activo"));
			addTransaccion(edadexcluido);
			dataset.next();
		}
	}

}
