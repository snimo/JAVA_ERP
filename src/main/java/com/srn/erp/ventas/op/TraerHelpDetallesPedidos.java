package com.srn.erp.ventas.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.Vendedor;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Decimal;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpDetallesPedidos extends Operation {

  public TraerHelpDetallesPedidos() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet ds                = getDataSetPedPendEnt();
    IDataSet dsDet             = getDataSetDetPedPendEnt();

    Sujeto sujeto              = null;
    Vendedor vendedor          = null;
    java.util.Date fecEntHasta = null;
    Integer nroPedDesde        = null;
    Integer nroPedHasta        = null;
    Producto producto          = null;
    String tipo = null;

    if (mapaDatos.containsKey("oid_sujeto"))
      sujeto = Sujeto.findByOidProxy(mapaDatos.getInteger("oid_sujeto"),getSesion());
    if (mapaDatos.containsKey("oid_vendedor"))
      vendedor = Vendedor.findByOidProxy(mapaDatos.getInteger("oid_vendedor"),getSesion());
    if (mapaDatos.containsKey("fec_ent_hasta"))
      fecEntHasta = mapaDatos.getDate("fec_ent_hasta");
    if (mapaDatos.containsKey("nro_desde"))
      nroPedDesde = mapaDatos.getInteger("nro_desde");
    if (mapaDatos.containsKey("nro_hasta"))
      nroPedHasta = mapaDatos.getInteger("nro_hasta");
    if (mapaDatos.containsKey("oid_producto"))
        producto = Producto.findByOidProxy(mapaDatos.getInteger("oid_producto"),getSesion());
    if (mapaDatos.containsKey("tipo"))
        tipo = mapaDatos.getString("tipo");
    
    List listaPedidos =  null;
    
    listaPedidos = PedidoCab.getPedidosByCondiciones(
        		nroPedDesde,
        		nroPedHasta,
        		sujeto,
        		vendedor,
        		fecEntHasta,
        		producto,
        		tipo,
        		getSesion());
    	
    Iterator iterPedidos = listaPedidos.iterator();
    while (iterPedidos.hasNext()) {
      PedidoCab pedido = (PedidoCab) iterPedidos.next();
      cargarPedidos(ds,pedido.getOIDInteger(),pedido,pedido.getSujeto(),pedido.getEmision());
      Iterator iterDetPendEnt = pedido.getDetalles().iterator();
      while (iterDetPendEnt.hasNext()) {
        PedidoDet pedidoDet = (PedidoDet) iterDetPendEnt.next();
        cargarDetalle(
        		dsDet,
        		pedido,
        		pedido.getOIDInteger(),
        		pedidoDet.getOIDInteger(),
                pedidoDet.getProducto(),
                pedidoDet.getFechaEntrega(),
                pedidoDet.getCantPendDespUniOri(),
                pedidoDet.getNroRenglon(),
                pedidoDet.getCant_um_ori(),
                pedidoDet.getCant_um_ori_desp(),
                pedidoDet.getPedido().getNroExt()
                );
      }
    }
    writeCliente(ds);
    writeCliente(dsDet);
  }

  private IDataSet getDataSetPedPendEnt() {
    IDataSet dataset = new TDataSet();
    dataset.create("TPedidos");
    dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_sujeto", Field.STRING, 50));
    dataset.fieldDef(new Field("rz_sujeto", Field.STRING, 255));
    dataset.fieldDef(new Field("fec_emision", Field.STRING, 10));
    dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("letra",Field.STRING, 1));
    dataset.fieldDef(new Field("lug_emi",Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ext",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_moneda",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_moneda",Field.STRING, 30));
    dataset.fieldDef(new Field("oid_lista_precio",Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_lista_precio",Field.STRING,100));
    dataset.fieldDef(new Field("oid_cond_pago",Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_cond_pago",Field.STRING, 100));
    dataset.fieldDef(new Field("oid_dom_ent",Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_dom_ent",Field.STRING, 100));
    dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarPedidos(IDataSet dataset,
                             Integer oidCCOPed,
                             PedidoCab pedido,
                             Sujeto sujeto,
                             java.util.Date fecEmision) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_cco_ped", oidCCOPed);
    dataset.fieldValue("comprobante", pedido.getCodigo());
    dataset.fieldValue("oid_sujeto", sujeto.getOIDInteger());
    dataset.fieldValue("cod_sujeto", sujeto.getCodigo());
    dataset.fieldValue("rz_sujeto", sujeto.getRazon_social());
    dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(fecEmision));
    dataset.fieldValue("oid_tc", pedido.getTipoCompro().getOIDInteger());
    dataset.fieldValue("letra",pedido.getLetra());
    dataset.fieldValue("lug_emi",pedido.getLugarEmision().getLugemi());
    dataset.fieldValue("nro_ext",pedido.getNroExt());
    dataset.fieldValue("oid_moneda",pedido.getMoneda().getOIDInteger());
    dataset.fieldValue("cod_moneda",pedido.getMoneda().getCodigo());
    dataset.fieldValue("oid_lista_precio",pedido.getLista_precios().getOIDInteger());
    dataset.fieldValue("desc_lista_precio",pedido.getLista_precios().getDescripcion());
    dataset.fieldValue("oid_cond_pago",pedido.getCondicionPago().getOIDInteger());
    dataset.fieldValue("desc_cond_pago",pedido.getCondicionPago().getDescripcion());
    if (pedido.getDomicilio_entrega()!=null) {
      dataset.fieldValue("oid_dom_ent",pedido.getDomicilio_entrega().getOIDInteger());
      dataset.fieldValue("desc_dom_ent",pedido.getDomicilio_entrega().getDescripcion());
    } else {
      dataset.fieldValue("oid_dom_ent",new Integer(0));
      dataset.fieldValue("desc_dom_ent","");
    }
    dataset.fieldValue("activo",pedido.isActivo());

  }


  private IDataSet getDataSetDetPedPendEnt() {
    IDataSet dataset = new TDataSet();
    dataset.create("TDetPedidos");
    dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_ped_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
    dataset.fieldDef(new Field("fec_entrega", Field.STRING, 10));
    dataset.fieldDef(new Field("cant_pend_ent", Field.CURRENCY,0));
    dataset.fieldDef(new Field("oid_cco",Field.INTEGER,0));
    dataset.fieldDef(new Field("comprobante",Field.STRING,50));
    dataset.fieldDef(new Field("fec_emision",Field.STRING,10));
    dataset.fieldDef(new Field("codigo_cliente",Field.STRING,50));
    dataset.fieldDef(new Field("razon_social_cliente",Field.STRING,100));
    dataset.fieldDef(new Field("oid_moneda",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_moneda",Field.STRING, 30));
    dataset.fieldDef(new Field("oid_lista_precio",Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_lista_precio",Field.STRING,100));
    dataset.fieldDef(new Field("oid_cond_pago",Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_cond_pago",Field.STRING, 100));
    dataset.fieldDef(new Field("oid_dom_ent",Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_dom_ent",Field.STRING, 100));
    dataset.fieldDef(new Field("nro_item",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cant_pedido", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cant_entregada", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("nro_ext_ped", Field.INTEGER, 0));
    
    return dataset;
  }

  private void cargarDetalle(IDataSet dataset,
                             PedidoCab pedidoCab,
                             Integer oidCCOPed,
                             Integer oidPedDet,
                             Producto producto,
                             java.util.Date fecEntrega,
                             Decimal cantPendEnt,
                             Integer nroRenglon,
                             Decimal cantPedido,
                             Decimal cantEntregada,
                             Integer nroExtPed) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_cco_ped", oidCCOPed);
    dataset.fieldValue("oid_ped_det", oidPedDet);
    dataset.fieldValue("oid_producto", producto.getOIDInteger());
    dataset.fieldValue("cod_producto", producto.getCodigo());
    dataset.fieldValue("desc_producto", producto.getDescripcion());
    dataset.fieldValue("fec_entrega", Fecha.getddmmyyyy(fecEntrega));
    dataset.fieldValue("cant_pend_ent", cantPendEnt);
    dataset.fieldValue("oid_cco",pedidoCab.getOIDInteger());
    dataset.fieldValue("comprobante",pedidoCab.getCodigo());
    dataset.fieldValue("fec_emision",Fecha.getddmmyyyy(pedidoCab.getEmision()));
    dataset.fieldValue("codigo_cliente",pedidoCab.getSujeto().getCodigo());
    dataset.fieldValue("razon_social_cliente",pedidoCab.getSujeto().getRazon_social());
    dataset.fieldValue("oid_moneda",pedidoCab.getMoneda().getOIDInteger());
    dataset.fieldValue("cod_moneda",pedidoCab.getMoneda().getCodigo());
    dataset.fieldValue("oid_lista_precio",pedidoCab.getLista_precios().getOIDInteger());
    dataset.fieldValue("desc_lista_precio",pedidoCab.getLista_precios().getDescripcion());
    dataset.fieldValue("oid_cond_pago",pedidoCab.getCondicionPago().getOIDInteger());
    dataset.fieldValue("desc_cond_pago",pedidoCab.getCondicionPago().getDescripcion());
    
    if (pedidoCab.getDomicilio_entrega()!=null) {
      dataset.fieldValue("oid_dom_ent",pedidoCab.getDomicilio_entrega().getOIDInteger());
      dataset.fieldValue("desc_dom_ent",pedidoCab.getDomicilio_entrega().getDescripcion());
    } else {
      dataset.fieldValue("oid_dom_ent",new Integer(0));
      dataset.fieldValue("desc_dom_ent","");
    }
    
    dataset.fieldValue("nro_item",nroRenglon);
    dataset.fieldValue("cant_pedido", cantPedido);
    dataset.fieldValue("cant_entregada", cantEntregada);
    dataset.fieldValue("nro_ext_ped", nroExtPed);
    
    

  }

}
