package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveTipoBarba extends Operation {

	public SaveTipoBarba() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TTipoBarba");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			TipoBarba tipobarba = TipoBarba.findByOid(dataset.getInteger("oid_tipo_barba"), getSesion());
			tipobarba.setOID(dataset.getInteger("oid_tipo_barba"));
			tipobarba.setCodigo(dataset.getString("codigo"));
			tipobarba.setDescripcion(dataset.getString("descripcion"));
			tipobarba.setActivo(dataset.getBoolean("activo"));
			addTransaccion(tipobarba);
			dataset.next();
		}
	}

}
