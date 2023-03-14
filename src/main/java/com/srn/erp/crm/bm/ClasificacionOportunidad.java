package com.srn.erp.crm.bm;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ClasificacionOportunidad extends ObjetoLogico { 

  public ClasificacionOportunidad() { 
  }

  public static String NICKNAME = "crm.ClasificacionOportunidad";

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

 public static ClasificacionOportunidad findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ClasificacionOportunidad) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ClasificacionOportunidad findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
    return (ClasificacionOportunidad) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 
 public static ClasificacionOportunidad findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ClasificacionOportunidad) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }

}
