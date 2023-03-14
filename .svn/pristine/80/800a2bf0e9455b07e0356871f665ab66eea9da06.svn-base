package com.srn.erp.compras.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.da.DBAcuerdoLP;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class AcuerdoLP extends ObjetoLogico {

	private List preciosCompraClasifArt = new ArrayList();
	private boolean readPreciosCompraClasifArt = true;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		this.supportRefresh();
		return descripcion;
	}

	public AcuerdoLP() {
	}

	public static String NICKNAME = "cp.AcuerdoLP";

	private TipoAcuerdo Tipo_acuerdo;

	private String descripcion;

	private Proveedor proveedor;

	private Boolean activo;

	private List condicionesPago = new ArrayList();

	private boolean readCondicionesPago = true;

	private List acuerdosDet = new ArrayList();

	private boolean readAcuerdosDet = true;

	public TipoAcuerdo getTipo_acuerdo() throws BaseException {
		supportRefresh();
		return Tipo_acuerdo;
	}

	public void setDescripcion(String aDescripcion) throws BaseException {
		if (aDescripcion!=null) {
			if (aDescripcion.length()>50)
				this.descripcion = aDescripcion.substring(1,50);
			else
				this.descripcion = aDescripcion;
		}
		else
			this.descripcion = aDescripcion;
	}

	public void setTipo_acuerdo(TipoAcuerdo aTipo_acuerdo) {
		this.Tipo_acuerdo = aTipo_acuerdo;
	}

	public Proveedor getProveedor() throws BaseException {
		supportRefresh();
		return proveedor;
	}

	public void setProveedor(Proveedor aProveedor) {
		this.proveedor = aProveedor;
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

	public static AcuerdoLP findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AcuerdoLP) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AcuerdoLP findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AcuerdoLP) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static AcuerdoLP findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AcuerdoLP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(Tipo_acuerdo, "Debe ingresar el Tipo de Acuerdo");
		Validar.noNulo(proveedor, "Debe ingresar el Proveedor");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

	public static List getAcuerdosLP(Proveedor proveedor, TipoAcuerdo tipoAcuerdo, ISesion aSesion) throws BaseException {
		return DBAcuerdoLP.getAcuerdosLP(proveedor, tipoAcuerdo, aSesion);
	}

	public List getCondPagoAcuerdo() throws BaseException {
		if (readCondicionesPago) {
			List listaCondicionesPago = AcuerdoLPCondPago.getAcuerdosLPCondPago(this, getSesion());
			condicionesPago.addAll(listaCondicionesPago);
			readCondicionesPago = false;
		}
		return condicionesPago;
	}

	public List getAcuerdosLPDetalles() throws BaseException {
		if (readAcuerdosDet) {
			List listaAcuerdosLPDetalles = AcuerdoLPDetalle.getAcuerdosLPDetalles(this, getSesion());
			acuerdosDet.addAll(listaAcuerdosLPDetalles);
			readAcuerdosDet = false;
		}
		return acuerdosDet;
	}

	public void addCondPagoDto(AcuerdoLPCondPago aAcuerdoLPCondPago) throws BaseException {
		aAcuerdoLPCondPago.setAcuerdolp(this);
		condicionesPago.add(aAcuerdoLPCondPago);
	}

	public void addAcuerdoLPDetalle(AcuerdoLPDetalle aAcuerdoLPDetalle) throws BaseException {
		aAcuerdoLPDetalle.setAcuerdo_lp(this);
		acuerdosDet.add(aAcuerdoLPDetalle);
	}

	public void afterSave() throws BaseException {

		Iterator iterCondPago = condicionesPago.iterator();
		while (iterCondPago.hasNext()) {
			AcuerdoLPCondPago acuerdoLPCondPago = (AcuerdoLPCondPago) iterCondPago.next();
			acuerdoLPCondPago.save();
			acuerdoLPCondPago = null;
		}
		iterCondPago = null;

		Iterator iterCondAcuerdosLP = acuerdosDet.iterator();
		while (iterCondAcuerdosLP.hasNext()) {
			AcuerdoLPDetalle acuerdoLPDetalle = (AcuerdoLPDetalle) iterCondAcuerdosLP.next();
			acuerdoLPDetalle.save();
			acuerdoLPDetalle = null;
		}
		iterCondPago = null;

		Iterator iterPreciosClasifArt = this.preciosCompraClasifArt.iterator();
		while (iterPreciosClasifArt.hasNext()) {
			PrecioCompraPorClasifArt precio = (PrecioCompraPorClasifArt) iterPreciosClasifArt.next();
			precio.save();
			precio = null;
		}
		iterPreciosClasifArt = null;

	}

	public static List getAcuerdosLP(Proveedor proveedor, String tipoAcuerdo, java.util.Date fecha, ISesion aSesion) throws BaseException {
		return DBAcuerdoLP.getAcuerdosLP(proveedor, tipoAcuerdo, fecha, aSesion);
	}

	public AcuerdoLPDetalle getAcuerdosLPDetalle(Producto producto, ISesion aSesion) throws BaseException {
		AcuerdoLPDetalle acuerdoLPDetalleVigente = null;
		Iterator iterAcuerdosDetalles = AcuerdoLPDetalle.getAcuerdosLPDetalles(this, producto, getSesion()).iterator();
		while (iterAcuerdosDetalles.hasNext()) {
			AcuerdoLPDetalle acuerdoLPDetalle = (AcuerdoLPDetalle) iterAcuerdosDetalles.next();
			if (acuerdoLPDetalle.isActivo().booleanValue()) {
				acuerdoLPDetalleVigente = acuerdoLPDetalle;
				break;
			}
		}
		/*
		 * if (acuerdoLPDetalleVigente == null) throw new
		 * ExceptionValidation(null,
		 * "No se pudo encontra precio para el producto " + producto.getCodigo()
		 * + " - " + producto.getDescripcion() + " en la LP " +
		 * this.getDescripcion() );
		 */
		return acuerdoLPDetalleVigente;

	}

	public List getPreciosCompraPorClasifArt() throws BaseException {
		if (this.readPreciosCompraClasifArt) {
			List listaPreciosCompra = PrecioCompraPorClasifArt.getPreciosClasifArt(this, getSesion());
			this.preciosCompraClasifArt.addAll(listaPreciosCompra);
			this.readPreciosCompraClasifArt = false;
		}
		return preciosCompraClasifArt;
	}

	public List getPreciosVigentesAFecha(java.util.Date fecha, String descripcion, String codigo,
			ValorClasifEntProdGen valorClasifEntProdGen, HashTableDatos listaValoresClasif) throws BaseException {
		return PrecioCompraPorClasifArt.getPreciosClasifArtVigentesAFecha(this, fecha, descripcion, codigo, valorClasifEntProdGen,
				listaValoresClasif, getSesion());
	}

	public void addPrecioCompraClasifArt(PrecioCompraPorClasifArt precioCompraClasifArt) throws BaseException {
		precioCompraClasifArt.setAcuerdo_lp(this);
		preciosCompraClasifArt.add(precioCompraClasifArt);
	}

	public void addPrecioClasifArt(ClasificadorEntidad clasificador, ValorClasifEntProdGen valorClasifEnt, Money cantidad,
			UnidadMedida uniMed, Money precio, Moneda moneda, Boolean activo, java.util.Date fechaVigencia) throws BaseException {

		PrecioCompraPorClasifArt precioCompraClasif = PrecioCompraPorClasifArt.getPrecioCompraAFecha(this.getOIDInteger(), valorClasifEnt,
				fechaVigencia, this.getSesion());

		if (precioCompraClasif == null)
			precioCompraClasif = (PrecioCompraPorClasifArt) PrecioCompraPorClasifArt.getNew(PrecioCompraPorClasifArt.NICKNAME, this
					.getSesion());

		precioCompraClasif.setActivo(activo);
		precioCompraClasif.setAcuerdo_lp(this);
		precioCompraClasif.setClasificador(clasificador);
		precioCompraClasif.setValor_clasif_art(valorClasifEnt);
		precioCompraClasif.setUnidad_medida(uniMed);
		precioCompraClasif.setCantidad(cantidad);
		precioCompraClasif.setPrecio(precio);
		precioCompraClasif.setMoneda(moneda);
		precioCompraClasif.setFecVigencia(fechaVigencia);

		if ((activo.booleanValue() == false) && (!precioCompraClasif.isNew()))
			precioCompraClasif.delete();

		if (!(this.isNew() && (precioCompraClasif.isActivo() == false)))
			this.addPrecioCompraClasifArt(precioCompraClasif);

	}

	public void addPrecioClasifArt(PrecioCompraPorClasifArt aPrecioCompraClasif) throws BaseException {

		if (aPrecioCompraClasif.isActivo() == false)
			aPrecioCompraClasif.delete();

		this.addPrecioCompraClasifArt(aPrecioCompraClasif);

	}

	public PrecioCompraPorClasifArt getPrecioCompraVigenteAFecha(ValorClasificadorEntidad valClasifEnt, java.util.Date fecha)
			throws BaseException {

		return PrecioCompraPorClasifArt.getPrecioCompraVigenteAFecha(this.getOIDInteger(), valClasifEnt, fecha, this.getSesion());
	}

	public PrecioCompraPorClasifArt getProximoPrecioCompraPostAFecha(ValorClasificadorEntidad valClasifEnt, java.util.Date fecha)
			throws BaseException {

		return PrecioCompraPorClasifArt.getProximoPrecioCompraPostAFecha(this.getOIDInteger(), valClasifEnt, fecha, this.getSesion());
	}

	public static AcuerdoLP getAcuedoProveedor(Proveedor proveedor, ISesion aSesion) throws BaseException {
		return DBAcuerdoLP.getAcuedoProveedor(proveedor, aSesion);
	}

	public static AcuerdoLP getListaDePreciosProveedor(Proveedor proveedor, ISesion aSesion) throws BaseException {
		return DBAcuerdoLP.getListaDePreciosProveedor(proveedor, aSesion);
	}

	public static AcuerdoLP getAcuerdoLP(Proveedor proveedor, TipoAcuerdo tipoAcuerdo, ISesion aSesion) throws BaseException {
		return DBAcuerdoLP.getAcuerdoLP(proveedor, tipoAcuerdo, aSesion);
	}

	public static List getAcuerdosLPByValClasifEntProd(ValorClasifEntProdGen valorClasifEntProdGral, ISesion aSesion) throws BaseException {
		return DBAcuerdoLP.getAcuerdosLPByValClasifEntProd(valorClasifEntProdGral, aSesion);
	}

}
