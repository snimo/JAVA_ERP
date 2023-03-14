package com.srn.erp.general.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.compras.bm.PrecioCompraPorClasifArt;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.TipoAcuerdo;
import com.srn.erp.costos.bm.FormaCalcCosto;
import com.srn.erp.ctasAPagar.bm.ComproProvInfRecOC;
import com.srn.erp.general.da.DBValorClasificadorEntidad;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.ConceptoImpuestoProducto;
import com.srn.erp.stock.bm.CostoProductoGral;
import com.srn.erp.stock.bm.ExtensionProdGen;
import com.srn.erp.stock.bm.FactConvProdGral;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.ProductoProveedor;
import com.srn.erp.stock.bm.SeguimientoStock;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.ConfProdGralPorLP;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.PrecioPorEstrucLP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Utils.BaseException;

public class ValorClasifEntProdGen extends ValorClasificadorEntidad implements IEntidadClasificable {

	public IValorClasificadorEntidad getValorClasifEnt(
			ClasificadorEntidad clasifEnt) throws BaseException {
		// TODO Auto-generated metRhod stub
		if (clasifEnt == null) return null;
		this.supportRefresh();
		if (this.getExtensionProdGen()==null) return null;
		return this.getExtensionProdGen().getValorClasifEnt(clasifEnt);
	}

	public static String NICKNAME = "ge.ValorClasifEntProdGral";

	private List productosProveedor = new ArrayList();
	private boolean readProductosProveedores = true;

	private List costosProductoGral = new ArrayList();
	private boolean readCostosProductosGral = true;

	private List configuracionPorLP = new ArrayList();
	private boolean readConfiguracionPorLP = true;
	
	private List preciosLista = new ArrayList();

	private List factConvUM = new ArrayList();
	private boolean readFactConvUM = true;

	private List productos = new ArrayList();
	private boolean readProductos = true;
	
	private List seguiStock = new ArrayList();
	private boolean readSeguiStock= true;
	
	private List conceptosImpuestos = new ArrayList();
	private boolean readConcImpu= true;	
	

	private ExtensionProdGen extensionProdGen;

