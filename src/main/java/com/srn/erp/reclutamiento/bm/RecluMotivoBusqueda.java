package com.srn.erp.reclutamiento.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluMotivoBusqueda extends ObjetoLogico { 

  public RecluMotivoBusqueda() { 
  }

  public static String NICKNAME = "rs.RecluMotivoBusqueda";

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

 public static RecluMotivoBusqueda findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecluMotivoBusqueda) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static RecluMotivoBusqueda findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (RecluMotivoBusqueda) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 

 public static RecluMotivoBusqueda findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecluMotivoBusqueda) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }

}
