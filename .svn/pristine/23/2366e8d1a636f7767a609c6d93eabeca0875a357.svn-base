package com.srn.erp.reclutamiento.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.reclutamiento.da.DBRecluProceso;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluProceso extends ObjetoLogico { 

  public RecluProceso() { 
  }

  public static String NICKNAME = "rs.RecluProceso";

  private String codigo;
  private String descripcion;
  private Integer orden;
  private Money costo;
  private Boolean activo;
  private Boolean altaSolapaPostulante;
  private Boolean visuSolapaPostulante;
  private Boolean visuConsRecepcion;
  private Boolean altaEnBusqueda; 
  
  
  private List conceptos = new ArrayList();
  private boolean readConceptos = true;  

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }
  
  public Boolean isAltaSolapaPostulante() throws BaseException { 
	    supportRefresh();
	    return this.altaSolapaPostulante;
	  }
  
  public Boolean isAltaEnBusqueda() throws BaseException { 
	    supportRefresh();
	    return this.altaEnBusqueda;
	  }
  
  
  public Boolean isVisuConsRecepcion() throws BaseException { 
	    supportRefresh();
	    return this.visuConsRecepcion;
	  }  
  
  
  public Boolean isVisuSolapaPostulante() throws BaseException { 
	    supportRefresh();
	    return this.visuSolapaPostulante;
	  }  

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }
  
  public void setAltaEnBusqueda(Boolean aAltaEnBusqueda) { 
	    this.altaEnBusqueda =  aAltaEnBusqueda;
	  }
  
  
  public void setVisuConsRecepcion(Boolean aVisuConsRecepcion) { 
	    this.visuConsRecepcion =  aVisuConsRecepcion;
	  }  
  
  public void setAltaSolapaPostulante(Boolean aAltaSolapaPostulante) { 
	    this.altaSolapaPostulante =  aAltaSolapaPostulante;
	  }  
  
  public void setVisuSolapaPostulante(Boolean aVisuSolapaPostulante) { 
	    this.visuSolapaPostulante =  aVisuSolapaPostulante;
	  }  

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public Integer getOrden() throws BaseException { 
    supportRefresh();
    return orden;
  }

  public void setOrden(Integer aOrden) { 
    this.orden =  aOrden;
  }

  public Money getCosto() throws BaseException { 
    supportRefresh();
    return costo;
  }

  public void setCosto(Money aCosto) { 
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

 public static RecluProceso findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecluProceso) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static RecluProceso findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (RecluProceso) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 

 public static RecluProceso findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecluProceso) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(orden, "Debe ingresar el Orden");
 }
 
 public List getConceptos() throws BaseException {
	    if (this.readConceptos) {
	      List listaConceptos = RecluConceptoProceso.getConceptos(this,getSesion());
	      this.conceptos.addAll(listaConceptos);
	      readConceptos = false;
	    }
	    return this.conceptos;
 }

 public void addConcepto(RecluConceptoProceso aRecluConceptoProceso) throws BaseException {
	 aRecluConceptoProceso.setProceso(this);
	 conceptos.add(aRecluConceptoProceso);
 }

 public void afterSave() throws BaseException {
	    Iterator iterConceptos = this.conceptos.iterator();
	    while (iterConceptos.hasNext()) {
	      RecluConceptoProceso recluConceptoProceso = (RecluConceptoProceso) iterConceptos.next();
	      recluConceptoProceso.save();
	      recluConceptoProceso = null;
	    }
	    iterConceptos = null;
 }
 
 public static List getProcesosActivos(ISesion aSesion) throws BaseException {
	  return DBRecluProceso.getProcesosActivos(aSesion);
 }
 
 public RecluConceptoProceso getConceptoProcesoDefault() throws BaseException {
	 RecluConceptoProceso primerConcepto = null;
	 Iterator iterConceptos = this.getConceptos().iterator();
	 while (iterConceptos.hasNext()) {
		 RecluConceptoProceso recluConceptoProceso = (RecluConceptoProceso) iterConceptos.next();
		 if (primerConcepto == null)
			 primerConcepto = recluConceptoProceso;
		 if (recluConceptoProceso.isAltaEnBusqueda()) return recluConceptoProceso;  
	 }
	 return primerConcepto;
 }

}
