package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.ActCacheo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SaveActCacheo extends Operation {

	public SaveActCacheo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		if (mapaDatos.containsKey("activa"))
			ActCacheo.setActivado(true);
		else
			ActCacheo.setActivado(false);
	}
}
