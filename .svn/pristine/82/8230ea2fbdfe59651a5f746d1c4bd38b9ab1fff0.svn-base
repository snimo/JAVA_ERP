package com.srn.erp.compras.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ObsGeneralesOC extends ObjetoLogico { 

  public ObsGeneralesOC() { 
  }

  public static String NICKNAME = "cp.ObsGeneralesOC";

  private String codigo;
  private String descripcion;
  private Boolean incluir_en_oc;
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

  public Boolean isIncluir_en_oc() throws BaseException { 
    supportRefresh();
    return incluir_en_oc;
  }

  public void setIncluir_en_oc(Boolean aIncluir_en_oc) { 
    this.incluir_en_oc =  aIncluir_en_oc;
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

 public static ObsGeneralesOC findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ObsGeneralesOC) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ObsGeneralesOC findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ObsGeneralesOC) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la descripción");
    Validar.noNulo(orden, "Debe ingresar el Orden");
 }

}
