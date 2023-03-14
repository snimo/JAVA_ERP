package com.srn.erp.ventas.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.CotizacionCab;
import com.srn.erp.ventas.bm.EstadoPresupuestoCliente;
import com.srn.erp.ventas.bm.MotivoEstadoPresuCliente;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.Vendedor;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpCotizacionesCliente extends Operation {

  public TraerHelpCotizacionesCliente() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dsCotizaciones = getDataSetCotizaciones();
    traerCotizaciones(dsCotizaciones,mapaDatos);
    writeCliente(dsCotizaciones);
  }

  private void traerCotizaciones(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    Integer nroExtDesde = null;
    Integer nroExtHasta = null;
    java.util.Date fecDesde = null;
    java.util.Date fecHasta = null;
    Sujeto sujeto = null;
    Producto producto = null;
    Vendedor vendedor= null;
    EstadoPresupuestoCliente estado = null;
    MotivoEstadoPresuCliente motivo = null;

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
    if (mapaDatos.containsKey("oid_estado_presu"))
        estado = EstadoPresupuestoCliente.findByOidProxy(mapaDatos.getInteger("oid_estado_presu"),getSesion());
    if (mapaDatos.containsKey("oid_motivo_estado"))
        motivo = MotivoEstadoPresuCliente.findByOidProxy(mapaDatos.getInteger("oid_motivo_estado"),getSesion());
    

    List listaCotizaciones =
        CotizacionCab.getCotizaciones(nroExtDesde,nroExtHasta,fecDesde,fecHasta,sujeto,producto,vendedor,estado,motivo,getSesion());
    Iterator iterCotizaciones = listaCotizaciones.iterator();
    while (iterCotizaciones.hasNext()) {
      CotizacionCab cotizacionCab = (CotizacionCab) iterCotizaciones.next();
      cargarRegistroCotizacion(dataSet,cotizacionCab);
    }

  }

  private IDataSet getDataSetCotizaciones() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpCotizaciones");
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
    dataset.fieldDef(new Field("moneda", Field.STRING, 20));
    dataset.fieldDef(new Field("estado", Field.STRING, 50));
    dataset.fieldDef(new Field("motivo", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroCotizacion(IDataSet dataset,
                                    CotizacionCab cotizacion)
    throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid", cotizacion.getOID());
    dataset.fieldValue("oid_cco", cotizacion.getOID());
    dataset.fieldValue("comprobante", cotizacion.getCodigo());
    dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(cotizacion.getEmision()));
    dataset.fieldValue("oid_cliente", cotizacion.getSujeto().getOID());
    dataset.fieldValue("cod_cliente", cotizacion.getSujeto().getCodigo());
    dataset.fieldValue("rz_cliente", cotizacion.getSujeto().getRazon_social());
    dataset.fieldValue("nro_ext", cotizacion.getNroExt());
    dataset.fieldValue("activo", cotizacion.isActivo());
    dataset.fieldValue("importe", cotizacion.getTotal());
    dataset.fieldValue("moneda", cotizacion.getMoneda().getCodigo());
    if (cotizacion.getEstadoPresupuestoCliente()!=null)
    	dataset.fieldValue("estado", cotizacion.getEstadoPresupuestoCliente().getDescripcion());
    else
    	dataset.fieldValue("estado", "");
    if (cotizacion.getMotivoEstadoPresuCliente()!=null)
    	dataset.fieldValue("motivo", cotizacion.getMotivoEstadoPresuCliente().getDescripcion());
    else
    	dataset.fieldValue("motivo", "");
    
    
  }

}
