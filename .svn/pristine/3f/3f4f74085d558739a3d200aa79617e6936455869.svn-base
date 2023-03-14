package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.PedMercDep;
import com.srn.erp.stock.bm.PedMercDepoDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPedMercParaDepo extends Operation {

	private int secu = 0;

	public TraerPedMercParaDepo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsPedCab = this.getDSPedDepoCab();
		IDataSet dsPedDet = this.getDSPedDepoDet();

		PedMercDep pedidoMercaderia = PedMercDep.findByOid(mapaDatos.getInteger("oid"), this.getSesion());
		cargarRegistroPedCab(dsPedCab, pedidoMercaderia);
		
		Iterator iterDetalles = 
			pedidoMercaderia.getDetalles().iterator();
		while (iterDetalles.hasNext()) {
			PedMercDepoDet pedMercDet = (PedMercDepoDet) iterDetalles.next();
			if (!pedMercDet.isActivo()) continue;
			cargarRegistroPedCab(dsPedDet, pedMercDet);
		}
		
		

		writeCliente(dsPedCab);
		writeCliente(dsPedDet);
	}

	private IDataSet getDSPedDepoCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPedidoDepositoCab");
		dataset.fieldDef(new Field("oid_ped_depo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tc", Field.STRING, 20));
		dataset.fieldDef(new Field("letra", Field.STRING, 1));
		dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_usuario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ape_y_nombre", Field.STRING, 100));
		dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
		dataset.fieldDef(new Field("anulado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_solicitar_a", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_deposito", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cod_deposito", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_deposito", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroPedCab(IDataSet ds, PedMercDep pedidoMercaderia) throws BaseException {
		ds.append();

		ds.fieldValue("oid_ped_depo", pedidoMercaderia.getOIDInteger());
		ds.fieldValue("oid_talonario", pedidoMercaderia.getTalonario().getOIDInteger());
		ds.fieldValue("oid_tc", pedidoMercaderia.getTipoCompro().getOIDInteger());
		ds.fieldValue("cod_tc", pedidoMercaderia.getTipoCompro().getCodigo());
		ds.fieldValue("letra", pedidoMercaderia.getLetra());
		ds.fieldValue("oid_lug_emi", pedidoMercaderia.getLugarEmision().getOIDInteger());
		ds.fieldValue("lug_emi", pedidoMercaderia.getLugarEmision().getLugemi());
		ds.fieldValue("nro_ext", pedidoMercaderia.getNroExt());
		ds.fieldValue("fec_emision", pedidoMercaderia.getEmision());
		ds.fieldValue("oid_usuario", pedidoMercaderia.getUsuario().getOIDInteger());
		ds.fieldValue("ape_y_nombre", pedidoMercaderia.getUsuario().getApellidoyNombre());
		ds.fieldValue("comentario", pedidoMercaderia.getComentario());
		ds.fieldValue("anulado", !pedidoMercaderia.isActivo());
		ds.fieldValue("activo", pedidoMercaderia.isActivo());
		ds.fieldValue("oid_solicitar_a", pedidoMercaderia.getSolicitar_a().getOIDInteger());
		ds.fieldValue("oid_deposito", pedidoMercaderia.getDeposito_entrega().getOIDInteger());
		ds.fieldValue("cod_deposito", pedidoMercaderia.getDeposito_entrega().getCodigo());
		ds.fieldValue("desc_deposito", pedidoMercaderia.getDeposito_entrega().getDescripcion());

	}

	private IDataSet getDSPedDepoDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPedidoDepositoDet");
		dataset.fieldDef(new Field("oid_ped_depo_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_ped_depo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_renglon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
		dataset.fieldDef(new Field("desc_adic_sku", Field.MEMO, 0));
		dataset.fieldDef(new Field("cant_solicitada", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um_req", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_requerida", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_cco_ref", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_ref_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("referencia", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroPedCab(IDataSet ds, PedMercDepoDet pedidoMercaderiaDet) throws BaseException {
		ds.append();
		++secu;
		ds.fieldValue("oid_ped_depo_det", pedidoMercaderiaDet.getOIDInteger());
		ds.fieldValue("oid_ped_depo", pedidoMercaderiaDet.getPedido_mercaderia().getOIDInteger());
		ds.fieldValue("nro_renglon", new Integer(secu));
		ds.fieldValue("oid_producto", pedidoMercaderiaDet.getProducto().getOIDInteger());
		ds.fieldValue("codigo_producto", pedidoMercaderiaDet.getProducto().getCodigo());
		ds.fieldValue("desc_producto", pedidoMercaderiaDet.getProducto().getDescripcion());
		ds.fieldValue("desc_adic_sku", pedidoMercaderiaDet.getObservacion());
		ds.fieldValue("cant_solicitada", pedidoMercaderiaDet.getCantidad());
		ds.fieldValue("oid_um_req", pedidoMercaderiaDet.getUnidad_medida().getOIDInteger());
		ds.fieldValue("fec_requerida", pedidoMercaderiaDet.getFec_necesidad());
		if (pedidoMercaderiaDet.getPedido() != null)
			ds.fieldValue("oid_cco_ref", pedidoMercaderiaDet.getPedido().getOIDInteger());
		else
			ds.fieldValue("oid_cco_ref", "");
		if (pedidoMercaderiaDet.getPedido_det() != null)
			ds.fieldValue("oid_cco_ref_det", pedidoMercaderiaDet.getPedido_det().getOIDInteger());
		else
			ds.fieldValue("oid_cco_ref_det", "");
		if (pedidoMercaderiaDet.getPedido_det() != null)
			ds.fieldValue("referencia", pedidoMercaderiaDet.getPedido_det().getReferencia());
		else if (pedidoMercaderiaDet.getPedido() != null)
			ds.fieldValue("referencia", pedidoMercaderiaDet.getPedido().getCodigo());
		else
			ds.fieldValue("referencia", "");

	}

}
