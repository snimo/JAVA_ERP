package com.srn.erp.reclutamiento.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluConvenio extends ObjetoLogico { 

  public RecluConvenio() { 
  }

  public static String NICKNAME = "rs.RecluConvenio";

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

 public static RecluConvenio findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecluConvenio) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static RecluConvenio findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (RecluConvenio) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 

 public static RecluConvenio findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecluConvenio) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }

}
