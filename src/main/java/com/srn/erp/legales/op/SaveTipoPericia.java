package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.TipoPericia;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoPericia extends Operation {

	public SaveTipoPericia() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TTipoPericia");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			TipoPericia tipopericia = TipoPericia.findByOid(dataset.getInteger("oid_tipo_pericia"), getSesion());
			tipopericia.setOID(dataset.getInteger("oid_tipo_pericia"));
			tipopericia.setDescripcion(dataset.getString("descripcion"));
			tipopericia.setActivo(dataset.getBoolean("activo"));
			addTransaccion(tipopericia);
			dataset.next();
		}
	}

}
