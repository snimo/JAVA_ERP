package com.srn.erp.pagos.bm;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class CertificadoRetIVACab extends ObjetoLogico {

  public CertificadoRetIVACab() {
  }

  public static String NICKNAME = "pag.CertificadoRetIVACab";

  private ComproCab ordenPago;
  private Proveedor proveedor;
  private PeriRetIVA periRetIVA;
  private CatRetIVA catRetIVA;
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

  public PeriRetIVA getPeriretiva() throws BaseException {
    supportRefresh();
    return periRetIVA;
  }

  public void setPeriretiva(PeriRetIVA aPeriretiva) {
    this.periRetIVA =  aPeriretiva;
  }

  public CatRetIVA getCatretiva() throws BaseException {
    supportRefresh();
    return catRetIVA;
  }

  public void setCatretiva(CatRetIVA aCatretiva) {
    this.catRetIVA =  aCatretiva;
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

 public static CertificadoRetIVACab findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CertificadoRetIVACab) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static CertificadoRetIVACab findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CertificadoRetIVACab) getObjectByCodigo(NICKNAME,codigo,aSesion);
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