	public static ValorClasifEntProdGen findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ValorClasifEntProdGen) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public List getProductosProveedor() throws BaseException {
		if (this.readProductosProveedores) {
			ObjetoLogico.cargarListaFromBD(productosProveedor, ProductoProveedor.getProductosProveedor(this.getClasificador_entidad(), this, this.getSesion()));
			readProductosProveedores = false;
		}
		return productosProveedor;
	}
	
	public List getSeguimientosStock() throws BaseException {
		if (this.readSeguiStock) {
			ObjetoLogico.cargarListaFromBD(seguiStock, SeguimientoStock.getSeguimientosStock(this,this.getSesion()));
			readSeguiStock = false;
		}
		return seguiStock;
	}
	
	public List getConceptosImpuestos() throws BaseException {
		if (this.readConcImpu) {
			ObjetoLogico.cargarListaFromBD(conceptosImpuestos, ConceptoImpuestoProducto.getConceptosImpuestos(this,this.getSesion()));
			readConcImpu = false;
		}
		return conceptosImpuestos;
	}
	
	

	public List getCostosProductosGeneral() throws BaseException {
		if (this.readCostosProductosGral) {
			ObjetoLogico.cargarListaFromBD(costosProductoGral, CostoProductoGral.getCostosProductosGral(this.getClasificador_entidad(),this, this.getSesion()));
			readCostosProductosGral = false;
		}
		return costosProductoGral;
	}

	public List getConfiguacionesPorLP() throws BaseException {
		if (this.readConfiguracionPorLP) {
			ObjetoLogico.cargarListaFromBD(configuracionPorLP, ConfProdGralPorLP.getConfProdPorValorClasif(this, this.getSesion()));
			readConfiguracionPorLP = false;
		}
		return configuracionPorLP;
	}

	public List getFactoresConvUM() throws BaseException {
		if (this.readFactConvUM) {
			ObjetoLogico.cargarListaFromBD(factConvUM, FactConvProdGral.getFactoresConv(this, this.getSesion()));			
			readFactConvUM = false;
		}
		return factConvUM;
	}

	public void addProductoProveedor(ProductoProveedor aProductoProveedor)
			throws BaseException {
		aProductoProveedor.setValClasifProdGeneral(this);
		aProductoProveedor.setClasifProdGeneral(this.getClasificador_entidad());
		productosProveedor.add(aProductoProveedor);
	}
	
	public void addConceptoImpuesto(ConceptoImpuestoProducto aConceptoImpuestoProducto)
	throws BaseException {
		aConceptoImpuestoProducto.setValClasifEnt(this);
		conceptosImpuestos.add(aConceptoImpuestoProducto);
	}
	
	
	public void addSeguimientoStock(SeguimientoStock aSeguimientoStock)
	throws BaseException {
		aSeguimientoStock.setValClasifEnt(this);
		seguiStock.add(aSeguimientoStock);
	}
	

	public void addCostoProductoGral(CostoProductoGral aCostoProductoGral)
			throws BaseException {
		aCostoProductoGral.setVal_clasif_ent(this);
		aCostoProductoGral.setClasificador(this.getClasificador_entidad());
		costosProductoGral.add(aCostoProductoGral);
	}

	public void addConfPorLP(ConfProdGralPorLP aConfProdGralPorLP)
			throws BaseException {
		aConfProdGralPorLP.setValor_clasif_ent(this);
		aConfProdGralPorLP.setClasificador(this.getClasificador_entidad());
		configuracionPorLP.add(aConfProdGralPorLP);
	}
	
	public void addPreciosLista(PrecioPorEstrucLP aPrecioPorEstrucLP) {
		aPrecioPorEstrucLP.setValor_clasif_art2(this);
		preciosLista.add(aPrecioPorEstrucLP);
	}
	
	public void addProducto(Producto aProducto)
	throws BaseException {
		aProducto.addOidValorClasif(aProducto.getClasifProductoGeneral(this.getSesion()).getNroClasif(),this.getOIDInteger());
		productos.add(aProducto);
	}	

	public void addFactConvProdGral(FactConvProdGral aFactConvProdGral)
			throws BaseException {
		aFactConvProdGral.setValClasifEnt(this);
		factConvUM.add(aFactConvProdGral);
	}

	public void afterSave() throws BaseException {

		super.afterSave();
		
		
		
		Iterator iterProductos = productos.iterator();
		while (iterProductos.hasNext()) {
			Producto producto = (Producto) iterProductos.next();
			
			if (this.getExtensionProdGen()!=null) {
				this.getExtensionProdGen().asignarAProducto(producto);
			}
			
			producto.addOidValorClasif(producto.getClasifProductoGeneral(this.getSesion()).getNroClasif(),this.getOIDInteger());
			
			producto.save();
			producto = null;
		}
		iterProductos = null;
		
		
		
		Iterator iterProdProv = getProductosProveedor().iterator();
		while (iterProdProv.hasNext()) {
			ProductoProveedor productoProveedor = (ProductoProveedor) iterProdProv
					.next();
			productoProveedor.save();
			productoProveedor = null;
		}
		iterProdProv = null;
		
		

		Iterator iterCostosProdGral = getCostosProductosGeneral().iterator();
		while (iterCostosProdGral.hasNext()) {
			CostoProductoGral costoProductoGeneral = (CostoProductoGral) iterCostosProdGral
					.next();
			costoProductoGeneral.save();
			costoProductoGeneral = null;
		}
		iterCostosProdGral = null;

	
		
		Iterator iterPreciosLista = this.preciosLista.iterator();
		while (iterPreciosLista.hasNext()) {
			PrecioPorEstrucLP precioPorEstrucLP =
				(PrecioPorEstrucLP) (iterPreciosLista.next());
			precioPorEstrucLP.save();
		}
		
		
		Iterator iterConfProdGralPorLP = this.getConfiguacionesPorLP().iterator();
		while (iterConfProdGralPorLP.hasNext()) {
			ConfProdGralPorLP confProdGralPorLP = (ConfProdGralPorLP) iterConfProdGralPorLP
					.next();
			confProdGralPorLP.save();
			confProdGralPorLP = null;
		}
		iterConfProdGralPorLP = null;
		
		Iterator iterFactConvProdGral = getFactoresConvUM().iterator();
		while (iterFactConvProdGral.hasNext()) {
			FactConvProdGral factConvProdGral = (FactConvProdGral) iterFactConvProdGral
					.next();
			factConvProdGral.save();
			factConvProdGral = null;
		}
		iterFactConvProdGral = null;
				
		Iterator iterSeguiStock = getSeguimientosStock().iterator();
		while (iterSeguiStock.hasNext()) {
			SeguimientoStock seguiStock = (SeguimientoStock) iterSeguiStock.next();
			seguiStock.save();
			seguiStock = null;
		}
		iterSeguiStock = null;		
		
		
		
		Iterator iterConcImpu = this.getConceptosImpuestos().iterator();
		while (iterConcImpu.hasNext()) {
			ConceptoImpuestoProducto concImpuProd = (ConceptoImpuestoProducto) iterConcImpu.next();
			concImpuProd.save();
			concImpuProd = null;
		}
		iterConcImpu = null;
		
		

		// Grabar el Concepto General
		/*
		 * if (extensionProdGen!=null) {
		 * extensionProdGen.setValor_clasif_ent(this);
		 * extensionProdGen.setClasificador(this.getClasificador_entidad());
		 * extensionProdGen.save(); }
		 */

	}

	public ExtensionProdGen getExtensionProdGen() throws BaseException {
		this.supportRefresh();
		return this.extensionProdGen;
	}

	public void setExtensionProdGen(ExtensionProdGen extensionProdGen) {
		this.extensionProdGen = extensionProdGen;
	}

	public static ValorClasifEntProdGen findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (ValorClasifEntProdGen) getObjectByOidProxy(NICKNAME, oid,
				aSesion);
	}

	public CostoProductoGral getCostoProductoAFecha(java.util.Date fecha)
			throws BaseException {
		return CostoProductoGral.getCostoProductoByFecha(fecha, this, this
				.getSesion());
	}

	public Money getCostoConvAUMVta(Money costo, Money cantCosto,
			UnidadMedida umCosto, Money cantPV, UnidadMedida umVenta)
			throws BaseException {

		ExtensionProdGen extProdGral = ExtensionProdGen.getExtensionProdGral(
				this, this.getSesion());

		return CostoProductoGral.getCostoConvAUMVta(extProdGral, costo,
				cantCosto, umCosto, cantPV, umVenta, this.getSesion());

	}

	public List getProductos() throws BaseException {
		if (this.readProductos) {
			List listaProductos = Producto.getProductosByValorClasificador(
					this, this.getSesion());
			productos.addAll(listaProductos);
			readProductos = false;
		}
		return productos;
	}
	
	public String getNickName() {
		return NICKNAME;
	}
	
	public CostoProductoGral getCostoVigenteAFecha(java.util.Date fecha) throws BaseException {
		return CostoProductoGral.getCostoProductoVigenteAFecha(fecha, this, this.getSesion());
	}
	
	public static List getAllValoresClasifProdGrales(ISesion aSesion)
	throws BaseException {
		return DBValorClasificadorEntidad.getAllValoresClasifProdGrales(aSesion); 
	}
	
	public CostoProductoGral calcNuevoCosto(
			java.util.Date fechaDesde,
			java.util.Date fechaHasta,
			java.util.Date fechaCosto) throws BaseException {
		
		if (this.getExtensionProdGen()==null) return null;
		if (this.getExtensionProdGen().getFormaCalcCosto()==null) return null;
		
		CostoProductoGral costo = 
			getCostoSegunFormCalc(
					this.getExtensionProdGen().getFormaCalcCosto(),
					fechaDesde,
					fechaHasta,
					fechaCosto);
		
		return costo;
	}
	
	public Precio getPrecioUltimaFactProv(Proveedor proveedor,java.util.Date fecha) throws BaseException {
		Precio precio = null;
		List listaDetFactProv = ComproProvInfRecOC.getComproProvProdGralMasCercaAFecha(proveedor,fecha,this,
				getSesion());
		Iterator iterDetalles = listaDetFactProv.iterator();
		while (iterDetalles.hasNext()) {
			ComproProvInfRecOC comproProvInfRecOC = (ComproProvInfRecOC) iterDetalles.next();
			precio = new Precio();
			
			precio.setMoneda(comproProvInfRecOC.getComprobante_proveedorBase().getMoneda());
			precio.setImporte(new Money(comproProvInfRecOC.getImpo_det_factura()));
			precio.setPorcDto1(new Porcentaje(0));
			precio.setPorcDto2(new Porcentaje(0));
			precio.setPorcDto3(new Porcentaje(0));
			precio.setEnCascada(new Boolean(false));
			precio.setCantidad(new Money(1));
			
			UnidadMedida um = null;
			if (comproProvInfRecOC.getOrdenDeCompraDet()!=null)
				um = comproProvInfRecOC.getOrdenDeCompraDet().getUnidad_compra();
			
			if (um == null)
				um = this.getExtensionProdGen().getUMCompra();
			
			precio.setUm(um);
			precio.setFecVigencia(comproProvInfRecOC.getComprobante_proveedorBase().getEmision());
			
			precio.setFuente("Compro Prov.  "
					+ comproProvInfRecOC.getComprobante_proveedorBase().getCodigo()+" "
					+ " fecha "
					+ Fecha
							.getddmmyyyy(comproProvInfRecOC.getComprobante_proveedorBase().getEmision()
									));

			return precio;
		}
		return precio;
	}
	
	
	public Precio getPrecioUltimaOC(Proveedor proveedor,java.util.Date fecha) throws BaseException {
		Precio precio = null;
		List listaDetOC = OrdenDeCompraDet.getDetallesByProvProdGralMasCercaAFecha(fecha,proveedor,this,
				getSesion());
		Iterator iterDetalles = listaDetOC.iterator();
		while (iterDetalles.hasNext()) {
			OrdenDeCompraDet ocDet = (OrdenDeCompraDet) iterDetalles.next();
			precio = new Precio();
			precio.setMoneda(ocDet.getMoneda());
			precio.setImporte(new Money(ocDet.getPrecio().doubleValue()));
			precio.setPorcDto1(new Porcentaje(ocDet.getDto1().doubleValue()));
			precio.setPorcDto2(new Porcentaje(ocDet.getDto2().doubleValue()));
			precio.setPorcDto3(new Porcentaje(ocDet.getDto3().doubleValue()));
			precio.setEnCascada(ocDet.isEnCascada().booleanValue());
			precio.setCantidad(new Money(1));
			precio.setUm(ocDet.getUnidad_compra());
			precio.setFecVigencia(ocDet.getOrden_de_compra().getEmision());
			
			precio.setFuente("O.C. "
					+ ocDet.getOrden_de_compra().getNroExt()
					+ " fecha "
					+ Fecha
							.getddmmyyyy(ocDet.getOrden_de_compra()
									.getEmision()));

			return precio;
		}
		return precio;
	}
	
	
	
	private CostoProductoGral getCostoSegunUltimaCompra(			
			java.util.Date fechaDesde,
			java.util.Date fechaHasta,
			java.util.Date fechaCosto) throws BaseException {
		
		if (this.getExtensionProdGen() == null)
			return null;
		
		Precio precio = getPrecioUltimaOC(
				this.getExtensionProdGen().getProveedorCosto(),
				fechaHasta);
		
		if (precio == null) return null;
		
		
		CostoProductoGral costo = getCostoProductoAFecha(fechaCosto);
		if (costo == null)
			costo = (CostoProductoGral) CostoProductoGral.getNew(
					CostoProductoGral.NICKNAME, 
					this.getSesion());
		
		costo.setVal_clasif_ent(this);
		costo.setClasificador(this.getClasificador_entidad());
		costo.setFec_ult_costo(fechaCosto);
		costo.setMoneda(precio.getMoneda());
		costo.setCantidad(precio.getCantidad());
		costo.setUm(precio.getUm());
		costo.setActivo(new Boolean(true));
		costo.setFecVigencia(costo.getFecVigencia());
		costo.setCosto(precio.getImporte());
		
		return costo;
		
	}
	
	private CostoProductoGral getCostoSegunUltimaFactProv(			
			java.util.Date fechaDesde,
			java.util.Date fechaHasta,
			java.util.Date fechaCosto) throws BaseException {
		
		if (this.getExtensionProdGen() == null)
			return null;
		
		Precio precio = getPrecioUltimaFactProv(
				this.getExtensionProdGen().getProveedorCosto(),
				fechaHasta);
		
		if (precio == null) return null;
		
		
		CostoProductoGral costo = getCostoProductoAFecha(fechaCosto);
		if (costo == null)
			costo = (CostoProductoGral) CostoProductoGral.getNew(
					CostoProductoGral.NICKNAME, 
					this.getSesion());
		
		costo.setVal_clasif_ent(this);
		costo.setClasificador(this.getClasificador_entidad());
		costo.setFec_ult_costo(fechaCosto);
		costo.setMoneda(precio.getMoneda());
		costo.setCantidad(precio.getCantidad());
		costo.setUm(precio.getUm());
		costo.setActivo(new Boolean(true));
		costo.setFecVigencia(costo.getFecVigencia());
		costo.setCosto(precio.getImporte());
		
		return costo;
		
	}
	
	private CostoProductoGral getCostoSegunFactProv_LPAcuerdoProv(			
			java.util.Date fechaDesde,
			java.util.Date fechaHasta,
			java.util.Date fechaCosto) throws BaseException {
		
		CostoProductoGral costoLP =
			getCostoSegunLPAcuerdoProveedor(fechaDesde,fechaHasta,fechaCosto);
		
		CostoProductoGral costoFactProv =
			getCostoSegunFactProv_LPAcuerdoProv(fechaDesde,fechaHasta,fechaCosto);

		
		if ((costoLP!=null) && (costoFactProv!=null)) {
			if (costoLP.getFecVigencia().before(costoFactProv.getFecVigencia()))
				return costoFactProv;
			else
				return costoLP; 
		} 
		else 
		if (costoLP!=null)
			return costoLP;
		else 
		if (costoFactProv!=null)
			return costoFactProv;
		
		return null;
		
	}
	
	
	
	private CostoProductoGral getCostoSegunUltimaCompra_LPAcuerdoProv(			
			java.util.Date fechaDesde,
			java.util.Date fechaHasta,
			java.util.Date fechaCosto) throws BaseException {
		
		CostoProductoGral costoLP =
			getCostoSegunLPAcuerdoProveedor(fechaDesde,fechaHasta,fechaCosto);
		
		CostoProductoGral costoUltCompra =
			getCostoSegunUltimaCompra(fechaDesde,fechaHasta,fechaCosto);
		
		if ((costoLP!=null) && (costoUltCompra!=null) && (costoLP.getFecVigencia()!=null) && (costoUltCompra.getFecVigencia()!=null)) {
			if (costoLP.getFecVigencia().before(costoUltCompra.getFecVigencia()))
				return costoUltCompra;
			else
				return costoLP; 
		} 
		else 
		if (costoLP!=null)
			return costoLP;
		else 
		if (costoUltCompra!=null)
			return costoUltCompra;
		
		return null;
		
	}
	
	
	
	private CostoProductoGral getCostoSegunLPAcuerdoProveedor(			
			java.util.Date fechaDesde,
			java.util.Date fechaHasta,
			java.util.Date fechaCosto) throws BaseException {
		
		Precio precio = getPrecioLP(
				this.getExtensionProdGen().getProveedorCosto(),
				fechaHasta,
				TipoAcuerdo.ACUERDO);
		
		if (precio == null) 
			precio = getPrecioLP(
					this.getExtensionProdGen().getProveedorCosto(),
					fechaHasta,
					TipoAcuerdo.LISTA_PRECIOS);
		
		if (precio == null) return null;
		
		
		CostoProductoGral costo = getCostoProductoAFecha(fechaCosto);
		if (costo == null)
			costo = (CostoProductoGral) CostoProductoGral.getNew(
					CostoProductoGral.NICKNAME, 
					this.getSesion());
		
		costo.setVal_clasif_ent(this);
		costo.setClasificador(this.getClasificador_entidad());
		costo.setFec_ult_costo(fechaCosto);
		costo.setMoneda(precio.getMoneda());
		costo.setCantidad(precio.getCantidad());
		costo.setUm(precio.getUm());
		costo.setActivo(new Boolean(true));
		costo.setFecVigencia(precio.getFecVigencia());
		costo.setCosto(precio.getImporte());
		
		return costo;
		
	}
	
	private CostoProductoGral getCostoSegunFormCalc(
			String formaCalculo,
			java.util.Date fechaDesde,
			java.util.Date fechaHasta,
			java.util.Date fechaCosto) throws BaseException {
		
		if (formaCalculo == null) return null;
		if (this.getExtensionProdGen()==null) return null;
		
		if (FormaCalcCosto.isListaAcuerdoProveedor(formaCalculo)) 
			return getCostoSegunLPAcuerdoProveedor(fechaDesde,fechaHasta,fechaCosto);
		else
		if (FormaCalcCosto.isPrecioUltimaCompra(formaCalculo)) 
			return getCostoSegunUltimaCompra(fechaDesde,fechaHasta,fechaCosto);
		if (FormaCalcCosto.isPrecioUltimaCompra_ListaAcuerdoProv(formaCalculo)) 
			return getCostoSegunUltimaCompra_LPAcuerdoProv(fechaDesde,fechaHasta,fechaCosto);		
		if (FormaCalcCosto.isFacturaProveedor(formaCalculo)) 
			return getCostoSegunUltimaFactProv(fechaDesde,fechaHasta,fechaCosto);		
		if (FormaCalcCosto.isFacturaProveedorLPAcuerdoProv(formaCalculo)) 
			return getCostoSegunFactProv_LPAcuerdoProv(fechaDesde,fechaHasta,fechaCosto);		
		
		return null;
	}
			
	public Precio getPrecioLP(Proveedor proveedor, java.util.Date fecha , String tipoAcuerdo)
	throws BaseException {

		PrecioCompraPorClasifArt precioCompra =
			PrecioCompraPorClasifArt.getPrecioCompraVigAFecha(
					this,
					proveedor,
					fecha,
					tipoAcuerdo,
					this.getSesion());
		
		if (precioCompra == null) return null;
		
		
		
		Precio precio = null;
		if (precioCompra != null) {
			precio = new Precio();
			precio.setMoneda(precioCompra.getMoneda());
			precio.setImporte(precioCompra.getPrecioUnitario());
			precio.setPorcDto1(new Porcentaje(0));
			precio.setPorcDto2(new Porcentaje(0));
			precio.setPorcDto3(new Porcentaje(0));
			precio.setEnCascada(false);
			precio.setUm(precioCompra.getUnidad_medida());
			precio.setCantidad(new Money(1));
			precio.setFuente(precioCompra.getAcuerdo_lp().getDescripcion());
			precio.setFecVigencia(precioCompra.getFechaVigencia());
			
		}

		return precio;
		
	}
	
	public Precio getPrecioSinIVA(ListaPrecios listaPrecios,java.util.Date fecha) throws BaseException {
		
		PrecioPorEstrucLP precioPorEstrucLP =
			PrecioPorEstrucLP.getPrecioEstrucLPBYClasificadores(listaPrecios, this, this.getSesion());
		
		if (precioPorEstrucLP == null)
			return null;
		
		if (listaPrecios.isIncluyeIVA()==false) {
			Precio precio = new Precio();
			precio.setMoneda(precioPorEstrucLP.getMoneda());
			precio.setImporte(new Money(precioPorEstrucLP.getPrecio()));
			precio.setIncluyeIVA(false);
			precio.setCantidad(new Money(precioPorEstrucLP.getCantidad()));
			precio.setUm(precioPorEstrucLP.getUnidad_medida());
			return precio;
		}
		
		ConceptoImpuestoProducto concimpuProd =
			ConceptoImpuestoProducto.getConcImpuProdGralIVA(
					this,
					fecha,
					this.getSesion());
		
		if (concimpuProd == null) {
			// Asumo que el producto no tiene IVA
			Precio precio = new Precio();
			precio.setMoneda(precioPorEstrucLP.getMoneda());
			precio.setImporte(new Money(precioPorEstrucLP.getPrecio()));
			precio.setIncluyeIVA(false);
			precio.setCantidad(new Money(precioPorEstrucLP.getCantidad()));
			precio.setUm(precioPorEstrucLP.getUnidad_medida());
			return precio;
			
		}
				
		ConceptoImpuesto concImpIVA = concimpuProd.getConcepto_impuesto();
		Money precioSinIVA = concImpIVA.getPrecioSinIVA(fecha, new Money(precioPorEstrucLP.getPrecio()));
		
		if (precioSinIVA!=null) {
			Precio precio = new Precio();
			precio.setMoneda(precioPorEstrucLP.getMoneda());
			precio.setImporte(precioSinIVA);
			precio.setIncluyeIVA(false);
			precio.setCantidad(new Money(precioPorEstrucLP.getCantidad()));
			precio.setUm(precioPorEstrucLP.getUnidad_medida());
			return precio;
		}

		return null;
	}

	public ConceptoImpuestoProducto getConcImpuProdImpInt(
			java.util.Date fecha) throws BaseException {

		ConceptoImpuestoProducto concimpuProd =
			ConceptoImpuestoProducto.getConcImpuProdGralImpInt(
					this,
					fecha,
					this.getSesion());
		
		return concimpuProd;
		
	}
	

	public ConceptoImpuestoProducto getConcImpuProdPercIB(
			java.util.Date fecha) throws BaseException {

		ConceptoImpuestoProducto concimpuProd =
			ConceptoImpuestoProducto.getConcImpuProdGralPercIB(
					this,
					fecha,
					this.getSesion());
		
		return concimpuProd;
		
	}
	
	public ConceptoImpuestoProducto getConcImpuIVAProdVigAFecha(
			java.util.Date fecha) throws BaseException {

		ConceptoImpuestoProducto concimpuProd =
			ConceptoImpuestoProducto.getConcImpuProdGralIVA(
					this,
					fecha,
					this.getSesion());
		
		return concimpuProd;
		
	}
	
	public ConceptoImpuestoProducto getConcImpuPercIVAProdVigAFecha(
			java.util.Date fecha) throws BaseException {

		ConceptoImpuestoProducto concimpuProd =
			ConceptoImpuestoProducto.getConcImpuProdGralPercIVA(
					this,
					fecha,
					this.getSesion());
		
		return concimpuProd;
		
	}
	
	
	public Precio getPrecioSinIVA(PrecioPorEstrucLP precioPorEstrucLP,java.util.Date fecha) throws BaseException {
		
		if (precioPorEstrucLP == null)
			return null;
		
		if (precioPorEstrucLP.getLista_precios().isIncluyeIVA()==false) {
			Precio precio = new Precio();
			precio.setMoneda(precioPorEstrucLP.getMoneda());
			precio.setImporte(new Money(precioPorEstrucLP.getPrecio()));
			precio.setIncluyeIVA(false);
			precio.setCantidad(new Money(precioPorEstrucLP.getCantidad()));
			precio.setUm(precioPorEstrucLP.getUnidad_medida());
			return precio;
		}
		
		ConceptoImpuestoProducto concimpuProd =
			ConceptoImpuestoProducto.getConcImpuProdGralIVA(
					this,
					fecha,
					this.getSesion());
		
		if (concimpuProd == null) {
			// Asumo que el producto no tiene IVA
			Precio precio = new Precio();
			precio.setMoneda(precioPorEstrucLP.getMoneda());
			precio.setImporte(new Money(precioPorEstrucLP.getPrecio()));
			precio.setIncluyeIVA(false);
			precio.setCantidad(new Money(precioPorEstrucLP.getCantidad()));
			precio.setUm(precioPorEstrucLP.getUnidad_medida());
			return precio;
			
		}
				
		ConceptoImpuesto concImpIVA = concimpuProd.getConcepto_impuesto();
		Money precioSinIVA = concImpIVA.getPrecioSinIVA(fecha, new Money(precioPorEstrucLP.getPrecio()));
		
		if (precioSinIVA!=null) {
			Precio precio = new Precio();
			precio.setMoneda(precioPorEstrucLP.getMoneda());
			precio.setImporte(precioSinIVA);
			precio.setIncluyeIVA(false);
			precio.setCantidad(new Money(precioPorEstrucLP.getCantidad()));
			precio.setUm(precioPorEstrucLP.getUnidad_medida());
			return precio;
		}

		return null;
	}
	
	public Precio getPrecioConIVA(PrecioPorEstrucLP precioPorEstrucLP,java.util.Date fecha) throws BaseException {
		
		if (precioPorEstrucLP == null)
			return null;
		
		if (precioPorEstrucLP.getLista_precios().isIncluyeIVA()==true) {
			Precio precio = new Precio();
			precio.setMoneda(precioPorEstrucLP.getMoneda());
			precio.setImporte(new Money(precioPorEstrucLP.getPrecio()));
			precio.setIncluyeIVA(true);
			precio.setCantidad(new Money(precioPorEstrucLP.getCantidad()));
			precio.setUm(precioPorEstrucLP.getUnidad_medida());
			return precio;
		}
		
		ConceptoImpuestoProducto concimpuProd =
			ConceptoImpuestoProducto.getConcImpuProdGralIVA(
					this,
					fecha,
					this.getSesion());
		
		if (concimpuProd == null) {
			// Asumo que el producto no tiene IVA
			Precio precio = new Precio();
			precio.setMoneda(precioPorEstrucLP.getMoneda());
			precio.setImporte(new Money(precioPorEstrucLP.getPrecio()));
			precio.setIncluyeIVA(false);
			precio.setCantidad(new Money(precioPorEstrucLP.getCantidad()));
			precio.setUm(precioPorEstrucLP.getUnidad_medida());
			return precio;
			
		}
		
		
				
		ConceptoImpuesto concImpIVA = concimpuProd.getConcepto_impuesto();
		Money montoIVA = concImpIVA.getImpuestoIVA(fecha, new Money(precioPorEstrucLP.getPrecio()));
		
		CalculadorMoney precioConIVA = new CalculadorMoney(new Money(precioPorEstrucLP.getPrecio()));
		if (montoIVA!=null)
			precioConIVA.sumar(montoIVA);
				
		if (precioConIVA!=null) {
			Precio precio = new Precio();
			precio.setMoneda(precioPorEstrucLP.getMoneda());
			precio.setImporte(precioConIVA.getResultMoney());
			precio.setIncluyeIVA(true);
			precio.setCantidad(new Money(precioPorEstrucLP.getCantidad()));
			precio.setUm(precioPorEstrucLP.getUnidad_medida());
			return precio;
		}

		return null;
	}
	
	
	

}
