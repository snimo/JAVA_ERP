package com.srn.erp.turnos.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EntidadTurno extends ObjetoLogico { 

  public EntidadTurno() { 
  }

  public static String NICKNAME = "tu.EntidadTurno";

  private String codigo;
  private String descripcion;
  private TurnoGrupoEntidad grupo_entidad;
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

  public TurnoGrupoEntidad getGrupo_entidad() throws BaseException { 
    supportRefresh();
    return grupo_entidad;
  }

  public void setGrupo_entidad(TurnoGrupoEntidad aGrupo_entidad) { 
    this.grupo_entidad =  aGrupo_entidad;
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

 public static EntidadTurno findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (EntidadTurno) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static EntidadTurno findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (EntidadTurno) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 

 public static EntidadTurno findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (EntidadTurno) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(grupo_entidad, "Debe ingresar el Tipo");
 }

}
