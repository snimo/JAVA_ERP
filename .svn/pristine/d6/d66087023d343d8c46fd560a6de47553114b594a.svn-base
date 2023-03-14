package com.srn.erp.tesoreria.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Ticket extends ObjetoLogico {

  public Ticket() {
  }

  public static String NICKNAME = "te.Ticket";

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

 public static Ticket findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (Ticket) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static Ticket findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (Ticket) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static Ticket findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (Ticket) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la descripción");
 }

}
