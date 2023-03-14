package com.srn.erp.pagos.bm;

import java.util.Date;

import com.srn.erp.impuestos.bm.SujetoImpositivo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class RetPorcLib extends ObjetoLogico {

  public RetPorcLib() {
  }

  public static String NICKNAME = "pag.RetPorcLib";

  private SujetoImpositivo sujetoImpositivo;
  private String compoImpu;
  private String decreto;
  private Date fecVigDesde;
  private Date fecVigHasta;
  private Money porcLib;
  private Boolean activo;

  public SujetoImpositivo getSujetoimpositivo() throws BaseException {
    supportRefresh();
    return sujetoImpositivo;
  }

  public void setSujetoimpositivo(SujetoImpositivo aSujetoimpositivo) {
    this.sujetoImpositivo =  aSujetoimpositivo;
  }

  public String getCompoimpu() throws BaseException {
    supportRefresh();
    return compoImpu;
  }

  public void setCompoimpu(String aCompoimpu) {
    this.compoImpu =  aCompoimpu;
  }

  public String getDecreto() throws BaseException {
    supportRefresh();
    return decreto;
  }

  public void setDecreto(String aDecreto) {
    this.decreto =  aDecreto;
  }

  public Date getFecvigdesde() throws BaseException {
    supportRefresh();
    return fecVigDesde;
  }

  public void setFecvigdesde(Date aFecvigdesde) {
    this.fecVigDesde =  aFecvigdesde;
  }

  public Date getFecvighasta() throws BaseException {
    supportRefresh();
    return fecVigHasta;
  }

  public void setFecvighasta(Date aFecvighasta) {
    this.fecVigHasta =  aFecvighasta;
  }

  public Money getPorclib() throws BaseException {
    supportRefresh();
    return porcLib;
  }

  public void setPorclib(Money aPorclib) {
    this.porcLib =  aPorclib;
  }

  public Boolean isActivo() throws BaseException {
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) {
    this.activo =  aActivo;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static RetPorcLib findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (RetPorcLib) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static RetPorcLib findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (RetPorcLib) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
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

}
