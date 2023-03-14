package com.srn.erp.stock.bm;


import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Transporte extends ObjetoLogico {

  public Transporte() {
  }

  public static String NICKNAME = "st.Transporte";

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

 public static Transporte findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (Transporte) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static Transporte findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (Transporte) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static Transporte findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (Transporte) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar el código de Transporte");
    Validar.noNulo(descripcion, "Debe ingresar la descripción del Transporte");
 }

}
