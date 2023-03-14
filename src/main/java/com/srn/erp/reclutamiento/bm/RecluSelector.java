package com.srn.erp.reclutamiento.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluSelector extends ObjetoLogico { 

  public RecluSelector() { 
  }

  public static String NICKNAME = "rs.RecluSelector";

  private String codigo;
  private String descripcion;
  private Usuario usuario;
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

  public Usuario getUsuario() throws BaseException { 
    supportRefresh();
    return usuario;
  }

  public void setUsuario(Usuario aUsuario) { 
    this.usuario =  aUsuario;
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

 public static RecluSelector findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecluSelector) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static RecluSelector findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (RecluSelector) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 

 public static RecluSelector findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecluSelector) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(usuario, "Debe ingresar el Usuario");
 }

}
