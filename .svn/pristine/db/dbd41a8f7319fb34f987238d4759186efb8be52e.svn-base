package com.srn.erp.excelReport.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoReporteExcel extends ObjetoLogico { 

  public GrupoReporteExcel() { 
  }

  public static String NICKNAME = "ex.GrupoReporteExcel";

  private String codigo;
  private String descripcion;
  private Integer orden;
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

  public Integer getOrden() throws BaseException { 
    supportRefresh();
    return orden;
  }

  public void setOrden(Integer aOrden) { 
    this.orden =  aOrden;
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

 public static GrupoReporteExcel findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (GrupoReporteExcel) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static GrupoReporteExcel findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (GrupoReporteExcel) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(orden, "Debe ingresar el Orden");
 }

}
