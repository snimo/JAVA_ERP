package com.srn.erp.ctasAPagar.bm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.da.DBComproProveedorBase;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.CotizacionesConta;
import com.srn.erp.general.bm.IdentificacionTipoComprobante;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoCambio;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class ComproProveedorBase extends ComproCab {

	protected void beforeSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.beforeSaveNew();

		
		// Si se trata de un anticipo proveedor
		if (IdentificacionTipoComprobante.esAnticipoProveedor(this
				.getTipoCompro().getIdentificacion())) {
			this.setAnticipoPagado(new Boolean(false));
			this.setSaldoAnticipoProveedor(this.getTotMonedaOri());
		}
		
		this.setSigno(this.getSignoLibroIVA());
		this.setEsEstadistica(getEstadisticaComproProv());

	}

	public ComproProveedorBase() {
	}

	public static String NICKNAME = "cap.ComproProveedorBase";

	private boolean isPagoContado = false;

	private java.util.Date imputacion;

	private Proveedor proveedor;

	private Money totMonedaOri;

	private Money totMonedaLoc;

	private Moneda moneda;
	
	private TipoCtaCteProv tipoCtaCteProv;

	private java.util.Date fecBase;

	private Money maxMontoAutOri;

	private Boolean autorizada;

	private CondicionCompra condPagoCC;

	private CondicionCompra condPagoAlt1;

	private CondicionCompra condPagoAlt2;

	private Money descCondPagoCC;

	private Money descCondPagoAlt1;

	private Money descCondPagoAlt2;

	private Boolean noContaOtrasMonedas;

	private ValorCotizacion cotizacion;

	private TipoCambio tipoCambio;

	private String tipoFactura;

	private ComproCab comprobante;
	
	private Boolean esEstadistica;

	private List detalles = new ArrayList();

	private boolean readDetalle = true;

	private List detallesVtosFijos = new ArrayList();

	private boolean readDetallesVtosFijos = true;

	private List detallesTotImpuestos = new ArrayList();

	private CotizacionesConta cotizacionesConta = null;

	private boolean readDetallesTotImpuestos = true;

	private List detallesOCDetInfRecDet = new ArrayList();

	private boolean readdetallesOCDetInfRecDet = true;

	private Money netoGravadoMonOri;

	private Money netoNoGravadoMonOri;

	private Money netoGravadoMonLoc;

	private Money netoNoGravadoMonLoc;

	private SectorCompra sectorCompra;

	private ValorCotizacion valorCotizExt1;

	private ValorCotizacion valorCotizExt2;

	private Boolean anticipoPagado;

	private Money saldoAnticipoProveedor;
	
	private Integer signo;

	public void setSaldoAnticipoProveedor(Money aSaldoAnticipoProveedor)
			throws BaseException {
		this.saldoAnticipoProveedor = aSaldoAnticipoProveedor;
	}

	public Money getSaldoAnticipoProveedor() throws BaseException {
		this.supportRefresh();
		return this.saldoAnticipoProveedor;
	}

	public void setValorCotizExt1(ValorCotizacion aValorotizExt1)
			throws BaseException {
		this.valorCotizExt1 = aValorotizExt1;
	}

	public ValorCotizacion getValorCotizExt1() throws BaseException {
		this.supportRefresh();
		return this.valorCotizExt1;
	}

	public void setValorCotizExt2(ValorCotizacion aValorotizExt2)
			throws BaseException {
		this.valorCotizExt2 = aValorotizExt2;
	}

	public ValorCotizacion getValorCotizExt2() throws BaseException {
		this.supportRefresh();
		return this.valorCotizExt2;
	}

	public void setPagoContado(boolean aPagoContado) throws BaseException {
		this.isPagoContado = aPagoContado;
	}

	public boolean isPagoContado() throws BaseException {
		this.supportRefresh();
		return this.isPagoContado;
	}

	public void setAnticipoPagado(Boolean aAnticipoPagado) throws BaseException {
		this.anticipoPagado = aAnticipoPagado;
	}

	public Boolean isAnticipoPagado() throws BaseException {
		return this.anticipoPagado;
	}

	public Money getNetoGravadoMonOri() throws BaseException {
		supportRefresh();
		return netoGravadoMonOri;
	}

	public void setSectorCompra(SectorCompra aSectorCompra)
			throws BaseException {
		this.sectorCompra = aSectorCompra;
	}

	public SectorCompra getSectorCompra() throws BaseException {
		supportRefresh();
		return this.sectorCompra;
	}
	
	public void setEsEstadistica(Boolean aEsEstadistica)
	throws BaseException {
		this.esEstadistica = aEsEstadistica;
	}

	public Boolean isEstadistica() throws BaseException {
		supportRefresh();
		return this.esEstadistica;
	}
	
	
	public void setSigno(Integer aSigno)
	throws BaseException {
		this.signo = aSigno;
	}

	public Integer getSigno() throws BaseException {
		supportRefresh();
		return this.signo;
	}
	

	public void setNetoGravadoMonOri(Money aNetoGravadoMonOri)
			throws BaseException {
		this.netoGravadoMonOri = aNetoGravadoMonOri;
	}

	public Money getNetoNoGravadoMonOri() throws BaseException {
		supportRefresh();
		return netoNoGravadoMonOri;
	}

	public void setNetoNoGravadoMonOri(Money aNetoNoGravadoMonOri)
			throws BaseException {
		this.netoNoGravadoMonOri = aNetoNoGravadoMonOri;
	}

	public Money getNetoGravadoMonLoc() throws BaseException {
		supportRefresh();
		return netoGravadoMonLoc;
	}

	public void setNetoGravadoMonLoc(Money aNetoGravadoMonLoc)
			throws BaseException {
		this.netoGravadoMonLoc = aNetoGravadoMonLoc;
	}

	public Money getNetoNoGravadoMonLoc() throws BaseException {
		supportRefresh();
		return netoNoGravadoMonLoc;
	}

	public void setNetoNoGravadoMonLoc(Money aNetoNoGravadoMonLoc)
			throws BaseException {
		this.netoNoGravadoMonLoc = aNetoNoGravadoMonLoc;
	}

	public Proveedor getProveedor() throws BaseException {
		supportRefresh();
		return proveedor;
	}

	public java.util.Date getImputacion() throws BaseException {
		return imputacion;
	}

	public void setProveedor(Proveedor aProveedor) {
		this.proveedor = aProveedor;
	}

	public String getTipoFactura() throws BaseException {
		supportRefresh();
		return tipoFactura;
	}

	public void setTipoFactura(String aTipoFactura) {
		this.tipoFactura = aTipoFactura;
	}

	public TipoCtaCteProv getTipoCtaCteProv() throws BaseException {
		supportRefresh();
		return tipoCtaCteProv;
	}

	public void setTipoCtaCteProv(TipoCtaCteProv tipoCtaCteProv)
			throws BaseException {
		this.tipoCtaCteProv = tipoCtaCteProv;
	}

	public ValorCotizacion getCotizacion() throws BaseException {
		supportRefresh();
		return cotizacion;
	}

	public void setCotizazion(ValorCotizacion aValorCotizacion)
			throws BaseException {
		this.cotizacion = aValorCotizacion;
	}

	public void setTipoCambio(TipoCambio tipoCambio) throws BaseException {
		this.tipoCambio = tipoCambio;
	}

	public TipoCambio getTipoCambio() throws BaseException {
		supportRefresh();
		return tipoCambio;
	}

	public void setCotizacion(ValorCotizacion aValorCotizacion) {
		this.cotizacion = aValorCotizacion;
	}

	public java.util.Date getFecImputacion() throws BaseException {
		supportRefresh();
		return imputacion;
	}

	public void setFecImputacion(java.util.Date aFecImputacion) {
		this.imputacion = aFecImputacion;
	}

	public Money getTotMonedaOri() throws BaseException {
		supportRefresh();
		return totMonedaOri;
	}

	public void setTotMonedaOri(Money aTotmonedaori) throws BaseException {
		this.totMonedaOri = aTotmonedaori;
	}

	public Money getTotMonedaLoc() throws BaseException {
		supportRefresh();
		return totMonedaLoc;
	}

	public void setTotMonedaLoc(Money aTotmonedaloc) {
		this.totMonedaLoc = aTotmonedaloc;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public java.util.Date getFecbase() throws BaseException {
		supportRefresh();
		return fecBase;
	}

	public void setFecbase(java.util.Date aFecbase) {
		this.fecBase = aFecbase;
	}

	public Money getMaxMontoAutori() throws BaseException {
		supportRefresh();
		return maxMontoAutOri;
	}

	public void setMaxMontoAutOri(Money aMaxmontoautori) {
		this.maxMontoAutOri = aMaxmontoautori;
	}

	public Boolean isAutorizada() throws BaseException {
		supportRefresh();
		return autorizada;
	}

	public void setAutorizada(Boolean aAutorizada) {
		this.autorizada = aAutorizada;
	}

	public CondicionCompra getCondPagoCC() throws BaseException {
		supportRefresh();
		return condPagoCC;
	}

	public void setCondPagoCC(CondicionCompra aCondpagocc) {
		this.condPagoCC = aCondpagocc;
	}

	public CondicionCompra getCondPagoalt1() throws BaseException {
		supportRefresh();
		return condPagoAlt1;
	}

	public void setCondPagoAlt1(CondicionCompra aCondpagoalt1) {
		this.condPagoAlt1 = aCondpagoalt1;
	}

	public CondicionCompra getCondPagoAlt2() throws BaseException {
		supportRefresh();
		return condPagoAlt2;
	}

	public void setCondpagoAlt2(CondicionCompra aCondpagoalt2) {
		this.condPagoAlt2 = aCondpagoalt2;
	}

	public Money getDescCondPagoCC() throws BaseException {
		supportRefresh();
		return descCondPagoCC;
	}

	public void setDescCondPagoCC(Money aDesccondpagocc) {
		this.descCondPagoCC = aDesccondpagocc;
	}

	public Money getDescCondPagoAlt1() throws BaseException {
		supportRefresh();
		return descCondPagoAlt1;
	}

	public void setDescCondPagoAlt1(Money aDesccondpagoalt1) {
		this.descCondPagoAlt1 = aDesccondpagoalt1;
	}

	public Money getDescCondPagoAlt2() throws BaseException {
		supportRefresh();
		return descCondPagoAlt2;
	}

	public Boolean getNoContaOtrasMonedas() throws BaseException {
		supportRefresh();
		return noContaOtrasMonedas;
	}

	public void setNoContaOtrasMonedas(Boolean noContaOtrasMonedas) {
		this.noContaOtrasMonedas = noContaOtrasMonedas;
	}

	public void setDescCondPagoAlt2(Money aDesccondpagoalt2) {
		this.descCondPagoAlt2 = aDesccondpagoalt2;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ComproProveedorBase findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ComproProveedorBase) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ComproProveedorBase findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (ComproProveedorBase) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public ComproCab getComprobante() throws BaseException {
		supportRefresh();
		return comprobante;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	private void validarTotalComprobante() throws BaseException {
		CalculadorMoney totComprobante = new CalculadorMoney(
				getTotalConceptos());
		totComprobante.sumar(getTotalImpuestos());
		if (totComprobante.getResultMoney().doubleValue() != getTotMonedaOri()
				.doubleValue())
			throw new ExceptionValidation(
					null,
					"No coincide el Importe Total de los impuestos del Comprobante con el detalle cargado de los mismos");
	}

	private void validarCabeceraComproProv() throws BaseException {
		Validar.noNulo(getTipoCompro(), "Debe ingresar el Tipo de Comprobante");
		Validar.noNulo(getLetra(), "Debe ingresar la Letra del Comprobante");
		Validar.noNulo(getNroExt(),
				"Debe ingresar el Nro. Externo del Comprobante");
		Validar.noNulo(getEmision(), "Debe ingresar la Fecha de Emisión");
		Validar.noNulo(getFecImputacion(),
				"Debe ingresar la Fecha de Imputación");
		Validar.noNulo(getProveedor(), "Debe ingresar el Proveedor");
		Validar.noNulo(getTipoCtaCteProv(), "Debe ingresar el Tipo de Cuenta");
		Validar.noNulo(getTotMonedaOri(),
				"Debe ingresar el Importe del Comprobante");
		if (getTotMonedaOri().doubleValue() <= 0)
			throw new ExceptionValidation(null,
					"El importe del Comprobante debe ser mayor a cero");
		Validar.noNulo(getMoneda(), "Debe ingresar la moneda del Comprobante");
		Validar.noNulo(getCotizacion(), "Debe ingresar la Cotización");
		Validar.noNulo(getFecbase(), "Debe ingresar la Fecha Base");
		Validar.noNulo(getCondPagoCC(),
				"Debe ingresar la condición de Pago Principal");
	}

	public List getImpuestosRetencionGan() throws BaseException {
		List listaImpuestosRetencionesGan = new ArrayList();
		Iterator iterDetalles = getDetalles().iterator();
		while (iterDetalles.hasNext()) {
			ComproProveedorDet comproProveedorDet = (ComproProveedorDet) iterDetalles
					.next();
			if (comproProveedorDet.getImpoMonedaOri().doubleValue() == 0)
				continue;
			Iterator iterImpuRet = comproProveedorDet
					.getImpuestosRetencionesGan().iterator();
			while (iterImpuRet.hasNext()) {
				ConceptoImpuesto conceptoImpuesto = (ConceptoImpuesto) iterImpuRet
						.next();
				if (!listaImpuestosRetencionesGan.contains(conceptoImpuesto))
					listaImpuestosRetencionesGan.add(conceptoImpuesto);
			}
		}
		return listaImpuestosRetencionesGan;
	}

	private void validarCargaDeImputaciones() throws BaseException {
		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			ComproProveedorDet comproProveedorDet = (ComproProveedorDet) iterDetalles
					.next();
			if (comproProveedorDet.getImpoMonedaOri() == null)
				continue;

			CalculadorMoney calcDifTotImputaciones = new CalculadorMoney(
					comproProveedorDet.getImpoMonedaOri());
			Iterator iterImputacionesConcepto = comproProveedorDet
					.getDetalleImputacionesConc().iterator();
			while (iterImputacionesConcepto.hasNext()) {
				ComproProvDetCtaImpu detImputacion = (ComproProvDetCtaImpu) iterImputacionesConcepto
						.next();
				if (detImputacion.getCuentaimputable() == null)
					throw new ExceptionValidation(null,
							"Debe ingresar la Imputación Contable");
				if (detImputacion.getImporte() == null)
					throw new ExceptionValidation(null,
							"Debe ingresar el importe de la imputación "
									+ detImputacion.getCuentaimputable()
											.getDescripcion()
									+ " del concepto "
									+ comproProveedorDet.getConcFactProv()
											.getDescripcion());
				calcDifTotImputaciones.restar(new Money(detImputacion
						.getImporte().doubleValue()));
			}
			if (calcDifTotImputaciones.getResultMoney().doubleValue() != 0)
				throw new ExceptionValidation(null, "En el concepto "
						+ comproProveedorDet.getComprobanteBase().getCodigo()
						+ " el importe no coincide con el detalle imputaciones");

		}
	}

	public void beforeSave() throws BaseException {

		validarCabeceraComproProv();
		validarCargaDeImputaciones();
		validarTotalComprobante();

		beforeSaveComprobante(this);
		if (this.isNew()) {

			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);

			// Validar que el comprobante no exista
			ComproProveedorBase comproProvBase = ComproProveedorBase
					.getComproProveedor(this.getTipoCompro(), this.getLetra(),
							this.getNroLugEmision(), this.getNroExt(),
							proveedor, this.getSesion());
			if (comproProvBase != null)
				throw new ExceptionValidation(null, "Comprobante de Proveedor "
						+ comproProvBase.getCodigo() + " ya ingresado");

		}

	}

	// Agregar el After Save
	public void afterSave() throws BaseException {

		// Grabar los detalles del Comprobante
		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			ComproProveedorDet comproProveedorDet = (ComproProveedorDet) iterDetalles
					.next();
			comproProveedorDet.save();
			comproProveedorDet = null;
		}
		iterDetalles = null;

		// Grabar las condiciones Fijas
		Iterator iterDetVtosFijo = detallesVtosFijos.iterator();
		while (iterDetVtosFijo.hasNext()) {
			ComproProvVtoFijo comproProvVtoFijo = (ComproProvVtoFijo) iterDetVtosFijo
					.next();
			comproProvVtoFijo.save();
			comproProvVtoFijo = null;
		}
		iterDetVtosFijo = null;

		// Grabar los Impuestos
		Iterator iterTotImpuestos = detallesTotImpuestos.iterator();
		while (iterTotImpuestos.hasNext()) {
			ComproProvTotImpu comproProvTotImpu = (ComproProvTotImpu) iterTotImpuestos
					.next();
			comproProvTotImpu.save();
			comproProvTotImpu = null;
		}
		iterTotImpuestos = null;

		// Grabar los Detalles de los Informes de Recepci{on / Orden de Compra
		Iterator iterDetOCDetInfRecDet = detallesOCDetInfRecDet.iterator();
		while (iterDetOCDetInfRecDet.hasNext()) {
			ComproProvInfRecOC comproProvInfRecOC = (ComproProvInfRecOC) iterDetOCDetInfRecDet
					.next();
			comproProvInfRecOC.save();
			comproProvInfRecOC = null;
		}
		iterDetOCDetInfRecDet = null;

		afterSaveComprobante(this);

	}

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() {
		return "";
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public static EsquemaAutorizFactProv getEsquemaAutorizFactProv(
			ISesion aSesion) throws BaseException {
		ValorParametro valorParamContabilizaComproProv = ValorParametro
				.findByCodigoParametro("ESQUEMA_AUTORIZ_FACT_PROV_DIR", aSesion);
		EsquemaAutorizFactProv esquemaAutorizFactProv = EsquemaAutorizFactProv
				.findByOidProxy(valorParamContabilizaComproProv.getOidObjNeg(),
						aSesion);
		return esquemaAutorizFactProv;
	}

	// Agregar Detalle
	public ComproProveedorDet addDetalle() throws BaseException {
		ComproProveedorDet comproProveedorDet = (ComproProveedorDet) ComproProveedorDet
				.getNew(ComproProveedorDet.NICKNAME, getSesion());
		comproProveedorDet.setComprobante(this);
		detalles.add(comproProveedorDet);
		return comproProveedorDet;
	}

	public Money getTotalConceptos() throws BaseException {
		CalculadorMoney calcTotConceptos = new CalculadorMoney(new Money(0));
		Iterator iterConceptos = detalles.iterator();
		while (iterConceptos.hasNext()) {
			ComproProveedorDet concProvDet = (ComproProveedorDet) iterConceptos
					.next();
			if (concProvDet.getImpoMonedaOri()!=null)
				calcTotConceptos.sumar(concProvDet.getImpoMonedaOri());
		}
		return calcTotConceptos.getResultMoney();
	}

	public ComproProvVtoFijo addComproProvVtoFijo() throws BaseException {
		ComproProvVtoFijo comproProvVtoFijo = (ComproProvVtoFijo) ComproProvVtoFijo
				.getNew(ComproProvVtoFijo.NICKNAME, getSesion());
		comproProvVtoFijo.setComprobante(this);
		detallesVtosFijos.add(comproProvVtoFijo);
		return comproProvVtoFijo;
	}

	public ComproProvInfRecOC addComproProvInfRecOC() throws BaseException {
		ComproProvInfRecOC comproProvInfRecOC = (ComproProvInfRecOC) ComproProvInfRecOC
				.getNew(ComproProvInfRecOC.NICKNAME, getSesion());
		comproProvInfRecOC.setComprobante_proveedorBase(this);
		detallesOCDetInfRecDet.add(comproProvInfRecOC);
		return comproProvInfRecOC;
	}

	public ComproProvTotImpu addComproProvTotImpu() throws BaseException {
		ComproProvTotImpu comproProvTotImpu = (ComproProvTotImpu) ComproProvTotImpu
				.getNew(ComproProvTotImpu.NICKNAME, getSesion());
		comproProvTotImpu.setComprobante(this);
		detallesTotImpuestos.add(comproProvTotImpu);
		return comproProvTotImpu;
	}

	public Money getTotalImpuestos() throws BaseException {
		CalculadorMoney calcTotImpuestos = new CalculadorMoney(new Money(0));
		Iterator iterConceptosImpuestos = detallesTotImpuestos.iterator();
		while (iterConceptosImpuestos.hasNext()) {
			ComproProvTotImpu comproProvTotImpu = (ComproProvTotImpu) iterConceptosImpuestos
					.next();
			calcTotImpuestos.sumar(comproProvTotImpu.getImporteMonedaOri());
		}
		return calcTotImpuestos.getResultMoney();
	}

	protected CotizacionesConta getCotizacionesConta() throws BaseException {
		if (cotizacionesConta == null)
			cotizacionesConta = new CotizacionesConta(getSesion());
		return cotizacionesConta;
	}

	public Hashtable getTotPorConcRetGan() throws BaseException {
		Hashtable totPorConcRetGan = new Hashtable();
		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			ComproProveedorDet comproProveedorDet = (ComproProveedorDet) iterDetalles
					.next();
			Iterator iterConcImpu = comproProveedorDet.getConcFactProv()
					.getConceptosImpuestos().iterator();
			while (iterConcImpu.hasNext()) {
				ConceptoImpuesto concImpu = (ConceptoImpuesto) iterConcImpu
						.next();
				if (concImpu.isRetGanProv())
					acumPorConcRetGan(totPorConcRetGan, concImpu,
							comproProveedorDet.getImpoMonedaLoc());
			}
		}
		return totPorConcRetGan;
	}

	public Money getTotMontoGravadoPorConceptoRetencionMonLocal(
			ConceptoImpuesto conceptoImpuesto) throws BaseException {
		CalculadorMoney totMontoGravado = new CalculadorMoney(new Money(0));
		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			ComproProveedorDet comproProveedorDet = (ComproProveedorDet) iterDetalles
					.next();
			if (comproProveedorDet.aplicaRetencion(conceptoImpuesto))
				totMontoGravado.sumar(comproProveedorDet.getImpoMonedaLoc());
		}
		return totMontoGravado.getResultMoney();
	}

	private void acumPorConcRetGan(Hashtable totalesPorConcRetGab,
			ConceptoImpuesto concImpu, Money netoGravado) throws BaseException {
		boolean found = false;
		Iterator iterConcImpu = totalesPorConcRetGab.keySet().iterator();
		while (iterConcImpu.hasNext()) {
			ConceptoImpuesto concImpuTot = (ConceptoImpuesto) iterConcImpu
					.next();
			if (concImpuTot.getOID() == concImpu.getOID()) {
				found = true;
				Money montoGravadoAcum = (Money) totalesPorConcRetGab
						.get(concImpuTot);
				CalculadorMoney nuevoTotAcum = new CalculadorMoney(
						montoGravadoAcum);
				nuevoTotAcum.sumar(netoGravado);
				totalesPorConcRetGab.put(concImpuTot, nuevoTotAcum
						.getResultMoney());
				break;
			}
		}
		if (!found)
			totalesPorConcRetGab.put(concImpu, netoGravado);
	}

	public List getDetalles() throws BaseException {
		if (readDetalle == true) {
			detalles.addAll(ComproProveedorDet.getDetallesByComproProv(this,
					getSesion()));
			readDetalle = false;
			return detalles;
		} else
			return detalles;
	}

	public List getVtosFijos() throws BaseException {
		if (this.readDetallesVtosFijos == true) {
			detallesVtosFijos.addAll(ComproProvVtoFijo.getVtosFijos(this,
					getSesion()));
			readDetallesVtosFijos = false;
			return detallesVtosFijos;
		} else
			return detallesVtosFijos;
	}

	public List getDetallesTotImpuestos() throws BaseException {
		if (readDetallesTotImpuestos) {
			cargarListaFromBD(detallesTotImpuestos, ComproProvTotImpu
					.getImpuestosByCompro(this, getSesion()));
			readDetallesTotImpuestos = false;
		}
		return detallesTotImpuestos;
	}

	public List getDetallesOCDetInfRecDet() throws BaseException {
		if (readdetallesOCDetInfRecDet) {
			List detalles = ComproProvInfRecOC.getComproProvInfRecOCDet(this,
					getSesion());
			detallesOCDetInfRecDet.addAll(detalles);
			readdetallesOCDetInfRecDet = false;
		}
		return detallesOCDetInfRecDet;
	}

	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();

	}

	private void refreshConceptos() throws BaseException {
		detalles.clear();
		readDetalle = true;
	}

	public static ComproProveedorBase findByComproProv(String identificacion,
			Integer oid, ISesion aSesion) throws BaseException {
		if (IdentificacionTipoComprobante.esFactProv(identificacion)
				|| IdentificacionTipoComprobante.esNCProv(identificacion)
				|| IdentificacionTipoComprobante.esNDProv(identificacion)) {
			return ComproProveedor.findByOid(oid, aSesion);
		} else if (IdentificacionTipoComprobante
				.esAnticipoProveedor(identificacion)) {
			return ComproAnticipoProveedor.findByOid(oid, aSesion);
		} else if (IdentificacionTipoComprobante
				.esNotaCreditoInternoProveedor(identificacion)
				|| IdentificacionTipoComprobante
						.esNotaDebitoInternoProveedor(identificacion))
			return ComproProveedorInterno.findByOid(oid, aSesion);
		return null;
	}

	public static ComproProveedorBase findByComproProv(Integer oid,
			ISesion aSesion) throws BaseException {
		ComproCab comproCab = ComproCab.findByOidCompro(oid, aSesion);
		return ComproProveedorBase.findByComproProv(comproCab.getTipoCompro()
				.getIdentificacion(), oid, aSesion);
	}

	public static ComproCab findByOidCompro(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ComproCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ComproCab findByOidProxyCompro(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ComproCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	protected void onNew() throws BaseException {
		// TODO Auto-generated method stub
		super.onNew();

		this.setAnticipoPagado(new Boolean(false));

	}

	public static List getAnticiposProvAutori(Proveedor proveedor,
			Moneda moneda, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (proveedor != null)
			condiciones.put(Proveedor.NICKNAME, proveedor);
		if (moneda != null)
			condiciones.put(Moneda.NICKNAME, moneda);
		return DBComproProveedorBase.getAnticiposProvAutori(condiciones,
				aSesion);
	}

	public static ComproProveedorBase getComproProveedor(TipoComprobante tc,
			String letra, Integer nroLugEmi, Integer nroExt,
			Proveedor proveedor, ISesion aSesion) throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TipoComprobante.NICKNAME, tc);
		condiciones.put("letra", letra);
		condiciones.put("nro_lug_emi", nroLugEmi);
		condiciones.put("nro_ext", nroExt);
		condiciones.put(Proveedor.NICKNAME, proveedor);

		return (ComproProveedorBase) ObjetoLogico.getObjects(
				ComproProveedorBase.NICKNAME,
				DBComproProveedorBase.SELECT_BY_TC_LETRA_LE_NRO_ACTIVO,
				condiciones, new ObjetoObservado(), aSesion);
	}

	public boolean isAutorizadoPago() throws BaseException {
		// Autorizacion del Pago

		return true;
	}

	public static TipoComprobante getTipoComproAnulaComproProv(ISesion aSesion)
			throws BaseException {
		ValorParametro valor = ValorParametro.findByCodigoParametro(
				"TC_ANU_COMPRO_PROV", aSesion);
		TipoComprobante tc = TipoComprobante.findByOidProxy(valor
				.getOidObjNeg(), aSesion);
		return tc;
	}

	public List getAplicacionesActivasCompro() throws BaseException {
		return AplProv.getAplicacionesActivasCompro(this, this.getSesion());
	}
	
	public List getAplicacionesActivasDelCompro() throws BaseException {
		  return AplProv.getAplicacionesActivasDelCompro(this,this.getSesion());
	  }	

	public int getSignoLibroIVA() throws BaseException {
		
		if (this.getTipoCompro().getIdentificacion().equals(IdentificacionTipoComprobante.MOTA_DEBITO_PROV_INT))
			return 1;
		else
		if (this.getTipoCompro().getIdentificacion().equals(IdentificacionTipoComprobante.NOTA_CREDITO_PROV_INT))
			return -1;
			else
		if (this.getTipoCompro().getIdentificacion().equals(IdentificacionTipoComprobante.COMPRO_FACTURA_PROVEEDOR))
			return 1;
		else if (this.getTipoCompro().getIdentificacion().equals(IdentificacionTipoComprobante.COMPRO_ND_PROVEEDOR))
			return 1;
		else if (this.getTipoCompro().getIdentificacion().equals(IdentificacionTipoComprobante.COMPRO_NC_PROVEEDOR))
			return -1;
		else if (this.getTipoCompro().getIdentificacion().equals(IdentificacionTipoComprobante.ANTICIPO_PROV))
			return 1;
		else
			throw new ExceptionValidation("No se ha programado el signo del libro de IVA Compras para el tipo de comprobante "+this.getTipoCompro().getDescripcion());
			
	}
	
	public boolean getEstadisticaComproProv() throws BaseException {
		if (this.getTipoCompro().getIdentificacion().equals(IdentificacionTipoComprobante.MOTA_DEBITO_PROV_INT))
			return true;
		else
		if (this.getTipoCompro().getIdentificacion().equals(IdentificacionTipoComprobante.NOTA_CREDITO_PROV_INT))
			return true;
			else
		if (this.getTipoCompro().getIdentificacion().equals(IdentificacionTipoComprobante.COMPRO_FACTURA_PROVEEDOR))
			return true;
		else if (this.getTipoCompro().getIdentificacion().equals(IdentificacionTipoComprobante.COMPRO_ND_PROVEEDOR))
			return true;
		else if (this.getTipoCompro().getIdentificacion().equals(IdentificacionTipoComprobante.COMPRO_NC_PROVEEDOR))
			return true;
		else if (this.getTipoCompro().getIdentificacion().equals(IdentificacionTipoComprobante.ANTICIPO_PROV))
			return false;
		else
			throw new ExceptionValidation("No se ha programado si graba o no la estadística del tipo de comprobante "+this.getTipoCompro().getDescripcion());		
	}
	
	
}
