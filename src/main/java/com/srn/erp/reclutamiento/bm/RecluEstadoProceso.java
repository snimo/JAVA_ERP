package com.srn.erp.reclutamiento.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluEstadoProceso extends ObjetoLogico { 

  public RecluEstadoProceso() { 
  }

  public static String NICKNAME = "rs.RecluEstadoProceso";

  private String codigo;
  private String descripcion;
  private Boolean iniciar_prox_proc;
  private Boolean fec_planif_oblig; 
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

  public Boolean isIniciar_prox_proc() throws BaseException { 
    supportRefresh();
    return iniciar_prox_proc;
  }
  
  
  public Boolean isFecPlanifOblig() throws BaseException { 
	    supportRefresh();
	    if (this.fec_planif_oblig==null)
	    	return false;
	    else
	    	return this.fec_planif_oblig;
	  }  

  public void setIniciar_prox_proc(Boolean aIniciar_prox_proc) { 
    this.iniciar_prox_proc =  aIniciar_prox_proc;
  }
  
  public void setFecPlanifOblig(Boolean aFecPlanifOblig) { 
	    this.fec_planif_oblig =  aFecPlanifOblig;
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

 public static RecluEstadoProceso findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecluEstadoProceso) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static RecluEstadoProceso findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (RecluEstadoProceso) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 

 public static RecluEstadoProceso findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecluEstadoProceso) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }
 
 public static RecluEstadoProceso getEstadoProcesoDefaultAltaCandidato(ISesion aSesion)
	throws BaseException {
		Integer oidEstadoProceso = ValorParametro.findByCodigoParametro(
				"EST_PROC_DEF_CANDIDATO", aSesion).getOidObjNeg();
		RecluEstadoProceso estadoProceso = RecluEstadoProceso.findByOid(oidEstadoProceso, aSesion);
		return estadoProceso;
 } 

}
