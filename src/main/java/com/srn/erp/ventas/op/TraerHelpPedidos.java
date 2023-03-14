package com.srn.erp.ventas.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.Vendedor;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpPedidos extends Operation {

  public TraerHelpPedidos() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dsPedido = getDataSetPedidos();
    traerPedidos(dsPedido,mapaDatos);
    writeCliente(dsPedido);
  }

  private void traerPedidos(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    Integer nroExtDesde = null;
    Integer nroExtHasta = null;
    java.util.Date fecDesde = null;
    java.util.Date fecHasta = null;
    Sujeto sujeto = null;
    Producto producto = null;
    Vendedor vendedor = null;

    if (mapaDatos.containsKey("nro_ext_desde"))
      nroExtDesde = mapaDatos.getInteger("nro_ext_desde");
    if (mapaDatos.containsKey("nro_ext_hasta"))
      nroExtHasta = mapaDatos.getInteger("nro_ext_hasta");
    if (mapaDatos.containsKey("fec_desde"))
      fecDesde = mapaDatos.getDate("fec_desde");
    if (mapaDatos.containsKey("fec_hasta"))
      fecHasta = mapaDatos.getDate("fec_hasta");
    if (mapaDatos.containsKey("oid_cliente"))
      sujeto = Sujeto.findByOidProxy(mapaDatos.getInteger("oid_cliente"),getSesion());
    if (mapaDatos.containsKey("oid_producto"))
        producto = Producto.findByOidProxy(mapaDatos.getInteger("oid_producto"),getSesion());
    if (mapaDatos.containsKey("oid_vendedor"))
        vendedor = Vendedor.findByOidProxy(mapaDatos.getInteger("oid_vendedor"),getSesion());
    

    List listaPedidos =
        PedidoCab.getPedidos(nroExtDesde,nroExtHasta,fecDesde,fecHasta,sujeto,producto,vendedor,getSesion());
    Iterator iterPedidos = listaPedidos.iterator();
    while (iterPedidos.hasNext()) {
      PedidoCab pedidoCab = (PedidoCab) iterPedidos.next();
      cargarRegistroPedido(dataSet,pedidoCab);
    }

  }

  private IDataSet getDataSetPedidos() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpPedidos");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision", Field.STRING, 10));
    dataset.fieldDef(new Field("oid_cliente", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_cliente", Field.STRING, 50));
    dataset.fieldDef(new Field("rz_cliente", Field.STRING, 100));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("moneda", Field.STRING, 10));
    dataset.fieldDef(new Field("vendedor", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroPedido(IDataSet dataset,
                                    PedidoCab pedido)
    throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid", pedido.getOID());
    dataset.fieldValue("oid_cco", pedido.getOID());
    dataset.fieldValue("comprobante", pedido.getCodigo());
    dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(pedido.getEmision()));
    dataset.fieldValue("oid_cliente", pedido.getSujeto().getOID());
    dataset.fieldValue("cod_cliente", pedido.getSujeto().getCodigo());
    dataset.fieldValue("rz_cliente", pedido.getSujeto().getRazon_social());
    dataset.fieldValue("nro_ext", pedido.getNroExt());
    dataset.fieldValue("activo", pedido.isActivo());
    dataset.fieldValue("importe", pedido.getTotal());
    dataset.fieldValue("moneda", pedido.getMoneda().getCodigo());
    dataset.fieldValue("vendedor", pedido.getVendedor().getNombreyApellido());
    
  }

}
