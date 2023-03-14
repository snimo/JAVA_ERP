package com.srn.erp.contabilidad.bm;

import java.util.List;

import com.srn.erp.contabilidad.da.DBGrupoAtributoEntidadFijo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoAtributoEntidadFijo extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public GrupoAtributoEntidadFijo() { 
  }

  public static String NICKNAME = "cg.GrupoAtributoEntidadFijo";

  private String nickname;
  private String nombre;
  private Integer orden;
  private GrupoDeAtributos grupo_atributo;
  private Boolean activo;

  public String getNickname() throws BaseException { 
    supportRefresh();
    return nickname;
  }

  public void setNickname(String aNickname) { 
    this.nickname =  aNickname;
  }

  public String getNombre() throws BaseException { 
    supportRefresh();
    return nombre;
  }

  public void setNombre(String aNombre) { 
    this.nombre =  aNombre;
  }

  public Integer getOrden() throws BaseException { 
    supportRefresh();
    return orden;
  }

  public void setOrden(Integer aOrden) { 
    this.orden =  aOrden;
  }

  public GrupoDeAtributos getGrupo_atributo() throws BaseException { 
    supportRefresh();
    return grupo_atributo;
  }

  public void setGrupo_atributo(GrupoDeAtributos aGrupo_atributo) { 
    this.grupo_atributo =  aGrupo_atributo;
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

 public static GrupoAtributoEntidadFijo findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (GrupoAtributoEntidadFijo) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static GrupoAtributoEntidadFijo findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (GrupoAtributoEntidadFijo) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(nickname, "Debe ingresar una entidad");
    Validar.noNulo(nombre, "Debe seleccionar un nombre");
    Validar.noNulo(orden, "Debe seleccionar un orden");
    Validar.noNulo(grupo_atributo, "Debe ingresar un Grupo de Atributos");
 }
 
	public static List getGruposAtriFijosByNickName(String nickname, ISesion aSesion) throws BaseException {
		return DBGrupoAtributoEntidadFijo.getGruposAtriFijosByNickName(nickname,aSesion);
	}
 

}
