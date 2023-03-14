package com.srn.erp.contabilidad.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EstructuraCompo extends ObjetoLogico {

  public EstructuraCompo() {
  }

  public static String NICKNAME = "cg.EstructuraCompo";

  private Estructura estructura;
  private Integer secu;
  private Componente componente;
  private Boolean activo;
  private IObjetoLogico valorDefault;

  public Estructura getEstructura() throws BaseException {
    supportRefresh();
    return estructura;
  }

  public void setEstructura(Estructura aEstructura) {
    this.estructura =  aEstructura;
  }
  
  public IObjetoLogico getValorDefault() throws BaseException {
	    supportRefresh();
	    return this.valorDefault;
	  }

  public void setValorDefault(IObjetoLogico aObjetoLogico) {
	  this.valorDefault =  aObjetoLogico;
  }  

  public Integer getSecu() throws BaseException {
    supportRefresh();
    return secu;
  }

  public void setSecu(Integer aSecu) {
    this.secu =  aSecu;
  }

  public Componente getComponente() throws BaseException {
    supportRefresh();
    return componente;
  }

  public void setComponente(Componente aComponente) {
    this.componente =  aComponente;
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

 public static EstructuraCompo findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (EstructuraCompo) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static EstructuraCompo findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (EstructuraCompo) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(estructura, "Debe ingresar la Estructura");
    Validar.noNulo(secu, "Debe ingresar el Orden");
    Validar.noNulo(componente, "Debe ingresar un Componente");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("El item debe estar activo");

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
