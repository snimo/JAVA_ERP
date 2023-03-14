package com.srn.erp.contabilidad.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Leyenda extends ObjetoLogico {

  public Leyenda() {
  }

  public static String NICKNAME = "cg.Leyenda";

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

 public static Leyenda findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (Leyenda) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static Leyenda findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (Leyenda) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }


 public static Leyenda findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (Leyenda) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la descripción");
 }

}
