package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBPeligrosidadExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PeligrosidadExcluido extends ObjetoLogico { 

  public PeligrosidadExcluido() { 
  }

  public static String NICKNAME = "exc.PeligrosidadExcluido";

  private String codigo;
  private String descripcion;
  private Integer grado;
  private Boolean activo;
  private String color;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }
  
  public String getColor() throws BaseException { 
	    supportRefresh();
	    if (color!=null)
	    	return color;
	    else
	    	return "";
  }

  public void setColor(String aColor) { 
	    this.color =  aColor;
  }  

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public Integer getGrado() throws BaseException { 
    supportRefresh();
    return grado;
  }

  public void setGrado(Integer aGrado) { 
    this.grado =  aGrado;
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

 public static PeligrosidadExcluido findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (PeligrosidadExcluido) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static PeligrosidadExcluido findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (PeligrosidadExcluido) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 
 

 public static PeligrosidadExcluido findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (PeligrosidadExcluido) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(grado, "Debe indicar el Grado");
    Validar.noNulo(color, "Debe indicar el Color");
 }
 
 public static List getAllActivos(ISesion aSesion) throws BaseException {
	  return DBPeligrosidadExcluido.getAllActivos(aSesion);
} 

}
