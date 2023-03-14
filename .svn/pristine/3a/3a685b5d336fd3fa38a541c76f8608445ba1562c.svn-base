package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.Proveedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDetallesOCPendRecep extends Operation {

  public TraerDetallesOCPendRecep() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = getDataSetDetOCPendRecep();
    
    // Tomar Parametros
    OrdenDeCompraCab oc = null;
    Proveedor proveedor = Proveedor.findByOid(mapaDatos.getInteger("oid_proveedor"),getSesion());
    /*if (mapaDatos.containsKey("oid_oc")) 
    	oc = OrdenDeCompraCab.findByOidProxy(mapaDatos.getInteger("oid_oc"),getSesion());
    Iterator iterOrcEnt = OrdenDeCompraEnt.getOrdenDeCompraDetPendRecep(proveedor,oc,getSesion()).iterator();
    while (iterOrcEnt.hasNext()) {
    	OrdenDeCompraEnt ocEnt = (OrdenDeCompraEnt) iterOrcEnt.next();
    	cargarRegistroDetOCPendRec(dataset,ocEnt);
    }*/
    writeCliente(dataset);
  }

  private IDataSet getDataSetDetOCPendRecep() {
    IDataSet dataset = new TDataSet();
    dataset.create("TDetOCPendRecep");
    dataset.fieldDef(new Field("oid_oc_ent", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_item", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_adic_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("cod_producto_prov", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_um_stk",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cant_recep_us",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_um_cpra",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cant_recep_uc",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("comentario",Field.STRING, 255));
    dataset.fieldDef(new Field("comprado",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("recibido",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("pend_recep",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("codigo_oc",Field.STRING, 50));
    dataset.fieldDef(new Field("oid_oc",Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo",Field.INTEGER, 0));
    return dataset;
  }

  /*private void cargarRegistroDetOCPendRec(IDataSet dataset,
                         OrdenDeCompraEnt ocDetEnt) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_oc_ent", ocDetEnt.getOIDInteger());
    dataset.fieldValue("nro_item", ocDetEnt.getOrdendecompradet().getNro_item());
    dataset.fieldValue("oid_producto", ocDetEnt.getOrdendecompradet().getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto", ocDetEnt.getOrdendecompradet().getProducto().getCodigo());
    dataset.fieldValue("desc_producto", ocDetEnt.getOrdendecompradet().getProducto().getDescripcion());
    if (ocDetEnt.getOrdendecompradet().getDesc_adic_sku()!=null)
    	dataset.fieldValue("desc_adic_producto", ocDetEnt.getOrdendecompradet().getDesc_adic_sku());
    else
    	dataset.fieldValue("desc_adic_producto", "");
    ProductoProveedor productoProveedor = 
    	ocDetEnt.getOrdendecompradet().getProducto().getProductoProveedor(ocDetEnt.getOrdendecompradet().getOrden_de_compra().getProveedor());
    if (productoProveedor == null)
    	dataset.fieldValue("cod_producto_prov","");
    else {	
    	if (productoProveedor.getCod_prod_prov()!=null)
    		dataset.fieldValue("cod_producto_prov", productoProveedor.getCod_prod_prov());
    	else
    		dataset.fieldValue("cod_producto_prov", "");
    }
    if (ocDetEnt.getOrdendecompradet().getUm_stock()!=null)      
    	dataset.fieldValue("oid_um_stk",ocDetEnt.getOrdendecompradet().getUm_stock().getOIDInteger());
    else
    	dataset.fieldValue("oid_um_stk",0);
    dataset.fieldValue("cant_recep_us",0);
    dataset.fieldValue("oid_um_cpra",ocDetEnt.getOrdendecompradet().getUnidad_compra().getOIDInteger());
    dataset.fieldValue("cant_recep_uc",0);
    if (ocDetEnt.getOrdendecompradet().getComentario()!=null)
    	dataset.fieldValue("comentario",ocDetEnt.getOrdendecompradet().getComentario());
    else
    	dataset.fieldValue("comentario","");
    dataset.fieldValue("comprado", ocDetEnt.getOrdendecompradet().getCant_comprada_uc());
    dataset.fieldValue("recibido", ocDetEnt.getCant_recepcionada_uc()); 
    dataset.fieldValue("pend_recep",ocDetEnt.getCant_pend_recep_uc());
    dataset.fieldValue("codigo_oc", ocDetEnt.getOrdendecompradet().getOrden_de_compra().getCodigo());
    dataset.fieldValue("oid_oc",ocDetEnt.getOrdendecompradet().getOrden_de_compra().getOIDInteger());
    dataset.fieldValue("activo",ocDetEnt.getOrdendecompradet().isActivo());
  }*/
}
