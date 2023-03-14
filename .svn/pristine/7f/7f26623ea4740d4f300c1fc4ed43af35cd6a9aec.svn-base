package com.srn.erp.pagos.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.contabilidad.bm.CalcImportesContables;
import com.srn.erp.contabilidad.bm.CuentasParametrizadas;
import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.contabilidad.bm.RenglonAsiento;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.bm.AplicacionComproProv;
import com.srn.erp.ctasAPagar.bm.AplicacionComproProvDet;
import com.srn.erp.ctasAPagar.bm.ComproProvTotImpu;
import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.ctasAPagar.bm.GrabarCtaCteProv;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.CotizacionesConta;
import com.srn.erp.general.bm.IdentificacionTipoComprobante;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.da.DBComproOrdenPagoCab;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.MedioPago;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class ComproOrdenPagoCab extends ComproCab implements IContabilizable {

	public ComproOrdenPagoCab() {
	}

	private AnuladorOrdenDePago anuladorOrdenDePago = null;

	public static String NICKNAME = "pag.ComproOrdenPagoCab";

	private ComproCab comprobante;
	private CotizacionesConta cotizacionesConta = null;
	private Date fecEmision;
	private MotivoPago motivoPago;
	private Moneda moneda;
	private Double cotizacion;
	private Proveedor proveedor;
	private Money retIVAMonPago = new Money(0);
	private Money retGanMonPago = new Money(0);
	private Money retIBMonPago = new Money(0);
	private CalculadorRetencionesOP calcRetOP;
	private Money pagoACuentaMonPago;
	private Money pagoACuentaMonLoc;
	private List listaCertificadosRetGan = new ArrayList();
	private Money pagoACuenta;
	private Caja caja;
	private Money totalPago;

	private Money bruto;
	private Money descuento;
	private Money neto;
	private Money retIVA;
	private Money retGan;
	private Money retIB;
	private Money retSUS;
	private FormaPago formaPago;

	public Money getBruto() throws BaseException {
		supportRefresh();
		return bruto;
	}

	public void setBruto(Money bruto) {
		this.bruto = bruto;
	}

	public Money getDescuento() throws BaseException {
		this.supportRefresh();
		return descuento;
	}

	public void setDescuento(Money descuento) {
		this.descuento = descuento;
	}

	public Money getNeto() throws BaseException {
		this.supportRefresh();
		return neto;
	}

	public void setNeto(Money neto) {
		this.neto = neto;
	}

	public Money getRetIVA() throws BaseException {
		this.supportRefresh();
		return retIVA;
	}

	public void setRetIVA(Money retIVA) {
		this.retIVA = retIVA;
	}

	public Money getRetGan() throws BaseException {
		this.supportRefresh();
		return retGan;
	}

	public void setRetGan(Money retGan) {
		this.retGan = retGan;
	}

	public Money getRetIB() throws BaseException {
		this.supportRefresh();
		return retIB;
	}

	public void setRetIB(Money retIB) {
		this.retIB = retIB;
	}

	public Money getRetSUS() throws BaseException {
		this.supportRefresh();
		return retSUS;
	}

	public void setRetSUS(Money retSUS) {
		this.retSUS = retSUS;
	}

	public FormaPago getFormaPago() throws BaseException {
		this.supportRefresh();
		return formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public void setPagoACuenta(Money aPagoACuenta) throws BaseException {
		this.pagoACuenta = aPagoACuenta;
	}

	public Money getPagoACuenta() throws BaseException {
		supportRefresh();
		return this.pagoACuenta;
	}

	public void setCaja(Caja aCaja) throws BaseException {
		this.caja = aCaja;
	}

	public Caja getCaja() throws BaseException {
		supportRefresh();
		return this.caja;
	}

	public void setTotalPago(Money aTotalPago) throws BaseException {
		this.totalPago = aTotalPago;
	}

	public Money getTotalPago() throws BaseException {
		supportRefresh();
		return this.totalPago;
	}

	public void addCertificadoRetGan(CertificadoRetGanCab aCertRetGan) throws BaseException {
		listaCertificadosRetGan.add(aCertRetGan);
	}

	public void setPagoACuentaMonPago(Money pagoACuentaMonPago) throws BaseException {
		this.pagoACuentaMonPago = pagoACuentaMonPago;
	}

	public Money getPagoACuentaMonPago() throws BaseException {
		return pagoACuentaMonPago;
	}

	public void setPagoACuentaMonLoc(Money pagoACuentaMonLoc) throws BaseException {
		this.pagoACuentaMonLoc = pagoACuentaMonLoc;
	}

	public Money getPagoACuentaMonLoc() throws BaseException {
		return pagoACuentaMonLoc;
	}

	public Money getRetIVAMonPago() throws BaseException {
		return retIVAMonPago;
	}

	public Money getRetGanMonPago() throws BaseException {
		return retGanMonPago;
	}

	public void setRetGanMonPago(Money aRetGanMonPago) throws BaseException {
		this.retGanMonPago = aRetGanMonPago;
	}

	public Money getRetIBMonPago() throws BaseException {
		return retIBMonPago;
	}

	private List vencimientosPagados = new ArrayList();
	private boolean readVtosPagados = true;

	private List listaMediosPago = new ArrayList();
	private boolean readMediosPago = true;

	private List mediosPago = new ArrayList();
	private Hashtable cotizaciones = new Hashtable();

	private List imputacionesOPVarias = new ArrayList();
	private boolean readImputacionesOPVarias = true;

	public ComproCab getComprobante() throws BaseException {
		supportRefresh();
		return comprobante;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public void addCotizacion(Integer oidMoneda, ValorCotizacion cotizacion) throws BaseException {
		cotizaciones.put(oidMoneda, cotizacion);
	}

	public Date getFecemision() throws BaseException {
		supportRefresh();
		return fecEmision;
	}

	public void setFecemision(Date aFecemision) {
		this.fecEmision = aFecemision;
	}

	public MotivoPago getMotivopago() throws BaseException {
		supportRefresh();
		return motivoPago;
	}

	public void setMotivopago(MotivoPago aMotivopago) {
		this.motivoPago = aMotivopago;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public Double getCotizacion() throws BaseException {
		supportRefresh();
		return cotizacion;
	}

	public void setCotizacion(Double aCotizacion) {
		this.cotizacion = aCotizacion;
	}

	public Proveedor getProveedor() throws BaseException {
		supportRefresh();
		return proveedor;
	}

	public void setProveedor(Proveedor aProveedor) {
		this.proveedor = aProveedor;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ComproOrdenPagoCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ComproOrdenPagoCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ComproOrdenPagoCab findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ComproOrdenPagoCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {

		if (this.isNew()) {

			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));

		}
		// calcularRetencionesOP();
		beforeSaveComprobante(this);

		if (this.isNew())
			if (this.getTipoCompro().esOrdenDePagoVariosEfectivo())
				validarIngresoConceptos();

		if (this.isNew()) {

			if (this.getMotivopago().isPagosVarios()) {
				Money totPago = getTotPagadoValoresMonPago();
				setTotalPago(totPago);
				setBruto(totPago);
				setNeto(totPago);
				setDescuento(new Money(0));
				setRetGan(new Money(0));
				setRetGanMonPago(new Money(0));
				setRetIB(new Money(0));
				setRetIVA(new Money(0));
				setRetSUS(new Money(0));
			} else if (this.isPagoACuenta()) {
				setTotalPago(this.getPagoACuenta());
				setBruto(getPagoACuenta());
				setNeto(getPagoACuenta());
				setDescuento(new Money(0));
				setRetGan(new Money(0));
				setRetGanMonPago(new Money(0));
				setRetIB(new Money(0));
				setRetIVA(new Money(0));
				setRetSUS(new Money(0));
			}

		}

	}

	private boolean isPagoACuenta() throws BaseException {
		if (this.getMotivopago().isPagosAProveedores())
			if (this.getProveedor() != null)
				if (this.getVencimientosPagados().size() == 0)
					if (this.getPagoACuenta() != null)
						if (this.getPagoACuenta().doubleValue() > 0)
							return true;
		return false;
	}

	private void validarIngresoConceptos() throws BaseException {

		Money totalPago = this.getTotalPago();
		if (totalPago == null)
			throw new ExceptionValidation(null, "Debe ingresar el total de la Orden de Pago");

		CalculadorMoney calcTotalPagos = new CalculadorMoney(new Money(0));
		Iterator iterComproOPDet = this.vencimientosPagados.iterator();
		while (iterComproOPDet.hasNext()) {
			ComproOrdenPagoDet comproOrdenPagoDet = (ComproOrdenPagoDet) iterComproOPDet.next();
			calcTotalPagos.sumar(comproOrdenPagoDet.getNetopagomonori());
		}

		if (totalPago.doubleValue() == 0)
			throw new ExceptionValidation(null, "Debe ingresar el total de la Orden de Pago");

		if (totalPago.doubleValue() != calcTotalPagos.getResultMoney().doubleValue())
			throw new ExceptionValidation(null, "El total de la Orden de Pago no coincide con el total de los conceptos");

	}

	/**
	 * isActivo
	 * 
	 * @return Boolean
	 */
	public Boolean isActivo() throws BaseException {
		return super.isActivo();
	}

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() throws BaseException {
		return this.getCodigo();
	}

	public List getVencimientosPagados() throws BaseException {
		if (readVtosPagados) {
			List listaVencimientosPagados = ComproOrdenPagoDet.getOrdPagoDet(this, getSesion());
			vencimientosPagados.addAll(listaVencimientosPagados);
			readVtosPagados = false;
		}
		return vencimientosPagados;
	}

	public List getImputacionesOPVarias() throws BaseException {
		if (readImputacionesOPVarias) {
			List listaImputacionesOPVarias = ImputacionPagosVarios.getImputacionesOPVarias(this, getSesion());
			imputacionesOPVarias.addAll(listaImputacionesOPVarias);
			readImputacionesOPVarias = false;
		}
		return imputacionesOPVarias;
	}

	public List getMediosPagos() throws BaseException {
		if (this.readMediosPago) {
			List traerMediosPago = ComproOrdenPagoMediosPago.getMediosPago(this, getSesion());
			this.listaMediosPago.addAll(traerMediosPago);
			readMediosPago = false;
		}
		return this.listaMediosPago;
	}

	public void addOrdenPagoDet(ComproOrdenPagoDet aComproOrdenPagoDet) throws BaseException {
		aComproOrdenPagoDet.setComprobante(this);
		vencimientosPagados.add(aComproOrdenPagoDet);
	}

	public void addImputacionOPVarias(ImputacionPagosVarios aImputacionOPVarias) throws BaseException {
		aImputacionOPVarias.setComprobante(this);
		imputacionesOPVarias.add(aImputacionOPVarias);
	}

	private void grabarVtosPagados() throws BaseException {
		Iterator iterVtosPagados = vencimientosPagados.iterator();
		while (iterVtosPagados.hasNext()) {
			ComproOrdenPagoDet comproOrdenPagoDet = (ComproOrdenPagoDet) iterVtosPagados.next();
			comproOrdenPagoDet.save();
			comproOrdenPagoDet = null;
		}
		iterVtosPagados = null;
	}

	private void grabarMediosPago() throws BaseException {
		Iterator iterMediosPagos = mediosPago.iterator();
		while (iterMediosPagos.hasNext()) {
			MedioPago medioPago = (MedioPago) iterMediosPagos.next();
			medioPago.save();
		}
	}

	private void grabarImputacionesOPVarias() throws BaseException {
		Iterator iterImpuOPVarias = imputacionesOPVarias.iterator();
		while (iterImpuOPVarias.hasNext()) {
			ImputacionPagosVarios impuPagosVarios = (ImputacionPagosVarios) iterImpuOPVarias.next();
			impuPagosVarios.save();
		}
	}

	public void afterSave() throws BaseException {

		cargarCotizaciones();
		grabarVtosPagados();
		grabarMediosPago();
		grabarImputacionesOPVarias();

		if (this.getTipoCompro().esOrdenDePago()) {
			aplicarCtaCte();
			grabarACuenta();
			grabarRetenciones();
		}

		afterSaveComprobante(this);
	}

	public MedioPago addMedioPago() throws BaseException {
		MedioPago medioPago = new MedioPago();
		medioPago.setSesion(getSesion());
		medioPago.setComprobante(this);
		mediosPago.add(medioPago);
		return medioPago;
	}

	public void aplicarCtaCte() throws BaseException {

		// Realizar las Aplicaciones
		Talonario talAplicProv = AplicacionComproProv.getTalonatioAplicComproProv(getSesion());

		AplicacionComproProv aplicacionComproProv = AplicacionComproProv.findByOid(new Integer(-1), getSesion());
		aplicacionComproProv.setContabiliza(false);
		aplicacionComproProv.setTalonario(talAplicProv);
		aplicacionComproProv.setTipoCompro(talAplicProv.getTipo_comprobante());
		aplicacionComproProv.setLetra(talAplicProv.getLetra());
		aplicacionComproProv.setLugarEmision(talAplicProv.getLugar_emision());
		aplicacionComproProv.setEmision(getFecemision());
		aplicacionComproProv.setImputacion(getFecemision());
		aplicacionComproProv.setComentario("");
		aplicacionComproProv.setProveedor(getProveedor());
		aplicacionComproProv.setNoContaOtrasMonedas(new Boolean(false));
		aplicacionComproProv.setActivo(new Boolean(true));
		aplicacionComproProv.setAllowDesaplicar(false);

		Iterator iterVtosPagados = vencimientosPagados.iterator();
		while (iterVtosPagados.hasNext()) {
			ComproOrdenPagoDet comproOrdenPagoDet = (ComproOrdenPagoDet) iterVtosPagados.next();

			// Por el pago de anticipo no hay ningun tipo de aplicacion
			if (IdentificacionTipoComprobante.esAnticipoProveedor(comproOrdenPagoDet.getComprobantePagado().getTipoCompro()
					.getIdentificacion()))
				continue;

			AplicacionComproProvDet aplicComproProvDet = aplicacionComproProv.addDetalle();
			aplicComproProvDet.setTranprovvto(comproOrdenPagoDet.getTranprovvto());

			CalculadorMoney calcTotAplicacion = new CalculadorMoney(comproOrdenPagoDet.getNetopagomonori());
			calcTotAplicacion.sumar(comproOrdenPagoDet.getDtomonori());

			if (comproOrdenPagoDet.getTranprovvto().getSigno() <= 0)
				aplicComproProvDet.setAplicmonedaori(calcTotAplicacion.getResultMoney());
			else {
				CalculadorMoney cambiarSigno = new CalculadorMoney(calcTotAplicacion.getResultMoney());
				cambiarSigno.multiplicarPor(new Money(-1));
				aplicComproProvDet.setAplicmonedaori(cambiarSigno.getResultMoney());
			}

			aplicComproProvDet.setCotizmonoricont(comproOrdenPagoDet.getValorCotizOriCon());
			aplicComproProvDet.setCotizmonext1cont(comproOrdenPagoDet.getValorCotizExt1Con());
			aplicComproProvDet.setCotizmonext2cont(comproOrdenPagoDet.getValorCotizExt2Con());
			aplicComproProvDet.setCotizmonorihoy(comproOrdenPagoDet.getValorCotizOriHoy());
			aplicComproProvDet.setCotizmonext1hoy(comproOrdenPagoDet.getValorCotizExt1Hoy());
			aplicComproProvDet.setCotizmonext2hoy(comproOrdenPagoDet.getValorCotizExt2Hoy());
			aplicComproProvDet.setNroRelacion(new Integer(0));
			aplicComproProvDet.setComproAplicOri(this);
			aplicComproProvDet.setTranprovvtoAplic(null);
		}

		// Si hay comprobantes para aplicar
		if (aplicacionComproProv.getDetalles().size() > 0)
			aplicacionComproProv.save();

	}

	public Money getTotAPagarMonPagoComprobantes() throws BaseException {
		CalculadorMoney calcTotPagComproProv = new CalculadorMoney(new Money(0));
		Iterator iterVtosPagados = vencimientosPagados.iterator();
		while (iterVtosPagados.hasNext()) {
			ComproOrdenPagoDet comproOrdenPagoDet = (ComproOrdenPagoDet) iterVtosPagados.next();
			calcTotPagComproProv.sumar(comproOrdenPagoDet.getNetopagomonpago());
		}
		calcTotPagComproProv.restar(getRetIVAMonPago());
		calcTotPagComproProv.restar(getRetGanMonPago());
		calcTotPagComproProv.restar(getRetIBMonPago());

		return calcTotPagComproProv.getResultMoney();
	}

	public Money getTotPagadoValoresMonPago() throws BaseException {
		CalculadorMoney calcTotValores = new CalculadorMoney(new Money(0));
		Iterator iterMediosPagos = mediosPago.iterator();
		while (iterMediosPagos.hasNext()) {
			MedioPago medioPago = (MedioPago) iterMediosPagos.next();
			calcTotValores.sumar(medioPago.getImporteMonedaPago());
		}
		return calcTotValores.getResultMoney();
	}

	public Money getTotPagadoValoresMonLoc() throws BaseException {
		CalculadorMoney calcTotValores = new CalculadorMoney(new Money(0));
		Iterator iterMediosPagos = mediosPago.iterator();
		while (iterMediosPagos.hasNext()) {
			MedioPago medioPago = (MedioPago) iterMediosPagos.next();
			calcTotValores.sumar(medioPago.getImportesContables().getImpoMonLoc());
		}
		return calcTotValores.getResultMoney();
	}

	public void grabarACuenta() throws BaseException {
		if (getPagoACuenta().doubleValue() > 0) {
			setPagoACuentaMonPago(getPagoACuenta());
			grabarPagoACuenta(getPagoACuenta());
		}
	}

	private CotizacionesConta getCotizacionesConta() throws BaseException {
		if (cotizacionesConta == null)
			cotizacionesConta = new CotizacionesConta(getSesion());
		return cotizacionesConta;
	}

	public TipoCtaCteProv getTipoCtaCteProvPagoACuenta() throws BaseException {
		Integer oidTipoCtaCteProv = ValorParametro.findByCodigoParametro("TIPO_CTA_PROV_PAGOS_A_CTA", getSesion()).getOidObjNeg();
		TipoCtaCteProv tipoCtaCteProv = TipoCtaCteProv.findByOid(oidTipoCtaCteProv, getSesion());
		return tipoCtaCteProv;
	}

	private void cargarCotizaciones() throws BaseException {
		getCotizacionesConta().init();
		Iterator iterCotiz = cotizaciones.keySet().iterator();
		while (iterCotiz.hasNext()) {
			Integer oidMoneda = (Integer) iterCotiz.next();
			ValorCotizacion cotizacion = (ValorCotizacion) cotizaciones.get(oidMoneda);
			getCotizacionesConta().addCotizacion(Moneda.findByOidProxy(oidMoneda, getSesion()), cotizacion);
		}
		getCotizacionesConta().setFecha(getFecemision());
	}

	public void grabarPagoACuenta(Money pagoACuenta) throws BaseException {

		// Grabar la Cuenta Corriente del Proveedor

		GrabarCtaCteProv ctaCteProv = new GrabarCtaCteProv(getSesion());
		ctaCteProv.setGrabarAutorizacion(false);
		ctaCteProv.setSigno(new Integer(1));
		ctaCteProv.setComprobante(this);
		ctaCteProv.setTipoCtaCteProv(getTipoCtaCteProvPagoACuenta());
		ctaCteProv.setProveedor(getProveedor());
		ctaCteProv.setMoneda(getMoneda());
		ctaCteProv.setImporte(pagoACuenta);
		ctaCteProv.setImputac(getFecemision());
		ctaCteProv.setEmision(getFecemision());
		ctaCteProv.setBase(getFecemision());
		ctaCteProv.setCotizMonOri(new ValorCotizacion(getCotizacion()));
		ctaCteProv.setCotizMonExt1(this.getCotizMonExt1());
		ctaCteProv.setCotizMonExt2(this.getCotizMonExt2());
		ctaCteProv.setCotizMonOriCon(new ValorCotizacion(getCotizacion()));
		ctaCteProv.setCotizMonExt1Con(this.getCotizMonExt1());
		ctaCteProv.setCotizMonExt2Con(this.getCotizMonExt2());
		ctaCteProv.setCondPago(null);
		ctaCteProv.addVtoFechaFija(getFecemision(), pagoACuenta);
		ctaCteProv.save();

	}

	public static TipoComprobante getTipoComproOrdenPago(ISesion aSesion) throws BaseException {
		Integer oidTipoComprobante = ValorParametro.findByCodigoParametro("TC_ORDEN_DE_PAGO", aSesion).getOidObjNeg();
		TipoComprobante tipoComprobante = TipoComprobante.findByOid(oidTipoComprobante, aSesion);
		return tipoComprobante;
	}

	private void calcularRetencionesOP() throws BaseException {
		calcRetOP = new CalculadorRetencionesOP();
		calcRetOP.setComprobante(this);
		calcRetOP.setMonedaPago(getMoneda());
		calcRetOP.setCotizacionesConta(getCotizacionesConta());
		calcRetOP.setCotizMonPago(new ValorCotizacion(getCotizacion()));
		calcRetOP.setPagoACuentaMonPago(getPagoACuentaMonPago());
		calcRetOP.setFecha(getFecemision());
		calcRetOP.setSesion(getSesion());
		Iterator iterVtosPagados = vencimientosPagados.iterator();
		while (iterVtosPagados.hasNext()) {
			ComproOrdenPagoDet comproOrdenPagoDet = (ComproOrdenPagoDet) iterVtosPagados.next();
			calcRetOP.addPagoCuotaComprobante(comproOrdenPagoDet.getTranprovvto(), comproOrdenPagoDet.getComproAntProv(),
					comproOrdenPagoDet.getTranprovvto().getSaldo(), comproOrdenPagoDet.getNetopagomonpago(), comproOrdenPagoDet
							.getNetoPagoMonLoc());
		}
		calcRetOP.calcularRetenciones();
		retIVAMonPago = calcRetOP.getRetIVAMonPago();
		retGanMonPago = calcRetOP.getRetGanMonPago();
		retIBMonPago = calcRetOP.getRetIBMonPago();
	}

	public void grabarRetenciones() throws BaseException {
		// Grabar los certificados de Retencione Ganancias
		Iterator iterRetGan = listaCertificadosRetGan.iterator();
		while (iterRetGan.hasNext()) {
			CertificadoRetGanCab certRetGanCab = (CertificadoRetGanCab) iterRetGan.next();
			certRetGanCab.save();
		}
	}

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {

		RenglonesAsiento renglones = new RenglonesAsiento();
		Iterator iterVtosPagados = vencimientosPagados.iterator();
		while (iterVtosPagados.hasNext()) {
			ComproOrdenPagoDet comproOrdenPagoDet = (ComproOrdenPagoDet) iterVtosPagados.next();

			// Conceptos Pagos Varios
			if (this.getTipoCompro().esOrdenDePagoVariosEfectivo()) {
				RenglonAsiento renglonProv = renglones.addRenglonAsiento();
				renglonProv.setCuentaImputable(comproOrdenPagoDet.getConceptoOPVarias().getCuenta_imputable());
				renglonProv.setD_H(RenglonAsiento.DEBE);
				renglonProv.setMonedaOri(getMoneda());
				renglonProv.setImporteOri(comproOrdenPagoDet.getNetopagomonori());
				renglonProv.setCotizOri(new ValorCotizacion(getCotizacion()));
				renglonProv.setCotizMonExt1(getCotizMonExt1());
				renglonProv.setCotizMonExt2(getCotizMonExt2());

				renglonProv.setComentario("");
				renglonProv.setImpoLocHist(comproOrdenPagoDet.getNetoPagoMonHist());
				renglonProv.setImpoLocAju(comproOrdenPagoDet.getNetoPagoMonAju());
				renglonProv.setImpoMonExt1(comproOrdenPagoDet.getNetoPagoMonExt1());
				renglonProv.setImpoMonExt2(comproOrdenPagoDet.getNetoPagoMonExt2());

			}

			// Debitar la cuenta proveedores por el total de los Valores
			if ((this.getTipoCompro().esOrdenDePago()) && (!comproOrdenPagoDet.isAnticipo())) {
				RenglonAsiento renglonProv = renglones.addRenglonAsiento();
				renglonProv.setCuentaImputable(CuentasParametrizadas.getProveedores(getSesion()));
				renglonProv.setD_H(RenglonAsiento.DEBE);
				renglonProv.setMonedaOri(getMoneda());
				renglonProv.setImporteOri(comproOrdenPagoDet.getTotAplicMonOri());
				renglonProv.setCotizOri(new ValorCotizacion(getCotizacion()));
				renglonProv.setCotizMonExt1(getCotizMonExt1());
				renglonProv.setCotizMonExt2(getCotizMonExt2());

				renglonProv.setComentario("");
				renglonProv.setImpoLocHist(comproOrdenPagoDet.getNetoPagoMonHist());
				renglonProv.setImpoLocAju(comproOrdenPagoDet.getNetoPagoMonAju());
				renglonProv.setImpoMonExt1(comproOrdenPagoDet.getNetoPagoMonExt1());
				renglonProv.setImpoMonExt2(comproOrdenPagoDet.getNetoPagoMonExt2());

				// Debitar los descuento proveedor por los descuento recibidos
				RenglonAsiento renglonProvDto = renglones.addRenglonAsiento();
				renglonProvDto.setCuentaImputable(CuentasParametrizadas.getProveedores(getSesion()));
				renglonProvDto.setD_H(RenglonAsiento.DEBE);
				renglonProvDto.setMonedaOri(getMoneda());
				renglonProvDto.setImporteOri(comproOrdenPagoDet.getDtomonori());
				renglonProvDto.setCotizOri(new ValorCotizacion(getCotizacion()));
				renglonProvDto.setCotizMonExt1(getCotizMonExt1());
				renglonProvDto.setCotizMonExt2(getCotizMonExt2());

				renglonProvDto.setComentario("");
				renglonProvDto.setImpoLocHist(comproOrdenPagoDet.getDtoMonHist());
				renglonProvDto.setImpoLocAju(comproOrdenPagoDet.getDtoMonAju());
				renglonProvDto.setImpoMonExt1(comproOrdenPagoDet.getDtoMonExt1());
				renglonProvDto.setImpoMonExt2(comproOrdenPagoDet.getDtoMonExt2());
			}

			// Calcular los impuestos proporcionales del Descuento

			CalculadorMoney calcAcumImpuestosPropMonOri = new CalculadorMoney(new Money(0));
			CalculadorMoney calcAcumImpuestosPropMonLoc = new CalculadorMoney(new Money(0));
			CalculadorMoney calcAcumImpuestosPropMonExt1 = new CalculadorMoney(new Money(0));
			CalculadorMoney calcAcumImpuestosPropMonExt2 = new CalculadorMoney(new Money(0));

			if ((this.getTipoCompro().esOrdenDePago()) && (comproOrdenPagoDet.getDtomonori().doubleValue() > 0)) {

				Integer oidComproProv = comproOrdenPagoDet.getTranprovvto().getTranprov().getComprobante().getOIDInteger();
				ComproProveedorBase comproProvBase = ComproProveedorBase.findByOid(oidComproProv, getSesion());
				Money totMonOri = comproProvBase.getTotMonedaOri();
				Iterator iterTotImuestos = comproProvBase.getDetallesTotImpuestos().iterator();
				while (iterTotImuestos.hasNext()) {
					ComproProvTotImpu comproProvTotImpu = (ComproProvTotImpu) iterTotImuestos.next();
					Money montoImpuesto = comproProvTotImpu.getImporteMonedaOri();
					CalculadorMoney calcProporcionImpuesto = new CalculadorMoney(montoImpuesto);
					calcProporcionImpuesto.multiplicarPor(comproOrdenPagoDet.getDtomonori());
					calcProporcionImpuesto.dividirPor(totMonOri);

					RenglonAsiento renglonImpuPropDto = renglones.addRenglonAsiento();
					renglonImpuPropDto.setCuentaImputable(comproProvTotImpu.getConceptoImpuesto().getCuentaImputable());
					renglonImpuPropDto.setD_H(RenglonAsiento.HABER);
					renglonImpuPropDto.setMonedaOri(getMoneda());
					renglonImpuPropDto.setImporteOri(calcProporcionImpuesto.getResultMoney());
					renglonImpuPropDto.setCotizOri(new ValorCotizacion(getCotizacion()));
					renglonImpuPropDto.setCotizMonExt1(getCotizMonExt1());
					renglonImpuPropDto.setCotizMonExt2(getCotizMonExt2());

					renglonImpuPropDto.setComentario("");
					CalcImportesContables calcImpContImpuProp = new CalcImportesContables(getSesion(), getFecemision(),
							getCotizacionesConta());
					ImportesContables importesContablesImpuProp = calcImpContImpuProp.getImportesContables(calcProporcionImpuesto
							.getResultMoney(), getMoneda());
					renglonImpuPropDto.setImpoLocHist(importesContablesImpuProp.getImpoMonLoc());
					renglonImpuPropDto.setImpoLocAju(importesContablesImpuProp.getImpoMonLocAju());
					renglonImpuPropDto.setImpoMonExt1(importesContablesImpuProp.getImpoMonExt1());
					renglonImpuPropDto.setImpoMonExt2(importesContablesImpuProp.getImpoMonExt2());

					// Acumular los Impuestos
					calcAcumImpuestosPropMonOri.sumar(calcProporcionImpuesto.getResultMoney());
					calcAcumImpuestosPropMonLoc.sumar(importesContablesImpuProp.getImpoMonLoc());
					calcAcumImpuestosPropMonExt1.sumar(importesContablesImpuProp.getImpoMonExt1());
					calcAcumImpuestosPropMonExt2.sumar(importesContablesImpuProp.getImpoMonExt2());

				}

				// Armar el descuento por la Diferencia
				CalculadorMoney calcDtoNetoDeImpuestosMonOri = new CalculadorMoney(comproOrdenPagoDet.getDtomonori());
				calcDtoNetoDeImpuestosMonOri.restar(calcAcumImpuestosPropMonOri.getResultMoney());
				CalculadorMoney calcDtoNetoDeImpuestosMonLoc = new CalculadorMoney(comproOrdenPagoDet.getDtoMonHist());
				calcDtoNetoDeImpuestosMonLoc.restar(calcAcumImpuestosPropMonLoc.getResultMoney());
				CalculadorMoney calcDtoNetoDeImpuestosMonExt1 = new CalculadorMoney(comproOrdenPagoDet.getDtoMonExt1());
				calcDtoNetoDeImpuestosMonExt1.restar(calcAcumImpuestosPropMonExt1.getResultMoney());
				CalculadorMoney calcDtoNetoDeImpuestosMonExt2 = new CalculadorMoney(comproOrdenPagoDet.getDtoMonExt2());
				calcDtoNetoDeImpuestosMonExt2.restar(calcAcumImpuestosPropMonExt2.getResultMoney());

				// Acreditar la cuenta descuentos
				RenglonAsiento renglonDto = renglones.addRenglonAsiento();
				renglonDto.setCuentaImputable(CuentasParametrizadas.getDescuentoOP(getSesion()));
				renglonDto.setD_H(RenglonAsiento.HABER);
				renglonDto.setMonedaOri(getMoneda());
				renglonDto.setImporteOri(calcDtoNetoDeImpuestosMonOri.getResultMoney());
				renglonDto.setCotizOri(new ValorCotizacion(getCotizacion()));
				renglonDto.setCotizMonExt1(getCotizMonExt1());
				renglonDto.setCotizMonExt2(getCotizMonExt2());
				renglonDto.setComentario("");
				renglonDto.setImpoLocHist(calcDtoNetoDeImpuestosMonLoc.getResultMoney());
				renglonDto.setImpoLocAju(calcDtoNetoDeImpuestosMonLoc.getResultMoney());
				renglonDto.setImpoMonExt1(calcDtoNetoDeImpuestosMonExt1.getResultMoney());
				renglonDto.setImpoMonExt2(calcDtoNetoDeImpuestosMonExt2.getResultMoney());
			} // Fin tratamiento impuestos proporcionales del descuento

		}

		// Contabilizar el Pago a cuenta
		if ((this.getTipoCompro().esOrdenDePago()) && (getPagoACuenta().doubleValue() > 0)) {
			RenglonAsiento renglonPagoACuenta = renglones.addRenglonAsiento();
			renglonPagoACuenta.setCuentaImputable(CuentasParametrizadas.getProveedores(getSesion()));
			renglonPagoACuenta.setD_H(RenglonAsiento.DEBE);
			renglonPagoACuenta.setMonedaOri(getMoneda());
			renglonPagoACuenta.setImporteOri(getPagoACuenta());
			renglonPagoACuenta.setCotizOri(new ValorCotizacion(getCotizacion()));
			renglonPagoACuenta.setCotizMonExt1(getCotizMonExt1());
			renglonPagoACuenta.setCotizMonExt2(getCotizMonExt2());

			renglonPagoACuenta.setComentario("");
			ImportesContables importesContables = this.getImportesContables(getPagoACuenta(), getMoneda(), this.getEmision());

			renglonPagoACuenta.setImpoLocHist(importesContables.getImpoMonLoc());
			renglonPagoACuenta.setImpoLocAju(importesContables.getImpoMonLocAju());
			renglonPagoACuenta.setImpoMonExt1(importesContables.getImpoMonExt1());
			renglonPagoACuenta.setImpoMonExt2(importesContables.getImpoMonExt2());
		}

		// Imputar los Valores los Valores
		Iterator iterMediosPagos = mediosPago.iterator();
		while (iterMediosPagos.hasNext()) {
			MedioPago medioPago = (MedioPago) iterMediosPagos.next();
			RenglonAsiento renglonValor = renglones.addRenglonAsiento();
			renglonValor.setComentario("");
			renglonValor.setCuentaImputable(medioPago.getCuentaImputable());
			renglonValor.setD_H(RenglonAsiento.HABER);
			renglonValor.setMonedaOri(getMoneda());
			renglonValor.setImporteOri(medioPago.getImporteMonedaValor());
			renglonValor.setCotizOri(medioPago.getCotizMonedaValor());
			renglonValor.setCotizMonExt1(getCotizMonExt1());
			renglonValor.setCotizMonExt2(getCotizMonExt2());
			renglonValor.setImpoLocHist(medioPago.getImportesContables().getImpoMonLoc());
			renglonValor.setImpoLocAju(medioPago.getImportesContables().getImpoMonLocAju());
			renglonValor.setImpoMonExt1(medioPago.getImportesContables().getImpoMonExt1());
			renglonValor.setImpoMonExt2(medioPago.getImportesContables().getImpoMonExt2());
		}

		// Imputar las Retenciones
		Iterator iterCertRetGan = listaCertificadosRetGan.iterator();
		while (iterCertRetGan.hasNext()) {
			CertificadoRetGanCab certRetGanCab = (CertificadoRetGanCab) iterCertRetGan.next();
			Iterator iterCertRetGanDet = certRetGanCab.getDetalles().iterator();
			while (iterCertRetGanDet.hasNext()) {
				CertificadoRetGanDet certRetGanDet = (CertificadoRetGanDet) iterCertRetGanDet.next();
				RenglonAsiento renglonRet = renglones.addRenglonAsiento();
				renglonRet.setCuentaImputable(certRetGanDet.getConceptoimpuesto().getCuentaImputable());
				renglonRet.setComentario("");
				renglonRet.setD_H(RenglonAsiento.HABER);
				renglonRet.setMonedaOri(getMoneda());
				renglonRet.setImporteOri(certRetGanDet.getImpuestoretenido());
				renglonRet.setCotizOri(new ValorCotizacion(getCotizacion()));
				renglonRet.setCotizMonExt1(getCotizMonExt1());
				renglonRet.setCotizMonExt2(getCotizMonExt2());

				renglonRet.setImpoLocHist(certRetGanDet.getRetencionesContables().getImpoMonLoc());
				renglonRet.setImpoLocAju(certRetGanDet.getRetencionesContables().getImpoMonLocAju());
				renglonRet.setImpoMonExt1(certRetGanDet.getRetencionesContables().getImpoMonExt1());
				renglonRet.setImpoMonExt2(certRetGanDet.getRetencionesContables().getImpoMonExt2());
			}
		}

		// Imputar los pagos Varios
		Iterator iterImpuPagosVarios = this.imputacionesOPVarias.iterator();
		while (iterImpuPagosVarios.hasNext()) {
			ImputacionPagosVarios impuPagosVarios = (ImputacionPagosVarios) iterImpuPagosVarios.next();
			RenglonAsiento renglonImpuOPV = renglones.addRenglonAsiento();
			renglonImpuOPV.setComentario(impuPagosVarios.getComentario());
			renglonImpuOPV.setCuentaImputable(impuPagosVarios.getCuenta_imputable());
			Money importe = new Money(0);
			if (impuPagosVarios.isDebe()) {
				renglonImpuOPV.setD_H(RenglonAsiento.DEBE);
				importe = impuPagosVarios.getDebe_mon_pago();
				renglonImpuOPV.setImporteOri(importe);
			} else {
				renglonImpuOPV.setD_H(RenglonAsiento.HABER);
				importe = impuPagosVarios.getHaber_mon_pago();
				renglonImpuOPV.setImporteOri(importe);
			}
			renglonImpuOPV.setMonedaOri(getMoneda());
			renglonImpuOPV.setCotizOri(new ValorCotizacion(getCotizacion()));
			renglonImpuOPV.setCotizMonExt1(getCotizMonExt1());
			renglonImpuOPV.setCotizMonExt2(getCotizMonExt2());

			if (importe == null)
				throw new ExceptionValidation(null,"Debe ingresar al Importe del DEBE o del HABER");
			ImportesContables importesContables = this.getImportesContables(importe, getMoneda(), this.getEmision());

			renglonImpuOPV.setImpoLocHist(importesContables.getImpoMonLoc());
			renglonImpuOPV.setImpoLocAju(importesContables.getImpoMonLocAju());
			renglonImpuOPV.setImpoMonExt1(importesContables.getImpoMonExt1());
			renglonImpuOPV.setImpoMonExt2(importesContables.getImpoMonExt2());

		}

		return renglones;

	}

	public java.util.Date getImputacion() throws BaseException {
		return getFecemision();
	}

	public static boolean getContabilizarComprobante(ISesion aSesion) throws BaseException {
		ValorParametro valorParamContabilizaOP = ValorParametro.findByCodigoParametro("CONTABILIZA_OP", aSesion);
		return valorParamContabilizaOP.getBoolean();
	}

	public static boolean getContabilizarOPVariasEfectivo(ISesion aSesion) throws BaseException {
		ValorParametro valorParamContabilizaOP = ValorParametro.findByCodigoParametro("CONTABILIZA_OP_VARIAS", aSesion);
		return valorParamContabilizaOP.getBoolean();
	}

	public List getImpuestosRetGan() throws BaseException {
		List listaImpuestosRetenciones = new ArrayList();
		Iterator iterVencimientosPagados = getVencimientosPagados().iterator();
		while (iterVencimientosPagados.hasNext()) {
			ComproOrdenPagoDet comproOrdenPagoDet = (ComproOrdenPagoDet) iterVencimientosPagados.next();
			Integer oidComproProv = comproOrdenPagoDet.getTranprovvto().getTranprov().getComprobante().getOIDInteger();
			ComproProveedorBase comproProvBase = ComproProveedorBase.findByOid(oidComproProv, getSesion());
			Iterator impuestosRetGan = comproProvBase.getImpuestosRetencionGan().iterator();
			while (impuestosRetGan.hasNext()) {
				ConceptoImpuesto conceptoImpuesto = (ConceptoImpuesto) impuestosRetGan.next();
				if (!listaImpuestosRetenciones.contains(conceptoImpuesto))
					listaImpuestosRetenciones.add(conceptoImpuesto);
			}
		}
		return listaImpuestosRetenciones;
	}

	public static List getHelpComproOrdenPagoVariasEfectivo(Integer nroExtDesde, Integer nroExtHasta, Date fechaDesde, Date fechaHasta,
			ISesion sesion) throws BaseException {
		return DBComproOrdenPagoCab.getHelpComproOrdenPagoVariasEfectivo(nroExtDesde, nroExtHasta, fechaDesde, fechaHasta, sesion);

	}

	public void anular() throws BaseException {

		anuladorOrdenDePago = (AnuladorOrdenDePago) AnuladorOrdenDePago.getNew(AnuladorOrdenDePago.NICKNAME, getSesion());
		anuladorOrdenDePago.setOrdenDePago(this);
		anuladorOrdenDePago.generarComproAnulacion();
		anuladorOrdenDePago.save();

	}

	public static List getHelpOP(Integer nroExtDesde, Integer nroExtHasta, Proveedor proveedor, Date fechaDesde, Date fechaHasta,
			ISesion aSesion) throws BaseException {

		return DBComproOrdenPagoCab.getHelpOP(nroExtDesde, nroExtHasta, proveedor, fechaDesde, fechaHasta, aSesion);
	}

	public CertificadoRetGanCab getCertificadoRetGan() throws BaseException {
		return CertificadoRetGanCab.getCertificadoRetGan(this, this.getSesion());
	}

}
