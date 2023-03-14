package com.srn.erp.stock.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.ConsultaStock;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.ExtensionProdGen;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerProductosAInventariar extends Operation {

  private int secu = 0;
  private String nombreTable = null;
  
  public TraerProductosAInventariar() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	
	// Manejo de tablas
	if (mapaDatos.containsKey("nombre_table")) 
			nombreTable = mapaDatos.getString("nombre_table"); 
	  
	IDataSet ds = getDataSetDetInventario();
	  
	Deposito deposito = Deposito.findByOidProxy(mapaDatos.getInteger("oid_deposito"), this.getSesion());
	java.util.Date fechaInventario = mapaDatos.getDate("fecha_inventario");
		
	// Obtener el clasificador de Presentacion
	ClasificadorEntidad clasifEnt = null;
	if ((mapaDatos.containsKey("oid_clasif_presen") && (mapaDatos.getInteger("oid_clasif_presen")!=null))) {
		if (mapaDatos.getInteger("oid_clasif_presen").intValue()>0)
			clasifEnt = ClasificadorEntidad.findByOidProxy(mapaDatos.getInteger("oid_clasif_presen"), this.getSesion());
	}

	Integer oidProducto = null;
	if ((mapaDatos.containsKey("oid_producto") && (mapaDatos.getInteger("oid_producto")!=null))) 
		oidProducto = mapaDatos.getInteger("oid_producto");
	
	// Codgo de Producto y Desc. de Producto
	String codigoProducto = null;
	if (mapaDatos.containsKey("cod_producto"))
		codigoProducto = mapaDatos.getString("cod_producto");
	
	String descProducto = null;
	if (mapaDatos.containsKey("desc_producto"))
		descProducto = mapaDatos.getString("desc_producto");
	
	HashTableDatos listaValClasif = new HashTableDatos();
	
	if (mapaDatos.containsKey("TClasificadorEntidad")) {
	IDataSet dsValClasif = mapaDatos.getDataSet("TClasificadorEntidad");
	dsValClasif.first();
	while (!dsValClasif.EOF()) {
		
		Integer oidClasifEnt = dsValClasif.getInteger("oid_clasif_ent");
		ClasificadorEntidad clasifEntidad = ClasificadorEntidad.findByOidProxy(oidClasifEnt,this.getSesion());
		
		if ((dsValClasif.getInteger("oid_valor_clasif")!=null) && 
				(dsValClasif.getInteger("oid_valor_clasif").intValue()>0)) {
			ValorClasificadorEntidad valorClasifEnt = 
				ValorClasificadorEntidad.findByOidProxy(dsValClasif.getInteger("oid_valor_clasif"),this.getSesion());
			listaValClasif.put(clasifEntidad, valorClasifEnt);
		}		
		
		dsValClasif.next();
	}
	}
	
	List estadosStock = new ArrayList();
	estadosStock.add(EstadoStock.getEstadoStockLibre(this.getSesion()));
	estadosStock.add(EstadoStock.getEstadoStockReservado(this.getSesion()));
	
	
	
	HashTableDatos listaTodosProd = new HashTableDatos();
	Iterator iterProductos = 
		Producto.getConsultaMasivaProductos(oidProducto,descProducto,null,codigoProducto,null,false,false,true,false,false,listaValClasif,this.getSesion()).iterator();
	while (iterProductos.hasNext()) {
		Producto producto = (Producto) iterProductos.next();
		listaTodosProd.put(producto.getOIDInteger(), producto);
	}
	
	Iterator iterConsStock = ConsultaStock.getConsultaMasivaProductos(oidProducto,descProducto, codigoProducto, listaValClasif, deposito, fechaInventario, estadosStock, this.getSesion()).iterator();
	while (iterConsStock.hasNext()) {
			ConsultaStock consStock = (ConsultaStock) iterConsStock.next();
			cargarProducto(ds, clasifEnt, consStock, deposito, fechaInventario);
			listaTodosProd.remove(consStock.getOid_producto());	
	}
	
	Iterator iterTodosProd = listaTodosProd.values().iterator();
	while (iterTodosProd.hasNext()) {
		Producto producto = (Producto) iterTodosProd.next();
		cargarProducto(ds, clasifEnt, producto, deposito, fechaInventario);
	}
	
	// Agregra los Productos que no tengan stock
	
	writeCliente(ds);
	
  }
  
  private IDataSet getDataSetDetInventario() {
	IDataSet dataset = new TDataSet();
	if (nombreTable!=null)
		dataset.create(nombreTable);
	else
		dataset.create("TDetInventario");
	dataset.fieldDef(new Field("oid_det_inventario", Field.INTEGER, 0));
	dataset.fieldDef(new Field("oid_inventario", Field.INTEGER, 0));
	dataset.fieldDef(new Field("titulo", Field.STRING, 100));
	dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
	dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
	dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
	dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
	dataset.fieldDef(new Field("fisico", Field.CURRENCY, 0));
	dataset.fieldDef(new Field("conteo", Field.CURRENCY, 0));
	dataset.fieldDef(new Field("diferencia", Field.CURRENCY, 0));
	dataset.fieldDef(new Field("observacion", Field.MEMO, 0));
	return dataset;
  }
  
  private void cargarProducto(IDataSet ds,
		   ClasificadorEntidad clasificador,
		   ConsultaStock consultaStock, 
		   Deposito deposito, 
		   java.util.Date fecha) throws BaseException {
	  --secu;
	  ds.append();
	  ds.fieldValue("oid_det_inventario", secu);
	  ds.fieldValue("oid_inventario", new Integer(0));
	  if (clasificador!=null) {
		  Producto producto = Producto.findByOidProxy(consultaStock.getOid_producto(), this.getSesion());
		  IValorClasificadorEntidad valor = producto.getValorClasifEnt(clasificador);
		  if (valor!=null)
			  ds.fieldValue("titulo", valor.getDescripcion()+" - "+valor.getCodigo());
		  else
			  ds.fieldValue("titulo", "");
	  } else ds.fieldValue("titulo", "");

	  ds.fieldValue("oid_producto", consultaStock.getOid_producto());
	  ds.fieldValue("cod_producto", consultaStock.getCod_producto());
	  ds.fieldValue("desc_producto", consultaStock.getDesc_producto());
	  ds.fieldValue("oid_um", consultaStock.getOid_um());
	  ds.fieldValue("fisico", consultaStock.getCantidad());
	  ds.fieldValue("conteo", new Money(0));
	  ds.fieldValue("diferencia", new Money(0));
	  ds.fieldValue("observacion", "");
	  
  }
  
  private void cargarProducto(IDataSet ds,
		   ClasificadorEntidad clasificador,
		   Producto producto, 
		   Deposito deposito, 
		   java.util.Date fecha) throws BaseException {
	  
	  --secu;
	  ds.append();
	  ds.fieldValue("oid_det_inventario", secu);
	  ds.fieldValue("oid_inventario", new Integer(0));
	  if (clasificador!=null) {
		  IValorClasificadorEntidad valor = producto.getValorClasifEnt(clasificador);
		  if (valor!=null)
			  ds.fieldValue("titulo", valor.getDescripcion()+" - "+valor.getCodigo());
		  else
			  ds.fieldValue("titulo", "");
	  } else ds.fieldValue("titulo", "");

	  ds.fieldValue("oid_producto", producto.getOIDInteger());
	  ds.fieldValue("cod_producto", producto.getCodigo());
	  ds.fieldValue("desc_producto", producto.getDescripcion());
	  
	  if (producto.getUm_stk()!=null)
		  ds.fieldValue("oid_um", producto.getUm_stk().getOIDInteger());
	  else if (producto.getValorClasifProdGen().getExtensionProdGen().getUMStockPpal()!=null)
		  ds.fieldValue("oid_um", producto.getValorClasifProdGen().getExtensionProdGen().getUMStockPpal().getOIDInteger());
	  else 
		  ds.fieldValue("oid_um", "");
	  ds.fieldValue("fisico", new Money(0));
	  ds.fieldValue("conteo", new Money(0));
	  ds.fieldValue("diferencia", new Money(0));
	  ds.fieldValue("observacion", "");
	  
 }
  



}
