package com.srn.erp.ventas.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDetallesPedPendEnt extends Operation {

  public TraerDetallesPedPendEnt() {
  }

  private void guardarPedidos(PedidoCab pedidoCab,Hashtable pedidos) throws BaseException {
    if (!pedidos.containsKey(pedidoCab.getOIDInteger()))
      pedidos.put(pedidoCab.getOIDInteger(),pedidoCab);
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Hashtable pedidos = new Hashtable();
    IDataSet dsPedido    = getDataSetPedPendEnt();
    IDataSet dsPedidoDet = getDataSetDetPedPendEnt();
    IDataSet dsDetPedPendEnt = mapaDatos.getDataSet("TDetallesPedPendEnt");
    dsDetPedPendEnt.first();
    while (!dsDetPedPendEnt.EOF()) {
      Integer oid_ped_det = dsDetPedPendEnt.getInteger("oid_ped_det");
      PedidoDet pedidoDet = PedidoDet.findByOid(oid_ped_det,getSesion());
      if (pedidoDet.isPendDesp().booleanValue()) {
        cargarDetalle(dsPedidoDet, pedidoDet.getPedido(), pedidoDet);
        guardarPedidos(pedidoDet.getPedido(),pedidos);
      }
      dsDetPedPendEnt.next();
    }

    // Devolver los Pedidos
    Iterator iterPedidos = pedidos.values().iterator();
    while (iterPedidos.hasNext()) {
      PedidoCab pedidoCab = (PedidoCab) iterPedidos.next();
      cargarPedido(dsPedido,pedidoCab);
    }
    writeCliente(dsPedido);
    writeCliente(dsPedidoDet);
  }

  private IDataSet getDataSetPedPendEnt() {
    IDataSet dataset = new TDataSet();
    dataset.create("TPedPendEnt");
    dataset.fieldDef(new Field("oid_cco_ped",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tc",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tc",Field.STRING,50));
    dataset.fieldDef(new Field("letra",Field.STRING, 1));
    dataset.fieldDef(new Field("oid_lug_emi",Field.INTEGER, 0));
    dataset.fieldDef(new Field("lug_emi",Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ext",Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_emision",Field.STRING, 10));
    dataset.fieldDef(new Field("oid_sujeto",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_sujeto",Field.STRING, 30));
    dataset.fieldDef(new Field("rz_sujeto",Field.STRING, 100));
    dataset.fieldDef(new Field("oid_dom_entrega",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_dom_entrega",Field.STRING, 30));
    dataset.fieldDef(new Field("desc_dom_entrega",Field.STRING, 100));
    dataset.fieldDef(new Field("calle_y_nro",Field.STRING, 100));
    dataset.fieldDef(new Field("localidad",Field.STRING, 100));
    dataset.fieldDef(new Field("codigo_postal",Field.STRING, 100));
    dataset.fieldDef(new Field("oid_provincia",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_pais",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oc",Field.STRING, 100));
    dataset.fieldDef(new Field("pedido",Field.STRING, 50));
    
    
    return dataset;
  }

  private void cargarPedido(IDataSet dataset,
                            PedidoCab pedidoCab) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_cco_ped",pedidoCab.getOIDInteger());
    dataset.fieldValue("oid_tc",pedidoCab.getTipoCompro().getOIDInteger());
    dataset.fieldValue("cod_tc",pedidoCab.getTipoCompro().getCodigo());
    dataset.fieldValue("letra",pedidoCab.getLetra());
    dataset.fieldValue("oid_lug_emi",pedidoCab.getLugarEmision().getOIDInteger());
    dataset.fieldValue("lug_emi",pedidoCab.getLugarEmision().getLugemi());
    dataset.fieldValue("nro_ext",pedidoCab.getNroExt());
    dataset.fieldValue("fec_emision",Fecha.getddmmyyyy(pedidoCab.getEmision()));
    dataset.fieldValue("oid_sujeto",pedidoCab.getSujeto().getOIDInteger());
    dataset.fieldValue("cod_sujeto",pedidoCab.getSujeto().getCodigo());
    dataset.fieldValue("rz_sujeto",pedidoCab.getSujeto().getRazon_social());
    if (pedidoCab.getDomicilio_entrega()!=null) {
      dataset.fieldValue("oid_dom_entrega",pedidoCab.getDomicilio_entrega().getOIDInteger());
      dataset.fieldValue("cod_dom_entrega",pedidoCab.getDomicilio_entrega().getCodigo());
      dataset.fieldValue("desc_dom_entrega",pedidoCab.getDomicilio_entrega().getDescripcion());
    } else {
      dataset.fieldValue("oid_dom_entrega",new Integer(0));
      dataset.fieldValue("cod_dom_entrega","");
      dataset.fieldValue("desc_dom_entrega","");
    }
    if ((pedidoCab.getDomicilio_entrega()!=null) && (pedidoCab.getDomicilio_entrega().getCalle_y_mro()!=null))
      dataset.fieldValue("calle_y_nro",pedidoCab.getDomicilio_entrega().getCalle_y_mro());
    else
      dataset.fieldValue("calle_y_nro","");
    if ((pedidoCab.getDomicilio_entrega()!=null) &&(pedidoCab.getDomicilio_entrega().getLocalidad()!=null))
      dataset.fieldValue("localidad",pedidoCab.getDomicilio_entrega().getLocalidad());
    else
      dataset.fieldValue("localidad","");
    if ((pedidoCab.getDomicilio_entrega()!=null) &&(pedidoCab.getDomicilio_entrega().getCodigo_postal()!=null))
      dataset.fieldValue("codigo_postal",pedidoCab.getDomicilio_entrega().getCodigo_postal());
    else
      dataset.fieldValue("codigo_postal","");
    if ((pedidoCab.getDomicilio_entrega()!=null) &&(pedidoCab.getDomicilio_entrega().getProvincia()!=null))
      dataset.fieldValue("oid_provincia",pedidoCab.getDomicilio_entrega().getProvincia().getOIDInteger());
    else
      dataset.fieldValue("oid_provincia",0);
    
    //
    if ((pedidoCab.getDomicilio_entrega()!=null) && (pedidoCab.getDomicilio_entrega().getPais()!=null))
    	dataset.fieldValue("oid_pais",pedidoCab.getDomicilio_entrega().getPais().getOIDInteger());
    else
    	dataset.fieldValue("oid_pais",0);
    
    dataset.fieldValue("oc", pedidoCab.getOrdenDeCompra());
    dataset.fieldValue("pedido", pedidoCab.getNroExt());
    
  }


  private IDataSet getDataSetDetPedPendEnt() {
    IDataSet dataset = new TDataSet();
    dataset.create("TPedPentEntDet");
    dataset.fieldDef(new Field("oid_ped_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
    dataset.fieldDef(new Field("fec_entrega", Field.STRING, 10));
    dataset.fieldDef(new Field("cant_pedido", Field.CURRENCY,0));
    dataset.fieldDef(new Field("oid_um_pedido", Field.INTEGER,0));
    dataset.fieldDef(new Field("desc_adic", Field.MEMO,0));
    return dataset;
  }

  private void cargarDetalle(IDataSet dataset,
                             PedidoCab pedidoCab,
                             PedidoDet pedidoDet) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_ped_det", pedidoDet.getOIDInteger());
    dataset.fieldValue("oid_cco_ped",pedidoCab.getOIDInteger());
    dataset.fieldValue("oid_producto", pedidoDet.getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto", pedidoDet.getProducto().getCodigo());
    dataset.fieldValue("desc_producto", pedidoDet.getProducto().getDescripcion());
    dataset.fieldValue("fec_entrega", Fecha.getddmmyyyy(pedidoDet.getFechaEntrega()));
    dataset.fieldValue("cant_pedido", pedidoDet.getCantPendDespUniOri());
    dataset.fieldValue("oid_um_pedido", pedidoDet.getUni_med_ori().getOIDInteger());
    dataset.fieldValue("desc_adic", pedidoDet.getComentario());
  }

}
