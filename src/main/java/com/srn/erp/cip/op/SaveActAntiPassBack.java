package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.ActLAntiPassBack;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SaveActAntiPassBack extends Operation {

	public SaveActAntiPassBack() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		if (mapaDatos.containsKey("activa"))
			ActLAntiPassBack.setActivado(true);
		else
			ActLAntiPassBack.setActivado(false);
	}
}
