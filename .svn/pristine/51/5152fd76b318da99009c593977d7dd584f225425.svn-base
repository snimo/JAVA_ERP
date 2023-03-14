package com.srn.erp.mensajero.op;

import com.srn.erp.mensajero.bm.Ring;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRing extends Operation {

	public TraerRing() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Ring ring = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			ring = Ring.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			ring = Ring.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetRing = getDataSetRing();
		if (ring != null) {
			cargarRegistroRing(datasetRing, ring.getOIDInteger(), ring.getCodigo(), ring.getDescripcion(), ring.isActivo());
		}
		writeCliente(datasetRing);
	}

	private IDataSet getDataSetRing() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRing");
		dataset.fieldDef(new Field("oid_ring", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroRing(IDataSet dataset, Integer oid_ring, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_ring", oid_ring);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
