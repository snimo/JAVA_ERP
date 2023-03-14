package com.srn.erp.presupuesto.bm;

import java.util.List;

import com.srn.erp.presupuesto.da.DBGrupoComponente;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoComponente extends ObjetoLogico { 

  public GrupoComponente() { 
  }

  public static String NICKNAME = "pl.GrupoComponente";

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

 public static GrupoComponente findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (GrupoComponente) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static GrupoComponente findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (GrupoComponente) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 

 public static GrupoComponente findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (GrupoComponente) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }
 
 public static List getAllGrupos(ISesion aSesion) throws BaseException {
 	return DBGrupoComponente.getAllGrupos(aSesion);
 }
 
 public List getComponentesPresupuestarios() throws BaseException {
	 return CompoPresupuestario.getComponentesByGrupo(this,this.getSesion());
 }
 
 
 
 
 
}
