package com.srn.erp.general.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Pais extends ObjetoLogico {

  public Pais() {
  }

  public static String NICKNAME = "ge.Pais";

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

 public static Pais findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (Pais) getObjectByOid(NICKNAME,oid,aSesion);
 }

 public static Pais findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (Pais) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static Pais findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (Pais) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("El País debe ingresarse en modo activo");

 }

}
