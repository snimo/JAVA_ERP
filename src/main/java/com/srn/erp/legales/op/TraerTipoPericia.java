package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.TipoPericia;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoPericia extends Operation {

	public TraerTipoPericia() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		TipoPericia tipopericia = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			tipopericia = TipoPericia.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			tipopericia = TipoPericia.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetTipoPericia = getDataSetTipoPericia();
		if (tipopericia != null) {
			cargarRegistroTipoPericia(datasetTipoPericia, tipopericia.getOIDInteger(), tipopericia.getDescripcion(), tipopericia.isActivo());
		}
		writeCliente(datasetTipoPericia);
	}

	private IDataSet getDataSetTipoPericia() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTipoPericia");
		dataset.fieldDef(new Field("oid_tipo_pericia", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroTipoPericia(IDataSet dataset, Integer oid_tipo_pericia, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_tipo_pericia", oid_tipo_pericia);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
