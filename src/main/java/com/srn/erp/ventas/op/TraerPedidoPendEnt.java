package com.srn.erp.ventas.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPedidoPendEnt extends Operation {

  public TraerPedidoPendEnt() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {


    PedidoCab pedidoCab = null;

    if (mapaDatos.containsKey("oid_cco"))
      pedidoCab = PedidoCab.findByOid(mapaDatos.getInteger("oid_cco"),getSesion());
    else {
      Integer oidTC = mapaDatos.getInteger("oid_tc");
      String letra = mapaDatos.getString("letra");
      Integer lug_emi = mapaDatos.getInteger("nro_lug_emi");
      Integer nroExt = mapaDatos.getInteger("nro_ext");

      TipoComprobante tipoComprobante = TipoComprobante.findByOid(oidTC,getSesion());
      pedidoCab = PedidoCab.getPedidoBy_TC_Letra_LE_NroExt(tipoComprobante,
                                                                   letra,
                                                                   lug_emi,
                                                                   nroExt,
                                                                   getSesion());
    }

    if (pedidoCab == null)
      throw new ExceptionValidation(null,"Pedido inexistente");

    if (pedidoCab.isActivo().booleanValue()==false)
      throw new ExceptionValidation(null,"El Pedido se encuentra anulado");

    if (pedidoCab.isPendEnt().booleanValue()==false)
      throw new ExceptionValidation(null,"El Pedido no se encuentra pendiente de entrega");


    IDataSet ds                = getDataSetPedPendEnt();
    IDataSet dsDet             = getDataSetDetPedPendEnt();

    cargarPedido(ds,pedidoCab);
    List listaDetalles = pedidoCab.getDetallesPendEnt();
    Iterator iterDetPendEnt = listaDetalles.iterator();
    while (iterDetPendEnt.hasNext()) {
      PedidoDet pedidoDet = (PedidoDet) iterDetPendEnt.next();
      cargarDetalle(dsDet,pedidoCab,pedidoDet);
    }
    writeCliente(ds);
    writeCliente(dsDet);
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
    dataset.fieldValue("oid_dom_entrega",pedidoCab.getDomicilio_entrega().getOIDInteger());
    dataset.fieldValue("cod_dom_entrega",pedidoCab.getDomicilio_entrega().getCodigo());
    dataset.fieldValue("desc_dom_entrega",pedidoCab.getDomicilio_entrega().getDescripcion());
    if (pedidoCab.getDomicilio_entrega().getCalle_y_mro()!=null)
      dataset.fieldValue("calle_y_nro",pedidoCab.getDomicilio_entrega().getCalle_y_mro());
    else
      dataset.fieldValue("calle_y_nro","");
    if (pedidoCab.getDomicilio_entrega().getLocalidad()!=null)
      dataset.fieldValue("localidad",pedidoCab.getDomicilio_entrega().getLocalidad());
    else
      dataset.fieldValue("localidad","");
    if (pedidoCab.getDomicilio_entrega().getCodigo_postal()!=null)
      dataset.fieldValue("codigo_postal",pedidoCab.getDomicilio_entrega().getCodigo_postal());
    else
      dataset.fieldValue("codigo_postal","");
    if (pedidoCab.getDomicilio_entrega().getProvincia()!=null)
      dataset.fieldValue("oid_provincia",pedidoCab.getDomicilio_entrega().getProvincia().getOIDInteger());
    else
      dataset.fieldValue("oid_provincia",0);
    if (pedidoCab.getDomicilio_entrega().getPais().getOIDInteger()!=null)
      dataset.fieldValue("oid_pais",pedidoCab.getDomicilio_entrega().getPais().getOIDInteger());
    else
      dataset.fieldValue("oid_pais",0);
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
    dataset.fieldValue("cant_pend_ent", pedidoDet.getCantPendEntUniOri());
    dataset.fieldValue("oid_um_pedido", pedidoDet.getUni_med_ori().getOIDInteger());


  }

}
