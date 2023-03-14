package com.srn.erp.pagos.bm;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class CertificadoRetIBCab extends ObjetoLogico {

  public CertificadoRetIBCab() {
  }

  public static String NICKNAME = "pag.CertificadoRetIBCab";

  private ComproCab ordenPago;
  private Proveedor proveedor;
  private PeriRetIB periRetIB;
  private CatRetIB catRetIB;
  private Money porcLib;
  private String decreto;

  public ComproCab getOrdenpago() throws BaseException {
    supportRefresh();
    return ordenPago;
  }

  public void setOrdenpago(ComproCab aOrdenpago) {
    this.ordenPago =  aOrdenpago;
  }

  public Proveedor getProveedor() throws BaseException {
    supportRefresh();
    return proveedor;
  }

  public void setProveedor(Proveedor aProveedor) {
    this.proveedor =  aProveedor;
  }

  public PeriRetIB getPeriretib() throws BaseException {
    supportRefresh();
    return periRetIB;
  }

  public void setPeriretib(PeriRetIB aPeriretib) {
    this.periRetIB =  aPeriretib;
  }

  public CatRetIB getCatretib() throws BaseException {
    supportRefresh();
    return catRetIB;
  }

  public void setCatretib(CatRetIB aCatretib) {
    this.catRetIB =  aCatretib;
  }

  public Money getPorclib() throws BaseException {
    supportRefresh();
    return porcLib;
  }

  public void setPorclib(Money aPorclib) {
    this.porcLib =  aPorclib;
  }

  public String getDecreto() throws BaseException {
    supportRefresh();
    return decreto;
  }

  public void setDecreto(String aDecreto) {
    this.decreto =  aDecreto;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static CertificadoRetIBCab findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CertificadoRetIBCab) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static CertificadoRetIBCab findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CertificadoRetIBCab) getObjectByCodigo(NICKNAME,codigo,aSesion);
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
