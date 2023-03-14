package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Precio;
import com.srn.erp.general.bm.TipoCambio;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.impuestos.bm.TasaIVA;
import com.srn.erp.stock.bm.ConceptoImpuestoProducto;
import com.srn.erp.stock.bm.CostoProductoGral;
import com.srn.erp.stock.bm.ExtensionProdGen;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.ConfProdGralPorLP;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.PrecioPorEstrucLP;

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

public class TraerFormacionPreciosLPProdGral extends Operation {

  private Moneda monedaDefCosto = null;
  private UnidadMedida umDefCosto = null;
  private Moneda monedaDefPrecioVta = null;
  private UnidadMedida umDefPrecioVta = null;
	
  private String nombreTable = null;
  private ListaPrecios listaPrecios = null;
  
  HashTableDatos listaCotiz = null;
  
  public TraerFormacionPreciosLPProdGral() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	
	// Manejo de tablas
	  
	  if (mapaDatos.containsKey("TCotizaciones"))
		  listaCotiz = cargarCotizaciones(mapaDatos.getDataSet("TCotizaciones"));
	  
	  if (listaCotiz == null)
		  listaCotiz = this.getListaCotizaciones();
	  
	  //TIPO_CAMBIO_FORM_PRECIO
	  
	monedaDefCosto = Moneda.getMonedaDefaultCostoProducto(this.getSesion());
	umDefCosto = UnidadMedida.getUMDefaultCostoProducto(this.getSesion());
	monedaDefPrecioVta = Moneda.getMonedaDefaultPrecioVta(this.getSesion());
	umDefPrecioVta = UnidadMedida.getUMDefaultPrecioVenta(this.getSesion());
	  
	  
	if (mapaDatos.containsKey("nombre_table")) 
		nombreTable = mapaDatos.getString("nombre_table"); 
	
	IDataSet dsCabFormacionPrecios = getDataSetFormacionPrecios();
	IDataSet dsProductos = this.getDataSetProductos();
	 
	  
	listaPrecios = ListaPrecios.findByOidProxy(mapaDatos.getInteger("oid"), this.getSesion());
		
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
	
	
	HashTableDatos preciosDetPorOidProd = new HashTableDatos();
	Iterator iterListaPreciosDet = 
		PrecioPorEstrucLP.getConsultaMasivaProductos(listaPrecios,oidProducto,descProducto, null, codigoProducto, null, false, true, false, false, false, listaValClasif, this.getSesion()).iterator();
	while (iterListaPreciosDet.hasNext()) {
		PrecioPorEstrucLP lpDet = (PrecioPorEstrucLP) iterListaPreciosDet.next();
		preciosDetPorOidProd.put(lpDet.getValor_clasif_art2().getOIDInteger(),lpDet);
	}
	
	Iterator iterProductos = 
		ExtensionProdGen.getConsultaMasivaProductos(oidProducto,descProducto, null, codigoProducto, null, false, true, false, false, false, listaValClasif, this.getSesion()).iterator();
	
	while (iterProductos.hasNext()) {
		
		ExtensionProdGen producto = (ExtensionProdGen) iterProductos.next();
		CostoProductoGral costoProducto = producto.getCosto(Fecha.getFechaActual());
		PrecioPorEstrucLP lpDet = (PrecioPorEstrucLP) preciosDetPorOidProd.get(producto.getValor_clasif_ent().getOIDInteger());
		cargarProducto(dsProductos,producto,costoProducto,lpDet,clasifEnt);
	}
	
