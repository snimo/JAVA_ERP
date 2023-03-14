package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.AgrupadorDeposito;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDetPedParaOC extends Operation {

	public TraerDetPedParaOC() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		PedidoCab pedido = PedidoCab.findByOid(mapaDatos.getInteger("oid_cco_ped"), getSesion());
		AgrupadorDeposito agrupDepo = AgrupadorDeposito.findByOid(mapaDatos.getInteger("oid_agrupador_deposito"), getSesion());
		
		IDataSet ds = this.getDSDDetPedParaOC();
		Iterator iterPedDet = pedido.getDetalles().iterator();
		while (iterPedDet.hasNext()) {
			PedidoDet pedidoDet = (PedidoDet) iterPedDet.next();
			if (pedidoDet.isAnulado()) continue;
			cargarDSDetPedParaOC(ds, pedidoDet, agrupDepo);
		}
		
		writeCliente(ds);
	}

	private IDataSet getDSDDetPedParaOC() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDetallesPedAComprar");
		dataset.fieldDef(new Field("oid_ped_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_item", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
		dataset.fieldDef(new Field("desc_adic", Field.MEMO, 0));
		dataset.fieldDef(new Field("fec_entrega", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_um_ped", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_um_ped", Field.STRING, 50));
		dataset.fieldDef(new Field("cant_pend_ent", Field.STRING, 100));
		dataset.fieldDef(new Field("reservado", Field.STRING, 100));
		dataset.fieldDef(new Field("libre_stock", Field.STRING, 100));
		dataset.fieldDef(new Field("oc_item_pedido", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_compra", Field.DATE, 0));
		dataset.fieldDef(new Field("comprar", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um_compra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("titulo_compra_item_ped", Field.STRING, 100));
		dataset.fieldDef(new Field("titulo_compra_para_stock", Field.STRING, 100));
		dataset.fieldDef(new Field("titulo_fec_req_compra", Field.STRING, 100));
		dataset.fieldDef(new Field("titulo_um_compra", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_ext_ped", Field.INTEGER, 0));
		
		return dataset;
	}

	private void cargarDSDetPedParaOC(
			IDataSet dataset, 
			PedidoDet pedidoDet,
			AgrupadorDeposito agrupadorDeposito) throws BaseException {
		dataset.append();
		
		dataset.fieldValue("oid_ped_det", pedidoDet.getOIDInteger());
		dataset.fieldValue("oid_cco_ped", pedidoDet.getPedido().getOIDInteger());
		dataset.fieldValue("nro_item", pedidoDet.getNroRenglon());
		dataset.fieldValue("oid_producto", pedidoDet.getProducto().getOIDInteger());
		dataset.fieldValue("cod_producto", pedidoDet.getProducto().getCodigo());
		dataset.fieldValue("desc_producto", pedidoDet.getProducto().getDescripcion());
		dataset.fieldValue("desc_adic", pedidoDet.getComentario());
		dataset.fieldValue("fec_entrega", "Ent. "+ Fecha.getddmmyyyy(pedidoDet.getFechaEntrega()));
		dataset.fieldValue("oid_um_ped", pedidoDet.getUni_med_ori().getOIDInteger());
		dataset.fieldValue("cod_um_ped", pedidoDet.getUni_med_ori().getCodigo());
		dataset.fieldValue("cant_pend_ent", "Pend. "+pedidoDet.getCantPendDespUniOri().doubleValue());
		dataset.fieldValue("reservado", "Res. "+pedidoDet.getCant_um_ori_res().doubleValue());
		if (agrupadorDeposito!=null)
			dataset.fieldValue("libre_stock", "Libre "+agrupadorDeposito.getSaldoLibreStock(pedidoDet.getProducto()).doubleValue());
		else
			dataset.fieldValue("libre_stock", new Double(0).toString());
		dataset.fieldValue("oc_item_pedido", "OC "+pedidoDet.getCantOCPendRecepEnUniVta().doubleValue());
		dataset.fieldValue("fec_compra", Fecha.FECHA_NULA());
		dataset.fieldValue("comprar", new Double(0).toString());
		if (pedidoDet.getProducto().getUm_cpra()!=null)
			dataset.fieldValue("oid_um_compra", pedidoDet.getProducto().getUm_cpra().getOIDInteger());
		else dataset.fieldValue("oid_um_compra",pedidoDet.getUni_med_ori().getOIDInteger());
		dataset.fieldValue("titulo_compra_item_ped", "Comprar p/Item");
		dataset.fieldValue("titulo_compra_para_stock", "Comprar p/Stock");
		dataset.fieldValue("titulo_fec_req_compra", "Fecha Req.");
		dataset.fieldValue("titulo_um_compra", "U.M.");
		dataset.fieldValue("nro_ext_ped", pedidoDet.getPedido().getNroExt());
			
		
	}

}
