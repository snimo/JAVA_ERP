package com.srn.erp.ventas.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpFacturasNC extends Operation {

  public TraerHelpFacturasNC() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dsFactura = getDataSetFacturas();
    traerFacturas(dsFactura,mapaDatos);
    writeCliente(dsFactura);
  }

  private void traerFacturas(
  		IDataSet dataSet ,
  		MapDatos mapaDatos) throws BaseException {

    Integer nroExtDesde = null;
    Integer nroExtHasta = null;
    java.util.Date fecDesde = null;
    java.util.Date fecHasta = null;
    Sujeto sujeto = null;
    Producto producto = null;

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
    

    List listaFacturas =
        FacturaCab.getFacturas(nroExtDesde,nroExtHasta,fecDesde,fecHasta,sujeto,producto,getSesion());
    Iterator iterFacturas = listaFacturas.iterator();
    while (iterFacturas.hasNext()) {
      FacturaCab facturaCab = (FacturaCab) iterFacturas.next();
      cargarRegistroFactura(dataSet,facturaCab);
    }

  }

  private IDataSet getDataSetFacturas() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpFacturas");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision", Field.STRING, 10));
    dataset.fieldDef(new Field("oid_cliente", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_cliente", Field.STRING, 50));
    dataset.fieldDef(new Field("rz_cliente", Field.STRING, 100));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroFactura(IDataSet dataset,
                                     FacturaCab factura)
    throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid", factura.getOID());
    dataset.fieldValue("oid_cco", factura.getOID());
    dataset.fieldValue("comprobante", factura.getCodigo());
    dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(factura.getEmision()));
    dataset.fieldValue("oid_cliente", factura.getSujeto().getOID());
    dataset.fieldValue("cod_cliente", factura.getSujeto().getCodigo());
    dataset.fieldValue("rz_cliente", factura.getSujeto().getRazon_social());
    dataset.fieldValue("nro_ext", factura.getNroExt());
    dataset.fieldValue("activo", factura.isActivo());
    
  }

}
