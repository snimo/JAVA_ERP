package com.srn.erp.ventas.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerItemsPendEntMarcaEnt extends Operation {

  public TraerItemsPendEntMarcaEnt() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	PedidoDet pedDet = PedidoDet.findByOidProxy(mapaDatos.getInteger("oid_ped_det"), this.getSesion());
	
	  
	IDataSet ds = getDataSetConsDetPed();
	
	List pedidosPendEnt = PedidoDet.getDetallesPendDesp(pedDet.getPedido(),null,
			null,
			null,
			null,
			null,
			null,
			null,
			null,
			null,
			this.getSesion());
	
	Iterator iterPedPendEnt = pedidosPendEnt.iterator();
	while (iterPedPendEnt.hasNext()) {
		PedidoDet pedidoDet = (PedidoDet) iterPedPendEnt.next();
		cargarRegistro(ds, pedidoDet);
	}
	

    writeCliente(ds);
  }
  
	private IDataSet getDataSetConsDetPed() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConsDetPedidos");

		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cond_pago", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_cliente", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cliente", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_vendedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nom_y_ape_vend", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_oc", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_lp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_lp", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_lp", Field.STRING, 100));
		dataset.fieldDef(new Field("moneda_pedido", Field.STRING, 20));
		dataset.fieldDef(new Field("total_pedido", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("forma_entrega", Field.STRING, 50));
		dataset.fieldDef(new Field("dom_entrega", Field.STRING, 200));

		// Por el detalle del Pedido
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_adic", Field.STRING, 5000));
		dataset.fieldDef(new Field("cant_pedido", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("uni_med_ped", Field.STRING, 20));
		dataset.fieldDef(new Field("fec_entrega", Field.DATE, 0));
		dataset.fieldDef(new Field("cant_entregada", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_facturada", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_pend_ent", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_reservada", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("nro_item", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_ped_det", Field.INTEGER, 0));

		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, PedidoDet pedidoDet) throws BaseException {

		PedidoCab pedido = pedidoDet.getPedido();

		// Por la cabecera del Pedido

		dataset.append();
		dataset.fieldValue("oid_cco", pedido.getOIDInteger());
		dataset.fieldValue("comprobante", pedido.getCodigo());
		dataset.fieldValue("fec_emision", pedido.getEmision());
		dataset.fieldValue("oid_cond_pago", pedido.getCondicionPago().getOIDInteger());
		dataset.fieldValue("cond_pago", pedido.getCondicionPago().getDescripcion());
		dataset.fieldValue("oid_cliente", pedido.getSujeto().getOIDInteger());
		dataset.fieldValue("cliente", pedido.getSujeto().getRazon_social());
		dataset.fieldValue("oid_vendedor", pedido.getVendedor().getOIDInteger());
		dataset.fieldValue("nom_y_ape_vend", pedido.getVendedor().getNombreyApellido());
		dataset.fieldValue("nro_oc", pedido.getOrdenDeCompra());
		dataset.fieldValue("oid_lp", pedido.getLista_precios().getOIDInteger());
		dataset.fieldValue("cod_lp", pedido.getLista_precios().getCodigo());
		dataset.fieldValue("desc_lp", pedido.getLista_precios().getDescripcion());
		dataset.fieldValue("moneda_pedido", pedido.getMoneda().getCodigo());
		dataset.fieldValue("total_pedido", pedido.getTotal());
		dataset.fieldValue("forma_entrega", pedido.getFormaEntrega().getDescripcion());
		if (pedido.getDomicilio_entrega()!=null)
			dataset.fieldValue("dom_entrega", pedido.getDomicilio_entrega().getDireccionCompleta());
		else
			dataset.fieldValue("dom_entrega", "");

		// Por el detalle del Pedido
		dataset.fieldValue("oid_producto", pedidoDet.getProducto().getOIDInteger());
		dataset.fieldValue("cod_producto", pedidoDet.getProducto().getCodigo());
		dataset.fieldValue("desc_producto", pedidoDet.getProducto().getDescripcion());
		dataset.fieldValue("desc_adic", pedidoDet.getComentario());
		dataset.fieldValue("cant_pedido", pedidoDet.getCant_um_ori());
		dataset.fieldValue("uni_med_ped", pedidoDet.getUni_med_ori().getLabelImpresion());
		dataset.fieldValue("fec_entrega", pedidoDet.getFechaEntrega());
		dataset.fieldValue("cant_entregada", pedidoDet.getCant_um_ori_desp());
		dataset.fieldValue("cant_facturada", pedidoDet.getCant_um_ori_fact());
		dataset.fieldValue("cant_pend_ent", pedidoDet.getCantPendDespUniOri());
		dataset.fieldValue("cant_reservada", pedidoDet.getCant_um_ori_res());
		dataset.fieldValue("nro_item", pedidoDet.getNroRenglon());
		dataset.fieldValue("oid_ped_det", pedidoDet.getOIDInteger());

	}
  
  

 }
