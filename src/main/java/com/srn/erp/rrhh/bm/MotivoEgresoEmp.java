package com.srn.erp.rrhh.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MotivoEgresoEmp extends ObjetoLogico { 

  public MotivoEgresoEmp() { 
  }

  public static String NICKNAME = "rh.MotivoEgresoEmp";

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

 public static MotivoEgresoEmp findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (MotivoEgresoEmp) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static MotivoEgresoEmp findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (MotivoEgresoEmp) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 
 
 
 public static MotivoEgresoEmp findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (MotivoEgresoEmp) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }

}
