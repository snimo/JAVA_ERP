package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.CabAsiLiquiTarj;
import com.srn.erp.conciTarjeta.bm.CabModeloLiq;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class ValidarIngAsiLiq extends Operation {

	public ValidarIngAsiLiq() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidModeloLiq = mapaDatos.getInteger("oid_modelo_liq");
		java.util.Date fecha = mapaDatos.getDate("fecha");
		Integer nroLiquidacion = mapaDatos.getInteger("nro_liquidacion");

		CabModeloLiq cabModeloLiq = CabModeloLiq.findByOidProxy(oidModeloLiq, this.getSesion());

		if (CabAsiLiquiTarj.getAsientos(cabModeloLiq, fecha, nroLiquidacion, this.getSesion()).size() > 0)
			throw new ExceptionValidation(null, "Ya se ingreso el asiento de liquidación correspondiente a la liquidación: "
					+ nroLiquidacion);

	}
}
