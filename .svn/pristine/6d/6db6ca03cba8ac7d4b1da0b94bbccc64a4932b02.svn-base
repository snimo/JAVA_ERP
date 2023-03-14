package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.PedidoCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class MarcarPedidoHabAnulacionSC extends Operation {

	public MarcarPedidoHabAnulacionSC() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidCCOPed = mapaDatos.getInteger("oid_cco_ped");

		PedidoCab pedido = PedidoCab.findByOidProxy(oidCCOPed, this.getSesion());
		PedidoCab.marcarPedidoPuedeAnularSinControl(pedido, this.getSesion());

	}

}
