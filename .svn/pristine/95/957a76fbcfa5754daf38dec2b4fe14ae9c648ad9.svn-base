package com.srn.erp.contabilidad.bm;

import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class AnuladorAsientoDet extends ObjetoLogico {

  public AnuladorAsientoDet() {
  }

  public static String NICKNAME = "cg.AnuladorAsientoDet";

  private ComproCab comprobante;
  private Integer secu;
  private CuentaImputable cuentaImputable;
  private Integer signo;
  private Money    impoLocHist;
  private Money    impoLocAju;
  private Money    impo_mon_ext_1;
  private Money    impo_mon_ext_2;
  private String comentario;

  public ComproCab getComprobante() throws BaseException {
    supportRefresh();
    return comprobante;
  }

  public void setComprobante(ComproCab aComprobante) {
    this.comprobante =  aComprobante;
  }

  public Integer getSecu() throws BaseException {
    supportRefresh();
    return secu;
  }

  public void setSecu(Integer aSecu) {
    this.secu =  aSecu;
  }

  public CuentaImputable getCuentaimputable() throws BaseException {
    supportRefresh();
    return cuentaImputable;
  }

  public void setCuentaimputable(CuentaImputable aCuentaimputable) {
    this.cuentaImputable =  aCuentaimputable;
  }

  public Integer getSigno() throws BaseException {
    supportRefresh();
    return signo;
  }

  public void setSigno(Integer aSigno) {
    this.signo =  aSigno;
  }

  public Money getImpoLocHist() throws BaseException {
    supportRefresh();
    return impoLocHist;
  }

  public void setImpoLocHist(Money aImpolochist) {
    this.impoLocHist =  aImpolochist;
  }

  public Money getImpoLocAju() throws BaseException {
    supportRefresh();
    return impoLocAju;
  }

  public void setImpoLocAju(Money aImpolocaju) {
    this.impoLocAju =  aImpolocaju;
  }

  public Money getImpoMonExt1() throws BaseException {
    supportRefresh();
    return impo_mon_ext_1;
  }

  public void setImpoMonExt1(Money aImpo_mon_ext_1) {
    this.impo_mon_ext_1 =  aImpo_mon_ext_1;
  }

  public Money getImpoMonExt2() throws BaseException {
    supportRefresh();
    return impo_mon_ext_2;
  }

  public void setImpoMonExt2(Money aImpo_mon_ext_2) {
    this.impo_mon_ext_2 =  aImpo_mon_ext_2;
  }


  public String getComentario() throws BaseException {
    supportRefresh();
    return comentario;
  }

  public void setComentario(String aComentario) {
    this.comentario =  aComentario;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static AnuladorAsientoDet findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (AnuladorAsientoDet) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static AnuladorAsientoDet findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (AnuladorAsientoDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
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

}
