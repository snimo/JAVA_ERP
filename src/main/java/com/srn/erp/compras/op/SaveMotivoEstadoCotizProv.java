package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.CotizacionProveedorCab;
import com.srn.erp.compras.bm.MotivoDecisionAdjudicacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SaveMotivoEstadoCotizProv extends Operation {

	public SaveMotivoEstadoCotizProv() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidCCO = mapaDatos.getInteger("oid_cco");

		CotizacionProveedorCab cotProvCab = CotizacionProveedorCab.findByOid(oidCCO, this.getSesion());
		cotProvCab.setCotizacionAbierta(mapaDatos.getBoolean("abierta"));
		cotProvCab.setMotivoDecisionAdjudicacion(MotivoDecisionAdjudicacion.findByOidProxy(mapaDatos.getInteger("oid_motivo"), this
				.getSesion()));
		addTransaccion(cotProvCab);
	}

}
