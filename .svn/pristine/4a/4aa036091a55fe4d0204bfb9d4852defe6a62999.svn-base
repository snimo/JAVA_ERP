package com.srn.erp.cip.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoAccesoCIP extends ObjetoLogico { 

  public GrupoAccesoCIP() { 
  }

  public static String NICKNAME = "cip.GrupoAccesoCIP";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  private PermisoSemanalCIP permiso_semanal;

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

  public PermisoSemanalCIP getPermiso_semanal() throws BaseException { 
    supportRefresh();
    return permiso_semanal;
  }

  public void setPermiso_semanal(PermisoSemanalCIP aPermiso_semanal) { 
    this.permiso_semanal =  aPermiso_semanal;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static GrupoAccesoCIP findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (GrupoAccesoCIP) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static GrupoAccesoCIP findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (GrupoAccesoCIP) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }

}
