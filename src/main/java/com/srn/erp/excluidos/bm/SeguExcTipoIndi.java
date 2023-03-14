package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBSeguExcTipoIndi;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class SeguExcTipoIndi extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public SeguExcTipoIndi() { 
  }

  public static String NICKNAME = "exc.SeguExcTipoIndi";

  private SeguPerfilExcluido oid_segu_perfil;
  private String tipo_individuo;
  private Boolean visualiza;
  private Boolean alta;
  private Boolean baja;
  private Boolean modifica;
  private Boolean activo;

  public SeguPerfilExcluido getOid_segu_perfil() throws BaseException { 
    supportRefresh();
    return oid_segu_perfil;
  }

  public void setOid_segu_perfil(SeguPerfilExcluido aOid_segu_perfil) { 
    this.oid_segu_perfil =  aOid_segu_perfil;
  }

  public String getTipo_individuo() throws BaseException { 
    supportRefresh();
    return tipo_individuo;
  }

  public void setTipo_individuo(String aTipo_individuo) { 
    this.tipo_individuo =  aTipo_individuo;
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

 public static SeguExcTipoIndi findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (SeguExcTipoIndi) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static SeguExcTipoIndi findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (SeguExcTipoIndi) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(oid_segu_perfil, "Debe ingresar el Perfil");
    Validar.noNulo(tipo_individuo, "Debe ingresar el Tipo de Individuo");
 }
 
 public static List getTiposIndividuos(SeguPerfilExcluido seguPerfilExcluido,
         ISesion aSesion) throws BaseException {
	  return DBSeguExcTipoIndi.getTiposIndividuos(seguPerfilExcluido,aSesion);
 }
 
 public static SeguExcTipoIndi getSeguExcTipoIndi(SeguPerfilExcluido seguPerfilExcluido,String tipo,
         ISesion aSesion)
         throws BaseException {
	  return DBSeguExcTipoIndi.getSeguExcTipoIndi(seguPerfilExcluido,tipo,aSesion);
 } 

}
