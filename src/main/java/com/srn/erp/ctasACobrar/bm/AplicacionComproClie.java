package com.srn.erp.ctasACobrar.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.CalcDifCambio;
import com.srn.erp.contabilidad.bm.CuentasParametrizadas;
import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.RenglonAsiento;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.ctasACobrar.da.DBAplicacionComproClie;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;

public class AplicacionComproClie extends ComproCab implements IContabilizable {

	public AplicacionComproClie() {
	}

	private AnuladorComproClieAplic anuladorAplicacionCliente = null;

	public static String NICKNAME = "cac.AplicacionComproClie";

	private Sujeto sujeto;
	private ComproCab comprobante;
	private List detalles = new ArrayList();
	private java.util.Date imputacion;
	private Boolean noContaOtrasMonedas;
	private Boolean allowDesaplicar;

	public void setNoContaOtrasMonedas(Boolean noContaOtrasMonedas) {
		this.noContaOtrasMonedas = noContaOtrasMonedas;
	}

	public Boolean getNoContaOtrasMonedas() throws BaseException {
		supportRefresh();
		return noContaOtrasMonedas;
	}

	public void setAllowDesaplicar(Boolean aAllowDesaplicar) {
		this.allowDesaplicar = aAllowDesaplicar;
	}

	public Boolean isAllowDesaplicar() throws BaseException {
		supportRefresh();
		return this.allowDesaplicar;
	}

	public Sujeto getSujeto() throws BaseException {
		supportRefresh();
		return sujeto;
	}

	public void setSujeto(Sujeto aSujeto) {
		this.sujeto = aSujeto;
	}

	public void setImputacion(Date aImputacion) {
		this.imputacion = aImputacion;
	}

	public Date getImputacion() throws BaseException {
		return this.imputacion;
	}

	public ComproCab getComprobante() throws BaseException {
		supportRefresh();
		return comprobante;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public void beforeSave() throws BaseException {

		beforeSaveComprobante(this);
		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
		}

	}

	// Agregar el After Save
	public void afterSave() throws BaseException {

		// Grabar los detalles del Comprobante
		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			AplicacionComproClieDet aplicComproClieDet = (AplicacionComproClieDet) iterDetalles.next();
			aplicComproClieDet.save();

			AplicarCtaCteClie aplicCtaCteClie = new AplicarCtaCteClie(getSesion());
			aplicCtaCteClie.setComprobante(this);
			aplicCtaCteClie.setComprobanteOri(aplicComproClieDet.getComproAplicOri());
			aplicCtaCteClie.setTipoCtaCteClie(aplicComproClieDet.getTranClieVto().getTran_clie().getTipo_cta_cte());
			aplicCtaCteClie.setSujeto(aplicComproClieDet.getTranClieVto().getTran_clie().getSujeto());
			aplicCtaCteClie.setMoneda(aplicComproClieDet.getTranClieVto().getTran_clie().getMoneda());
			aplicCtaCteClie.setImporte(aplicComproClieDet.getAplicmonedaori());
			aplicCtaCteClie.setEmision(getEmision());
			aplicCtaCteClie.setImputac(getImputacion());
			aplicCtaCteClie.setDiasBase(new Integer(0));
			aplicCtaCteClie.setDiasVto(new Integer(0));
			aplicCtaCteClie.setTranVto(aplicComproClieDet.getTranClieVto());
			aplicCtaCteClie.setTranVtoOri(aplicComproClieDet.getTranClieVtoAplic());
			aplicCtaCteClie.setValorCotizMonOri(aplicComproClieDet.getCotizmonorihoy());
			aplicCtaCteClie.setValorCotizMonExt1(aplicComproClieDet.getCotizmonext1hoy());
			aplicCtaCteClie.setValorCotizMonExt2(aplicComproClieDet.getCotizmonext2hoy());
			aplicCtaCteClie.grabarAplicacion();

			// marcarCuotaComoNoAutoriz(aplicComproProvDet);

			aplicComproClieDet = null;

		}
		iterDetalles = null;
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

	
	public static boolean contabilizarComprobante(ISesion aSesion) throws BaseException {
		ValorParametro valorParamContabilizaComproProv = ValorParametro.findByCodigoParametro("CONTA_APLIC_COMPRO_PROV", aSesion);
		return valorParamContabilizaComproProv.getBoolean();
	}

