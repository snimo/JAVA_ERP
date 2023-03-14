package com.srn.erp.ctacte.bm;

import java.util.List;

import com.srn.erp.ctacte.da.DBTipoCtaCteProv;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoCtaCteProv extends ObjetoLogico {

  public TipoCtaCteProv() {
  }

  public static String NICKNAME = "cc.TipoCtaCteProv";

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

 public static TipoCtaCteProv findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (TipoCtaCteProv) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static TipoCtaCteProv findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (TipoCtaCteProv) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }


 public static TipoCtaCteProv findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (TipoCtaCteProv) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {

   Validar.noNulo(codigo, "Debe ingresar un código");
   Validar.noNulo(descripcion, "Debe ingresar la descripción");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("El Tipo de Cuenta debe ingresarse en modo activo");

 }
 
 public static List getTipoCtaCteProv(
         ISesion aSesion) throws BaseException {
	  return DBTipoCtaCteProv.getTipoCtaCteProv(aSesion);
 }
 

}
