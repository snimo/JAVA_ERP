package com.srn.erp.rrhh.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.request.bl.Utils.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import java.util.List;

public class EnfermedadRRHH extends ObjetoLogico { 

  public EnfermedadRRHH() { 
  }

  public static String NICKNAME = "rh.EnfermedadRRHH";

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

  public static EnfermedadRRHH findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (EnfermedadRRHH) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
  public static EnfermedadRRHH findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (EnfermedadRRHH) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 
 public static EnfermedadRRHH findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (EnfermedadRRHH) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
 }

}
