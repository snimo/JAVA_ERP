package com.srn.erp.ventas.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.DevolucionVtasCab;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpIngDev extends Operation {

  public TraerHelpIngDev() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dsDevolucion = this.getDataSetIngDev();
    traerDevolucion(dsDevolucion,mapaDatos);
    writeCliente(dsDevolucion);
  }

  private void traerDevolucion(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    Integer nroExtDesde = null;
    Integer nroExtHasta = null;
    java.util.Date fecDesde = null;
    java.util.Date fecHasta = null;
    Sujeto sujeto = null;
    Producto producto = null;
    FacturaCab factura = null;
    PedidoCab pedido = null;
    RemitoCab remito = null;

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
    if (mapaDatos.containsKey("oid_cco_fact"))
        factura = FacturaCab.findByOidProxy(mapaDatos.getInteger("oid_cco_fact"),getSesion());
    if (mapaDatos.containsKey("oid_cco_ped"))
        pedido = PedidoCab.findByOidProxy(mapaDatos.getInteger("oid_cco_ped"),getSesion());
    if (mapaDatos.containsKey("oid_cco_rto"))
        remito = RemitoCab.findByOidProxy(mapaDatos.getInteger("oid_cco_rto"),getSesion());

    List listaDevoluciones =
        DevolucionVtasCab.getDevolucionesCab(nroExtDesde, nroExtHasta, fecDesde, fecHasta, sujeto, producto, factura, pedido, remito, this.getSesion());
    Iterator iterDevoluciones = listaDevoluciones.iterator();
    while (iterDevoluciones.hasNext()) {
      DevolucionVtasCab devolucion = (DevolucionVtasCab) iterDevoluciones.next();
      cargarRegistroPedido(dataSet,devolucion);
    }

  }

  private IDataSet getDataSetIngDev() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpIngDevoluciones");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision", Field.STRING, 10));
    dataset.fieldDef(new Field("oid_cliente", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_cliente", Field.STRING, 50));
    dataset.fieldDef(new Field("rz_cliente", Field.STRING, 100));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_cco_fact", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_factura", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_cco_rto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_remito", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_pedido", Field.STRING, 100));    
    return dataset;
  }

  private void cargarRegistroPedido(IDataSet dataset,
                                    DevolucionVtasCab devolucion)
    throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid", devolucion.getOID());
    dataset.fieldValue("oid_cco", devolucion.getOID());
    dataset.fieldValue("comprobante", devolucion.getCodigo());
    dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(devolucion.getEmision()));
    dataset.fieldValue("oid_cliente", devolucion.getSujeto().getOID());
    dataset.fieldValue("cod_cliente", devolucion.getSujeto().getCodigo());
    dataset.fieldValue("rz_cliente", devolucion.getSujeto().getRazon_social());
    dataset.fieldValue("nro_ext", devolucion.getNroExt());
    dataset.fieldValue("activo", devolucion.isActivo());
    if (devolucion.getFacturaCab()!=null) {
    	dataset.fieldValue("oid_cco_fact", devolucion.getFacturaCab().getOIDInteger());
    	dataset.fieldValue("codigo_factura", devolucion.getFacturaCab().getCodigo());
    } else {
    	dataset.fieldValue("oid_cco_fact", "");
    	dataset.fieldValue("codigo_factura", "");
    }
    if (devolucion.getRemitoCab()!=null) {
    	dataset.fieldValue("oid_cco_rto", devolucion.getRemitoCab().getOIDInteger());
    	dataset.fieldValue("codigo_remito", devolucion.getRemitoCab().getCodigo());
    } else {
    	dataset.fieldValue("oid_cco_rto", "");
    	dataset.fieldValue("codigo_remito", "");
    } 
    if (devolucion.getPedidoCab()!=null) {
    	dataset.fieldValue("oid_cco_ped", devolucion.getPedidoCab().getOIDInteger());
    	dataset.fieldValue("codigo_pedido", devolucion.getPedidoCab().getCodigo());
    } else {
    	dataset.fieldValue("oid_cco_ped", "");
    	dataset.fieldValue("codigo_pedido", "");
    }
    
    
  }

}
