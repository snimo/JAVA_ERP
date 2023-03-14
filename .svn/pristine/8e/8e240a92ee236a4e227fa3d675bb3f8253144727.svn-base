package com.srn.erp.ventas.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPedParaReserProd extends Operation {

  private Integer nroPedDesde = null;
  private Integer nroPedHasta = null;
  private java.util.Date fecEntregaHasta = null;
  private Sujeto cliente;
  private String tableName;
  private PedidoDet pedidoDet;
  
	
	
  public TraerPedParaReserProd() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet ds = getDataSetConsDetPed();
	  List<PedidoDet> detallesPedidos = 
		  PedidoDet.getDetallesPendDesp(
			  null,
			  pedidoDet,
			  cliente,
			  nroPedDesde,
			  nroPedHasta,
			  null,
			  null,
			  null,
			  fecEntregaHasta,
			  null,
			  this.getSesion());
	  
	  Iterator<PedidoDet> iterDetalles =  detallesPedidos.iterator();
	  while (iterDetalles.hasNext()) {
		  PedidoDet pedidoDet = iterDetalles.next();
		  if (pedidoDet.isAnulado().booleanValue()) continue;
		  if (pedidoDet.getPedido().isActivo()==false) continue;
		  cargarRegistro(ds,pedidoDet);
	  }
	  
	  writeCliente(ds);
  }

	@Override
	public void beforeExecute(MapDatos mapaDatos) throws BaseException {
	// TODO Auto-generated method stub
		super.beforeExecute(mapaDatos);
		
		if (mapaDatos.containsKey("nro_pedido_desde")) 
			if (mapaDatos.getInteger("nro_pedido_desde")>0)
				nroPedDesde = mapaDatos.getInteger("nro_pedido_desde");
		
		if (mapaDatos.containsKey("nro_pedido_hasta")) 
			if (mapaDatos.getInteger("nro_pedido_hasta")>0)
				nroPedHasta = mapaDatos.getInteger("nro_pedido_hasta");
		
		if (mapaDatos.containsKey("fec_entrega_hasta")) 
				fecEntregaHasta = mapaDatos.getDate("fec_entrega_hasta");
		
		if (mapaDatos.containsKey("oid_cliente")) 
				cliente = Sujeto.findByOidProxy(mapaDatos.getInteger("oid_cliente"), this.getSesion());
		
		if (mapaDatos.containsKey("oid_ped_det")) 
			pedidoDet = PedidoDet.findByOidProxy(mapaDatos.getInteger("oid_ped_det"), this.getSesion());
		
		
		tableName = mapaDatos.getString("table_name");
		
	}

	private IDataSet getDataSetConsDetPed() {
		IDataSet dataset = new TDataSet();
		dataset.create(tableName);

		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_ext_ped", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cond_pago", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_cliente", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_cliente", Field.STRING, 50));
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
		dataset.fieldDef(new Field("cant_pend_ent", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_facturada", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_reservada", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_separada", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_ped_det", Field.INTEGER, 0));
		

		return dataset;
	}

  private void cargarRegistro(IDataSet dataset,
                              PedidoDet pedidoDet) throws BaseException {
    dataset.append();
	dataset.fieldValue("oid_cco", pedidoDet.getPedido().getOIDInteger());
	dataset.fieldValue("comprobante", pedidoDet.getPedido().getCodigo());
	dataset.fieldValue("nro_ext_ped", pedidoDet.getPedido().getNroExt());
	dataset.fieldValue("fec_emision", pedidoDet.getPedido().getEmision());
	dataset.fieldValue("oid_cond_pago", pedidoDet.getPedido().getCondicionPago().getOIDInteger());
	dataset.fieldValue("cond_pago", pedidoDet.getPedido().getCondicionPago().getDescripcion());
	dataset.fieldValue("oid_cliente", pedidoDet.getPedido().getSujeto().getOIDInteger());
	dataset.fieldValue("cod_cliente", pedidoDet.getPedido().getSujeto().getCodigo());
	dataset.fieldValue("cliente", pedidoDet.getPedido().getSujeto().getRazon_social());
	dataset.fieldValue("oid_vendedor", pedidoDet.getPedido().getVendedor().getOIDInteger());
	dataset.fieldValue("nom_y_ape_vend", pedidoDet.getPedido().getVendedor().getNombreyApellido());
	dataset.fieldValue("nro_oc", pedidoDet.getPedido().getOrdenDeCompra());
	dataset.fieldValue("oid_lp", pedidoDet.getPedido().getLista_precios().getOIDInteger());
	dataset.fieldValue("cod_lp", pedidoDet.getPedido().getLista_precios().getCodigo());
	dataset.fieldValue("desc_lp", pedidoDet.getPedido().getLista_precios().getDescripcion());
	dataset.fieldValue("moneda_pedido", pedidoDet.getPedido().getMoneda().getDescripcion());
	dataset.fieldValue("total_pedido", pedidoDet.getPedido().getTotal());
	if (pedidoDet.getPedido().getFormaEntrega()!=null)
		dataset.fieldValue("forma_entrega", pedidoDet.getPedido().getFormaEntrega().getDescripcion());
	else
		dataset.fieldValue("forma_entrega", "");
	if (pedidoDet.getPedido().getDomicilio_entrega()!=null)
		dataset.fieldValue("dom_entrega", pedidoDet.getPedido().getDomicilio_entrega().getDescripcion());
	else
		dataset.fieldValue("dom_entrega", "");

	// Por el detalle del Pedido
	dataset.fieldValue("oid_producto", pedidoDet.getProducto().getOIDInteger());
	dataset.fieldValue("cod_producto", pedidoDet.getProducto().getCodigo());
	dataset.fieldValue("desc_producto", pedidoDet.getProducto().getDescripcion());
	dataset.fieldValue("desc_adic", pedidoDet.getComentario());
	dataset.fieldValue("cant_pedido", pedidoDet.getCant_um_ori());
	dataset.fieldValue("uni_med_ped", pedidoDet.getUni_med_ori().getCodigo());
	dataset.fieldValue("fec_entrega", pedidoDet.getFechaEntrega());
	dataset.fieldValue("cant_entregada", pedidoDet.getCant_um_ori_desp());
	dataset.fieldValue("cant_pend_ent", pedidoDet.getCantPendDespUniOri());
	dataset.fieldValue("cant_facturada", pedidoDet.getCant_um_ori_fact());
	dataset.fieldValue("cant_reservada", pedidoDet.getCant_um_ori_res());
	dataset.fieldValue("cant_separada", pedidoDet.getCant_um_ori_sep());
	dataset.fieldValue("oid_ped_det", pedidoDet.getOIDInteger());
    
    
  }
}
