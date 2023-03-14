package com.srn.erp.bienUso.bm;

import com.srn.erp.bienUso.da.DBVidaUtilGrupo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class VidaUtilGrupo extends ObjetoLogico { 

  public VidaUtilGrupo() { 
  }

  public static String NICKNAME = "bu.VidaUtilGrupo";

  private GrupoBien grupo_bien;
  private SistemaValuacion sistema_valuacion;
  private Integer vida_util;
  private Boolean activo;

  public GrupoBien getGrupo_bien() throws BaseException { 
    supportRefresh();
    return grupo_bien;
  }

  public void setGrupo_bien(GrupoBien aGrupo_bien) { 
    this.grupo_bien =  aGrupo_bien;
  }

  public SistemaValuacion getSistema_valuacion() throws BaseException { 
    supportRefresh();
    return sistema_valuacion;
  }

  public void setSistema_valuacion(SistemaValuacion aSistema_valuacion) { 
    this.sistema_valuacion =  aSistema_valuacion;
  }

  public Integer getVida_util() throws BaseException { 
    supportRefresh();
    return vida_util;
  }

  public void setVida_util(Integer aVida_util) { 
    this.vida_util =  aVida_util;
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

 public static VidaUtilGrupo findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (VidaUtilGrupo) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static VidaUtilGrupo findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (VidaUtilGrupo) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(grupo_bien, "Debe ingresar el Grupo Bien");
    Validar.noNulo(sistema_valuacion, "Debe ingresar el Sistema de Valuación");
    Validar.noNulo(vida_util, "Debe ingresar la vida útil");
 }

  public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
  }

  public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
  }

  public static VidaUtilGrupo getVidaUtilGrupo(GrupoBien grupoBien,SistemaValuacion sistVal,
        ISesion aSesion)
        throws BaseException {
	return DBVidaUtilGrupo.getVidaUtilGrupo(grupoBien,sistVal,aSesion);
  }

}
