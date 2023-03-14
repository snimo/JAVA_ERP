package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.TipoAudiencia;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoAudiencia extends Operation {

	public SaveTipoAudiencia() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TTipoAudiencia");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			TipoAudiencia tipoaudiencia = TipoAudiencia.findByOid(dataset.getInteger("oid_tipo_aud"), getSesion());
			tipoaudiencia.setOID(dataset.getInteger("oid_tipo_aud"));
			tipoaudiencia.setCodigo(dataset.getString("codigo"));
			tipoaudiencia.setDescripcion(dataset.getString("descripcion"));
			tipoaudiencia.setActivo(dataset.getBoolean("activo"));
			addTransaccion(tipoaudiencia);
			dataset.next();
		}
	}

}
