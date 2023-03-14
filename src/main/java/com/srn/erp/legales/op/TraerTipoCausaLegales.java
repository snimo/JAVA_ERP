package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerTipoCausaLegales extends Operation {

	public TraerTipoCausaLegales() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		TipoCausaLegales tipocausalegales = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			tipocausalegales = TipoCausaLegales.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			tipocausalegales = TipoCausaLegales.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetTipoCausaLegales = getDataSetTipoCausaLegales();
		if (tipocausalegales != null) {
			cargarRegistroTipoCausaLegales(datasetTipoCausaLegales, tipocausalegales.getOIDInteger(), tipocausalegales.getDescripcion(), tipocausalegales.isActivo());
		}
		writeCliente(datasetTipoCausaLegales);
	}

	private IDataSet getDataSetTipoCausaLegales() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTipoCausaLegales");
		dataset.fieldDef(new Field("oid_tipo_causa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 80));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroTipoCausaLegales(IDataSet dataset, Integer oid_tipo_causa, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_tipo_causa", oid_tipo_causa);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
