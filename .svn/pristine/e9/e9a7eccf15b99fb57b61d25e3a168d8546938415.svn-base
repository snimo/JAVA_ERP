package com.srn.erp.reclutamiento.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluCompetencias extends ObjetoLogico { 

  public RecluCompetencias() { 
  }

  public static String NICKNAME = "rs.RecluCompetencias";

  private String codigo;
  private String descripcion;
  private RecluGrupoCompe oid_grupo_compe;
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

  public RecluGrupoCompe getOid_grupo_compe() throws BaseException { 
    supportRefresh();
    return oid_grupo_compe;
  }

  public void setOid_grupo_compe(RecluGrupoCompe aOid_grupo_compe) { 
    this.oid_grupo_compe =  aOid_grupo_compe;
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

 public static RecluCompetencias findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecluCompetencias) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 
 public static RecluCompetencias findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (RecluCompetencias) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 

 public static RecluCompetencias findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecluCompetencias) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(oid_grupo_compe, "Debe ingresar el Grupo Competencia");
 }

}
