package com.srn.erp.presupuesto.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoEstructuraPlanif extends ObjetoLogico { 

  public GrupoEstructuraPlanif() { 
  }

  public static String NICKNAME = "pl.GrupoEstructuraPlanif";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  private Integer orden;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }
  
  public Integer getOrden() throws BaseException { 
    supportRefresh();
    return this.orden;
  }

  public void setOrden(Integer aOrden) { 
    this.orden =  aOrden;
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

 public static GrupoEstructuraPlanif findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (GrupoEstructuraPlanif) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static GrupoEstructuraPlanif findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (GrupoEstructuraPlanif) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 

 public static GrupoEstructuraPlanif findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (GrupoEstructuraPlanif) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }

}
