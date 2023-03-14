package com.srn.erp.stock.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Serie extends ObjetoLogico {

  public Serie() {
  }

  public static String NICKNAME = "st.Serie";

  private String codigo;
  private String descripcion;
  private Integer nro;
  private java.util.Date fec_inicio;
  private java.util.Date fec_vto;
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

  public Integer getNro() throws BaseException {
    supportRefresh();
    return nro;
  }

  public void setNro(Integer aNro) {
    this.nro =  aNro;
  }

  public java.util.Date getFec_inicio() throws BaseException {
    supportRefresh();
    return fec_inicio;
  }

  public void setFec_inicio(java.util.Date aFec_inicio) {
    this.fec_inicio =  aFec_inicio;
  }

  public java.util.Date getFec_vto() throws BaseException {
    supportRefresh();
    return fec_vto;
  }

  public void setFec_vto(java.util.Date aFec_vto) {
    this.fec_vto =  aFec_vto;
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

 public static Serie findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (Serie) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static Serie findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (Serie) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static Serie findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (Serie) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(nro, "Debe ingresar el Nro.");
    Validar.noNulo(fec_inicio, "Debe ingresar la Fecha de Inicio");
    Validar.noNulo(fec_vto, "Debe ingresar la Fecha de Vencimiento");
 }

}
