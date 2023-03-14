package com.srn.erp.legales.bm;

import java.text.DecimalFormat;
import java.util.List;

import com.srn.erp.legales.da.DBPagoJuicio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.Util;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PagoJuicio extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public PagoJuicio() {
	}

	public static String NICKNAME = "leg.PagoJuicio";

	private Juicio juicio;
	private java.util.Date fec_pago;
	private String observacion;
	private ConcPagoSeclo concepto_pago_seclo;
	private Money pago_acuerdo;
	private Money pago_horario;
	private Money pago_perito;
	private Money pago_tasa_just;
	private Money pago_letrado;
	private Boolean activo;

	public Juicio getJuicio() throws BaseException {
		supportRefresh();
		return juicio;
	}

	public Money getPagoLetrado() throws BaseException {
		supportRefresh();
		return this.pago_letrado;
	}

	public void setJuicio(Juicio aJuicio) {
		this.juicio = aJuicio;
	}

	public void setPagoLetrado(Money aPagoLetrado) {
		this.pago_letrado = aPagoLetrado;
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

	public ConcPagoSeclo getConcepto_pago_seclo() throws BaseException {
		supportRefresh();
		return concepto_pago_seclo;
	}

	public void setConcepto_pago_seclo(ConcPagoSeclo aConcepto_pago_seclo) {
		this.concepto_pago_seclo = aConcepto_pago_seclo;
	}

	public Money getPago_acuerdo() throws BaseException {
		supportRefresh();
		return pago_acuerdo;
	}

	public void setPago_acuerdo(Money aPago_acuerdo) {
		this.pago_acuerdo = aPago_acuerdo;
	}

	public Money getPago_horario() throws BaseException {
		supportRefresh();
		return pago_horario;
	}

	public void setPago_horario(Money aPago_horario) {
		this.pago_horario = aPago_horario;
	}

	public Money getPago_perito() throws BaseException {
		supportRefresh();
		return pago_perito;
	}

	public void setPago_perito(Money aPago_perito) {
		this.pago_perito = aPago_perito;
	}

	public Money getPago_tasa_just() throws BaseException {
		supportRefresh();
		return pago_tasa_just;
	}

	public void setPago_tasa_just(Money aPago_tasa_just) {
		this.pago_tasa_just = aPago_tasa_just;
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

	public static PagoJuicio findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PagoJuicio) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PagoJuicio findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PagoJuicio) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(juicio, "Debe ingresar el Juicio");
		Validar.noNulo(fec_pago, "Debe ingresar la fecha de Pago");
	}

	public static List getPagosJuicio(Juicio aJuicio, ISesion aSesion) throws BaseException {
		return DBPagoJuicio.getPagosJuicio(aJuicio, aSesion);
	}

	public String getLeyendaPago() throws BaseException {

		DecimalFormat myFormatter = new DecimalFormat("#,###");

		StringBuffer resp = new StringBuffer("");
		if (this.getFec_pago() != null)
			resp.append("Fecha " + Fecha.getddmmyyyy(this.getFec_pago()) + " " + Util.ENTER());

		if ((this.getPago_acuerdo() != null) && (this.getPago_acuerdo().doubleValue() != 0))
			resp.append("           Pago acuerdo " + myFormatter.format(this.getPago_acuerdo().doubleValue(2)) + " " + Util.ENTER());

		if ((this.getPagoLetrado() != null) && (this.getPagoLetrado().doubleValue() != 0))
			resp.append("           Pago letrado " + myFormatter.format(this.getPagoLetrado().doubleValue(2)) + " " + Util.ENTER());

		if ((this.getPago_horario() != null) && (this.getPago_horario().doubleValue() != 0))
			resp.append("           Pago conciliador " + myFormatter.format(this.getPago_horario().doubleValue(2)) + " " + Util.ENTER());

		if ((this.getPago_perito() != null) && (this.getPago_perito().doubleValue() != 0))
			resp.append("           Pago perito " + myFormatter.format(this.getPago_perito().doubleValue(2)) + " " + Util.ENTER());

		if ((this.getPago_tasa_just() != null) && (this.getPago_tasa_just().doubleValue() != 0))
			resp.append("           Pago tasa justicia " + myFormatter.format(this.getPago_tasa_just().doubleValue(2)) + " " + Util.ENTER());

		if ((this.getObservacion() != null) && (this.getObservacion().trim() != ""))
			resp.append("           Obs. " + this.getObservacion());

		return resp.toString();

	}

	public static List getPagosJuicio(java.util.Date fecDesde, java.util.Date fecHasta, ISesion aSesion) throws BaseException {
		return DBPagoJuicio.getPagosJuicio(fecDesde, fecHasta, aSesion);
	}

	public Money getTotalPago() throws BaseException {
		
		CalculadorMoney totPago = new CalculadorMoney(new Money(0));
		
		if (getPago_acuerdo()!=null)
			totPago.sumar(getPago_acuerdo());
		if (getPago_horario()!=null)
			totPago.sumar(getPago_horario());		
		if (getPagoLetrado()!=null)
			totPago.sumar(getPagoLetrado());		
		if (getPago_perito()!=null)
			totPago.sumar(getPago_perito());		
		if (getPago_tasa_just()!=null)
			totPago.sumar(getPago_tasa_just());
		
		return totPago.getResultMoney();
	}

}
