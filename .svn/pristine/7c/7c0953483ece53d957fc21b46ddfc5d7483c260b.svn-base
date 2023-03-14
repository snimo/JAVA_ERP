package com.srn.erp.reclutamiento.bm;

import java.util.List;

import com.srn.erp.reclutamiento.da.DBRecluConceptoProceso;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluConceptoProceso extends ObjetoLogico { 

  @Override
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public RecluConceptoProceso() { 
  }

  public static String NICKNAME = "rs.RecluConceptoProceso";

  private RecluProceso proceso;
  private String descripcion;
  private Double costo;
  private Boolean activo;
  private Boolean altaEnBusqueda;

  public RecluProceso getProceso() throws BaseException { 
    supportRefresh();
    return proceso;
  }
  
  public void setAltaEnBusqueda(Boolean aAltaEnBusqueda) { 
	    this.altaEnBusqueda =  aAltaEnBusqueda;
	  }
  

  public Boolean isAltaEnBusqueda() throws BaseException { 
	    supportRefresh();
	    return this.altaEnBusqueda;
	  }

  public void setProceso(RecluProceso aProceso) { 
    this.proceso =  aProceso;
  }

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public Double getCosto() throws BaseException { 
    supportRefresh();
    return costo;
  }

  public void setCosto(Double aCosto) { 
    this.costo =  aCosto;
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

 public static RecluConceptoProceso findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecluConceptoProceso) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static RecluConceptoProceso findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (RecluConceptoProceso) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 

 public static RecluConceptoProceso findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecluConceptoProceso) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(proceso, "Debe ingresar el Proceso");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }
 
 public static List getConceptos(RecluProceso aRecluProceso,
         ISesion aSesion) throws BaseException {
	  return DBRecluConceptoProceso.getConceptos(aRecluProceso,aSesion);
 } 

}
