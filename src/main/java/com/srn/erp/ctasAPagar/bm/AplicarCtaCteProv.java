package com.srn.erp.ctasAPagar.bm;

import java.util.Date;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class AplicarCtaCteProv  {

  private ISesion         sesion;
  private ComproCab       comprobante;
  private TipoCtaCteProv  tipoCtaCteProv;
  private Proveedor       proveedor;
  private Moneda          moneda;
  private Money           importe;
  private java.util.Date  emision;
  private java.util.Date  imputac;
  private Integer         diasBase;
  private Integer         diasVto;
  private ComproCab       comprobanteOri;
  private TranProvVto     tranVto;
  private TranProvVto     tranVtoOri;
  private ValorCotizacion valorCotizMonOri;
  private ValorCotizacion valorCotizMonExt1;
  private ValorCotizacion valorCotizMonExt2;


  public AplicarCtaCteProv(ISesion aSesion) throws BaseException {
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

  public Proveedor getProveedor() {
    return proveedor;
  }

  public TipoCtaCteProv getTipoCtaCteProv() {
    return tipoCtaCteProv;
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

  public TranProvVto getTranVto() {
    return tranVto;
  }

  public TranProvVto getTranVtoOri() {
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

  public void setProveedor(Proveedor proveedor) {
    this.proveedor = proveedor;
  }

  public void setTipoCtaCteProv(TipoCtaCteProv tipoCtaCteProv) {
    this.tipoCtaCteProv = tipoCtaCteProv;
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

  public void setTranVto(TranProvVto tranVto) {
    this.tranVto = tranVto;
  }

  public void setTranVtoOri(TranProvVto tranVtoOri) {
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
    AplProv aplProv = (AplProv)AplProv.getNew(AplProv.NICKNAME,sesion);
    aplProv.setComprobanteapl(getComprobante());
    aplProv.setTipoctaprov(getTipoCtaCteProv());
    aplProv.setProveedor(getProveedor());
    aplProv.setMoneda(getMoneda());
    aplProv.setImporte(getImporte());
    aplProv.setFecimputac(getImputac());
    aplProv.setEmision(getEmision());
    aplProv.setDiasbase(getDiasBase());
    aplProv.setDiasvto(getDiasVto());
    aplProv.setComprobanteori(getComprobanteOri());
    aplProv.setTranprovvto(getTranVto());
    aplProv.setTranprovvtoOri(getTranVtoOri());
    aplProv.setCotizMonOri(getValorCotizMonOri());
    aplProv.setCotizMonExt1(getValorCotizMonExt1());
    aplProv.setCotizMonExt2(getValorCotizMonExt2());
    aplProv.save();

    // Descontar la Aplicacion de la Transaccion Vencimiento
    TranProvVto tranProvVto = getTranVto();
    
    if (Math.abs(getImporte().doubleValue())
    	>Math.abs(tranProvVto.getSaldo().doubleValue())) 
    	throw new ExceptionValidation(null,"La aplicación no puede superar al saldo del comprobante");
    
    CalculadorMoney calcNuevoSaldo = new CalculadorMoney(tranProvVto.getSaldo());
    calcNuevoSaldo.sumar(getImporte());
    Money nuevoSaldoCuota = calcNuevoSaldo.getResultMoney();
    if (nuevoSaldoCuota.doubleValue() == 0)
      tranProvVto.setPendiente(new Boolean(false));
    tranProvVto.setSaldo(nuevoSaldoCuota);
    tranProvVto.save();

    // Descontar la Aplicacion de la Transaccion del Comprobante
    TranProv tranProv = tranProvVto.getTranprov();
    CalculadorMoney calcNuevoSaldoCompro = new CalculadorMoney(tranProv.getSaldo());
    calcNuevoSaldoCompro.sumar(getImporte());
    Money nuevoSaldoCompro = calcNuevoSaldoCompro.getResultMoney();
    if (nuevoSaldoCompro.doubleValue() == 0)
      tranProv.setPendiente(new Boolean(false));
    tranProv.setSaldo(nuevoSaldoCompro);
    tranProv.save();

  }

}
