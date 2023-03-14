package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.PedidoDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class MarcarItemsPedComoEnt extends Operation {

	
	private boolean marcarEntCantDespMenorAFact = false;
	
	public MarcarItemsPedComoEnt() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dataset = mapaDatos.getDataSet("TConsDetPedidos");
		if (mapaDatos.containsKey("MARCAR_ENT_CANT_DESC_MENOR_FACT"))
			marcarEntCantDespMenorAFact = true;
		
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {

			PedidoDet pedidoDet = PedidoDet.findByOid(dataset.getInteger("oid_ped_det"), this.getSesion());
			if ((pedidoDet.getPedido().isActivo().booleanValue() == false) || (pedidoDet.isAnulado())
					|| (pedidoDet.isPendDesp().booleanValue() == false) || (dataset.getBoolean("sel") == false)) {

				dataset.next();
				continue;
			}

			if (pedidoDet.isPendDesp()) {
				if (marcarEntCantDespMenorAFact)
					pedidoDet.setMarcarEntregadoSiDespMenorAFact(true);
				pedidoDet.descartarCantNoDespachadas();
			}

			addTransaccion(pedidoDet);
			dataset.next();
		}
	}

}
