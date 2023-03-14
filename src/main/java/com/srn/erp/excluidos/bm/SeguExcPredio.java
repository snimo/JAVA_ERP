package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBSeguExcPredio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class SeguExcPredio extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public SeguExcPredio() { 
  }

  public static String NICKNAME = "exc.SeguExcPredio";

  private SeguPerfilExcluido perfil;
  private PredioExcluido predio;
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

  public PredioExcluido getPredio() throws BaseException { 
    supportRefresh();
    return predio;
  }

  public void setPredio(PredioExcluido aPredio) { 
    this.predio =  aPredio;
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

 public static SeguExcPredio findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (SeguExcPredio) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static SeguExcPredio findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (SeguExcPredio) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(perfil, "Debe ingresar el Perfil");
    Validar.noNulo(predio, "Debe ingresar el Predio Excluido");
 }
 
 public static List getPredios(SeguPerfilExcluido seguPerfilExcluido,
         ISesion aSesion) throws BaseException {
	  return DBSeguExcPredio.getPredios(seguPerfilExcluido,aSesion);
 }
 
 public static SeguExcPredio getSeguExcPredio(
		  SeguPerfilExcluido seguPerfilExcluido,
		  PredioExcluido predio,
         ISesion aSesion)
         throws BaseException {
	 
	  return DBSeguExcPredio.getSeguExcPredio(seguPerfilExcluido,predio,aSesion);
	  
 }  

}
