package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.TipoAudiencia;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoAudiencia extends Operation {

	public TraerTipoAudiencia() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		TipoAudiencia tipoaudiencia = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			tipoaudiencia = TipoAudiencia.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			tipoaudiencia = TipoAudiencia.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetTipoAudiencia = getDataSetTipoAudiencia();
		if (tipoaudiencia != null) {
			cargarRegistroTipoAudiencia(datasetTipoAudiencia, tipoaudiencia.getOIDInteger(), tipoaudiencia.getCodigo(), tipoaudiencia.getDescripcion(), tipoaudiencia.isActivo());
		}
		writeCliente(datasetTipoAudiencia);
	}

	private IDataSet getDataSetTipoAudiencia() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTipoAudiencia");
		dataset.fieldDef(new Field("oid_tipo_aud", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroTipoAudiencia(IDataSet dataset, Integer oid_tipo_aud, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_tipo_aud", oid_tipo_aud);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
