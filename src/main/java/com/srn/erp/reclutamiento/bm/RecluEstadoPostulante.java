package com.srn.erp.reclutamiento.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluEstadoPostulante extends ObjetoLogico { 

  public RecluEstadoPostulante() { 
  }

  public static String NICKNAME = "rs.RecluEstadoPostulante";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  private Integer color;
  private Boolean seleccionado;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }
  
  public Boolean isSeleccionado() throws BaseException { 
	    supportRefresh();
	    return this.seleccionado;
	  }  
  
  public Integer getColor() throws BaseException { 
	    supportRefresh();
	    return this.color;
	  }  

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }
  
  public void setSeleccionado(Boolean aSeleccionado) { 
	    this.seleccionado =  aSeleccionado;
	  }  
  
  public void setColor(Integer aColor) { 
	    this.color =  aColor;
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

 public static RecluEstadoPostulante findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecluEstadoPostulante) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static RecluEstadoPostulante findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (RecluEstadoPostulante) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 

 public static RecluEstadoPostulante findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecluEstadoPostulante) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
 }

}
