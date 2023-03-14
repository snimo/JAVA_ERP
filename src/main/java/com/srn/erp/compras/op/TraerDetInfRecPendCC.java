package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.ProductoProveedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDetInfRecPendCC extends Operation {

  public TraerDetInfRecPendCC() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	HashTableDatos condiciones = new HashTableDatos();
	
	if (mapaDatos.containsKey("oid_proveedor")) {
		Proveedor proveedor = Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"),getSesion());
		condiciones.put(Proveedor.NICKNAME,proveedor);
	}
	
	if (mapaDatos.containsKey("oid_producto")) {
		Producto producto = Producto.findByOidProxy(mapaDatos.getInteger("oid_producto"),getSesion());
		condiciones.put(Producto.NICKNAME,producto);
	}	
	
	if (mapaDatos.containsKey("oid_inf_rec")) {
		InformeRecepcion informeRecepcion = InformeRecepcion.findByOidProxy(mapaDatos.getInteger("oid_inf_rec"),getSesion());
		condiciones.put(InformeRecepcion.NICKNAME,informeRecepcion);
	}	
	
    IDataSet dataset = getDataSetInfRecPendCC();
    Iterator iterDetInfRec = InformeRecepcionDet.getDetallesInfRecPendCC(condiciones,getSesion()).iterator();
    while (iterDetInfRec.hasNext()) {
    	InformeRecepcionDet infRecDet = (InformeRecepcionDet) iterDetInfRec.next();
    	cargarRegistroInfRecPendCC(dataset,infRecDet);
    }
    writeCliente(dataset);
    
  }

  private IDataSet getDataSetInfRecPendCC() {
    IDataSet dataset = new TDataSet();
    dataset.create("TDetInfRecPendCC");
    dataset.fieldDef(new Field("oid_inf_rec_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
    dataset.fieldDef(new Field("desc_adic_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("articulo_proveedor", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_um_stk", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cant_recep_us", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("pend_cc_us", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_prov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_prov", Field.STRING, 50));
    dataset.fieldDef(new Field("rs_prov", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroInfRecPendCC(IDataSet dataset,
                         InformeRecepcionDet infRecDet) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_inf_rec_det", infRecDet.getOIDInteger());
    dataset.fieldValue("oid_producto", infRecDet.getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto", infRecDet.getProducto().getCodigo());
    dataset.fieldValue("desc_producto", infRecDet.getProducto().getDescripcion());
    dataset.fieldValue("desc_adic_producto", infRecDet.getComentario());
    ProductoProveedor productoProveedor = infRecDet.getProducto().getProductoProveedor(infRecDet.getInforme_recepcion().getProveedor());
    if (productoProveedor!=null)
       dataset.fieldValue("articulo_proveedor", productoProveedor.getCodigo());
    else
       dataset.fieldValue("articulo_proveedor", "");
    dataset.fieldValue("oid_um_stk", infRecDet.getUnidadMedidaStock().getOIDInteger());
    dataset.fieldValue("cant_recep_us", infRecDet.getCant_rec_en_us());
    dataset.fieldValue("pend_cc_us", infRecDet.getCantPendCCEnUS());
    dataset.fieldValue("oid_prov", infRecDet.getInforme_recepcion().getProveedor().getOIDInteger());
    dataset.fieldValue("cod_prov", infRecDet.getInforme_recepcion().getProveedor().getCodigo());
    dataset.fieldValue("rs_prov", infRecDet.getInforme_recepcion().getProveedor().getRazonsocial());
  }
}
