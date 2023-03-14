package com.srn.erp.cip.op;

import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SaveIgnorarProxAntiPassBack extends Operation {

	public SaveIgnorarProxAntiPassBack() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		if (!mapaDatos.containsKey("oid_legajo")) return;
		
		Integer oidLegajo = mapaDatos.getInteger("oid_legajo");
		if (oidLegajo<=0) return;
		Legajo legajo = Legajo.findByOid(oidLegajo, this.getSesion());
		legajo.setIgnorarProxAntiPassBack(true);
		
		this.addTransaccion(legajo);
	}
}
