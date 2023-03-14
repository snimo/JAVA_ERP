package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.RemitoCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarPedido extends Operation {

	public ValidarPedido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		PedidoCab pedido = null;

		IDataSet ds = this.getDataSetValidarPedido();

		if (mapaDatos.containsKey("oid_cco")) {
			pedido = PedidoCab.findByOid(mapaDatos.getInteger("oid_cco"),
					this.getSesion());
		} else {
			String codigoPedido = mapaDatos.getString("codigo");
			pedido = PedidoCab.buscarPedidoByCodigo(codigoPedido, true,
					this.getSesion());
			if (pedido == null)
				pedido = PedidoCab.buscarPedidoByCodigo(codigoPedido,
						false, this.getSesion());
		}
		if (pedido != null) {
			cargarRegistroRemito(ds, pedido);
		}

		writeCliente(ds);
	}

	private IDataSet getDataSetValidarPedido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValPedido");
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_sujeto", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_sujeto", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("total", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroRemito(IDataSet dataset, PedidoCab pedido)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_cco", pedido.getOIDInteger());
		dataset.fieldValue("codigo", pedido.getCodigo());
		dataset.fieldValue("oid_sujeto", pedido.getSujeto().getOIDInteger());
		dataset.fieldValue("cod_sujeto", pedido.getSujeto().getCodigo());
		dataset.fieldValue("rs_sujeto", pedido.getSujeto().getRazon_social());
		dataset.fieldValue("oid_moneda", pedido.getMoneda().getOIDInteger());
		dataset.fieldValue("total", pedido.getTotal());
		dataset.fieldValue("activo", pedido.isActivo());
	}
}
