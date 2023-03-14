package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.PermisoVisita;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class EliminarPermisoVisita extends Operation {

	public EliminarPermisoVisita() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		PermisoVisita permisoVisita = PermisoVisita.findByOid(mapaDatos.getInteger("oid_permiso_visita"), this.getSesion());
		if (permisoVisita!=null) {
			permisoVisita.delete();
			addTransaccion(permisoVisita);
		}
		
	}
}
