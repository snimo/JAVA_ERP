package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.AcuerdoLP;
import com.srn.erp.compras.bm.PrecioCompraPorClasifArt;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.TipoAcuerdo;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.da.DBProductoProveedor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class ProductoProveedor extends ObjetoLogico {

	public ProductoProveedor() {
	}

	private boolean noGrabarPrecioPorClasifArt;

	public boolean isNoGrabarPrecioPorClasifArt() {
		return noGrabarPrecioPorClasifArt;
	}

	public void setNoGrabarPrecioPorClasifArt(boolean noGrabarPrecioPorClasifArt) {
		this.noGrabarPrecioPorClasifArt = noGrabarPrecioPorClasifArt;
	}

	public static String NICKNAME = "st.ProductoProveedor";

	private Producto producto;

	private Proveedor proveedor;

	private String cod_prod_prov;

	private UnidadMedida umCpra;

	private Money lote_minimo;

	private Money multiplo;

	private Integer lt_ent_dias;

	private Integer prioridad;

	private Moneda moneda;

	private Money costo;

	private java.util.Date fecVig;

	private Boolean activo;

	private List factoresConvProveedor = new ArrayList();

	private boolean readFactoresConvProv = true;

	private ClasificadorEntidad clasifProductoGeneral;

	private ValorClasificadorEntidad valClasifProdGral;

	private TipoAcuerdo tipoAcuerdo;

	private PrecioCompraPorClasifArt precioCompraPorClasifArt;

	public TipoAcuerdo getTipoAcuerdo() throws BaseException {
		supportRefresh();
		return this.tipoAcuerdo;
	}

	public void setTipoAcuerdo(TipoAcuerdo aTipoAcuerdo) {
		this.tipoAcuerdo = aTipoAcuerdo;
	}

	public java.util.Date getFecVig() throws BaseException {
		supportRefresh();
		return this.fecVig;
	}

	public void setFecVig(java.util.Date aFecVig) {
		this.fecVig = aFecVig;
	}

	public ClasificadorEntidad getClasifProdGeneral() throws BaseException {
		supportRefresh();
		return this.clasifProductoGeneral;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public Moneda getMoneda() throws BaseException {
		return this.moneda;
	}

	public void setCosto(Money aCosto) {
		this.costo = aCosto;
	}

	public Money getCosto() throws BaseException {
		return this.costo;
	}

	public void setClasifProdGeneral(ClasificadorEntidad aClasifProdGral) {
		this.clasifProductoGeneral = aClasifProdGral;
	}

	public ValorClasificadorEntidad getValClasifProdGeneral() throws BaseException {
		supportRefresh();
		return this.valClasifProdGral;
	}

	public void setValClasifProdGeneral(ValorClasificadorEntidad aValClasifProdGral) {
		this.valClasifProdGral = aValClasifProdGral;
	}

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public Proveedor getProveedor() throws BaseException {
		supportRefresh();
		return proveedor;
	}

	public void setProveedor(Proveedor aProveedor) {
		this.proveedor = aProveedor;
	}

	public Integer getPrioridadCompra() throws BaseException {
		supportRefresh();
		return this.prioridad;
	}

	public void setPrioridadCompra(Integer aPrioridadCompra) {
		this.prioridad = aPrioridadCompra;
	}

	public String getCod_prod_prov() throws BaseException {
		supportRefresh();
		return cod_prod_prov;
	}

	public void setCod_prod_prov(String aCod_prod_prov) {
		this.cod_prod_prov = aCod_prod_prov;
	}

	public UnidadMedida getUmcpra() throws BaseException {
		supportRefresh();
		return umCpra;
	}

	public void setUmcpra(UnidadMedida aUmcpra) {
		this.umCpra = aUmcpra;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public Money getLote_minimo() throws BaseException {
		supportRefresh();
		return lote_minimo;
	}

	public void setLote_minimo(Money aLote_minimo) {
		this.lote_minimo = aLote_minimo;
	}

	public Money getMultiplo() throws BaseException {
		supportRefresh();
		return multiplo;
	}

	public void setMultiplo(Money aMultiplo) {
		this.multiplo = aMultiplo;
	}

	public Integer getLt_ent_dias() throws BaseException {
		supportRefresh();
		return lt_ent_dias;
	}

	public void setLt_ent_dias(Integer aLt_ent_dias) {
		this.lt_ent_dias = aLt_ent_dias;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ProductoProveedor findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ProductoProveedor) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ProductoProveedor findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ProductoProveedor) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ProductoProveedor findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ProductoProveedor) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(proveedor, "Debe ingresar el proveedor");
		if ((producto == null) && (this.valClasifProdGral == null))
			throw new ExceptionValidation(null, "Debe ingresar el producto");
		Validar.noNulo(umCpra, "Debe ingresar la Unidad de Medida de Compra");
		Validar.noNulo(tipoAcuerdo, "Debe ingresar el Tipo de Acuerdo");
	}

	/**
	 * isActivo
	 * 
	 * @return Boolean
	 */
	public Boolean isActivo() {
		return this.activo;
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public String getCodigo() {
		return "";
	}

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() {
		return "";
	}

	public static List getProductosProveedor(Producto producto, ISesion aSesion) throws BaseException {
		return DBProductoProveedor.getProductosProveedor(producto, aSesion);
	}

	public static ProductoProveedor getProductoProveedor(Producto producto, Proveedor proveedor, String codProdProv, UnidadMedida uniMed,
			ISesion aSesion) throws BaseException {
		return DBProductoProveedor.getProductoProveedor(producto, proveedor, codProdProv, uniMed, aSesion);
	}

	public List getFactoresConversionProv() throws BaseException {
		if (readFactoresConvProv) {
			List listaFactConvProv = FactorConversionProveedor.getFactoresConversion(this, getSesion());
			factoresConvProveedor.addAll(listaFactConvProv);
			readFactoresConvProv = false;
		}
		return factoresConvProveedor;
	}

	public void addFactorConversionProveedor(FactorConversionProveedor aFactorConversionProveedor) throws BaseException {
		aFactorConversionProveedor.setProducto_proveedor(this);
		factoresConvProveedor.add(aFactorConversionProveedor);
	}

	public void afterSave() throws BaseException {

		if ((this.getValClasifProdGeneral() != null) && (isNoGrabarPrecioPorClasifArt()==false)) {

			AcuerdoLP acuerdoLP = AcuerdoLP.getAcuerdoLP(this.getProveedor(), this.getTipoAcuerdo(), this.getSesion());
			if (acuerdoLP == null) {
				acuerdoLP = (AcuerdoLP) AcuerdoLP.getNew(AcuerdoLP.NICKNAME, this.getSesion());
				acuerdoLP.setTipo_acuerdo(this.getTipoAcuerdo());
				acuerdoLP.setProveedor(this.getProveedor());
				if ((this.getTipoAcuerdo() != null) && (this.getProveedor() != null))
					acuerdoLP.setDescripcion(this.getTipoAcuerdo().getDescripcion() + " " + this.getProveedor().getRazonsocial());
				else
					acuerdoLP.setDescripcion("Lista / Acuerdo de Precios");
				acuerdoLP.setActivo(true);
				acuerdoLP.save();
			}

			if (acuerdoLP != null) {

				if ((this.getCosto() != null) && ((this.getMoneda() == null) || (this.getFecVig() == null))) {
					if (this.getMoneda() == null)
						throw new ExceptionValidation(null, "Debe ingresar la Moneda");
					if (this.getFecVig() == null)
						throw new ExceptionValidation(null, "Debe ingresar la Fecha de Vigencia");
				}

				if ((this.getMoneda() != null) && ((this.getCosto() == null) || (this.getFecVig() == null))) {
					if (this.getCosto() == null)
						throw new ExceptionValidation(null, "Debe ingresar el Costo");
					if (this.getFecVig() == null)
						throw new ExceptionValidation(null, "Debe ingresar la Fecha de Vigencia");
				}

				if ((this.getFecVig() != null) && ((this.getMoneda() == null) || (this.getCosto() == null))) {
					if (this.getMoneda() == null)
						throw new ExceptionValidation(null, "Debe ingresar la Moneda");
					if (this.getCosto() == null)
						throw new ExceptionValidation(null, "Debe ingresar el Costo");
				}
			}

			if ((acuerdoLP != null) && (this.getCosto() != null) && (this.getMoneda() != null) && (this.getFecVig() != null)) {

				// PrecioCompraPorClasifArt precioCompraPorClasifArt =
				// PrecioCompraPorClasifArt.getPrecioCompraAFecha(acuerdoLP
				// .getOIDInteger(), this.getValClasifProdGeneral(),
				// this.getFecVig(), this.getSesion());

				PrecioCompraPorClasifArt precioCompraPorClasifArt = PrecioCompraPorClasifArt.getPrecioCompraPorClasifArt(this, this
						.getSesion());

				if (precioCompraPorClasifArt == null)
					PrecioCompraPorClasifArt.getPrecioCompraAFecha(acuerdoLP.getOIDInteger(), this.getValClasifProdGeneral(), this
							.getFecVig(), this.getSesion());

				if (precioCompraPorClasifArt != null) {
					precioCompraPorClasifArt.setPrecio(this.getCosto());
					precioCompraPorClasifArt.setMoneda(this.getMoneda());
					precioCompraPorClasifArt.setFecVigencia(this.getFecVig());
					precioCompraPorClasifArt.setActivo(this.isActivo());
					if (!precioCompraPorClasifArt.isActivo())
						precioCompraPorClasifArt.delete();
					precioCompraPorClasifArt.setProductoProveedor(this);
					precioCompraPorClasifArt.save();

				} else {
					precioCompraPorClasifArt = (PrecioCompraPorClasifArt) PrecioCompraPorClasifArt.getNew(
							PrecioCompraPorClasifArt.NICKNAME, this.getSesion());
					precioCompraPorClasifArt.setProductoProveedor(this);
					precioCompraPorClasifArt.setAcuerdo_lp(acuerdoLP);
					ValorClasifEntProdGen valClasif = ValorClasifEntProdGen.findByOid(this.getValClasifProdGeneral().getOIDInteger(), this
							.getSesion());
					precioCompraPorClasifArt.setValor_clasif_art(valClasif);
					precioCompraPorClasifArt.setClasificador(this.getClasifProdGeneral());
					precioCompraPorClasifArt.setUnidad_medida(this.getUmcpra());
					precioCompraPorClasifArt.setCantidad(new Money(1));
					precioCompraPorClasifArt.setPrecio(this.getCosto());
					precioCompraPorClasifArt.setMoneda(this.getMoneda());
					precioCompraPorClasifArt.setActivo(this.isActivo());
					precioCompraPorClasifArt.setFecVigencia(this.getFecVig());
					precioCompraPorClasifArt.setActivo(true);
					precioCompraPorClasifArt.save();
				}

			}

		}

		Iterator iterFactConvProv = factoresConvProveedor.iterator();
		while (iterFactConvProv.hasNext()) {
			FactorConversionProveedor factConvProv = (FactorConversionProveedor) iterFactConvProv.next();
			factConvProv.save();
			factConvProv = null;
		}
		iterFactConvProv = null;

		/*
		
		if (this.getValClasifProdGeneral() != null) {
			ValorClasifEntProdGen valClasifEntProdGral = ValorClasifEntProdGen.findByOid(this.getValClasifProdGeneral().getOIDInteger(),
					this.getSesion());

			if (valClasifEntProdGral != null) {
				Iterator iterProductos = valClasifEntProdGral.getProductos().iterator();
				while (iterProductos.hasNext()) {
					Producto producto = (Producto) iterProductos.next();

					ProductoProveedor productoProveedor = producto.getProductoProveedor(this.getProveedor());
					if (productoProveedor == null)
						productoProveedor = (ProductoProveedor) ProductoProveedor.getNew(ProductoProveedor.NICKNAME, this.getSesion());
					productoProveedor.setProducto(producto);
					productoProveedor.setProveedor(this.getProveedor());
					productoProveedor.setCod_prod_prov(this.getCod_prod_prov());
					productoProveedor.setUmcpra(this.getUmcpra());
					productoProveedor.setLote_minimo(this.getLote_minimo());
					productoProveedor.setMultiplo(this.getMultiplo());
					productoProveedor.setLt_ent_dias(this.getLt_ent_dias());
					productoProveedor.setPrioridadCompra(this.getPrioridadCompra());
					productoProveedor.setTipoAcuerdo(this.getTipoAcuerdo());
					productoProveedor.setClasifProdGeneral(null);
					productoProveedor.setValClasifProdGeneral(null);
					productoProveedor.save();

				}
			}
		}*/

	}

	public PrecioCompraPorClasifArt getPrecioCompraPorClasifArt() {
		return precioCompraPorClasifArt;
	}

	public void setPrecioCompraPorClasifArt(PrecioCompraPorClasifArt precioCompraPorClasifArt) {
		this.precioCompraPorClasifArt = precioCompraPorClasifArt;
	}

	public static List getProductosProveedor(Producto producto, Proveedor proveedor, ISesion aSesion) throws BaseException {
		return DBProductoProveedor.getProductosProveedor(producto, proveedor, aSesion);
	}

	public static List getProductosProveedor(ClasificadorEntidad clasificadorEntidad, ValorClasificadorEntidad valClasifEnt, ISesion aSesion)
			throws BaseException {
		return DBProductoProveedor.getProductosProveedor(clasificadorEntidad, valClasifEnt, aSesion);
	}

	@Override
	public void afterSaveDelete() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveDelete();
		
		/*

		if (this.getValClasifProdGeneral() != null) {

			ValorClasifEntProdGen valClasifEntProdGral = ValorClasifEntProdGen.findByOid(this.getValClasifProdGeneral().getOIDInteger(),
					this.getSesion());

			if (valClasifEntProdGral != null) {
				Iterator iterProductos = valClasifEntProdGral.getProductos().iterator();
				while (iterProductos.hasNext()) {
					Producto producto = (Producto) iterProductos.next();

					ProductoProveedor productoProveedor = producto.getProductoProveedor(this.getProveedor());
					if (productoProveedor != null) {
						productoProveedor.delete();
						productoProveedor.save();
					}

				}
			}

		}*/

	}

	public static ProductoProveedor getProveedorMenorPrioridad(Producto producto, ISesion aSesion) throws BaseException {
		return DBProductoProveedor.getProveedorMenorPrioridad(producto, aSesion);
	}

	public void beforeSaveDelete() throws BaseException {
		// TODO Auto-generated method stub
		super.beforeSaveDelete();

		if (this.getPrecioCompraPorClasifArt() != null) {
			this.getPrecioCompraPorClasifArt().setActivo(false);
			this.getPrecioCompraPorClasifArt().delete();
			this.getPrecioCompraPorClasifArt().save();
		}

		// Si encuentra el acuerdo de precios borrarlo

	}

}
