package com.srn.erp.ctasACobrar.bm;

import java.util.Date;

import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class AplicarCtaCteClie  {

  private ISesion         sesion;
  private ComproCab       comprobante;
  private TipoCtaCteClie  tipoCtaCteClie;
  private Sujeto          sujeto;
  private Moneda          moneda;
  private Money           importe;
  private java.util.Date  emision;
  private java.util.Date  imputac;
  private Integer         diasBase;
  private Integer         diasVto;
  private ComproCab       comprobanteOri;
  private TranClieVto     tranVto;
  private TranClieVto     tranVtoOri;
  private ValorCotizacion valorCotizMonOri;
  private ValorCotizacion valorCotizMonExt1;
  private ValorCotizacion valorCotizMonExt2;


  public AplicarCtaCteClie(ISesion aSesion) throws BaseException {
    this.sesion = aSesion;
  }

  public void setValorCotizMonOri(ValorCotizacion valorCotizMonOri) throws BaseException {
    this.valorCotizMonOri = valorCotizMonOri;
  }

  public ValorCotizacion getValorCotizMonOri() throws BaseException {
    return valorCotizMonOri;
  }

  public void setValorCotizMonExt1(ValorCotizacion valorCotizMonExt1) throws BaseException {
    this.valorCotizMonExt1 = valorCotizMonExt1;
  }

  public ValorCotizacion getValorCotizMonExt1() throws BaseException {
    return valorCotizMonExt1;
  }

  public void setValorCotizMonExt2(ValorCotizacion valorCotizMonExt2) throws BaseException {
    this.valorCotizMonExt2 = valorCotizMonExt2;
  }

  public ValorCotizacion getValorCotizMonExt2() throws BaseException {
    return valorCotizMonExt2;
  }


  public Integer getDiasVto() {
    return diasVto;
  }

  public Money getImporte() {
    return importe;
  }

  public Date getEmision() {
    return emision;
  }

  public Sujeto getSujeto() {
    return sujeto;
  }

  public TipoCtaCteClie getTipoCtaCteClie() {
    return tipoCtaCteClie;
  }

  public ComproCab getComprobante() {
    return comprobante;
  }

  public Moneda getMoneda() {
    return moneda;
  }

  public ISesion getSesion() {
    return sesion;
  }

  public TranClieVto getTranVto() {
    return tranVto;
  }

  public TranClieVto getTranVtoOri() {
    return tranVtoOri;
  }


  public Integer getDiasBase() {
    return diasBase;
  }

  public Date getImputac() {
    return imputac;
  }

  public void setComprobanteOri(ComproCab comprobanteOri) {
    this.comprobanteOri = comprobanteOri;
  }

  public void setDiasVto(Integer diasVto) {
    this.diasVto = diasVto;
  }

  public void setImporte(Money importe) {
    this.importe = importe;
  }

  public void setEmision(Date emision) {
    this.emision = emision;
  }

  public void setSujeto(Sujeto sujeto) {
    this.sujeto = sujeto;
  }

  public void setTipoCtaCteClie(TipoCtaCteClie tipoCtaCteClie) {
    this.tipoCtaCteClie = tipoCtaCteClie;
  }

  public void setComprobante(ComproCab comprobante) {
    this.comprobante = comprobante;
  }

  public void setMoneda(Moneda moneda) {
    this.moneda = moneda;
  }

  public void setSesion(ISesion sesion) {
    this.sesion = sesion;
  }

  public void setTranVto(TranClieVto tranVto) {
    this.tranVto = tranVto;
  }

  public void setTranVtoOri(TranClieVto tranVtoOri) {
    this.tranVtoOri = tranVtoOri;
  }

  public void setDiasBase(Integer diasBase) {
    this.diasBase = diasBase;
  }

  public void setImputac(Date imputac) {
    this.imputac = imputac;
  }

  public ComproCab getComprobanteOri() {
    return comprobanteOri;
  }

  public void grabarAplicacion() throws BaseException {

    // Grabar la Aplicacion
    AplicClieVto aplicClie = (AplicClieVto)AplicClieVto.getNew(AplicClieVto.NICKNAME,sesion);
    aplicClie.setComprobante(getComprobante());
    aplicClie.setTipo_cta_cte(getTipoCtaCteClie());
    aplicClie.setSujeto(getSujeto());
    aplicClie.setMoneda(getMoneda());
    aplicClie.setImporte(getImporte());
    aplicClie.setImputac(getImputac());
    aplicClie.setEmision(getEmision());
    aplicClie.setDias_base(getDiasBase());
    aplicClie.setDias_vto(getDiasVto());
    aplicClie.setCompro_ori(getComprobanteOri());
    aplicClie.setTran_vto(getTranVto());
    aplicClie.setTran_vto_ori(getTranVtoOri());
    aplicClie.setCotiz_mon_ori(getValorCotizMonOri());
    aplicClie.setCotiz_mon_ext1(getValorCotizMonExt1());
    aplicClie.setCotiz_mon_ext2(getValorCotizMonExt2());
    aplicClie.save();

    // Descontar la Aplicacion de la Transaccion Vencimiento
    TranClieVto tranClieVto = getTranVto();
    
    if (Math.abs(getImporte().doubleValue())
        	>Math.abs(tranClieVto.getSaldo().doubleValue())) 
        	throw new ExceptionValidation(null,"La aplicación no puede superar al saldo del comprobante");
    
    
    
    CalculadorMoney calcNuevoSaldo = new CalculadorMoney(tranClieVto.getSaldo());
    calcNuevoSaldo.sumar(getImporte());
    Money nuevoSaldoCuota = calcNuevoSaldo.getResultMoney();
    if (nuevoSaldoCuota.doubleValue() == 0)
      tranClieVto.setPendiente(new Boolean(false));
    tranClieVto.setSaldo(nuevoSaldoCuota);
    tranClieVto.save();

    // Descontar la Aplicacion de la Transaccion del Comprobante
    TranClie tranClie = tranClieVto.getTran_clie();
    CalculadorMoney calcNuevoSaldoCompro = new CalculadorMoney(tranClie.getSaldo());
    calcNuevoSaldoCompro.sumar(getImporte());
    Money nuevoSaldoCompro = calcNuevoSaldoCompro.getResultMoney();
    if (nuevoSaldoCompro.doubleValue() == 0)
      tranClie.setPendiente(new Boolean(false));
    tranClie.setSaldo(nuevoSaldoCompro);
    tranClie.save();

  }

}
