package com.srn.erp.ventas.bm;

import java.util.Hashtable;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EstadoSituacion extends ObjetoLogico {

  public EstadoSituacion() {
  }

  public static String NICKNAME = "ve.EstadoSituacion";

  private String codigo;
  private String descripcion;
  private String comportamiento;
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

  public String getComportamiento() throws BaseException {
    supportRefresh();
    return comportamiento;
  }

  public void setComportamiento(String aComportamiento) {
    this.comportamiento =  aComportamiento;
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

 public static EstadoSituacion findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (EstadoSituacion) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static EstadoSituacion findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (EstadoSituacion) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }


 public static EstadoSituacion findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (EstadoSituacion) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(comportamiento, "Debe ingresar el Comportamiento");
 }

 public static Hashtable getComportamientos() throws BaseException {
   Hashtable comport = new Hashtable();
   comport.put("VIG","Vigente");
   comport.put("BAJA","Baja");
   comport.put("LIC","Licencia");
   return comport;
 }


}
