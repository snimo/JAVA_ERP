package com.srn.erp.general.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PeriodoInc extends ObjetoLogico {

  public PeriodoInc() {
  }

  public static String NICKNAME = "ge.PeriodoInc";

  private Periodo periodo;
  private String tipo;
  private String codigo;
  private Boolean activo;

  private List periodosIncDet = new ArrayList();
  private boolean readPeriodosIncDet = true;

  public Periodo getPeriodo() throws BaseException {
    supportRefresh();
    return periodo;
  }

  public void setPeriodo(Periodo aPeriodo) {
    this.periodo =  aPeriodo;
  }

  public String getTipo() throws BaseException {
    supportRefresh();
    return tipo;
  }

  public void setTipo(String aTipo) {
    this.tipo =  aTipo;
  }

  public String getCodigo() throws BaseException {
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) {
    this.codigo =  aCodigo;
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

 public static PeriodoInc findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (PeriodoInc) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static PeriodoInc findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (PeriodoInc) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }


 public static PeriodoInc findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (PeriodoInc) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(periodo, "Debe ingresar el Período");
    Validar.noNulo(tipo, "Debe ingresar el Tipo");
    Validar.noNulo(codigo, "Debe ingresar el Código");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("El período incluido debe estar en modo activo");

 }

  /**
   * getDescripcion
   *
   * @return String
   */
  public String getDescripcion() {
    return "";
  }

  public List getPeriodosIncDet() throws BaseException {
    if (readPeriodosIncDet) {
      List listaPeriodosIncDet = PeriodoIncDet.getPeriodosIncDet(this,getSesion());
      periodosIncDet.addAll(listaPeriodosIncDet);
      readPeriodosIncDet = false;
    }
    return periodosIncDet;
  }

  public void addPeriodoIncDet(PeriodoIncDet periodoIncDet) throws BaseException {
    periodoIncDet.setPeriinc(this);
    periodosIncDet.add(periodoIncDet);
  }

  public void afterSave() throws BaseException {
    Iterator iterPeriodosIncDet = periodosIncDet.iterator();
    while (iterPeriodosIncDet.hasNext()) {
      PeriodoIncDet periodoIncDet = (PeriodoIncDet) iterPeriodosIncDet.next();
      periodoIncDet.save();
      periodoIncDet = null;
    }
    iterPeriodosIncDet = null;
  }


}
