package com.srn.erp.ventas.op;

import java.util.Date;
import java.util.Iterator;
import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.CostoProducto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.ConfProdPorLP;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.ListaPreciosDet;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFormacionPreciosLP extends Operation {

  private Moneda monedaDefCosto = null;
  private UnidadMedida umDefCosto = null;
  private Moneda monedaDefPrecioVta = null;
  private UnidadMedida umDefPrecioVta = null;
	
  private String nombreTable = null;
  private ListaPrecios listaPrecios = null;
  
  HashTableDatos listaCotiz = null;
  
  public TraerFormacionPreciosLP() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	
	// Manejo de tablas
	  
	listaCotiz = cargarCotizaciones(mapaDatos.getDataSet("TCotizaciones"));
	  
	monedaDefCosto = Moneda.getMonedaDefaultCostoProducto(this.getSesion());
	umDefCosto = UnidadMedida.getUMDefaultCostoProducto(this.getSesion());
	monedaDefPrecioVta = Moneda.getMonedaDefaultPrecioVta(this.getSesion());
	umDefPrecioVta = UnidadMedida.getUMDefaultPrecioVenta(this.getSesion());
	  
	  
	if (mapaDatos.containsKey("nombre_table")) 
			nombreTable = mapaDatos.getString("nombre_table"); 
	  
	IDataSet dsProductos = this.getDataSetProductos();
	  
	listaPrecios = ListaPrecios.findByOidProxy(mapaDatos.getInteger("oid_lp"), this.getSesion());
		
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
	
	HashTableDatos costosProductos = 
		CostoProducto.getConsultaMasivaProductos(
				Fecha.getFechaActual(),
				oidProducto,
				descProducto, 
				null, 
				codigoProducto, 
				null, false, true, false, false, false, 
				listaValClasif, this.getSesion());
	
	// Pasar la lista con clave por Producto
	HashTableDatos costosProductosPorKeyOidProd = new HashTableDatos();
	Iterator iterValCostosProd = costosProductos.values().iterator();
	while (iterValCostosProd.hasNext()) {
		CostoProducto costoProducto = (CostoProducto) iterValCostosProd.next();
		costosProductosPorKeyOidProd.put(costoProducto.getProducto().getOIDInteger(), costoProducto);
	}
	
	HashTableDatos preciosDetPorOidProd = new HashTableDatos();
	Iterator iterListaPreciosDet = 
		ListaPreciosDet.getConsultaMasivaProductos(listaPrecios,oidProducto,descProducto, null, codigoProducto, null, false, true, false, false, false, listaValClasif, this.getSesion()).iterator();
	while (iterListaPreciosDet.hasNext()) {
		ListaPreciosDet lpDet = (ListaPreciosDet) iterListaPreciosDet.next();
		preciosDetPorOidProd.put(lpDet.getProducto().getOIDInteger(),lpDet);
	}
	
	
	Iterator iterProductos = 
		Producto.getConsultaMasivaProductos(oidProducto,descProducto, null, codigoProducto, null, false, true, false, false, false, listaValClasif, this.getSesion()).iterator();
	
	while (iterProductos.hasNext()) {
		
		Producto producto = (Producto) iterProductos.next();
		CostoProducto costoProducto = (CostoProducto) costosProductosPorKeyOidProd.get(producto.getOIDInteger());
		ListaPreciosDet lpDet = (ListaPreciosDet) preciosDetPorOidProd.get(producto.getOIDInteger());
		cargarProducto(dsProductos,producto,costoProducto,lpDet,clasifEnt);
	}
	
	writeCliente(dsProductos);
	
  }
  
  private IDataSet getDataSetProductos() {
	IDataSet dataset = new TDataSet();
	
	if (nombreTable!=null)
		dataset.create(nombreTable);
	else
		dataset.create("TProductosLP");
	
	dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
	dataset.fieldDef(new Field("cod_producto", Field.INTEGER, 0));
	dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
	dataset.fieldDef(new Field("cant_decimales",Field.INTEGER, 0));
	dataset.fieldDef(new Field("titulo", Field.STRING, 255));
	dataset.fieldDef(new Field("fec_ult_costo",Field.DATE, 255));
	dataset.fieldDef(new Field("oid_moneda_costo",Field.INTEGER, 0));
	dataset.fieldDef(new Field("cant_costo",Field.CURRENCY, 50));
	dataset.fieldDef(new Field("oid_um_costo",Field.INTEGER, 0));
	dataset.fieldDef(new Field("costo",Field.CURRENCY, 50));
	
	
	dataset.fieldDef(new Field("fec_ult_pv",Field.DATE, 0));
	dataset.fieldDef(new Field("oid_moneda_pv",Field.DATE, 0));
	dataset.fieldDef(new Field("cant_pv",Field.CURRENCY, 0));
	dataset.fieldDef(new Field("oid_um_pv",Field.INTEGER, 0));
	dataset.fieldDef(new Field("precio_venta",Field.CURRENCY, 0));
	dataset.fieldDef(new Field("porc_rent_actual",Field.CURRENCY, 0));
	dataset.fieldDef(new Field("nuevo_porc_rent",Field.CURRENCY, 0));
	dataset.fieldDef(new Field("nuevo_precio_vta",Field.CURRENCY, 0));
	
	
	
	
	
	return dataset;
  }
  
  public Money getCalcPorcRent(Producto producto,CostoProducto costoProducto,ListaPreciosDet lpDet) throws BaseException {
	  
	  
	  
	  Money costo = new Money(0);
	  if ((costoProducto!=null) && (lpDet!=null)) {
		costo =  producto.getCostoConvAUMVta(costoProducto.getCosto(),new Money(costoProducto.getCantidad()),costoProducto.getUnidad_medida(),new Money(lpDet.getCantidad()),lpDet.getUnidad_medida());
		costo = getConvAMoneda(costo,this.getCotizacionMoneda(costoProducto.getMoneda()),this.getCotizacionMoneda(lpDet.getMoneda()));
	  }
	  CalculadorMoney calcPorcRentActual = new CalculadorMoney(lpDet.getPrecio());
	  calcPorcRentActual.restar(costo);
	  
	  Money porcRent = new Money(0);
	  if (costo.doubleValue()!=0) {
		  calcPorcRentActual.dividirPor(costo);
		  calcPorcRentActual.multiplicarPor(new Money(100));
		  porcRent = calcPorcRentActual.getResultMoney(); 
	  }
	  
	  return porcRent; 
		  
  }
  
  
  private void cargarProducto(IDataSet ds,
		   Producto producto,
		   CostoProducto costoProducto,
		   ListaPreciosDet lpDet,
		   ClasificadorEntidad clasificador) throws BaseException {
	  
	  ds.append();
	  ds.fieldValue("oid_producto", producto.getOIDInteger());
	  ds.fieldValue("cod_producto", producto.getCodigo());
	  ds.fieldValue("desc_producto", producto.getDescripcion());
	  ds.fieldValue("cant_decimales", producto.getCantDecPrecioVta());
	  
	  IValorClasificadorEntidad valor = producto.getValorClasifEnt(clasificador);
	  if (valor!=null)
		  ds.fieldValue("titulo", valor.getDescripcion()+" - "+valor.getCodigo());
	  else
		  ds.fieldValue("titulo", "");
	  
	  Money costo = null;
	  if (costoProducto!=null) {
	    ds.fieldValue("fec_ult_costo", costoProducto.getFec_ult_costo());
	    ds.fieldValue("oid_moneda_costo",costoProducto.getMoneda().getOIDInteger());
	    ds.fieldValue("cant_costo", costoProducto.getCantidad());
	    ds.fieldValue("oid_um_costo", costoProducto.getUnidad_medida().getOIDInteger());
	    costo = costoProducto.getCosto();
	    ds.fieldValue("costo", costo);
	  } else {
		ds.fieldValue("fec_ult_costo", Fecha.FECHA_NULA());
		
		ds.fieldValue("oid_moneda_costo",this.monedaDefCosto.getOIDInteger());
		ds.fieldValue("cant_costo", new Money(1));
		if (producto.getUm_cpra()!=null)
			ds.fieldValue("oid_um_costo", producto.getUm_cpra().getOIDInteger());
		else
			ds.fieldValue("oid_um_costo", this.umDefCosto.getOIDInteger());
		costo = new Money(0);
		ds.fieldValue("costo", costo);
	  }
	  
	  
	  
	  if (lpDet!=null) {
	    ds.fieldValue("fec_ult_pv", Fecha.FECHA_NULA());
	    ds.fieldValue("oid_moneda_pv",lpDet.getMoneda().getOIDInteger());
	    ds.fieldValue("cant_pv",lpDet.getCantidad());
	    ds.fieldValue("oid_um_pv",lpDet.getUnidad_medida().getOIDInteger());
	    ds.fieldValue("precio_venta",lpDet.getPrecio());
	    
	    
	    // Debe tener en cuenta las Monedas y las cantidades
	    
	    ds.fieldValue("porc_rent_actual",getCalcPorcRent(producto,costoProducto,lpDet));
	    
		ConfProdPorLP confProdPorLP =
			producto.getConfProdPorLP(listaPrecios);
		
		if (confProdPorLP!=null)
			ds.fieldValue("nuevo_porc_rent",confProdPorLP.getPorc_rent_sug());
		else
			ds.fieldValue("nuevo_porc_rent",new Money(0));
	    
	    
	    ds.fieldValue("nuevo_precio_vta",new Money(0));
	  } else {
		ds.fieldValue("fec_ult_pv", Fecha.FECHA_NULA());
		
		ds.fieldValue("oid_moneda_pv",monedaDefPrecioVta.getOIDInteger());
		ds.fieldValue("cant_pv",new Money(1));
		if (producto.getUm_vta()!=null)
			ds.fieldValue("oid_um_pv",producto.getUm_vta().getOIDInteger());
		else
			ds.fieldValue("oid_um_pv",umDefPrecioVta.getOIDInteger());
		ds.fieldValue("precio_venta",new Money(0));
		ds.fieldValue("porc_rent_actual", new Money(0));
		
		ConfProdPorLP confProdPorLP =
			producto.getConfProdPorLP(listaPrecios);
		
		if (confProdPorLP!=null)
			ds.fieldValue("nuevo_porc_rent",confProdPorLP.getPorc_rent_sug());
		else
			ds.fieldValue("nuevo_porc_rent",new Money(0));
		ds.fieldValue("nuevo_precio_vta",new Money(0));
	  }
	  
	  
	  
  }
  
  private ValorCotizacion getCotizacionMoneda(Moneda moneda) throws BaseException {
	  if (moneda.isMonedaCursoLegal())
		  return new ValorCotizacion(1);
	  ValorCotizacion valorCotiz = (ValorCotizacion)listaCotiz.get(moneda.getOIDInteger());
	  if (valorCotiz == null) throw new ExceptionValidation(null,"No de pudo obtener la cotización de la moneda "+moneda.getDescripcion());
	  return valorCotiz;
  }
  
  private HashTableDatos cargarCotizaciones(IDataSet dsCotizaciones) throws BaseException {
	  HashTableDatos listaCotizaciones = new HashTableDatos();
	  dsCotizaciones.first();
	  while (!dsCotizaciones.EOF()) {
		  Moneda moneda              = Moneda.findByOidProxy(dsCotizaciones.getInteger("oid_moneda"),getSesion());
		  ValorCotizacion valorCotiz = dsCotizaciones.getCotizacion("cotizacion");
		  listaCotizaciones.put(moneda.getOIDInteger(),valorCotiz);
		  dsCotizaciones.next();
	  }
	  return listaCotizaciones;
  }
  
  public Money getConvAMoneda(Money importeOri,ValorCotizacion monedaOri,ValorCotizacion monedaDest) throws BaseException {
	  return Cotizacion.convertir(importeOri,monedaOri, monedaDest);
  }
  
  


}
