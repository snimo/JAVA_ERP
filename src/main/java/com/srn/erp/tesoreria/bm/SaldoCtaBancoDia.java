package com.srn.erp.tesoreria.bm;

import java.util.Date;

import com.srn.erp.tesoreria.da.DBSaldoCtaBancoDia;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class SaldoCtaBancoDia extends ObjetoLogico {

  public SaldoCtaBancoDia() {
  }

  public static String NICKNAME = "ba.SaldoCtaBancoDia";

  private Date fecha;
  private Money debitos;
  private Money creditos;
  private CuentaBancaria cuentaBancaria;
  private Money debitosHist;
  private Money creditosHist;
  private Money debitosAju;
  private Money creditosAju;
  private Money debitosExt1;
  private Money creditosExt1;
  private Money debitosExt2;
  private Money creditosExt2;

  public Date getFecha() throws BaseException {
    supportRefresh();
    return fecha;
  }

  public void setFecha(Date aFecha) {
    this.fecha =  aFecha;
  }

  public Money getDebitos() throws BaseException {
    supportRefresh();
    return debitos;
  }

  public void setDebitos(Money aDebitos) {
    this.debitos =  aDebitos;
  }

  public Money getCreditos() throws BaseException {
    supportRefresh();
    return creditos;
  }

  public void setCreditos(Money aCreditos) {
    this.creditos =  aCreditos;
  }

  public CuentaBancaria getCuentabancaria() throws BaseException {
    supportRefresh();
    return cuentaBancaria;
  }

  public void setCuentabancaria(CuentaBancaria aCuentabancaria) {
    this.cuentaBancaria =  aCuentabancaria;
  }

  public Money getDebitoshist() throws BaseException {
    supportRefresh();
    return debitosHist;
  }

  public void setDebitoshist(Money aDebitoshist) {
    this.debitosHist =  aDebitoshist;
  }

  public Money getCreditoshist() throws BaseException {
    supportRefresh();
    return creditosHist;
  }

  public void setCreditoshist(Money aCreditoshist) {
    this.creditosHist =  aCreditoshist;
  }

  public Money getDebitosaju() throws BaseException {
    supportRefresh();
    return debitosAju;
  }

  public void setDebitosaju(Money aDebitosaju) {
    this.debitosAju =  aDebitosaju;
  }

  public Money getCreditosaju() throws BaseException {
    supportRefresh();
    return creditosAju;
  }

  public void setCreditosaju(Money aCreditosaju) {
    this.creditosAju =  aCreditosaju;
  }

  public Money getDebitosext1() throws BaseException {
    supportRefresh();
    return debitosExt1;
  }

  public void setDebitosext1(Money aDebitosext1) {
    this.debitosExt1 =  aDebitosext1;
  }

  public Money getCreditosext1() throws BaseException {
    supportRefresh();
    return creditosExt1;
  }

  public void setCreditosext1(Money aCreditosext1) {
    this.creditosExt1 =  aCreditosext1;
  }

  public Money getDebitosext2() throws BaseException {
    supportRefresh();
    return debitosExt2;
  }

  public void setDebitosext2(Money aDebitosext2) {
    this.debitosExt2 =  aDebitosext2;
  }

  public Money getCreditosext2() throws BaseException {
    supportRefresh();
    return creditosExt2;
  }

  public void setCreditosext2(Money aCreditosext2) {
    this.creditosExt2 =  aCreditosext2;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static SaldoCtaBancoDia findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (SaldoCtaBancoDia) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static SaldoCtaBancoDia findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (SaldoCtaBancoDia) getObjectByCodigo(NICKNAME,codigo,aSesion);
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

  public static SaldoCtaBancoDia getSaldoByFechayCuenta(
                                                      CuentaBancaria cuentaBancaria,
                                                      java.util.Date fecha,
                                                      ISesion aSesion)
                                                      throws BaseException {
    return DBSaldoCtaBancoDia.getSaldoByCuentayFecha(cuentaBancaria,fecha,aSesion);
  }


}
