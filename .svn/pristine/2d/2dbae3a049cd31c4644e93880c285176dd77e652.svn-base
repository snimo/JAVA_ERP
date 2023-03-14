package com.srn.erp.tesoreria.bm;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class CertificadoRetencionSUS extends ValorBase  {
	
	public static String		ENTRADA	= "ENTRADA";

	public static String		SALIDA	= "SALIDA";
	
	
  public CertificadoRetencionSUS() {
  }

  public void beforeSave() throws BaseException {
    validarDatosChequePropio();
  }

  public void validarDatosChequePropio() throws BaseException {
  	
  	if ((this.getNroCertificado()==null) || (this.getNroCertificado().trim().equals("")))
  		throw new ExceptionValidation(null,"Debe ingresar el Nro. de Certificado");
    if (getTipoValor() == null)
      throw new ExceptionValidation(null,"Debe ingresar el tipo de Valor");
    if (getFechaEmision() == null)
      throw new ExceptionValidation(null,"Debe ingresar la Fecha de Emisión");
    if (getImporte() == null)
      throw new ExceptionValidation(null,"Debe ingresar el Importe");
  }

  public void save() throws BaseException {
        
    if (this.getTipoOper().equals(ENTRADA)) {
    	beforeSave();
    	setValorCertificado((Valor) Valor.getNew(Valor.NICKNAME,getSesion()));
    	this.getValorCertificado().setTipovalor(getTipoValor());
    	this.getValorCertificado().setCaja(this.getCaja());
    	this.getValorCertificado().setFechaemision(getFechaEmision());
    	this.getValorCertificado().setAnulado(new Boolean(false));
    	this.getValorCertificado().setEndosado(new Boolean(false));
    	this.getValorCertificado().setDepositado(new Boolean(false));
    	this.getValorCertificado().setRechazado(new Boolean(false));
    	this.getValorCertificado().setCobrado(new Boolean(false));
    	this.getValorCertificado().setRecibido(new Boolean(false));
    	this.getValorCertificado().setSujeto(this.getSujeto());
    	this.getValorCertificado().setImporte(getImporte());
    	this.getValorCertificado().setSaldo(getImporte());
    	if (this.getTipoValor().isSeguimientoCaja())
    		this.getValorCertificado().setEstaencaja(new Boolean(true));
    	else
    		this.getValorCertificado().setEstaencaja(new Boolean(false));
    	this.getValorCertificado().setUsuario(getSesion().getLogin().getUsuario());
    	this.getValorCertificado().setCotizacion(getCotizMonOri());
    	this.getValorCertificado().setNroCertificado(this.getNroCertificado());
    	this.getValorCertificado().save();
    } else {
			if (this.depositar())
				depositarCertificado();
			else if (this.isDevolucion())
				devolverCertificado();
			else if (this.isLiquidando())
				liquidarCertificado();
    	
    }
    afterSave();
  }
  
	private void devolverCertificado() throws BaseException {
		// Marcar el cheque como depositado
		this.getValorCertificado().supportRefresh();
		this.getValorCertificado().setDevuelto(true);
		this.getValorCertificado().setEstaencaja(new Boolean(false));
		this.getValorCertificado().save();
	}
  
	private void depositarCertificado() throws BaseException {
		// Marcar el cheque como depositado
		this.getValorCertificado().supportRefresh();
		this.getValorCertificado().setDepositado(new Boolean(true));
		this.getValorCertificado().setEstaencaja(new Boolean(false));
		this.getValorCertificado().save();
	}
  

  public void afterSave() throws BaseException {
	  if ((this.getTipoValor()!=null) && (this.getTipoValor().isSeguimientoCaja()!=null) && (this.getTipoValor().isSeguimientoCaja().booleanValue() == false))
		  return;
	  
	  if ((this.getValorCertificado()!=null) && (this.getValorCertificado().getTipovalor()!=null) && (this.getValorCertificado().getTipovalor().isSeguimientoCaja()!=null) && (this.getValorCertificado().getTipovalor().isSeguimientoCaja().booleanValue()==false))
		  return;
	  
	  movimientoArqueo();
  }
  
  private void movimientoArqueo() throws BaseException {
	MovimientoCaja movCaja = (MovimientoCaja) MovimientoCaja.getNew(MovimientoCaja.NICKNAME,getSesion());
	movCaja.setCaja(getCaja());
	movCaja.setComprobante(getComprobante());
	movCaja.setFechacaja(getCaja().getFechaCaja());
	movCaja.setValor(this.getValorCertificado());
	movCaja.setSujeto(getSujeto());
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

	private void liquidarCertificado() throws BaseException {
		// Marcar el cheque como depositado
		this.getValorCertificado().supportRefresh();
		this.getValorCertificado().setLiquidado(new Boolean(true));
		this.getValorCertificado().setEstaencaja(new Boolean(false));
		this.getValorCertificado().save();
	}


}
