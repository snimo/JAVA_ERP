package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.TarjetaCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class DevolvioTarjVisita extends Operation {

	public DevolvioTarjVisita() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		String nroTarjeta = mapaDatos.getString("nro_tarjeta");
		TarjetaCIP tarjetaCIP = TarjetaCIP.getTarjetaCIP(nroTarjeta, this.getSesion());
		if (tarjetaCIP == null) throw new ExceptionValidation(null,"Tarjeta Inexistente.");
		
		tarjetaCIP.devolverla(true);
		
	}
}