	public static Talonario getTalonatioAplicComproClie(ISesion aSesion) throws BaseException {
		return Talonario.getTalonatioAplicComproClie(aSesion);
	}

	public static TipoComprobante getTipoComproAplicProv(ISesion aSesion) throws BaseException {
		ValorParametro valorParamContabilizaComproProv = ValorParametro.findByCodigoParametro("TC_APLIC_PROV", aSesion);
		TipoComprobante tc = TipoComprobante.findByOidProxy(valorParamContabilizaComproProv.getOidObjNeg(), aSesion);
		return tc;
	}

	// Agregar Detalle
	public AplicacionComproClieDet addDetalle() throws BaseException {
		AplicacionComproClieDet aplicComproClieDet = (AplicacionComproClieDet) AplicacionComproClieDet.getNew(
				AplicacionComproClieDet.NICKNAME, getSesion());
		aplicComproClieDet.setComprocab(this);
		detalles.add(aplicComproClieDet);
		return aplicComproClieDet;
	}

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {
		RenglonesAsiento renglones = new RenglonesAsiento();

		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			AplicacionComproClieDet aplicComproClieDet = (AplicacionComproClieDet) iterDetalles.next();

			// Debitos
			RenglonAsiento renglon = renglones.addRenglonAsiento();
			renglon.setCuentaImputable(CuentasParametrizadas.getDeudoresPorVentas(getSesion()));
			renglon.setMonedaOri(aplicComproClieDet.getTranClieVto().getMoneda());
			renglon.setImporteOri(aplicComproClieDet.getAplicmonedaori());
			renglon.setCotizOri(aplicComproClieDet.getCotizmonorihoy());
			renglon.setCotizMonExt1(aplicComproClieDet.getCotizmonext1hoy());
			renglon.setCotizMonExt2(aplicComproClieDet.getCotizmonext2hoy());
			renglon.setComentario("");

			CalcDifCambio calcDifCambio = new CalcDifCambio(getSesion());
			calcDifCambio.setCotizMonOrigenConta(aplicComproClieDet.getCotizmonoricont());
			calcDifCambio.setCotizMonExt1Conta(aplicComproClieDet.getCotizmonext1cont());
			calcDifCambio.setCotizMonExt2Conta(aplicComproClieDet.getCotizmonext2cont());
			calcDifCambio.setCotizMonOrigenHoy(aplicComproClieDet.getCotizmonorihoy());
			calcDifCambio.setCotizMonExt1Hoy(aplicComproClieDet.getCotizmonext1hoy());
			calcDifCambio.setCotizMonExt2Hoy(aplicComproClieDet.getCotizmonext2hoy());
			calcDifCambio.setImporteAplicacion(aplicComproClieDet.getAplicmonedaori());
			calcDifCambio.calcular();

			renglon.setImpoLocHist(calcDifCambio.getDebitosImportesConta().getImpoMonLoc(), RenglonAsiento.DEBE);
			renglon.setImpoLocAju(calcDifCambio.getDebitosImportesConta().getImpoMonLocAju(), RenglonAsiento.DEBE);
			renglon.setImpoMonExt1(calcDifCambio.getDebitosImportesConta().getImpoMonExt1(), RenglonAsiento.DEBE);
			renglon.setImpoMonExt2(calcDifCambio.getDebitosImportesConta().getImpoMonExt2(), RenglonAsiento.DEBE);

			// Creditos
			RenglonAsiento renglon1 = renglones.addRenglonAsiento();
			renglon1.setCuentaImputable(CuentasParametrizadas.getDeudoresPorVentas(getSesion()));
			renglon1.setMonedaOri(aplicComproClieDet.getTranClieVto().getMoneda());
			renglon1.setImporteOri(aplicComproClieDet.getAplicmonedaori());
			renglon1.setCotizOri(aplicComproClieDet.getCotizmonorihoy());
			renglon1.setCotizMonExt1(aplicComproClieDet.getCotizmonext1hoy());
			renglon1.setCotizMonExt2(aplicComproClieDet.getCotizmonext2hoy());

			renglon1.setComentario("");

			CalcDifCambio calcDifCambio1 = new CalcDifCambio(getSesion());
			calcDifCambio1.setCotizMonOrigenConta(aplicComproClieDet.getCotizmonoricont());
			calcDifCambio1.setCotizMonExt1Conta(aplicComproClieDet.getCotizmonext1cont());
			calcDifCambio1.setCotizMonExt2Conta(aplicComproClieDet.getCotizmonext2cont());
			calcDifCambio1.setCotizMonOrigenHoy(aplicComproClieDet.getCotizmonorihoy());
			calcDifCambio1.setCotizMonExt1Hoy(aplicComproClieDet.getCotizmonext1hoy());
			calcDifCambio1.setCotizMonExt2Hoy(aplicComproClieDet.getCotizmonext2hoy());
			calcDifCambio1.setImporteAplicacion(aplicComproClieDet.getAplicmonedaori());
			calcDifCambio1.calcular();

			renglon1.setImpoLocHist(calcDifCambio1.getCreditosImportesConta().getImpoMonLoc(), RenglonAsiento.HABER);
			renglon1.setImpoLocAju(calcDifCambio1.getCreditosImportesConta().getImpoMonLocAju(), RenglonAsiento.HABER);
			renglon1.setImpoMonExt1(calcDifCambio1.getCreditosImportesConta().getImpoMonExt1(), RenglonAsiento.HABER);
			renglon1.setImpoMonExt2(calcDifCambio1.getCreditosImportesConta().getImpoMonExt2(), RenglonAsiento.HABER);

			// Diferencia de Cambio Debitos
			RenglonAsiento renglon2 = renglones.addRenglonAsiento();
			renglon2.setCuentaImputable(CuentasParametrizadas.getDiferenciaCambio(getSesion()));
			renglon2.setMonedaOri(aplicComproClieDet.getTranClieVto().getMoneda());
			renglon2.setImporteOri(aplicComproClieDet.getAplicmonedaori());
			renglon2.setCotizOri(aplicComproClieDet.getCotizmonorihoy());
			renglon2.setCotizMonExt1(aplicComproClieDet.getCotizmonext1hoy());
			renglon2.setCotizMonExt2(aplicComproClieDet.getCotizmonext2hoy());
			renglon2.setComentario("");

			CalcDifCambio calcDifCambio2 = new CalcDifCambio(getSesion());
			calcDifCambio2.setCotizMonOrigenConta(aplicComproClieDet.getCotizmonoricont());
			calcDifCambio2.setCotizMonExt1Conta(aplicComproClieDet.getCotizmonext1cont());
			calcDifCambio2.setCotizMonExt2Conta(aplicComproClieDet.getCotizmonext2cont());
			calcDifCambio2.setCotizMonOrigenHoy(aplicComproClieDet.getCotizmonorihoy());
			calcDifCambio2.setCotizMonExt1Hoy(aplicComproClieDet.getCotizmonext1hoy());
			calcDifCambio2.setCotizMonExt2Hoy(aplicComproClieDet.getCotizmonext2hoy());
			calcDifCambio2.setImporteAplicacion(aplicComproClieDet.getAplicmonedaori());
			calcDifCambio2.calcular();

			renglon2.setImpoLocHist(calcDifCambio2.getDebitosDifCambio().getImpoMonLoc(), RenglonAsiento.DEBE);
			renglon2.setImpoLocAju(calcDifCambio2.getDebitosDifCambio().getImpoMonLocAju(), RenglonAsiento.DEBE);
			renglon2.setImpoMonExt1(calcDifCambio2.getDebitosDifCambio().getImpoMonExt1(), RenglonAsiento.DEBE);
			renglon2.setImpoMonExt2(calcDifCambio2.getDebitosDifCambio().getImpoMonExt2(), RenglonAsiento.DEBE);

			// Diferencia de Cambio Creditos
			RenglonAsiento renglon3 = renglones.addRenglonAsiento();
			renglon3.setCuentaImputable(CuentasParametrizadas.getDiferenciaCambio(getSesion()));
			renglon3.setMonedaOri(aplicComproClieDet.getTranClieVto().getMoneda());
			renglon3.setImporteOri(aplicComproClieDet.getAplicmonedaori());
			renglon3.setCotizOri(aplicComproClieDet.getCotizmonorihoy());
			renglon3.setCotizMonExt1(aplicComproClieDet.getCotizmonext1hoy());
			renglon3.setCotizMonExt2(aplicComproClieDet.getCotizmonext2hoy());
			renglon3.setComentario("");

			CalcDifCambio calcDifCambio3 = new CalcDifCambio(getSesion());
			calcDifCambio3.setCotizMonOrigenConta(aplicComproClieDet.getCotizmonoricont());
			calcDifCambio3.setCotizMonExt1Conta(aplicComproClieDet.getCotizmonext1cont());
			calcDifCambio3.setCotizMonExt2Conta(aplicComproClieDet.getCotizmonext2cont());
			calcDifCambio3.setCotizMonOrigenHoy(aplicComproClieDet.getCotizmonorihoy());
			calcDifCambio3.setCotizMonExt1Hoy(aplicComproClieDet.getCotizmonext1hoy());
			calcDifCambio3.setCotizMonExt2Hoy(aplicComproClieDet.getCotizmonext2hoy());
			calcDifCambio3.setImporteAplicacion(aplicComproClieDet.getAplicmonedaori());
			calcDifCambio3.calcular();

			renglon3.setImpoLocHist(calcDifCambio3.getCreditosDifCambio().getImpoMonLoc(), RenglonAsiento.HABER);
			renglon3.setImpoLocAju(calcDifCambio3.getCreditosDifCambio().getImpoMonLocAju(), RenglonAsiento.HABER);
			renglon3.setImpoMonExt1(calcDifCambio3.getCreditosDifCambio().getImpoMonExt1(), RenglonAsiento.HABER);
			renglon3.setImpoMonExt2(calcDifCambio3.getCreditosDifCambio().getImpoMonExt2(), RenglonAsiento.HABER);

		}

		return renglones;

	}

	/**
	 * getImputacion
	 * 
	 * @return Date
	 */
	public static AplicacionComproClie findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AplicacionComproClie) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AplicacionComproClie findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AplicacionComproClie) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void anular() throws BaseException {

		anuladorAplicacionCliente = (AnuladorComproClieAplic) AnuladorComproClieAplic.getNew(AnuladorComproClieAplic.NICKNAME, getSesion());
		anuladorAplicacionCliente.setCompro_aplic_cliente(this);
		anuladorAplicacionCliente.generarComproAnulacion();
		anuladorAplicacionCliente.save();

	}

	public List getAplicacionesClienteVto() throws BaseException {
		return AplicClieVto.getAplicacionesClienteVto(this, this.getSesion());
	}

	public static List getAplicacionesActivasCompro(ComproCab compro, ISesion aSesion) throws BaseException {
		return DBAplicacionComproClie.getAplicacionesActivasCompro(compro, aSesion);
	}

}
