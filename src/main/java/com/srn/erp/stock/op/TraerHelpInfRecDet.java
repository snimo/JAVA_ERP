package com.srn.erp.stock.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.bm.ComproProveedor;
import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpInfRecDet extends Operation {

  public TraerHelpInfRecDet() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dsHelpInfRecDet = getDataSet();
    traerHelpInfRecDet(dsHelpInfRecDet,mapaDatos);
    writeCliente(dsHelpInfRecDet);
  }

  private void traerHelpInfRecDet(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

	OrdenDeCompraCab oc = null;  
    Integer nroExtDesde = null;
    Integer nroExtHasta = null;
    java.util.Date fecDesde = null;
    java.util.Date fecHasta = null;
    Producto producto = null;
    Proveedor proveedor = null;
    ComproProveedorBase comproProveedor = null;
    String remitoProveedor = null;
    String referencia = null;
    
    
    if (mapaDatos.containsKey("oid_cco_oc"))
    	oc = OrdenDeCompraCab.findByOidProxy(mapaDatos.getInteger("oid_cco_oc"), this.getSesion());
    
    if (mapaDatos.containsKey("oid_proveedor"))
    	proveedor = Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"), this.getSesion());
    
    if (mapaDatos.containsKey("oid_cco_fact_prov"))
    	comproProveedor = ComproProveedor.findByOidProxy(mapaDatos.getInteger("oid_cco_fact_prov"), this.getSesion());
    
    if (mapaDatos.containsKey("remito_proveedor"))
    	remitoProveedor = mapaDatos.getString("remito_proveedor");
    
    if (mapaDatos.containsKey("referencia"))
    	referencia = mapaDatos.getString("referencia");
    
    if (mapaDatos.containsKey("nro_ext_desde"))
    	nroExtDesde = mapaDatos.getInteger("nro_ext_desde");    
    
    if (mapaDatos.containsKey("nro_ext_hasta"))
    	nroExtHasta = mapaDatos.getInteger("nro_ext_hasta");    
    
    if (mapaDatos.containsKey("fec_desde"))
    	fecDesde = mapaDatos.getDate("fec_desde");    
    
    if (mapaDatos.containsKey("fec_hasta"))
    	fecDesde = mapaDatos.getDate("fec_hasta");
    
    if (mapaDatos.containsKey("oid_producto"))
    	producto = Producto.findByOidProxy(mapaDatos.getInteger("oid_producto"), this.getSesion());

    HashTableDatos condiciones = new HashTableDatos();
	if (oc!=null)
		condiciones.put(OrdenDeCompraCab.NICKNAME  , oc);
	
	if (nroExtDesde!=null)
		condiciones.put("NRO_EXT_DESDE" , nroExtDesde);
	
	if (nroExtHasta!=null)
		condiciones.put("NRO_EXT_HASTA" , nroExtHasta);
	
	if (fecDesde!=null)
		condiciones.put("FEC_DESDE" , fecDesde);
	
	if (fecHasta!=null)
		condiciones.put("FEC_HASTA" , fecHasta);
	
	if (producto!=null)
		condiciones.put(Producto.NICKNAME , producto);	
	
	if (proveedor!=null)
		condiciones.put(Proveedor.NICKNAME , proveedor);	
		
    if (remitoProveedor !=null)
    	condiciones.put("REMITO_PROVEEDOR" , remitoProveedor);
    
    if (referencia !=null)
    	condiciones.put("REFERENCIA" , referencia);
    
    if (producto !=null)
    	condiciones.put(Producto.NICKNAME , producto);
    
    
    List listaInfRecDet =
        InformeRecepcionDet.getDetallesInfRec(condiciones,getSesion());
    Iterator iterInfRecDet = listaInfRecDet.iterator();
    while (iterInfRecDet.hasNext()) {
      InformeRecepcionDet informeRecepcionDet = (InformeRecepcionDet) iterInfRecDet.next();
      cargarRegistro(dataSet,informeRecepcionDet);
    }

  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TProductosRecepcionados");
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("recepcionado", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_um_stock", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco_oc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_oc", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_oc_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco_fact_prov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_fact_prov", Field.STRING, 50));
    dataset.fieldDef(new Field("remito_proveedor", Field.STRING, 50));
    dataset.fieldDef(new Field("referencia", Field.STRING, 50));
    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_cco_inf_rec", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_inf_rec", Field.STRING, 50));
    dataset.fieldDef(new Field("cod_um_stock", Field.STRING, 20));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                              InformeRecepcionDet infRecDet)
    throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid_producto", infRecDet.getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto", infRecDet.getProducto().getCodigo());
    dataset.fieldValue("desc_producto", infRecDet.getProducto().getDescripcion());
    dataset.fieldValue("recepcionado", infRecDet.getCant_rec_en_us());
    dataset.fieldValue("oid_um_stock", infRecDet.getUnidadMedidaStock().getOIDInteger());
    
    if (infRecDet.getOrdenDeCompraDet()!=null) {
    	dataset.fieldValue("oid_cco_oc",  infRecDet.getOrdenDeCompraDet().getOrden_de_compra().getOIDInteger());
    	dataset.fieldValue("codigo_oc", infRecDet.getOrdenDeCompraDet().getOrden_de_compra().getCodigo());
    	dataset.fieldValue("oid_oc_det", infRecDet.getOrdenDeCompraDet().getOIDInteger());
    }
    else {
    	dataset.fieldValue("oid_cco_oc",  "");
    	dataset.fieldValue("codigo_oc", "");
    	dataset.fieldValue("oid_oc_det", "");
    }
    	
    if (infRecDet.getInforme_recepcion().getComproProveedor()!=null) {
    	dataset.fieldValue("oid_cco_fact_prov", infRecDet.getInforme_recepcion().getComproProveedor().getOIDInteger());
    	dataset.fieldValue("cod_fact_prov", infRecDet.getInforme_recepcion().getComproProveedor().getCodigo());
    } else {
    	dataset.fieldValue("oid_cco_fact_prov", "");
    	dataset.fieldValue("cod_fact_prov", "");
    }
    
    if (infRecDet.getInforme_recepcion()!=null)
    	dataset.fieldValue("remito_proveedor", infRecDet.getInforme_recepcion().getRemito_prov());
    else
    	dataset.fieldValue("remito_proveedor", "");
    
    if (infRecDet.getInforme_recepcion().getReferencia()!=null)
    	dataset.fieldValue("referencia", infRecDet.getInforme_recepcion().getReferencia());
    else
    	dataset.fieldValue("referencia", "");
    
    
    dataset.fieldValue("fecha", infRecDet.getInforme_recepcion().getEmision());
    dataset.fieldValue("oid_cco_inf_rec", infRecDet.getInforme_recepcion().getOIDInteger());
    dataset.fieldValue("codigo_inf_rec", infRecDet.getInforme_recepcion().getCodigo());
    dataset.fieldValue("cod_um_stock", infRecDet.getUnidadMedidaStock().getCodigo());
    dataset.fieldValue("activo", infRecDet.getInforme_recepcion().isActivo());
    
    
  }

}
