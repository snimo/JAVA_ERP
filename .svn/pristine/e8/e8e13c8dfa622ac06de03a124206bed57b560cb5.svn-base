package com.srn.erp.reclutamiento.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluMotiEstCandBusq extends ObjetoLogico { 

  public RecluMotiEstCandBusq() { 
  }

  public static String NICKNAME = "rs.RecluMotiEstCandBusq";

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

 public static RecluMotiEstCandBusq findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecluMotiEstCandBusq) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static RecluMotiEstCandBusq findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (RecluMotiEstCandBusq) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  }  

 public static RecluMotiEstCandBusq findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecluMotiEstCandBusq) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException {
	 Validar.noNulo(codigo, "Debe ingresar un Código");
	 Validar.noNulo(descripcion, "Debe ingresar la Descripción");	 
 }

}
