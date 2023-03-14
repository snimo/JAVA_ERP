package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.RubroCondena;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRubroCondena extends Operation {

	public SaveRubroCondena() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TRubroCondena");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			RubroCondena rubrocondena = RubroCondena.findByOid(dataset.getInteger("oid_rubro_condena"), getSesion());
			rubrocondena.setOID(dataset.getInteger("oid_rubro_condena"));
			rubrocondena.setCodigo(dataset.getString("codigo"));
			rubrocondena.setDescripcion(dataset.getString("descripcion"));
			rubrocondena.setActivo(dataset.getBoolean("activo"));
			addTransaccion(rubrocondena);
			dataset.next();
		}
	}

}
