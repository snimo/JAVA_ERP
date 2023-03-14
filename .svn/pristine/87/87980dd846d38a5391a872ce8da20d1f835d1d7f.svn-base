package com.srn.erp.presupuesto.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ElementoUPC extends ObjetoLogico {
	
	public static final String TIPO_PLANILLA = "PLANILLA";

  public ElementoUPC() { 
  }

  public static String NICKNAME = "pl.ElementoUPC";

  private String codigo;
  private String descripcion;
  private String tipo;
  private Integer nro_interno;
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

  public String getTipo() throws BaseException { 
    supportRefresh();
    return tipo;
  }

  public void setTipo(String aTipo) { 
    this.tipo =  aTipo;
  }

  public Integer getNro_interno() throws BaseException { 
    supportRefresh();
    return nro_interno;
  }

  public void setNro_interno(Integer aNro_interno) { 
    this.nro_interno =  aNro_interno;
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

 public static ElementoUPC findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ElementoUPC) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ElementoUPC findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ElementoUPC) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }

}
