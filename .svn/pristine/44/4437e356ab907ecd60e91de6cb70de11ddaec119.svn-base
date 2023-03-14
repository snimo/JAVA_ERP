package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBSeguExcPeligrosidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class SeguExcPeligrosidad extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public SeguExcPeligrosidad() { 
  }

  public static String NICKNAME = "exc.SeguExcPeligrosidad";

  private SeguPerfilExcluido perfil;
  private PeligrosidadExcluido peligrosidad;
  private Boolean visualiza;
  private Boolean alta;
  private Boolean baja;
  private Boolean modifica;
  private Boolean activo;

  public SeguPerfilExcluido getPerfil() throws BaseException { 
    supportRefresh();
    return perfil;
  }

  public void setPerfil(SeguPerfilExcluido aPerfil) { 
    this.perfil =  aPerfil;
  }

  public PeligrosidadExcluido getPeligrosidad() throws BaseException { 
    supportRefresh();
    return peligrosidad;
  }

  public void setPeligrosidad(PeligrosidadExcluido aPeligrosidad) { 
    this.peligrosidad =  aPeligrosidad;
  }

  public Boolean isVisualiza() throws BaseException { 
    supportRefresh();
    return visualiza;
  }

  public void setVisualiza(Boolean aVisualiza) { 
    this.visualiza =  aVisualiza;
  }

  public Boolean isAlta() throws BaseException { 
    supportRefresh();
    return alta;
  }

  public void setAlta(Boolean aAlta) { 
    this.alta =  aAlta;
  }

  public Boolean isBaja() throws BaseException { 
    supportRefresh();
    return baja;
  }

  public void setBaja(Boolean aBaja) { 
    this.baja =  aBaja;
  }

  public Boolean isModifica() throws BaseException { 
    supportRefresh();
    return modifica;
  }

  public void setModifica(Boolean aModifica) { 
    this.modifica =  aModifica;
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

 public static SeguExcPeligrosidad findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (SeguExcPeligrosidad) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static SeguExcPeligrosidad findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (SeguExcPeligrosidad) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(perfil, "Debe ingresar el Perfil");
    Validar.noNulo(peligrosidad, "Debe ingresar la Peligrosidad");
 }
 
 public static List getPeligrosidades(SeguPerfilExcluido seguPerfilExcluido,
         ISesion aSesion) throws BaseException {
	  return DBSeguExcPeligrosidad.getPeligrosidades(seguPerfilExcluido,aSesion);
 }
 
 public static SeguExcPeligrosidad getSeguExcPeligrosidad(
		 SeguPerfilExcluido seguPerfilExcluido,
		  PeligrosidadExcluido peligrosidad,
         ISesion aSesion)
         throws BaseException {
	  
	  return DBSeguExcPeligrosidad.getSeguExcPeligrosidad(seguPerfilExcluido,peligrosidad,aSesion);
			  				
 } 

}
