package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.CompaniaSeguro;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCompaniaSeguro extends Operation {

	public TraerCompaniaSeguro() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		CompaniaSeguro companiaseguro = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			companiaseguro = CompaniaSeguro.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			companiaseguro = CompaniaSeguro.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetCompaniaSeguro = getDataSetCompaniaSeguro();
		if (companiaseguro != null) {
			cargarRegistroCompaniaSeguro(datasetCompaniaSeguro, companiaseguro.getOIDInteger(), companiaseguro.getNombre(), companiaseguro.isEs_caucion(), companiaseguro.isActivo());
		}
		writeCliente(datasetCompaniaSeguro);
	}

	private IDataSet getDataSetCompaniaSeguro() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCompaniaSeguro");
		dataset.fieldDef(new Field("id_comp_seg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nombre", Field.STRING, 100));
		dataset.fieldDef(new Field("es_caucion", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroCompaniaSeguro(IDataSet dataset, Integer id_comp_seg, String nombre, Boolean es_caucion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("id_comp_seg", id_comp_seg);
		dataset.fieldValue("nombre", nombre);
		dataset.fieldValue("es_caucion", es_caucion);
		dataset.fieldValue("activo", activo);
	}
}
