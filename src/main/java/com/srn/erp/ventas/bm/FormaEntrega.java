package com.srn.erp.ventas.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class FormaEntrega extends ObjetoLogico { 

  public FormaEntrega() { 
  }

  public static String NICKNAME = "ve.FormaEntrega";

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

 public static FormaEntrega findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (FormaEntrega) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static FormaEntrega findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (FormaEntrega) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 

 public static FormaEntrega findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (FormaEntrega) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }

}
