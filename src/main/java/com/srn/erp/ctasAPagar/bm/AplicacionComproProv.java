package com.srn.erp.ctasAPagar.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.contabilidad.bm.CalcDifCambio;
import com.srn.erp.contabilidad.bm.CuentasParametrizadas;
import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.RenglonAsiento;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.ctasAPagar.da.DBAplicacionComproProv;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.IdentificacionTipoComprobante;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;

public class AplicacionComproProv extends ComproCab implements IContabilizable {

	public AplicacionComproProv() {
	}

	public static String NICKNAME = "cap.AplicacionComproProv";

	private Proveedor proveedor;
	private ComproCab comprobante;
	private List detalles = new ArrayList();
	private java.util.Date imputacion;
	private Boolean noContaOtrasMonedas;
	private Boolean allowDesaplicar;

	private AnuladorComproProvAplic anuladorComproProvAplic = null;

	public void setNoContaOtrasMonedas(Boolean noContaOtrasMonedas) {
		this.noContaOtrasMonedas = noContaOtrasMonedas;
	}

	public Boolean getNoContaOtrasMonedas() throws BaseException {
		supportRefresh();
		return noContaOtrasMonedas;
	}

	public Proveedor getProveedor() throws BaseException {
		supportRefresh();
		return proveedor;
	}

	public void setProveedor(Proveedor aProveedor) {
		this.proveedor = aProveedor;
	}

	public Boolean isAllowDesaplicar() throws BaseException {
		supportRefresh();
		return this.allowDesaplicar;
	}

