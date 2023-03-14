package com.srn.erp.ctasAPagar.bm;

import java.util.List;

import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.da.DBComproProvInfRecOC;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class ComproProvInfRecOC extends ObjetoLogico {

	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();

		grabarPorInfRecep();

		grabarPorOrdCpra();

	}

	private void grabarPorOrdCpra() throws BaseException {

		// Restar de la orden de compra las cantidades facturadas
		if (this.getOrdenDeCompraDet() != null) {
			Proveedor proveedor = this.getOrdenDeCompraDet().getOrden_de_compra().getProveedor();
			Money cantFactUS = getProducto().getConvertirUM(proveedor, getCant_facturada(), this.getOrdenDeCompraDet().getUnidad_compra(),
					this.getOrdenDeCompraDet().getProducto().getUm_stk());
			// Aplicar las cantidades faturadas
			this.getOrdenDeCompraDet().aplicarCantFacturadas(getCant_facturada(), cantFactUS.doubleValue());
			this.getOrdenDeCompraDet().save();
		}

	}

	private void grabarPorInfRecep() throws BaseException {

		// Obtener la cantidad en Unidades de Stock
		if (getInforme_rec_det() != null) {
			Proveedor proveedor = getInforme_rec_det().getInforme_recepcion().getProveedor();
			Money cantFactUS = getProducto().getConvertirUM(proveedor, getCant_facturada(), getInforme_rec_det().getUnidadMedidaCompra(),
					getInforme_rec_det().getUnidadMedidaStock());
			// Aplicar las cantidades faturadas
			getInforme_rec_det().aplicarCantFacturadas(getCant_facturada(), cantFactUS.doubleValue());
			getInforme_rec_det().save();
		}

	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ComproProvInfRecOC() {
	}

	public static String NICKNAME = "cap.ComproProvInfRecOC";

	private ComproProveedorBase comprobante_proveedorBase;
	private Producto producto;
	private InformeRecepcionDet Informe_rec_det;
	private Double cant_facturada;
	private Double precio_factura;
	private Double precio_oc;
	private Moneda moneda_oc;
	private Double impo_det_factura;
	private Boolean activo;
	private OrdenDeCompraDet ocDet;
	private Double cantValorizada;

	public ComproProveedorBase getComprobante_proveedorBase() throws BaseException {
		supportRefresh();
		return comprobante_proveedorBase;
	}

	public void setComprobante_proveedorBase(ComproProveedorBase aComprobante_proveedorBase) {
		this.comprobante_proveedorBase = aComprobante_proveedorBase;
	}

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public OrdenDeCompraDet getOrdenDeCompraDet() throws BaseException {
		supportRefresh();
		return this.ocDet;
	}

	public void setCantValorizada(Double aCantValorizada) {
		this.cantValorizada = aCantValorizada;
	}

	public Double getCantValorizada() throws BaseException {
		supportRefresh();
		return this.cantValorizada;
	}

	public void setOrdenDeCompraDet(OrdenDeCompraDet aOCDet) {
		this.ocDet = aOCDet;
	}

	public InformeRecepcionDet getInforme_rec_det() throws BaseException {
		supportRefresh();
		return Informe_rec_det;
	}

	public void setInforme_rec_det(InformeRecepcionDet aInforme_rec_det) {
		this.Informe_rec_det = aInforme_rec_det;
	}

	public Double getCant_facturada() throws BaseException {
		supportRefresh();
		return cant_facturada;
	}

	public void setCant_facturada(Double aCant_facturada) {
		this.cant_facturada = aCant_facturada;
	}

	public Double getPrecio_factura() throws BaseException {
		supportRefresh();
		return precio_factura;
	}

	public void setPrecio_factura(Double aPrecio_factura) {
		this.precio_factura = aPrecio_factura;
	}

	public Double getPrecio_oc() throws BaseException {
		supportRefresh();
		return precio_oc;
	}

	public void setPrecio_oc(Double aPrecio_oc) {
		this.precio_oc = aPrecio_oc;
	}

	public Moneda getMoneda_oc() throws BaseException {
		supportRefresh();
		return moneda_oc;
	}

	public void setMoneda_oc(Moneda aMoneda_oc) {
		this.moneda_oc = aMoneda_oc;
	}

	public Double getImpo_det_factura() throws BaseException {
		supportRefresh();
		return impo_det_factura;
	}

	public void setImpo_det_factura(Double aImpo_det_factura) {
		this.impo_det_factura = aImpo_det_factura;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ComproProvInfRecOC findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ComproProvInfRecOC) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ComproProvInfRecOC findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ComproProvInfRecOC) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ComproProvInfRecOC findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ComproProvInfRecOC) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(comprobante_proveedorBase, "Debe ingresar el Comprobante Proveedor");
		Validar.noNulo(producto, "Debe ingresar el Producto");
		Validar.noNulo(cant_facturada, "Debe ingresar la Cant. Facturada");
		Validar.noNulo(precio_factura, "Debe ingresar el Precio");
		Validar.noNulo(impo_det_factura, "Debe ingresar el Importe");
	}

	public static List getComproProvInfRecOCDet(ComproProveedorBase comproProveedorBase, ISesion aSesion) throws BaseException {
		return DBComproProvInfRecOC.getComproProvInfRecOCDet(comproProveedorBase, aSesion);
	}

	public static List getComproProvProdGralMasCercaAFecha(Proveedor proveedor, java.util.Date fecha, ValorClasificadorEntidad valorClasif,
			ISesion aSesion) throws BaseException {

		return DBComproProvInfRecOC.getComproProvProdGralMasCercaAFecha(proveedor, fecha, valorClasif, aSesion);

	}

	public static List getComproProvProductoOCDetActivo(OrdenDeCompraDet ocDet, ISesion aSesion) throws BaseException {
		return DBComproProvInfRecOC.getComproProvProductoOCDetActivo(ocDet, aSesion);
	}

}
