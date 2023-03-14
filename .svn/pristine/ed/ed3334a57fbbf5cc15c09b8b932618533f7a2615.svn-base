package com.srn.erp.produccion.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.produccion.bm.OrdenFabricacion;
import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpOrdenesDeFabricacion extends Operation {

  public TraerHelpOrdenesDeFabricacion() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet ds= getDataSet();
    traerOrdenesDeFabricacion(ds,mapaDatos);
    writeCliente(ds);
  }

  private void traerOrdenesDeFabricacion(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    Integer nroExtDesde = null;
    Integer nroExtHasta = null;
    java.util.Date fecDesde = null;
    java.util.Date fecHasta = null;
    Producto producto = null;
    java.util.Date fecIniDes = null;
    java.util.Date fecIniHas = null;
    java.util.Date fecFinDes = null;
    java.util.Date fecFinHas = null;
    String tipoOrden = null;
    Boolean soloAbiertas = new Boolean(true);

    if (mapaDatos.containsKey("nro_ext_desde"))
      nroExtDesde = mapaDatos.getInteger("nro_ext_desde");
    if (mapaDatos.containsKey("nro_ext_hasta"))
      nroExtHasta = mapaDatos.getInteger("nro_ext_hasta");
    if (mapaDatos.containsKey("fec_desde"))
      fecDesde = mapaDatos.getDate("fec_desde");
    if (mapaDatos.containsKey("fec_hasta"))
      fecHasta = mapaDatos.getDate("fec_hasta");
    if (mapaDatos.containsKey("oid_producto"))
      producto = Producto.findByOidProxy(mapaDatos.getInteger("oid_producto"),getSesion());
    if (mapaDatos.containsKey("fec_ini_desde"))
        fecIniDes = mapaDatos.getDate("fec_ini_desde");
    if (mapaDatos.containsKey("fec_ini_hasta"))
        fecIniHas = mapaDatos.getDate("fec_ini_hasta");
    if (mapaDatos.containsKey("fec_fin_desde"))
        fecFinDes = mapaDatos.getDate("fec_fin_desde");
    if (mapaDatos.containsKey("fec_fin_hasta"))
        fecFinHas = mapaDatos.getDate("fec_fin_hasta");
    if (mapaDatos.containsKey("tipo_orden"))
        tipoOrden = mapaDatos.getString("tipo_orden");
    if (mapaDatos.containsKey("solo_abiertas"))
        soloAbiertas = mapaDatos.getBoolean("solo_abiertas");
    
    List listaCompro =
        OrdenFabricacion.getOrdenes(
        		nroExtDesde,
        		nroExtHasta,
        		fecDesde,
        		fecHasta,
        		producto,
        		fecIniDes,
        		fecIniHas,
        		fecFinDes,
        		fecFinHas,
        		tipoOrden,
        		soloAbiertas,
        		getSesion());
    
    Iterator iterCompro = listaCompro.iterator();
    while (iterCompro.hasNext()) {
      OrdenFabricacion ordenFabricacion = (OrdenFabricacion) iterCompro.next();
      cargarRegistro(dataSet,ordenFabricacion);
    }

  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpOrdenesFabricacion");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision", Field.STRING, 10));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cod_um", Field.STRING, 10));
    dataset.fieldDef(new Field("fec_inicio", Field.DATE, 0));
    dataset.fieldDef(new Field("fec_fin", Field.DATE, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                              OrdenFabricacion orden)
    throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid", orden.getOIDInteger());
    dataset.fieldValue("oid_cco", orden.getOIDInteger());
    dataset.fieldValue("comprobante", orden.getCodigo());
    dataset.fieldValue("fec_emision", orden.getEmision());
    dataset.fieldValue("nro_ext", orden.getNroExt());
    dataset.fieldValue("activo", orden.isActivo());
    dataset.fieldValue("cod_producto", orden.getProducto().getCodigo());
    dataset.fieldValue("desc_producto", orden.getProducto().getDescripcion());
    dataset.fieldValue("cantidad", orden.getCantidad());
    dataset.fieldValue("cod_um", orden.getUnidad_medida().getCodigo());
    dataset.fieldValue("fec_inicio", orden.getFec_ini_est());
    dataset.fieldValue("fec_fin", orden.getFec_fin_est());
    
  }

}