	public void setAllowDesaplicar(Boolean aAllowDesaplicar) {
		this.allowDesaplicar = aAllowDesaplicar;
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
			AplicacionComproProvDet aplicComproProvDet = (AplicacionComproProvDet) iterDetalles.next();
			aplicComproProvDet.save();

			AplicarCtaCteProv aplicCtaCteProv = new AplicarCtaCteProv(getSesion());
			aplicCtaCteProv.setComprobante(this);
			aplicCtaCteProv.setComprobanteOri(aplicComproProvDet.getComproAplicOri());
			aplicCtaCteProv.setTipoCtaCteProv(aplicComproProvDet.getTranprovvto().getTranprov().getTipocuenta());
			aplicCtaCteProv.setProveedor(aplicComproProvDet.getTranprovvto().getTranprov().getProveedor());
			aplicCtaCteProv.setMoneda(aplicComproProvDet.getTranprovvto().getTranprov().getMoneda());
			aplicCtaCteProv.setImporte(aplicComproProvDet.getAplicmonedaori());
			aplicCtaCteProv.setEmision(getEmision());
			aplicCtaCteProv.setImputac(getImputacion());
			aplicCtaCteProv.setDiasBase(new Integer(0));
			aplicCtaCteProv.setDiasVto(new Integer(0));
			aplicCtaCteProv.setTranVto(aplicComproProvDet.getTranprovvto());
			aplicCtaCteProv.setTranVtoOri(aplicComproProvDet.getTranprovvtoAplic());
			aplicCtaCteProv.setValorCotizMonOri(aplicComproProvDet.getCotizmonorihoy());
			aplicCtaCteProv.setValorCotizMonExt1(aplicComproProvDet.getCotizmonext1hoy());
			aplicCtaCteProv.setValorCotizMonExt2(aplicComproProvDet.getCotizmonext2hoy());
			aplicCtaCteProv.grabarAplicacion();

			// marcarCuotaComoNoAutoriz(aplicComproProvDet);

			aplicComproProvDet = null;

		}
		iterDetalles = null;
		afterSaveComprobante(this);

	}

	private void marcarCuotaComoNoAutoriz(AplicacionComproProvDet aplicComproProvDet) throws BaseException {
		// Marcar la Factura o Nota de Debito como No Autorizada
		if ((aplicComproProvDet.getTranprovvto().getTranprov().getComprobante().getTipoCompro().getIdentificacion()
				.equals(IdentificacionTipoComprobante.COMPRO_FACTURA_PROVEEDOR))
				|| (aplicComproProvDet.getTranprovvto().getTranprov().getComprobante().getTipoCompro().getIdentificacion()
						.equals(IdentificacionTipoComprobante.COMPRO_ND_PROVEEDOR))) {
			AutorizacionFactProv autorizFactProv = AutorizacionFactProv.getAutorizByTranProvVto(aplicComproProvDet.getTranprovvto(),
					getSesion());

			if (autorizFactProv != null) {
				autorizFactProv.desAutorizar();
				autorizFactProv.save();
			}
			;

		}
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
	public static boolean contabilizarComprobante(ISesion aSesion) throws BaseException {
		ValorParametro valorParamContabilizaComproProv = ValorParametro.findByCodigoParametro("CONTA_APLIC_COMPRO_PROV", aSesion);
		return valorParamContabilizaComproProv.getBoolean();
	}

	public static Talonario getTalonatioAplicComproProv(ISesion aSesion) throws BaseException {
		return Talonario.getTalonatioAplicComproProv(aSesion);
	}

	public static TipoComprobante getTipoComproAplicProv(ISesion aSesion) throws BaseException {
		ValorParametro valorParamContabilizaComproProv = ValorParametro.findByCodigoParametro("TC_APLIC_PROV", aSesion);
		TipoComprobante tc = TipoComprobante.findByOidProxy(valorParamContabilizaComproProv.getOidObjNeg(), aSesion);
		return tc;
	}

	// Agregar Detalle
	public AplicacionComproProvDet addDetalle() throws BaseException {
		AplicacionComproProvDet aplicComproProvDet = (AplicacionComproProvDet) AplicacionComproProvDet.getNew(
				AplicacionComproProvDet.NICKNAME, getSesion());
		aplicComproProvDet.setComprocab(this);
		detalles.add(aplicComproProvDet);
		return aplicComproProvDet;
	}

	public List getDetalles() throws BaseException {
		return this.detalles;
	}

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {
		RenglonesAsiento renglones = new RenglonesAsiento();

		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			AplicacionComproProvDet aplicComproProvDet = (AplicacionComproProvDet) iterDetalles.next();

			// Debitos
			RenglonAsiento renglon = renglones.addRenglonAsiento();
			renglon.setCuentaImputable(CuentasParametrizadas.getProveedores(getSesion()));
			renglon.setMonedaOri(aplicComproProvDet.getTranprovvto().getMoneda());
			renglon.setImporteOri(aplicComproProvDet.getAplicmonedaori());
			renglon.setCotizOri(aplicComproProvDet.getCotizmonorihoy());
			renglon.setCotizMonExt1(aplicComproProvDet.getCotizmonext1hoy());
			renglon.setCotizMonExt2(aplicComproProvDet.getCotizmonext2hoy());
			renglon.setComentario("");

			CalcDifCambio calcDifCambio = new CalcDifCambio(getSesion());
			calcDifCambio.setCotizMonOrigenConta(aplicComproProvDet.getCotizmonoricont());
			calcDifCambio.setCotizMonExt1Conta(aplicComproProvDet.getCotizmonext1cont());
			calcDifCambio.setCotizMonExt2Conta(aplicComproProvDet.getCotizmonext2cont());
			calcDifCambio.setCotizMonOrigenHoy(aplicComproProvDet.getCotizmonorihoy());
			calcDifCambio.setCotizMonExt1Hoy(aplicComproProvDet.getCotizmonext1hoy());
			calcDifCambio.setCotizMonExt2Hoy(aplicComproProvDet.getCotizmonext2hoy());
			calcDifCambio.setImporteAplicacion(aplicComproProvDet.getAplicmonedaori());
			calcDifCambio.calcular();

			renglon.setImpoLocHist(calcDifCambio.getDebitosImportesConta().getImpoMonLoc(), RenglonAsiento.DEBE);
			renglon.setImpoLocAju(calcDifCambio.getDebitosImportesConta().getImpoMonLocAju(), RenglonAsiento.DEBE);
			renglon.setImpoMonExt1(calcDifCambio.getDebitosImportesConta().getImpoMonExt1(), RenglonAsiento.DEBE);
			renglon.setImpoMonExt2(calcDifCambio.getDebitosImportesConta().getImpoMonExt2(), RenglonAsiento.DEBE);

			// Creditos
			RenglonAsiento renglon1 = renglones.addRenglonAsiento();
			renglon1.setCuentaImputable(CuentasParametrizadas.getProveedores(getSesion()));
			renglon1.setMonedaOri(aplicComproProvDet.getTranprovvto().getMoneda());
			renglon1.setImporteOri(aplicComproProvDet.getAplicmonedaori());
			renglon1.setCotizOri(aplicComproProvDet.getCotizmonorihoy());
			renglon1.setCotizMonExt1(aplicComproProvDet.getCotizmonext1hoy());
			renglon1.setCotizMonExt2(aplicComproProvDet.getCotizmonext2hoy());

			renglon1.setComentario("");

			CalcDifCambio calcDifCambio1 = new CalcDifCambio(getSesion());
			calcDifCambio1.setCotizMonOrigenConta(aplicComproProvDet.getCotizmonoricont());
			calcDifCambio1.setCotizMonExt1Conta(aplicComproProvDet.getCotizmonext1cont());
			calcDifCambio1.setCotizMonExt2Conta(aplicComproProvDet.getCotizmonext2cont());
			calcDifCambio1.setCotizMonOrigenHoy(aplicComproProvDet.getCotizmonorihoy());
			calcDifCambio1.setCotizMonExt1Hoy(aplicComproProvDet.getCotizmonext1hoy());
			calcDifCambio1.setCotizMonExt2Hoy(aplicComproProvDet.getCotizmonext2hoy());
			calcDifCambio1.setImporteAplicacion(aplicComproProvDet.getAplicmonedaori());
			calcDifCambio1.calcular();

			renglon1.setImpoLocHist(calcDifCambio1.getCreditosImportesConta().getImpoMonLoc(), RenglonAsiento.HABER);
			renglon1.setImpoLocAju(calcDifCambio1.getCreditosImportesConta().getImpoMonLocAju(), RenglonAsiento.HABER);
			renglon1.setImpoMonExt1(calcDifCambio1.getCreditosImportesConta().getImpoMonExt1(), RenglonAsiento.HABER);
			renglon1.setImpoMonExt2(calcDifCambio1.getCreditosImportesConta().getImpoMonExt2(), RenglonAsiento.HABER);

			// Diferencia de Cambio Debitos
			RenglonAsiento renglon2 = renglones.addRenglonAsiento();
			renglon2.setCuentaImputable(CuentasParametrizadas.getDiferenciaCambio(getSesion()));
			renglon2.setMonedaOri(aplicComproProvDet.getTranprovvto().getMoneda());
			renglon2.setImporteOri(aplicComproProvDet.getAplicmonedaori());
			renglon2.setCotizOri(aplicComproProvDet.getCotizmonorihoy());
			renglon2.setCotizMonExt1(aplicComproProvDet.getCotizmonext1hoy());
			renglon2.setCotizMonExt2(aplicComproProvDet.getCotizmonext2hoy());
			renglon2.setComentario("");

			CalcDifCambio calcDifCambio2 = new CalcDifCambio(getSesion());
			calcDifCambio2.setCotizMonOrigenConta(aplicComproProvDet.getCotizmonoricont());
			calcDifCambio2.setCotizMonExt1Conta(aplicComproProvDet.getCotizmonext1cont());
			calcDifCambio2.setCotizMonExt2Conta(aplicComproProvDet.getCotizmonext2cont());
			calcDifCambio2.setCotizMonOrigenHoy(aplicComproProvDet.getCotizmonorihoy());
			calcDifCambio2.setCotizMonExt1Hoy(aplicComproProvDet.getCotizmonext1hoy());
			calcDifCambio2.setCotizMonExt2Hoy(aplicComproProvDet.getCotizmonext2hoy());
			calcDifCambio2.setImporteAplicacion(aplicComproProvDet.getAplicmonedaori());
			calcDifCambio2.calcular();

			renglon2.setImpoLocHist(calcDifCambio2.getDebitosDifCambio().getImpoMonLoc(), RenglonAsiento.DEBE);
			renglon2.setImpoLocAju(calcDifCambio2.getDebitosDifCambio().getImpoMonLocAju(), RenglonAsiento.DEBE);
			renglon2.setImpoMonExt1(calcDifCambio2.getDebitosDifCambio().getImpoMonExt1(), RenglonAsiento.DEBE);
			renglon2.setImpoMonExt2(calcDifCambio2.getDebitosDifCambio().getImpoMonExt2(), RenglonAsiento.DEBE);

			// Diferencia de Cambio Creditos
			RenglonAsiento renglon3 = renglones.addRenglonAsiento();
			renglon3.setCuentaImputable(CuentasParametrizadas.getDiferenciaCambio(getSesion()));
			renglon3.setMonedaOri(aplicComproProvDet.getTranprovvto().getMoneda());
			renglon3.setImporteOri(aplicComproProvDet.getAplicmonedaori());
			renglon3.setCotizOri(aplicComproProvDet.getCotizmonorihoy());
			renglon3.setCotizMonExt1(aplicComproProvDet.getCotizmonext1hoy());
			renglon3.setCotizMonExt2(aplicComproProvDet.getCotizmonext2hoy());
			renglon3.setComentario("");

			CalcDifCambio calcDifCambio3 = new CalcDifCambio(getSesion());
			calcDifCambio3.setCotizMonOrigenConta(aplicComproProvDet.getCotizmonoricont());
			calcDifCambio3.setCotizMonExt1Conta(aplicComproProvDet.getCotizmonext1cont());
			calcDifCambio3.setCotizMonExt2Conta(aplicComproProvDet.getCotizmonext2cont());
			calcDifCambio3.setCotizMonOrigenHoy(aplicComproProvDet.getCotizmonorihoy());
			calcDifCambio3.setCotizMonExt1Hoy(aplicComproProvDet.getCotizmonext1hoy());
			calcDifCambio3.setCotizMonExt2Hoy(aplicComproProvDet.getCotizmonext2hoy());
			calcDifCambio3.setImporteAplicacion(aplicComproProvDet.getAplicmonedaori());
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
	public static AplicacionComproProv findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AplicacionComproProv) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AplicacionComproProv findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AplicacionComproProv) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public List getAplicacionesProveedor() throws BaseException {
		return AplProv.getAplicacionesProveedor(this, this.getSesion());
	}

	public void anular() throws BaseException {

		anuladorComproProvAplic = (AnuladorComproProvAplic) anuladorComproProvAplic.getNew(anuladorComproProvAplic.NICKNAME, getSesion());
		anuladorComproProvAplic.setCompro_apl_prov(this);
		anuladorComproProvAplic.generarComproAnulacion();
		anuladorComproProvAplic.save();

	}

	public static List getAplicacionesActivasCompro(ComproCab compro, ISesion aSesion) throws BaseException {
		return DBAplicacionComproProv.getAplicacionesActivasCompro(compro, aSesion);
	}

}
