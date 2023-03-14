package com.srn.erp.general.bm;

import com.srn.erp.general.da.DBIndiceValor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class IndiceValor extends ObjetoLogico {

  public IndiceValor() {
  }

  public static String NICKNAME = "ge.IndiceValor";

  private Periodo peri;
  private Double valor;
  private Indice indice;
  private Boolean activo;

  public Periodo getPeri() throws BaseException {
    supportRefresh();
    return peri;
  }

  public void setPeri(Periodo aPeri) {
    this.peri =  aPeri;
  }

  public Double getValor() throws BaseException {
    supportRefresh();
    return valor;
  }

  public void setValor(Double aValor) {
    this.valor =  aValor;
  }

  public Indice getIndice() throws BaseException {
    supportRefresh();
    return indice;
  }

  public void setIndice(Indice aIndice) {
    this.indice =  aIndice;
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

 public static IndiceValor findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (IndiceValor) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static IndiceValor findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (IndiceValor) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(peri, "Debe ingresar un período");
    Validar.noNulo(valor, "Debe ingresar un Valor");
    Validar.noNulo(indice, "Debe ingresar el Indice");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("El índice debe ingresarse en modo alta");

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

  public static IndiceValor getIndiceValor(Indice indice,
                                            Periodo periodo,
                                            ISesion aSesion) throws BaseException {
    return DBIndiceValor.getIndiceValor(indice,periodo,aSesion);
  }


}
