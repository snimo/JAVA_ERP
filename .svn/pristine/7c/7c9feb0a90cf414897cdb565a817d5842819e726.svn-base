package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBPermisoInternoSector;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PermisoInternoSector extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public PermisoInternoSector() { 
  }

  public static String NICKNAME = "cip.PermisoInternoSector";

  private ReglasPermisosInt regla_permiso;
  private ValorClasificadorEntidad val_clasif_sector;
  private Boolean activo;

  public ReglasPermisosInt getRegla_permiso() throws BaseException { 
    supportRefresh();
    return regla_permiso;
  }

  public void setRegla_permiso(ReglasPermisosInt aRegla_permiso) { 
    this.regla_permiso =  aRegla_permiso;
  }

  public ValorClasificadorEntidad getVal_clasif_sector() throws BaseException { 
    supportRefresh();
    return val_clasif_sector;
  }

  public void setVal_clasif_sector(ValorClasificadorEntidad aVal_clasif_empresa) { 
    this.val_clasif_sector =  aVal_clasif_empresa;
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

 public static PermisoInternoSector findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (PermisoInternoSector) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static PermisoInternoSector findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (PermisoInternoSector) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(regla_permiso, "Debe ingresar la Regla");
    Validar.noNulo(val_clasif_sector, "Debe ingresar la Sector");
 }
 
 public static List getPermisosInternosSec(ReglasPermisosInt regla,
         ISesion aSesion) throws BaseException {
	  return DBPermisoInternoSector.getPermisosInternosSec(regla,aSesion);
 }
 
 public static PermisoInternoSector getPermisoInternoSector(
		  ReglasPermisosInt regla,
		  ValorClasificadorEntidad valor,
         ISesion aSesion)
         throws BaseException {
	  
	  return DBPermisoInternoSector.getPermisoInternoSector(regla,valor,aSesion);
	  
 } 

}
