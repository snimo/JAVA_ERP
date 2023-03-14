package com.srn.erp.general.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Zona extends ObjetoLogico {

  public Zona() {
  }

  public static String NICKNAME = "ge.Zona";

  private String codigo;
  private String descripcion;
  private Boolean activo;

  public String getCodigo() throws BaseException {
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) {
    this.codigo =  aCodigo;
  }

  public String getDescripcion() throws BaseException {
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) {
    this.descripcion =  aDescripcion;
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

 public static Zona findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (Zona) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static Zona findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (Zona) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static Zona findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (Zona) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("La Zona debe ingresarse en modo activo");

 }

}
