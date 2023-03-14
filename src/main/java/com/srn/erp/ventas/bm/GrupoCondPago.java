package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.ventas.da.DBGrupoCondPago;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoCondPago extends ObjetoLogico {

  public GrupoCondPago() {
  }

  public static String NICKNAME = "ve.GrupoCondPago";

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

 public static GrupoCondPago findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (GrupoCondPago) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static GrupoCondPago findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (GrupoCondPago) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static GrupoCondPago findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (GrupoCondPago) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }
 
  public static List getGruposCondPago(ISesion aSesion) throws BaseException {
	return DBGrupoCondPago.getGruposCondPago(aSesion);
  } 

}
