package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.CompaniaSeguro;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCompaniaSeguro extends Operation {

	public SaveCompaniaSeguro() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TCompaniaSeguro");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			CompaniaSeguro companiaseguro = CompaniaSeguro.findByOid(dataset.getInteger("id_comp_seg"), getSesion());
			companiaseguro.setOID(dataset.getInteger("id_comp_seg"));
			companiaseguro.setNombre(dataset.getString("nombre"));
			companiaseguro.setEs_caucion(dataset.getBoolean("es_caucion"));
			companiaseguro.setActivo(dataset.getBoolean("activo"));
			addTransaccion(companiaseguro);
			dataset.next();
		}
	}

}
