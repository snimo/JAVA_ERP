package com.srn.erp.mensajero.op;

import com.srn.erp.mensajero.bm.MotorMensONLINE;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class NotificarSalidaMensaje extends Operation {

	public NotificarSalidaMensaje() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		try {
			MotorMensONLINE.notificarMensaje();
		} catch (Exception e) {}
	}

}
