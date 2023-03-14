package com.srn.erp.reclutamiento.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluEstAprobBusq extends ObjetoLogico { 

  public RecluEstAprobBusq() { 
  }

  public static String NICKNAME = "rs.RecluEstAprobBusq";

  private String codigo;
  private String descripcion;
  private Boolean aprobado;
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

  public Boolean isAprobado() throws BaseException { 
    supportRefresh();
    return aprobado;
  }

  public void setAprobado(Boolean aAprobado) { 
    this.aprobado =  aAprobado;
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

 public static RecluEstAprobBusq findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecluEstAprobBusq) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static RecluEstAprobBusq findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (RecluEstAprobBusq) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 

 public static RecluEstAprobBusq findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecluEstAprobBusq) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }

}
