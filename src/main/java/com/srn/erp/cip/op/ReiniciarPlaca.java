package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.TelecomandoCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class ReiniciarPlaca extends Operation {

	public ReiniciarPlaca() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidPuerta = mapaDatos.getInteger("oid_puerta");
		Puerta puerta = Puerta.findByOid(oidPuerta, this.getSesion());
		TelecomandoCIP.getTelecomandoCIP().resetPlaca(puerta.getIP(), puerta.getTelePuerto(), new Integer(puerta.getIdentifPuerta()));
		
		//Integer oidPuerta = mapaDatos.getInteger("oid_puerta");
		//Puerta puerta = Puerta.findByOid(oidPuerta, this.getSesion());
		//puerta.resetPlaca();
	}

}
