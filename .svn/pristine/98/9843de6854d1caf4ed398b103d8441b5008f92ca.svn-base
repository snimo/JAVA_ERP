package com.srn.erp.general.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Idioma extends ObjetoLogico {

  public Idioma() {
  }

  public static String NICKNAME = "ge.Idioma";

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

 public static Idioma findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (Idioma) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static Idioma findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (Idioma) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }


 public static Idioma findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (Idioma) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la descripción");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("El Idioma debe ingresarse en modo activo");

 }
 
 public static Idioma getIdiomaLocal(ISesion aSesion) throws BaseException {
   Integer oidIdioma=
       ValorParametro.findByCodigoParametro("IDIOMA_LOCAL",aSesion).getOidObjNeg();
   Idioma idiomaLocal = Idioma.findByOid(oidIdioma,aSesion);
   return idiomaLocal;
 }
 

}
