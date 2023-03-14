package com.srn.erp.mensajero.op;

import com.srn.erp.mensajero.bm.MotorMensONLINE;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class ManejadorMensajesCliente extends Operation {

	public ManejadorMensajesCliente() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		MotorMensONLINE.esperarMensaje();
	}

}
