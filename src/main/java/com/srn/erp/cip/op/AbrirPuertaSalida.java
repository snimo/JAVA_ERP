package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.TelecomandoCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class AbrirPuertaSalida extends Operation {

	public AbrirPuertaSalida() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidPuerta = mapaDatos.getInteger("oid_puerta");
		Puerta puerta = Puerta.findByOid(oidPuerta, this.getSesion());
		TelecomandoCIP.getTelecomandoCIP().abrirPuerta(
				puerta.getIP(), puerta.getTelePuerto(), new Integer(puerta.getIdentifPuerta()),
				Legajo.getLegajoPaseAutoriz(this.getSesion()).getIDIdentificacion().toString(),
				new Integer(puerta.getIdentifSal()));
		
	}

}
