package com.srn.erp.tesoreria.bm;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class CuponTicket extends ValorBase {
	
	public static String		ENTRADA	= "ENTRADA";

	public static String		SALIDA	= "SALIDA";
	
  
  public CuponTicket() {
  }

  public void beforeSave() throws BaseException {
    validarDatosChequePropio();
  }

  public void validarDatosChequePropio() throws BaseException {
    if (getTipoValor() == null)
      throw new ExceptionValidation(null,"Debe ingresar el tipo de Valor");
    if (getImporte() == null)
      throw new ExceptionValidation(null,"Debe ingresar el Importe");
  }

  public void save() throws BaseException {
    
    if (this.getTipoOper().equals(ENTRADA)) {
    	beforeSave();
    	setCuponTicket((Valor) Valor.getNew(Valor.NICKNAME,getSesion()));
    	this.getCuponTicket().setTipovalor(getTipoValor());
    	this.getCuponTicket().setCaja(this.getCaja());
    	this.getCuponTicket().setFechaemision(getFechaEmision());
    	this.getCuponTicket().setFechavto(getFechaVencimiento());
    	this.getCuponTicket().setAnulado(new Boolean(false));
    	this.getCuponTicket().setEndosado(new Boolean(false));
    	this.getCuponTicket().setDepositado(new Boolean(false));
    	this.getCuponTicket().setRechazado(new Boolean(false));
    	this.getCuponTicket().setCobrado(new Boolean(false));
    	this.getCuponTicket().setRecibido(new Boolean(false));
    	this.getCuponTicket().setLiquidado(new Boolean(false));
    	this.getCuponTicket().setSujeto(this.getSujeto());
    	this.getCuponTicket().setImporte(getImporte());
    	this.getCuponTicket().setSaldo(getImporte());
    	if (this.getTipoValor().isSeguimientoCaja())
    		this.getCuponTicket().setEstaencaja(new Boolean(true));
    	else
    		this.getCuponTicket().setEstaencaja(new Boolean(false));
    	this.getCuponTicket().setUsuario(getSesion().getLogin().getUsuario());
    	this.getCuponTicket().setCotizacion(getCotizMonOri());
    	this.getCuponTicket().setLote(this.getLote());
    	this.getCuponTicket().setCupon(this.getNroCupon());
    	this.getCuponTicket().setNro_tarjeta(this.getNroTarjeta());
    	this.getCuponTicket().setTicket(this.getTicket());
    	this.getCuponTicket().setCuotas(this.getCuotas());
    	this.getCuponTicket().save();
    } else {
			if (this.depositar())
				depositarCuponTicket();
			else if (this.isDevolucion())
				devolverCuponTicket();
    }
    afterSave();
  }
  
	private void devolverCuponTicket() throws BaseException {
		// Marcar el cheque como depositado
		this.getCuponTicket().setDevuelto(true);
		this.getCuponTicket().setEstaencaja(new Boolean(false));
		this.getCuponTicket().save();
	}
  
	private void depositarCuponTicket() throws BaseException {
		// Marcar el cheque como depositado
		this.getCuponTicket().setDepositado(new Boolean(true));
		this.getCuponTicket().setEstaencaja(new Boolean(false));
		this.getCuponTicket().save();
	}
  

  public void afterSave() throws BaseException {

	  if ((this.getTipoValor()!=null) && (this.getTipoValor().isSeguimientoCaja()!=null) && (this.getTipoValor().isSeguimientoCaja().booleanValue() == false))
		  return;
	  
	  if ((this.getCuponTicket()!=null) && (this.getCuponTicket().getTipovalor()!=null) && (this.getCuponTicket().getTipovalor().isSeguimientoCaja().booleanValue()==false))
		  return;
	  
	  movimientoArqueo();
  }
  
  private void movimientoArqueo() throws BaseException {
	MovimientoCaja movCaja = (MovimientoCaja) MovimientoCaja.getNew(MovimientoCaja.NICKNAME,getSesion());
	movCaja.setCaja(getCaja());
	movCaja.setComprobante(getComprobante());
	movCaja.setFechacaja(getCaja().getFechaCaja());
	movCaja.setSujeto(getSujeto());
	movCaja.setValor(this.getCuponTicket());
	if (getTipoOper().equals(ENTRADA)) {
	   movCaja.setSigno(new Integer(1));
	   movCaja.setEntrada(getImporte());
	   movCaja.setSalida(new Money(0));
	}
	else {
	   movCaja.setSigno(new Integer( -1));
	   movCaja.setEntrada(new Money(0));
	   movCaja.setSalida(getImporte());
	}
	movCaja.setImporte(getImporte());
	movCaja.setMoneda(getTipoValor().getMoneda());
	movCaja.setTipovalor(getTipoValor());
	movCaja.setCompotipovalor(getTipoValor().getCompo());
	movCaja.setCotizacion(getCotizMonOri());
	movCaja.setFechaReal(Fecha.getFechaActual());
	movCaja.setHora(Fecha.getHoraActual());
	movCaja.setUsuario(this.getSesion().getLogin().getUsuario());
	movCaja.setActivo(new Boolean(true));
	movCaja.save();
	  
  }


}
