package com.srn.erp.cip.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class SubGrupoCategAcceso extends ObjetoLogico { 

  public SubGrupoCategAcceso() { 
  }

  public static String NICKNAME = "cip.SubGrupoCategAcceso";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  private Integer orden;
  private GrupoCategAcceso grupo_categoria;

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

  public Integer getOrden() throws BaseException { 
    supportRefresh();
    return orden;
  }

  public void setOrden(Integer aOrden) { 
    this.orden =  aOrden;
  }

  public GrupoCategAcceso getGrupo_categoria() throws BaseException { 
    supportRefresh();
    return grupo_categoria;
  }

  public void setGrupo_categoria(GrupoCategAcceso aGrupo_categoria) { 
    this.grupo_categoria =  aGrupo_categoria;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static SubGrupoCategAcceso findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (SubGrupoCategAcceso) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static SubGrupoCategAcceso findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (SubGrupoCategAcceso) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 

 public static SubGrupoCategAcceso findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (SubGrupoCategAcceso) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(orden, "Debe ingresar el Nro. de Orden");
    Validar.noNulo(grupo_categoria, "Debe ingresar el Grupo");
 }

}
