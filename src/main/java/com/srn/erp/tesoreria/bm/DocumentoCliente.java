package com.srn.erp.tesoreria.bm;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class DocumentoCliente extends ValorBase  {
	
	public static String		ENTRADA	= "ENTRADA";

	public static String		SALIDA	= "SALIDA";
	
	
  public DocumentoCliente() {
  }

  public void beforeSave() throws BaseException {
    validarDatosChequePropio();
  }

  public void validarDatosChequePropio() throws BaseException {
    if (getTipoValor() == null)
      throw new ExceptionValidation(null,"Debe ingresar el tipo de Valor");
    if (getFechaEmision() == null)
      throw new ExceptionValidation(null,"Debe ingresar la Fecha de Emisión");
    if (getFechaVencimiento() == null)
      throw new ExceptionValidation(null,"Debe ingresar la Fecha de Vencimiento");
    if (getImporte() == null)
      throw new ExceptionValidation(null,"Debe ingresar el Importe");
  }

  public void save() throws BaseException {
    
    if (this.getTipoOper().equals(ENTRADA)) {
    	beforeSave();
    	this.setDocumentoCliente((Valor) Valor.getNew(Valor.NICKNAME,getSesion()));    
    	this.getDocumentoCliente().setTipovalor(getTipoValor());
    	this.getDocumentoCliente().setCaja(this.getCaja());
    	this.getDocumentoCliente().setFechaemision(getFechaEmision());
    	this.getDocumentoCliente().setFechavto(getFechaVencimiento());
    	this.getDocumentoCliente().setAnulado(new Boolean(false));
    	this.getDocumentoCliente().setEndosado(new Boolean(false));
    	this.getDocumentoCliente().setDepositado(new Boolean(false));
    	this.getDocumentoCliente().setRechazado(new Boolean(false));
    	this.getDocumentoCliente().setCobrado(new Boolean(false));
    	this.getDocumentoCliente().setRecibido(new Boolean(false));
    	this.getDocumentoCliente().setLiquidado(new Boolean(false));
    	this.getDocumentoCliente().setSujeto(this.getSujeto());
    	this.getDocumentoCliente().setImporte(getImporte());
    	this.getDocumentoCliente().setSaldo(getImporte());
    	if (this.getTipoValor().isSeguimientoCaja())
    		this.getDocumentoCliente().setEstaencaja(new Boolean(true));
    	else
    		this.getDocumentoCliente().setEstaencaja(new Boolean(false));
    	this.getDocumentoCliente().setUsuario(getSesion().getLogin().getUsuario());
    	this.getDocumentoCliente().setCotizacion(getCotizMonOri());
    	this.getDocumentoCliente().setNro_valor(this.getNro());
    	this.getDocumentoCliente().save();
    }  else {
			if (this.depositar())
				depositarDocumentoCliente();
			else if (this.isDevolucion())
				devolverDocumentoCliente();
    }
    afterSave();
  }
  
	private void devolverDocumentoCliente() throws BaseException {
		// Marcar el cheque como depositado
		this.getDocumentoCliente().setDevuelto(true);
		this.getDocumentoCliente().setEstaencaja(new Boolean(false));
		this.getDocumentoCliente().save();
	}
  
	private void depositarDocumentoCliente() throws BaseException {
		// Marcar el cheque como depositado
		this.getDocumentoCliente().setDepositado(new Boolean(true));
		this.getDocumentoCliente().setEstaencaja(new Boolean(false));
		this.getDocumentoCliente().save();
	}
  

  public void afterSave() throws BaseException {
	  if ((this.getTipoValor()!=null) && (this.getTipoValor().isSeguimientoCaja()!=null) && (this.getTipoValor().isSeguimientoCaja().booleanValue() == false))
		  return;
	  
	  if ((this.getDocumentoCliente()!=null) && (this.getDocumentoCliente().getTipovalor()!=null) && (this.getDocumentoCliente().getTipovalor().isSeguimientoCaja()!=null) && (this.getDocumentoCliente().getTipovalor().isSeguimientoCaja().booleanValue()==false))
		  return;
	  
	  movimientoArqueo();
  }
  
  private void movimientoArqueo() throws BaseException {
	MovimientoCaja movCaja = (MovimientoCaja) MovimientoCaja.getNew(MovimientoCaja.NICKNAME,getSesion());
	movCaja.setCaja(getCaja());
	movCaja.setComprobante(getComprobante());
	movCaja.setFechacaja(getCaja().getFechaCaja());
	movCaja.setValor(this.getDocumentoCliente());
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


}
