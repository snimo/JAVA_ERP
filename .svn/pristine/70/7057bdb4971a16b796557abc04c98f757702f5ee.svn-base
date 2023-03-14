package com.srn.erp.proveedoresMaterials.op;

import com.srn.erp.proveedoresMaterials.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerCondicionPago extends Operation {

	public TraerCondicionPago() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		CondicionPago condicionpago = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			condicionpago = CondicionPago.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			condicionpago = CondicionPago.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetCondicionPago = getDataSetCondicionPago();
		if (condicionpago != null) {
			cargarRegistroCondicionPago(datasetCondicionPago, condicionpago.getOIDInteger(), condicionpago.getCodigo(), condicionpago.getDescripcion(), condicionpago.isActivo());
		}
		writeCliente(datasetCondicionPago);
	}

	private IDataSet getDataSetCondicionPago() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondicionPago");
		dataset.fieldDef(new Field("oid_condicion_pago", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 100));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 200));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroCondicionPago(IDataSet dataset, Integer oid_condicion_pago, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_condicion_pago", oid_condicion_pago);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
