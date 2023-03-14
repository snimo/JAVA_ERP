package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.TipoObsLeg;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoObsLeg extends Operation {

	public TraerTipoObsLeg() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		TipoObsLeg tipoobsleg = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			tipoobsleg = TipoObsLeg.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			tipoobsleg = TipoObsLeg.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetTipoObsLeg = getDataSetTipoObsLeg();
		if (tipoobsleg != null) {
			cargarRegistroTipoObsLeg(datasetTipoObsLeg, tipoobsleg.getOIDInteger(), tipoobsleg.getCodigo(), tipoobsleg.getDescripcion(), tipoobsleg.isActivo());
		}
		writeCliente(datasetTipoObsLeg);
	}

	private IDataSet getDataSetTipoObsLeg() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTipoObsLeg");
		dataset.fieldDef(new Field("oid_tipo_obs_leg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroTipoObsLeg(IDataSet dataset, Integer oid_tipo_obs_leg, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_tipo_obs_leg", oid_tipo_obs_leg);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
