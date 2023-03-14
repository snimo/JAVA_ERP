package com.srn.erp.contabilidad.bm;

import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EjercicioPeri extends ObjetoLogico {

  public EjercicioPeri() {
  }

  public static String NICKNAME = "cg.EjercicioPeri";

  private Ejercicio ejercicio;
  private Integer secu;
  private Periodo periodo;
  private Boolean cerrado;
  private Boolean activo;

  public Ejercicio getEjercicio() throws BaseException {
    supportRefresh();
    return ejercicio;
  }

  public void setEjercicio(Ejercicio aEjercicio) {
    this.ejercicio =  aEjercicio;
  }

  public Integer getSecu() throws BaseException {
    supportRefresh();
    return secu;
  }

  public void setSecu(Integer aSecu) {
    this.secu =  aSecu;
  }

  public Periodo getPeriodo() throws BaseException {
    supportRefresh();
    return periodo;
  }

  public void setPeriodo(Periodo aPeriodo) {
    this.periodo =  aPeriodo;
  }

  public Boolean isCerrado() throws BaseException {
    supportRefresh();
    return cerrado;
  }

  public void setCerrado(Boolean aCerrado) {
    this.cerrado =  aCerrado;
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

 public static EjercicioPeri findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (EjercicioPeri) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static EjercicioPeri findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (EjercicioPeri) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(periodo, "Debe ingresar un período");
    Validar.noNulo(cerrado, "");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("El período debe estar activo");

 }

  /**
   * getCodigo
   *
   * @return String
   */
  public String getCodigo() {
    return "";
  }

  /**
   * getDescripcion
   *
   * @return String
   */
  public String getDescripcion() {
    return "";
  }

}
