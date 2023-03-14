package com.srn.erp.conciTarjeta.bm;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class RegDetPOSNET {
	
	private String modoTransmision;
	private String tipoTransaccion;
	private String fechaOperativa;
	private String horaOperativa;
	private String tipoTarjeta;
	private String tarjeta;
	public String getModoTransmision() {
		return modoTransmision;
	}
	public void setModoTransmision(String modoTransmision) {
		this.modoTransmision = modoTransmision;
	}
	public String getTipoTransaccion() {
		return tipoTransaccion;
	}
	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}
	public String getFechaOperativa() {
		return fechaOperativa;
	}
	public void setFechaOperativa(String fechaOperativa) {
		this.fechaOperativa = fechaOperativa;
	}
	public String getHoraOperativa() {
		return horaOperativa;
	}
	public void setHoraOperativa(String horaOperativa) {
		this.horaOperativa = horaOperativa;
	}
	public String getTipoTarjeta() {
		return tipoTarjeta;
	}
	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}
	public String getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}
	public String getNroTarjeta() {
		return nroTarjeta;
	}
	public void setNroTarjeta(String nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}
	public String getBandaManual() {
		return bandaManual;
	}
	public void setBandaManual(String bandaManual) {
		this.bandaManual = bandaManual;
	}
	public String getCodAutoriz() {
		return codAutoriz;
	}
	public void setCodAutoriz(String codAutoriz) {
		this.codAutoriz = codAutoriz;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Money getMonto() {
		return monto;
	}
	public void setMonto(Money monto) {
		this.monto = monto;
	}
	public String getTipoCtaDebito() {
		return tipoCtaDebito;
	}
	public void setTipoCtaDebito(String tipoCtaDebito) {
		this.tipoCtaDebito = tipoCtaDebito;
	}
	public String getPlanycuota() {
		return planycuota;
	}
	public void setPlanycuota(String planycuota) {
		this.planycuota = planycuota;
	}
	public String getCodComercio() {
		return codComercio;
	}
	public void setCodComercio(String codComercio) {
		this.codComercio = codComercio;
	}
	public String getNroTerminal() {
		return nroTerminal;
	}
	public void setNroTerminal(String nroTerminal) {
		this.nroTerminal = nroTerminal;
	}
	public String getTicketSec() {
		return ticketSec;
	}
	public void setTicketSec(String ticketSec) {
		this.ticketSec = ticketSec;
	}
	public String getCodLista() {
		return codLista;
	}
	public void setCodLista(String codLista) {
		this.codLista = codLista;
	}
	public Money getMontoSec() {
		return montoSec;
	}
	public void setMontoSec(Money montoSec) {
		this.montoSec = montoSec;
	}
	public String getFechaSec() {
		return fechaSec;
	}
	public void setFechaSec(String fechaSec) {
		this.fechaSec = fechaSec;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	public String getNroHost() {
		return nroHost;
	}
	public void setNroHost(String nroHost) {
		this.nroHost = nroHost;
	}
	public String getNroLote() {
		return nroLote;
	}
	public void setNroLote(String nroLote) {
		this.nroLote = nroLote;
	}
	private String nroTarjeta;
	private String bandaManual;
	private String codAutoriz;
	private String ticket;
	private String moneda;
	private Money monto;
	private String tipoCtaDebito;
	private String planycuota;
	private String codComercio;
	private String nroTerminal;
	private String ticketSec;
	private String codLista;
	private Money montoSec;
	private String fechaSec;
	private String factura;
	private String nroHost;
	private String nroLote;
	
	public int getDia() {
		return new Integer(this.fechaOperativa.substring(0,2)).intValue();
	}
	
	public int getMes() {
		return new Integer(this.fechaOperativa.substring(2,4)).intValue();
	}	
	
	public int getAnio() {
		return new Integer(this.fechaOperativa.substring(4,6)).intValue()+2000;
	}
	
	public java.util.Date getFechaOperDate() throws BaseException {
		return Fecha.getFecha(getDia(), getMes(), getAnio());
	}
	
}
