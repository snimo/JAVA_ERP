package com.srn.erp.presupuesto.bm;

import java.util.List;

import com.srn.erp.presupuesto.da.DBGrupoRepositorioReal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoRepositorioReal extends ObjetoLogico { 

  public GrupoRepositorioReal() { 
  }

  public static String NICKNAME = "pl.GrupoRepositorioReal";

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

 public static GrupoRepositorioReal findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (GrupoRepositorioReal) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static GrupoRepositorioReal findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (GrupoRepositorioReal) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 

 public static GrupoRepositorioReal findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (GrupoRepositorioReal) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
 }
 
 public static List getGruposRepositorio(ISesion aSesion) throws BaseException {
 	return DBGrupoRepositorioReal.getGruposRepositorio(aSesion);
 }
 
 public List getListaRepositoriosReales() throws BaseException {
	 return RepositorioReal.getRepositoriosByGrupo(this,this.getSesion());
 }
 

}
