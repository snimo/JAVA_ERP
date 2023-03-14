package com.srn.erp.tesoreria.bm;

import java.util.Date;

import com.srn.erp.tesoreria.da.DBCajaCierreApertura;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class CajaCierreApertura extends ObjetoLogico {

  public CajaCierreApertura() {
  }

  public static String NICKNAME = "te.CajaCierreApertura";

  private Caja caja;
  private Date fecCierreAnt;
  private Date nueFecAper;
  private Boolean activo;

  public Caja getCaja() throws BaseException {
    supportRefresh();
    return caja;
  }

  public void setCaja(Caja aCaja) {
    this.caja =  aCaja;
  }

  public Date getFeccierreant() throws BaseException {
    supportRefresh();
    return fecCierreAnt;
  }

  public void setFeccierreant(Date aFeccierreant) {
    this.fecCierreAnt =  aFeccierreant;
  }

  public Date getNuefecaper() throws BaseException {
    supportRefresh();
    return nueFecAper;
  }

  public void setNuefecaper(Date aNuefecaper) {
    this.nueFecAper =  aNuefecaper;
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

 public static CajaCierreApertura findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CajaCierreApertura) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static CajaCierreApertura findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CajaCierreApertura) getObjectByCodigo(NICKNAME,codigo,aSesion);
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

  public void beforeSave() throws BaseException {
    Validar.noNulo(caja, "Debe ingresar una caja");
    Validar.noNulo(fecCierreAnt, "Debe ingresar la Fecha Ultimo Cierre");
    Validar.noNulo(nueFecAper, "Debe Ingresar la Fecha Apertura de Caja");
    if (!caja.isAperturaCierreManual()) throw new ExceptionValidation(null,"Solo se puede ingresar un caja con cierre y apertura manual");
    if(!getFeccierreant().before(getNuefecaper())) throw new ExceptionValidation(null,"La fecha de apertura debe ser mayor a la fecha actual");
  }

  public static CajaCierreApertura getAperturaCierreCaja(Caja caja,
                                                        ISesion aSesion)
                                                        throws BaseException {
    return DBCajaCierreApertura.getAperturaCierreCaja(caja,aSesion);
  }





}
