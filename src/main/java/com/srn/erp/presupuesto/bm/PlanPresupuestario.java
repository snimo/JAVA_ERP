package com.srn.erp.presupuesto.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PlanPresupuestario extends ObjetoLogico { 

  public PlanPresupuestario() { 
  }

  public static String NICKNAME = "pl.PlanPresupuestario";

  private String codigo;
  private String descripcion;
  private EstructuraPlan estructura_plan;
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

  public EstructuraPlan getEstructura_plan() throws BaseException { 
    supportRefresh();
    return estructura_plan;
  }

  public void setEstructura_plan(EstructuraPlan aEstructura_plan) { 
    this.estructura_plan =  aEstructura_plan;
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

 public static PlanPresupuestario findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (PlanPresupuestario) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static PlanPresupuestario findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (PlanPresupuestario) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(estructura_plan, "Debe ingresar la Estructura del Plan");
 }

}
