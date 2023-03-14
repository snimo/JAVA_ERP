package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerTipoBarba extends Operation {

	public TraerTipoBarba() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		TipoBarba tipobarba = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			tipobarba = TipoBarba.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			tipobarba = TipoBarba.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetTipoBarba = getDataSetTipoBarba();
		if (tipobarba != null) {
			cargarRegistroTipoBarba(datasetTipoBarba, tipobarba.getOIDInteger(), tipobarba.getCodigo(), tipobarba.getDescripcion(),
					tipobarba.isActivo());
		}
		writeCliente(datasetTipoBarba);
	}

	private IDataSet getDataSetTipoBarba() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTipoBarba");
		dataset.fieldDef(new Field("oid_tipo_barba", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroTipoBarba(IDataSet dataset, Integer oid_tipo_barba, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_tipo_barba", oid_tipo_barba);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
