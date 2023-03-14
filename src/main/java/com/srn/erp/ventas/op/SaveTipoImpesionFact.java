package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.FacturaCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SaveTipoImpesionFact extends Operation {

	public SaveTipoImpesionFact() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Integer oidCCO = mapaDatos.getInteger("oid_cco");
		String tipoImpresion = mapaDatos.getString("tipo_impresion");

		FacturaCab factura = FacturaCab.findByOid(oidCCO, this.getSesion());

		FacturaCab.updateTipoImpresion(factura, tipoImpresion, this.getSesion());

	}

}
