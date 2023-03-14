package com.srn.erp.general.bm;

import java.util.List;

import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PeriodoIncDet extends ObjetoLogico {

  public PeriodoIncDet() {
  }

  public static String NICKNAME = "ge.PeriodoIncDet";

  private PeriodoInc periInc;
  private Integer secu;
  private Periodo periodo;
  private Boolean activo;

  public PeriodoInc getPeriinc() throws BaseException {
    supportRefresh();
    return periInc;
  }

  public void setPeriinc(PeriodoInc aPeriinc) {
    this.periInc =  aPeriinc;
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

 public static PeriodoIncDet findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (PeriodoIncDet) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static PeriodoIncDet findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (PeriodoIncDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(periInc, "Debe ingresar el Período");
    Validar.noNulo(secu, "Debe ingresar la secuencia");
    Validar.noNulo(periodo, "Debe ingresar el Período");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("El Período incluido debe ingresarse en modo activo");

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

  public static List getPeriodosIncDet(PeriodoInc periodoInc,
                                       ISesion aSesion) throws BaseException {
    return DBPeriodoIncDet.getPeriodosIncDet(periodoInc,aSesion);
  }


}
