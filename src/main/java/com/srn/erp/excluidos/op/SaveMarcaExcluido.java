package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveMarcaExcluido extends Operation {

	public SaveMarcaExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TMarcaExcluido");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			MarcaExcluido marcaexcluido = MarcaExcluido.findByOid(dataset.getInteger("oid_marca"), getSesion());
			marcaexcluido.setOID(dataset.getInteger("oid_marca"));
			marcaexcluido.setCodigo(dataset.getString("codigo"));
			marcaexcluido.setDescripcion(dataset.getString("descripcion"));
			marcaexcluido.setActivo(dataset.getBoolean("activo"));
			addTransaccion(marcaexcluido);
			dataset.next();
		}
	}

}
