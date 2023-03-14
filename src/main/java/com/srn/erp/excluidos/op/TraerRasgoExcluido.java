package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.RasgoExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRasgoExcluido extends Operation {

	public TraerRasgoExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		RasgoExcluido rasgoexcluido = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			rasgoexcluido = RasgoExcluido.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			rasgoexcluido = RasgoExcluido.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetRasgoExcluido = getDataSetRasgoExcluido();
		if (rasgoexcluido != null) {
			cargarRegistroRasgoExcluido(datasetRasgoExcluido, rasgoexcluido.getOIDInteger(), rasgoexcluido.getCodigo(), rasgoexcluido
					.getDescripcion(), rasgoexcluido.isActivo());
		}
		writeCliente(datasetRasgoExcluido);
	}

	private IDataSet getDataSetRasgoExcluido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRasgoExcluido");
		dataset.fieldDef(new Field("oid_rasgo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroRasgoExcluido(IDataSet dataset, Integer oid_rasgo, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_rasgo", oid_rasgo);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
