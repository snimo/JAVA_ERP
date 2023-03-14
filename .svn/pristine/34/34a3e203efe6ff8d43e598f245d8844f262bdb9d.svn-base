package com.srn.erp.pagos.bm;

import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.pagos.da.DBComproOrdenPagoMediosPago;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class ComproOrdenPagoMediosPago extends ObjetoLogico {

	public ComproOrdenPagoMediosPago() {
	}

	public static String NICKNAME = "pag.ComproOrdenPagoMediosPago";

	private ComproCab comprobante;
	private Valor valor;
	private TipoValor tipoValor;
	private Money impoMonValor;
	private Money impoMonPago;
	private Money impoMonLocal;
	private Double cotizacion;
	private Caja caja;

	public ComproCab getComprobante() throws BaseException {
		supportRefresh();
		return comprobante;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public Caja getCaja() throws BaseException {
		supportRefresh();
		return caja;
	}

	public void setCaja(Caja aCaja) {
		this.caja = aCaja;
	}

	public Valor getValor() throws BaseException {
		supportRefresh();
		return valor;
	}

	public void setValor(Valor aValor) {
		this.valor = aValor;
	}

	public TipoValor getTipovalor() throws BaseException {
		supportRefresh();
		return tipoValor;
	}

	public void setTipovalor(TipoValor aTipovalor) {
		this.tipoValor = aTipovalor;
	}

	public Money getImpomonvalor() throws BaseException {
		supportRefresh();
		return impoMonValor;
	}

	public void setImpomonvalor(Money aImpomonvalor) {
		this.impoMonValor = aImpomonvalor;
	}

	public Money getImpoMonLocal() throws BaseException {
		supportRefresh();
		return impoMonLocal;
	}

	public void setImpoMonLocal(Money aImpoMonLocal) {
		this.impoMonLocal = aImpoMonLocal;
	}

	public Money getImpomonpago() throws BaseException {
		supportRefresh();
		return impoMonPago;
	}

	public void setImpomonpago(Money aImpomonpago) {
		this.impoMonPago = aImpomonpago;
	}

	public Double getCotizacion() throws BaseException {
		supportRefresh();
		return cotizacion;
	}

	public void setCotizacion(Double aCotizacion) {
		this.cotizacion = aCotizacion;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ComproOrdenPagoMediosPago findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ComproOrdenPagoMediosPago) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ComproOrdenPagoMediosPago findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ComproOrdenPagoMediosPago) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ComproOrdenPagoMediosPago findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ComproOrdenPagoMediosPago) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	/**
	 * isActivo
	 * 
	 * @return Boolean
	 */
	public Boolean isActivo() {
		return null;
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
	public String getCodigo() {
		return "";
	}

	public static List getMediosPago(ComproOrdenPagoCab comproOrdenPagoCab, ISesion aSesion) throws BaseException {
		return DBComproOrdenPagoMediosPago.getMediosPago(comproOrdenPagoCab, aSesion);
	}

}
