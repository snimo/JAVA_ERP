package com.srn.erp.ventas.bm;

import java.util.Hashtable;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoUnidadEdilicia extends ObjetoLogico {

  public static final String COMPO_VIVI = "VIVIENDA";
  public static final String COMPO_EMP = "EMPRESA";
  public static final String COMPO_SUC = "SUCURSAL";
  public static final String COMPO_DEPO = "DEPOSITO";
  public static final String COMPO_LOTE = "LOTE";
  public static final String COMPO_BARRIO = "BARRIO";


  public TipoUnidadEdilicia() {
  }

  public static String NICKNAME = "ve.TipoUnidadEdilicia";

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

 public static TipoUnidadEdilicia findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (TipoUnidadEdilicia) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static TipoUnidadEdilicia findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (TipoUnidadEdilicia) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static TipoUnidadEdilicia findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (TipoUnidadEdilicia) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la descripción");
    Validar.noNulo(comportamiento, "Debe ingresar el Tipo");
 }

 public static Hashtable getComportamientos() throws BaseException {
   Hashtable comportamientos = new Hashtable();
   comportamientos.put("VIVIENDA","Vivienda");
   comportamientos.put("EMPRESA","Empresa");
   comportamientos.put("SUCURSAL","Sucursal");
   comportamientos.put("DEPOSITO","Depósito");
   comportamientos.put("LOTE","Lote");
   comportamientos.put("BARRIO","Barrio");
   return comportamientos;
 }

}
