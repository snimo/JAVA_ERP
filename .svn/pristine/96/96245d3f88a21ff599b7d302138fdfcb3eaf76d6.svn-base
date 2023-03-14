package com.srn.erp.presupuesto.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MonedaPresu extends ObjetoLogico { 

  public MonedaPresu() { 
  }

  public static String NICKNAME = "pl.MonedaPresu";

  private String codigo;
  private String descripcion;
  private String simbolo;
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

  public String getSimbolo() throws BaseException { 
    supportRefresh();
    return simbolo;
  }

  public void setSimbolo(String aSimbolo) { 
    this.simbolo =  aSimbolo;
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

 public static MonedaPresu findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (MonedaPresu) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static MonedaPresu findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (MonedaPresu) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(simbolo, "Debe ingresar el símbolo");
 }

}
