package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.TipoZona;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoZona extends Operation {

	public TraerTipoZona() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		TipoZona tipozona = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			tipozona = TipoZona.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			tipozona = TipoZona.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetTipoZona = getDataSetTipoZona();
		if (tipozona != null) {
			cargarRegistroTipoZona(datasetTipoZona, tipozona.getOIDInteger(), tipozona.getCodigo(), tipozona.getDescripcion(), tipozona
					.isActivo());
		}
		writeCliente(datasetTipoZona);
	}

	private IDataSet getDataSetTipoZona() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTipoZona");
		dataset.fieldDef(new Field("oid_tipo_zona", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroTipoZona(IDataSet dataset, Integer oid_tipo_zona, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_tipo_zona", oid_tipo_zona);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
