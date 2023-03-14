package com.srn.erp.tesoreria.bm;

import java.util.Date;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class Efectivo {

  public static String ENTRADA = "ENTRADA";
  public static String SALIDA = "SALIDA";

  private ISesion sesion;
  private TipoValor tipoValor;
  private Date fechaCaja;
  private Money importe;
  private String tipoOper;
  private ComproCab comprobante;
  private ValorCotizacion cotizacion;
  private Caja caja;
  private Boolean activo;
  private Sujeto sujeto;

  public void setActivo(Boolean aActivo) {
    this.activo = aActivo;
  }

  public Boolean getActivo() {
    return activo;
  }
  
  public void setSujeto(Sujeto aSujeto) {
	this.sujeto = aSujeto;
  }

  public Sujeto getSujeto() {
	return sujeto;
  }
  

  private MovimientoCaja movCaja = null;

  public Efectivo() {
  }

  public ValorCotizacion getCotizacion() throws BaseException {
    return cotizacion;
  }

  public void setCotizacion(ValorCotizacion aValorCotizacion) throws BaseException {
    this.cotizacion = aValorCotizacion;
  }

  public Caja getCaja() throws BaseException {
    return caja;
  }

  public void setCaja(Caja aCaja) throws BaseException {
    this.caja = aCaja;
  }


  public void setComprobante(ComproCab aComproCAB) {
    this.comprobante = aComproCAB;
  }

  public ComproCab getComprobante() throws BaseException {
    return comprobante;
  }

  public void setTipoOper(String aTipoOper) {
    this.tipoOper = aTipoOper;
  }

  public String getTipoOper() {
    return tipoOper;
  }

  public Money getImporte() {
    return importe;
  }

  public Date getFechaCaja() {
    return fechaCaja;
  }

  public void setImporte(Money importe) {
    this.importe = importe;
  }

  public void setFechaCaja(Date aFechaCaja) {
    this.fechaCaja = aFechaCaja;
  }

  public void setSesion(ISesion sesion) {
    this.sesion = sesion;
  }

  public void setTipoValor(TipoValor tipoValor) {
    this.tipoValor = tipoValor;
  }

  public ISesion getSesion() {
    return sesion;
  }

  public TipoValor getTipoValor() {
    return tipoValor;
  }

  public void beforeSave() throws BaseException {
    validarDatosEfectivo();
  }

  public void validarDatosEfectivo() throws BaseException {
    if (getTipoValor() == null)
      throw new ExceptionValidation(null,"Debe ingresar el tipo de Valor");
    if (getFechaCaja() == null)
      throw new ExceptionValidation(null,"Debe ingresar la Fecha de movimiento en la Caja");
    if (getImporte() == null)
      throw new ExceptionValidation(null,"Debe ingresar el Importe");
    if (getCaja() == null)
      throw new ExceptionValidation(null,"Debe ingresar la caja");
  }

  public void save() throws BaseException {
    beforeSave();
    
    if (this.getTipoValor().isSeguimientoCaja().booleanValue() == false) return;
    	
    
    movCaja = (MovimientoCaja) MovimientoCaja.getNew(MovimientoCaja.NICKNAME,getSesion());
    movCaja.setCaja(getCaja());
    movCaja.setComprobante(getComprobante());
    movCaja.setFechacaja(getCaja().getFechaCaja());
    movCaja.setValor(null);
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
    movCaja.setCotizacion(getCotizacion());
    movCaja.setFechaReal(Fecha.getFechaActual());
    movCaja.setHora(Fecha.getHoraActual());
    movCaja.setUsuario(sesion.getLogin().getUsuario());
    movCaja.setActivo(getActivo());
    movCaja.save();
    afterSave();
  }

  public void afterSave() throws BaseException {
  }

}
