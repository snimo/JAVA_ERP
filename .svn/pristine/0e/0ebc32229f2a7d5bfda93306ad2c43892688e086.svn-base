package com.srn.erp.general.op;

import com.srn.erp.general.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerNacionalidad extends Operation {

	public TraerNacionalidad() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Nacionalidad nacionalidad = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			nacionalidad = Nacionalidad.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			nacionalidad = Nacionalidad.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetNacionalidad = getDataSetNacionalidad();
		if (nacionalidad != null) {
			cargarRegistroNacionalidad(datasetNacionalidad, nacionalidad.getOIDInteger(), nacionalidad.getCodigo(), nacionalidad
					.getDescripcion(), nacionalidad.isActivo());
		}
		writeCliente(datasetNacionalidad);
	}

	private IDataSet getDataSetNacionalidad() {
		IDataSet dataset = new TDataSet();
		dataset.create("TNacionalidad");
		dataset.fieldDef(new Field("oid_nacionalidad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroNacionalidad(IDataSet dataset, Integer oid_nacionalidad, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_nacionalidad", oid_nacionalidad);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
