package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBPermisoInternoEstado;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PermisoInternoEstado extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public PermisoInternoEstado() { 
  }

  public static String NICKNAME = "cip.PermisoInternoEstado";

  private ReglasPermisosInt regla_permiso;
  private EstadoCIP estado_cip;
  private Boolean activo;

  public ReglasPermisosInt getRegla_permiso() throws BaseException { 
    supportRefresh();
    return regla_permiso;
  }

  public void setRegla_permiso(ReglasPermisosInt aRegla_permiso) { 
    this.regla_permiso =  aRegla_permiso;
  }

  public EstadoCIP getEstado_cip() throws BaseException { 
    supportRefresh();
    return estado_cip;
  }

  public void setEstado_cip(EstadoCIP aEstado_cip) { 
    this.estado_cip =  aEstado_cip;
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

 public static PermisoInternoEstado findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (PermisoInternoEstado) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static PermisoInternoEstado findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (PermisoInternoEstado) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(regla_permiso, "Debe ingresar la Regla");
    Validar.noNulo(estado_cip, "Debe ingresar el Estado");
 }
 
 public static List getPermisoInternosEstado(
		  ReglasPermisosInt regla,
         ISesion aSesion) throws BaseException {
	  return DBPermisoInternoEstado.getPermisoInternosEstado(regla,aSesion);
 }
 
 public static PermisoInternoEstado getPermisoInternoEstado(
		  ReglasPermisosInt regla,
		  EstadoCIP estado,
         ISesion aSesion)
         throws BaseException {
	 
	  
	  return DBPermisoInternoEstado.getPermisoInternoEstado(regla,estado,aSesion);
 } 

}
