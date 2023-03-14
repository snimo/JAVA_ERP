package com.srn.erp.general.bm;

import java.util.List;

import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadFijo;
import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadVar;
import com.srn.erp.general.da.DBEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Entidad extends ObjetoLogico { 

  public Entidad() { 
  }

  public static String NICKNAME = "ge.Entidad";

  private String codigo;
  private String descripcion;
  private String nombre_nickname;
  private Boolean activo;
  private Boolean isComprobante;

  public Boolean isComprobante() throws BaseException { 
    supportRefresh();
    return this.isComprobante;
  }

  public void setIsComprobante(Boolean aIsComprobante) { 
    this.isComprobante =  aIsComprobante;
  }
  
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

  public String getNombre_nickname() throws BaseException { 
    supportRefresh();
    return nombre_nickname;
  }

  public void setNombre_nickname(String aNombre_nickname) { 
    this.nombre_nickname =  aNombre_nickname;
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

 public static Entidad findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (Entidad) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static Entidad findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (Entidad) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(nombre_nickname, "Debe ingresar la entidad");
 }
 
 public static Entidad getEntidad(String nickName, ISesion aSesion) throws BaseException {
		return DBEntidad.getEntidad(nickName,aSesion);
	}
 
 public List getGruposAtributosEntidadFijo() throws BaseException {
	  return GrupoAtributoEntidadFijo.getGruposAtriFijosByNickName(this.getNombre_nickname(),getSesion()); 
 }
 
 public List getGruposAtributosEntidadVar() throws BaseException {
	  return GrupoAtributoEntidadVar.getGruposAtriEntVar(this.getNombre_nickname(),getSesion()); 
 }
 
 public String getNombreTablaFisica() throws BaseException {
	 TablasDeEntidades tablaDeEntidades = new TablasDeEntidades();
	 return tablaDeEntidades.getTablaDeEntidad(this.getNombre_nickname()).getNombreTablaFisica();
 }
 
 

}
