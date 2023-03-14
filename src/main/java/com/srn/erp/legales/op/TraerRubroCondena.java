package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.RubroCondena;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRubroCondena extends Operation {

	public TraerRubroCondena() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		RubroCondena rubrocondena = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			rubrocondena = RubroCondena.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			rubrocondena = RubroCondena.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetRubroCondena = getDataSetRubroCondena();
		if (rubrocondena != null) {
			cargarRegistroRubroCondena(datasetRubroCondena, rubrocondena.getOIDInteger(), rubrocondena.getCodigo(), rubrocondena.getDescripcion(), rubrocondena.isActivo());
		}
		writeCliente(datasetRubroCondena);
	}

	private IDataSet getDataSetRubroCondena() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRubroCondena");
		dataset.fieldDef(new Field("oid_rubro_condena", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroRubroCondena(IDataSet dataset, Integer oid_rubro_condena, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_rubro_condena", oid_rubro_condena);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
