package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.ActLogsMens;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SaveActLogsMensajes extends Operation {

	public SaveActLogsMensajes() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		if (mapaDatos.containsKey("activa"))
			ActLogsMens.setActivado(true);
		else
			ActLogsMens.setActivado(false);
	}
}
