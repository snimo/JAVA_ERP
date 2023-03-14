package com.srn.erp.legales.bm;

import java.text.DecimalFormat;
import java.util.List;

import com.srn.erp.legales.da.DBPagoSeclo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.Util;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PagoSeclo extends ObjetoLogico {

	@Override
	public void afterSave() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSave();

		Seclo.actualizarMontoPagado(this.getSeclo(), this.getSesion());

	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public PagoSeclo() {
	}

	public static String NICKNAME = "leg.PagoSeclo";

	private Seclo seclo;
	private java.util.Date fec_pago;
	private String observacion;
	private Money pago_acuerdo;
	private Boolean activo;
	private Money pago_letrado;
	private ConcPagoSeclo conc_pago;
	private Money pago_conciliador;
	private Money pago_otros;

	public Seclo getSeclo() throws BaseException {
		supportRefresh();
		return seclo;
	}

	public void setSeclo(Seclo aSeclo) {
		this.seclo = aSeclo;
	}

	public java.util.Date getFec_pago() throws BaseException {
		supportRefresh();
		return fec_pago;
	}

	public void setFec_pago(java.util.Date aFec_pago) {
		this.fec_pago = aFec_pago;
	}

	public String getObservacion() throws BaseException {
		supportRefresh();
		return observacion;
	}

	public void setObservacion(String aObservacion) {
		this.observacion = aObservacion;
	}

	public Money getPago_acuerdo() throws BaseException {
		supportRefresh();
		return pago_acuerdo;
	}

	public void setPago_acuerdo(Money aPago_acuerdo) {
		this.pago_acuerdo = aPago_acuerdo;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public Money getPago_letrado() throws BaseException {
		supportRefresh();
		return pago_letrado;
	}

	public void setPago_letrado(Money aPago_letrado) {
		this.pago_letrado = aPago_letrado;
	}

	public ConcPagoSeclo getConc_pago() throws BaseException {
		supportRefresh();
		return conc_pago;
	}

	public void setConc_pago(ConcPagoSeclo aConc_pago) {
		this.conc_pago = aConc_pago;
	}

	public Money getPago_conciliador() throws BaseException {
		supportRefresh();
		return pago_conciliador;
	}

	public void setPago_conciliador(Money aPago_conciliador) {
		this.pago_conciliador = aPago_conciliador;
	}

	public Money getPago_otros() throws BaseException {
		supportRefresh();
		return pago_otros;
	}

	public void setPago_otros(Money aPago_otros) {
		this.pago_otros = aPago_otros;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static PagoSeclo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PagoSeclo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PagoSeclo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PagoSeclo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(seclo, "Debe ingresar el Seclo");
		Validar.noNulo(fec_pago, "Debe ingresar fecha Pago");
		Validar.noNulo(conc_pago, "Debe ingresar el Concepto");
	}

	public static List getPagosSeclo(Seclo aSeclo, ISesion aSesion) throws BaseException {
		return DBPagoSeclo.getPagosSeclo(aSeclo, aSesion);
	}

	public String getLeyendaPago() throws BaseException {

		DecimalFormat myFormatter = new DecimalFormat("#,###");

		StringBuffer resp = new StringBuffer("");
		if (this.getFec_pago() != null)
			resp.append("Fecha " + Fecha.getddmmyyyy(this.getFec_pago()) + " " + Util.ENTER());

		if ((this.getPago_acuerdo() != null) && (this.getPago_acuerdo().doubleValue() != 0))
			resp.append("           Pago acuerdo " + myFormatter.format(this.getPago_acuerdo().doubleValue(2)) + " " + Util.ENTER());

		if ((this.getPago_letrado() != null) && (this.getPago_letrado().doubleValue() != 0))
			resp.append("           Pago letrado " + myFormatter.format(this.getPago_letrado().doubleValue(2)) + " " + Util.ENTER());

		if ((this.getPago_conciliador() != null) && (this.getPago_conciliador().doubleValue() != 0))
			resp.append("           Pago conciliador " + myFormatter.format(this.getPago_conciliador().doubleValue(2)) + " " + Util.ENTER());

		if ((this.getPago_otros() != null) && (this.getPago_otros().doubleValue() != 0))
			resp.append("           Pago otros " + myFormatter.format(this.getPago_otros().doubleValue(2)) + " " + Util.ENTER());

		if ((this.getObservacion() != null) && (this.getObservacion().trim() != ""))
			resp.append("           Obs. " + this.getObservacion());

		return resp.toString();

	}

	public static List getPagosSeclo(java.util.Date fecDesde, java.util.Date fecHasta, ISesion aSesion) throws BaseException {
		return DBPagoSeclo.getPagosSeclo(fecDesde, fecHasta, aSesion);
	}

	public Money getTotalPago() throws BaseException {
		CalculadorMoney total = new CalculadorMoney(new Money(0));
		if (this.getPago_acuerdo()!=null)
			total.sumar(this.getPago_acuerdo());
		if (this.getPago_conciliador()!=null)
			total.sumar(this.getPago_conciliador());		
		if (this.getPago_letrado()!=null)
			total.sumar(this.getPago_letrado());		
		if (this.getPago_otros()!=null)
			total.sumar(this.getPago_otros());		
		return total.getResultMoney();
	}

}
