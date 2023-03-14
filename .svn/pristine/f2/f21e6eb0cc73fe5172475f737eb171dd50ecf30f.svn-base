package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBPrecioCompraPorClasifArt;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.ProductoProveedor;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class PrecioCompraPorClasifArt extends ObjetoLogico {

	private void altaProductoProveedor() throws BaseException {
		
		ProductoProveedor productoProveedor = (ProductoProveedor)ProductoProveedor.getNew(ProductoProveedor.NICKNAME, this.getSesion());
		productoProveedor.setProducto(null);
		productoProveedor.setProveedor(this.getAcuerdo_lp().getProveedor());
		productoProveedor.setCod_prod_prov(null);
		productoProveedor.setUmcpra(this.getUnidad_medida());
		productoProveedor.setLote_minimo(null);
		productoProveedor.setMultiplo(null);
		productoProveedor.setLt_ent_dias(null);
		productoProveedor.setPrioridadCompra(1);
		productoProveedor.setClasifProdGeneral(this.getClasificador());
		productoProveedor.setValClasifProdGeneral(this.getValor_clasif_art());
		productoProveedor.setTipoAcuerdo(this.getAcuerdo_lp().getTipo_acuerdo());
		productoProveedor.setNoGrabarPrecioPorClasifArt(true);
		productoProveedor.save();
		
		this.setProductoProveedor(productoProveedor);
		
		
	}

	@Override
	protected void beforeSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.beforeSaveNew();
		if (this.getProductoProveedor()==null)
			altaProductoProveedor();
	}

	@Override
	public void afterSaveModified() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveModified();
		if (this.getProductoProveedor()==null)
			altaProductoProveedor();
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public PrecioCompraPorClasifArt() {
	}

	public static String NICKNAME = "cp.PrecioCompraPorClasifArt";

	private AcuerdoLP acuerdo_lp;
	private ValorClasifEntProdGen valor_clasif_art;
	private ClasificadorEntidad clasificador;
	private UnidadMedida unidad_medida;
	private Money cantidad;
	private Money precio;
	private Moneda moneda;
	private Boolean activo;
	private java.util.Date fec_vigencia;
	private ProductoProveedor productoProveedor;

	public ProductoProveedor getProductoProveedor() throws BaseException {
		supportRefresh();
		return this.productoProveedor;
	}

	public void setProductoProveedor(ProductoProveedor aProductoProveedor) {
		this.productoProveedor = aProductoProveedor;
	}

	public AcuerdoLP getAcuerdo_lp() throws BaseException {
		supportRefresh();
		return acuerdo_lp;
	}

	public void setAcuerdo_lp(AcuerdoLP aAcuerdo_lp) {
		this.acuerdo_lp = aAcuerdo_lp;
	}

	public java.util.Date getFechaVigencia() throws BaseException {
		supportRefresh();
		return this.fec_vigencia;
	}

	public void setFecVigencia(java.util.Date aFecVigencia) {
		this.fec_vigencia = aFecVigencia;
	}

	public ValorClasifEntProdGen getValor_clasif_art() throws BaseException {
		supportRefresh();
		return valor_clasif_art;
	}

	public void setValor_clasif_art(ValorClasifEntProdGen aValor_clasif_art) {
		this.valor_clasif_art = aValor_clasif_art;
	}

	public ClasificadorEntidad getClasificador() throws BaseException {
		supportRefresh();
		return clasificador;
	}

	public void setClasificador(ClasificadorEntidad aClasificador) {
		this.clasificador = aClasificador;
	}

	public UnidadMedida getUnidad_medida() throws BaseException {
		supportRefresh();
		return unidad_medida;
	}

	public void setUnidad_medida(UnidadMedida aUnidad_medida) {
		this.unidad_medida = aUnidad_medida;
	}

	public Money getCantidad() throws BaseException {
		supportRefresh();
		return cantidad;
	}

	public void setCantidad(Money aCantidad) {
		this.cantidad = aCantidad;
	}

	public Money getPrecio() throws BaseException {
		supportRefresh();
		return precio;
	}

	public void setPrecio(Money aPrecio) {
		this.precio = aPrecio;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
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

	public static PrecioCompraPorClasifArt findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PrecioCompraPorClasifArt) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PrecioCompraPorClasifArt findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PrecioCompraPorClasifArt) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(acuerdo_lp, "Debe ingresar el Acuerdo de Precios");
		Validar.noNulo(valor_clasif_art, "Debe ingresar el Valor del Clasificador");
		Validar.noNulo(clasificador, "Debe ingresar el clasificador");
		Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
		Validar.noNulo(cantidad, "Debe ingresar la Cantidad");
		Validar.noNulo(precio, "Debe ingresar el precio");
		Validar.noNulo(moneda, "Debe ingresar la Moneda");
		Validar.noNulo(fec_vigencia, "Debe ingresar la Fecha de Vigencia");
	}

	public static List getPreciosClasifArt(AcuerdoLP acuerdoLP, ISesion aSesion) throws BaseException {
		return DBPrecioCompraPorClasifArt.getPreciosClasifArt(acuerdoLP, aSesion);
	}

	public Money getPrecioUnitario() throws BaseException {
		if (this.getPrecio() == null)
			return new Money(0);
		CalculadorMoney calcPrecioUnitario = new CalculadorMoney(this.getPrecio());
		if (this.getCantidad().doubleValue() > 0)
			calcPrecioUnitario.dividirPor(this.getCantidad());
		return calcPrecioUnitario.getResultMoney();
	}

	public static List getPreciosClasifArtVigentesAFecha(AcuerdoLP acuerdoLP, java.util.Date fecha, String descripcion, String codigo,
			ValorClasifEntProdGen valorClasifEntProdGen, HashTableDatos listaValoresClasif, ISesion aSesion) throws BaseException {
		return DBPrecioCompraPorClasifArt.getPreciosClasifArtVigentesAFecha(acuerdoLP, fecha, descripcion, codigo, valorClasifEntProdGen,
				listaValoresClasif, aSesion);
	}

	public static List getPreciosCompraPorClasifArt(Integer oidAcuerdo, ValorClasificadorEntidad valClasifEnt, ISesion aSesion)
			throws BaseException {

		return DBPrecioCompraPorClasifArt.getPrecioCompraPorClasifArt(oidAcuerdo, valClasifEnt.getClasificador_entidad(), valClasifEnt,
				aSesion);

	}

	public static PrecioCompraPorClasifArt getPrecioCompraVigenteAFecha(Integer oidAcuerdo, ValorClasificadorEntidad valClasifEnt,
			java.util.Date fecha, ISesion aSesion) throws BaseException {

		return DBPrecioCompraPorClasifArt.getPrecioCompraVigenteAFecha(oidAcuerdo, valClasifEnt, fecha, aSesion);
	}

	public static PrecioCompraPorClasifArt getPrecioCompraAFecha(Integer oidAcuerdo, ValorClasificadorEntidad valClasifEnt,
			java.util.Date fecha, ISesion aSesion) throws BaseException {

		return DBPrecioCompraPorClasifArt.getPrecioCompraAFecha(oidAcuerdo, valClasifEnt, fecha, aSesion);

	}

	public static PrecioCompraPorClasifArt getProximoPrecioCompraPostAFecha(Integer oidAcuerdo, ValorClasificadorEntidad valClasifEnt,
			java.util.Date fecha, ISesion aSesion) throws BaseException {

		PrecioCompraPorClasifArt precioCompra = null;

		List listaPreciosCompra = DBPrecioCompraPorClasifArt.getProximoPrecioCompraPostAFecha(oidAcuerdo, valClasifEnt, fecha, aSesion);

		if (listaPreciosCompra.size() > 0)
			precioCompra = (PrecioCompraPorClasifArt) listaPreciosCompra.get(0);

		return precioCompra;

	}

	public static PrecioCompraPorClasifArt getPrecioCompraVigAFecha(ValorClasificadorEntidad valClasifEnt, Proveedor proveedor,
			java.util.Date fecha, String tipoAcuerdo, ISesion aSesion) throws BaseException {

		return DBPrecioCompraPorClasifArt.getPrecioCompraVigAFecha(valClasifEnt, proveedor, fecha, tipoAcuerdo, aSesion);
	}

	public static List getPreciosDeCompraByValClasif(ValorClasificadorEntidad valClasifEnt, ISesion aSesion) throws BaseException {
		return PrecioCompraPorClasifArt.getPreciosDeCompraByValClasif(valClasifEnt, aSesion);
	}

	public static PrecioCompraPorClasifArt getPrecioClasifArtVigentesAFecha(AcuerdoLP acuerdoLP,
			ValorClasifEntProdGen valorClasifEntProdGen, ISesion aSesion) throws BaseException {
		return DBPrecioCompraPorClasifArt.getPreciosClasifArtVigentesAFecha(acuerdoLP, valorClasifEntProdGen, aSesion);
	}

	public static PrecioCompraPorClasifArt getPrecioCompraPorClasifArt(ProductoProveedor productoProveedor, ISesion aSesion)
			throws BaseException {
		return DBPrecioCompraPorClasifArt.getPrecioCompraPorClasifArt(productoProveedor, aSesion);
	}
	
	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return DBPrecioCompraPorClasifArt.getAllActivos(aSesion);
	}
	

}
