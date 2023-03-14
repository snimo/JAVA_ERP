package com.srn.erp.proveedoresMaterials.op;

import com.srn.erp.proveedoresMaterials.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveCondicionPago extends Operation {

	public SaveCondicionPago() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TCondicionPago");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			CondicionPago condicionpago = CondicionPago.findByOid(dataset.getInteger("oid_condicion_pago"), getSesion());
			condicionpago.setOID(dataset.getInteger("oid_condicion_pago"));
			condicionpago.setCodigo(dataset.getString("codigo"));
			condicionpago.setDescripcion(dataset.getString("descripcion"));
			condicionpago.setActivo(dataset.getBoolean("activo"));
			addTransaccion(condicionpago);
			dataset.next();
		}
	}

}