	if (!mapaDatos.containsKey("NO_INCLUIR_CAB")) {
		cargarFormacionPrecios(dsCabFormacionPrecios,listaPrecios);
		writeCliente(dsCabFormacionPrecios);
	}
	writeCliente(dsProductos);
	
	
  }
  
  
  private void cargarFormacionPrecios(IDataSet ds,ListaPrecios listaPrecios) throws BaseException {
	  ds.append();
	  ds.fieldValue("oid_formacion_precio", listaPrecios.getOIDInteger());
	  ds.fieldValue("oid_lp", listaPrecios.getOIDInteger());
	  ds.fieldValue("cod_lp", listaPrecios.getCodigo());
	  ds.fieldValue("desc_lp", listaPrecios.getDescripcion());
  }
  
  private IDataSet getDataSetFormacionPrecios() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFormacionPrecios");
		dataset.fieldDef(new Field("oid_formacion_precio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_lp",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_lp",Field.STRING, 50));
		dataset.fieldDef(new Field("desc_lp",Field.STRING, 50));
		return dataset;
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
	dataset.fieldDef(new Field("precio_venta_con_iva",Field.CURRENCY, 0));
	dataset.fieldDef(new Field("porc_rent_actual",Field.CURRENCY, 0));
	dataset.fieldDef(new Field("nuevo_porc_rent",Field.CURRENCY, 0));
	dataset.fieldDef(new Field("nuevo_precio_vta",Field.CURRENCY, 0));
	dataset.fieldDef(new Field("porc_iva",Field.CURRENCY, 0));
	
	
	
	
	
	return dataset;
  }
  
  public Money getCalcPorcRent(
		  ExtensionProdGen producto,
		  CostoProductoGral costoProducto,
		  PrecioPorEstrucLP lpDet,
		  Money precioSinIVA) throws BaseException {
	  
	  Money costo = new Money(0);
	  if ((costoProducto!=null) && (lpDet!=null)) {
		costo =  producto.getCostoConvAUMVta(costoProducto.getCosto(),costoProducto.getCantidad(),costoProducto.getUm(),new Money(lpDet.getCantidad()),lpDet.getUnidad_medida());
		ValorCotizacion valorCotizOri = this.getCotizacionMoneda(costoProducto.getMoneda());
		ValorCotizacion valorCotizDest = this.getCotizacionMoneda(lpDet.getMoneda());
		
		if (valorCotizOri == null)
			throw new ExceptionValidation(null,"No se pudo encontrar la cotización para la moneda "+costoProducto.getMoneda().getDescripcion());
		if (valorCotizDest == null)
			throw new ExceptionValidation(null,"No se pudo encontrar la cotización para la moneda "+lpDet.getMoneda().getDescripcion());		
		costo = getConvAMoneda(costo,valorCotizOri,valorCotizDest);
	  }
	  CalculadorMoney calcPorcRentActual = new CalculadorMoney(precioSinIVA);
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
		   ExtensionProdGen producto,
		   CostoProductoGral costoProducto,
		   PrecioPorEstrucLP lpDet,
		   ClasificadorEntidad clasificador) throws BaseException {
	  
	  ds.append();
	  ds.fieldValue("oid_producto", producto.getValor_clasif_ent().getOIDInteger());
	  ds.fieldValue("cod_producto", producto.getValor_clasif_ent().getCodigo());
	  ds.fieldValue("desc_producto", producto.getValor_clasif_ent().getDescripcion());
	  
	  ds.fieldValue("cant_decimales", producto.getCantDecPrecio());
	  
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
	    ds.fieldValue("oid_um_costo", costoProducto.getUm().getOIDInteger());
	    costo = costoProducto.getCosto();
	    ds.fieldValue("costo", costo);
	  } else {
		ds.fieldValue("fec_ult_costo", Fecha.FECHA_NULA());
		
		ds.fieldValue("oid_moneda_costo",this.monedaDefCosto.getOIDInteger());
		ds.fieldValue("cant_costo", new Money(1));
		if (producto.getUMCompra()!=null)
			ds.fieldValue("oid_um_costo", producto.getUMCompra().getOIDInteger());
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
	    
	    // Traer el Precio sin IVA Para el producto
	    //lpDet.getValor_clasif_art2()
	    
	    
	    Precio precioSinIVA = 
	    	lpDet.getValorClasifProdGral().getPrecioSinIVA(lpDet, Fecha.getFechaActual());
	    
	    if (precioSinIVA!=null)
	    	ds.fieldValue("precio_venta",precioSinIVA.getImporte());
	    else
	    	ds.fieldValue("precio_venta","");
	    
	    Precio precioConIVA = 
	    	lpDet.getValorClasifProdGral().getPrecioConIVA(lpDet, Fecha.getFechaActual());
	    
	    if (precioConIVA!=null)
	    	ds.fieldValue("precio_venta_con_iva",precioConIVA.getImporte());
	    else
	    	ds.fieldValue("precio_venta_con_iva","");
	    
	    
	    // Debe tener en cuenta las Monedas y las cantidades
	    
	    ds.fieldValue("porc_rent_actual",getCalcPorcRent(producto,costoProducto,lpDet,precioSinIVA.getImporte()));
	    
		ConfProdGralPorLP confProdPorLP =
			producto.getConfProdLP(listaPrecios);
		
		if (confProdPorLP!=null)
			ds.fieldValue("nuevo_porc_rent",confProdPorLP.getPorc_rent_sug());
		else
			ds.fieldValue("nuevo_porc_rent",new Money(0));
	    
	    
	    ds.fieldValue("nuevo_precio_vta",new Money(0));
	    
	    ConceptoImpuestoProducto concImpuProd = 
	    	lpDet.getValorClasifProdGral().getConcImpuIVAProdVigAFecha(Fecha.getFechaActual());
	    
	    if ((concImpuProd!=null) &&
	       (concImpuProd.getConcepto_impuesto()!=null)) {
	    	TasaIVA tasaIVA =
	    		concImpuProd.getConcepto_impuesto().getTasaVigenteIVA(Fecha.getFechaActual(), this.getSesion());
	    	if (tasaIVA!=null)
	    		ds.fieldValue("porc_iva",tasaIVA.getPorcentaje());
	    	else
	    		ds.fieldValue("porc_iva",new Money(0));
	    } else
	    		ds.fieldValue("porc_iva",new Money(0));
	    
	  } else {
		ds.fieldValue("fec_ult_pv", Fecha.FECHA_NULA());
		
		ds.fieldValue("oid_moneda_pv",monedaDefPrecioVta.getOIDInteger());
		ds.fieldValue("cant_pv",new Money(1));
		if (producto.getUMVta()!=null)
			ds.fieldValue("oid_um_pv",producto.getUMVta().getOIDInteger());
		else
			ds.fieldValue("oid_um_pv",umDefPrecioVta.getOIDInteger());
		ds.fieldValue("precio_venta",new Money(0));
		ds.fieldValue("precio_venta_con_iva",new Money(0));
		ds.fieldValue("porc_rent_actual", new Money(0));
		
		ConfProdGralPorLP confProdPorLP =
			producto.getConfProdLP(listaPrecios);
		
		if (confProdPorLP!=null)
			ds.fieldValue("nuevo_porc_rent",confProdPorLP.getPorc_rent_sug());
		else
			ds.fieldValue("nuevo_porc_rent",new Money(0));
		ds.fieldValue("nuevo_precio_vta",new Money(0));
		
	    ConceptoImpuestoProducto concImpuProd = 
	    	producto.getValorClasifProdGral().getConcImpuIVAProdVigAFecha(Fecha.getFechaActual());
	    
	    if ((concImpuProd!=null) &&
	       (concImpuProd.getConcepto_impuesto()!=null)) {
	    	TasaIVA tasaIVA =
	    		concImpuProd.getConcepto_impuesto().getTasaVigenteIVA(Fecha.getFechaActual(), this.getSesion());
	    	if (tasaIVA!=null)
	    		ds.fieldValue("porc_iva",tasaIVA.getPorcentaje());
	    	else
	    		ds.fieldValue("porc_iva",new Money(0));
	    } else
	    		ds.fieldValue("porc_iva",new Money(0));
		
		
		
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
	  if ((monedaOri == null) || (monedaDest == null))
		  throw new ExceptionValidation(null,"No se pudo obtener la cotización de una moneda.");
	  return Cotizacion.convertir(importeOri,monedaOri, monedaDest);
  }
  
  public void corregirProdGralesSinExtension() throws BaseException {
	  ClasificadorEntidad clasifProdGral = 
		  Producto.getClasifProductoGeneral(this.getSesion());
	  Iterator iterValoresClasif = 
		  clasifProdGral.getValoresClasificador().iterator();
	  while (iterValoresClasif.hasNext()) {
		  ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) iterValoresClasif.next();
		  ExtensionProdGen extProdgral = ExtensionProdGen.getExtensionProdGral(valClasifEnt, this.getSesion());
		  if (extProdgral == null) {
			  extProdgral = (ExtensionProdGen) ExtensionProdGen.getNew(ExtensionProdGen.NICKNAME, this.getSesion());
			  extProdgral.setClasificador(clasifProdGral);
			  extProdgral.setValor_clasif_ent(valClasifEnt);
			  extProdgral.save();			  
		  }
		  
	  }
  }

  @Override
  public void beforeExecute(MapDatos mapaDatos) throws BaseException {
	  // 	TODO Auto-generated method stub
	  super.beforeExecute(mapaDatos);
	  
	  corregirProdGralesSinExtension();
  }

	private HashTableDatos getListaCotizaciones() throws BaseException {
		return (HashTableDatos)Cotizacion.getListaCotizacionesPorOidMoneda(Fecha.getFechaActual(),
			TipoCambio.getTipoCambioFormacionPrecio(this.getSesion()),
			this.getSesion());
	}
  
  


}
