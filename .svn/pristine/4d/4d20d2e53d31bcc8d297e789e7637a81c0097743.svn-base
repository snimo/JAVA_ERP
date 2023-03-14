package com.srn.erp.reclutamiento.bm;

import java.util.List;

import com.srn.erp.reclutamiento.da.DBRecluProcesoCandidato;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class RecluProcesoCandidato extends ObjetoLogico { 

  @Override
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public RecluProcesoCandidato() { 
  }

  public static String NICKNAME = "rs.RecluProcesoCandidato";

  private RecluCandidatoBusq candidato_busq;
  private Integer orden;
  private RecluProceso proceso;
  private RecluConceptoProceso concepto_proceso;
  private Double costo;
  private RecluEstadoProceso estado;
  private java.util.Date fecha_planif;
  private String hora_planif;
  private String persona;
  private String observaciones;
  private Boolean puede_iniciar;
  private Boolean activo;
  private Integer nroArchivo;
  private String nombreArchivo;
  private RecluPostulante postulante;
  private RecluTipoFormuProceso tipoFormulario;
  private Boolean completoTipoFormulario;
  private java.util.Date fecCompletoTipoFormulario;
  private Boolean seAnuncio;
  private java.util.Date fecHorSeAnuncio;
  private RecluOperacion operacion;
  private RecluSectores sector;
  private RecluSelector selector;
  

  public RecluCandidatoBusq getCandidato_busq() throws BaseException { 
    supportRefresh();
    return candidato_busq;
  }
  
  public RecluOperacion getOperacion() throws BaseException { 
	    supportRefresh();
	    return this.operacion;
	  }  
  
  public RecluSectores getSector() throws BaseException { 
	    supportRefresh();
	    return this.sector;
	  }  
  
  public RecluSelector getSelector() throws BaseException { 
	    supportRefresh();
	    return this.selector;
	  }  
  
  public Boolean isSeAnuncio() throws BaseException { 
	    supportRefresh();
	    if (this.seAnuncio==null)
	    	return false;
	    else
	    	return this.seAnuncio;
	  }  
  
  public java.util.Date getCompletoTipoFormulario() throws BaseException { 
	    supportRefresh();
	    return this.fecCompletoTipoFormulario;
	  }  
  
  public java.util.Date getFecHorSeAnuncio() throws BaseException { 
	    supportRefresh();
	    return this.fecHorSeAnuncio;
	  }  
  
  public Boolean isCompletoTipoFormulario() throws BaseException { 
	    supportRefresh();
	    if (this.completoTipoFormulario==null)
	    	return false;
	    else
	    	return this.completoTipoFormulario;
	  }  
  
  public RecluTipoFormuProceso getTipoFormulario() throws BaseException { 
	    supportRefresh();
	    return this.tipoFormulario;
	  }  
  
  public RecluPostulante getRecluPostulante() throws BaseException { 
	    supportRefresh();
	    return this.postulante;
	  }  
  
  public Integer getNroArchivo() throws BaseException { 
	    supportRefresh();
	    return this.nroArchivo;
  }
  
  
  public String getNombreArchivo() throws BaseException { 
	    supportRefresh();
	    return this.nombreArchivo;
  }  
  
  
  public void setNombreArchivo(String aNombreArchivo) { 
	    this.nombreArchivo =  aNombreArchivo;
  }  
  
  public void setSelector(RecluSelector aSelector) { 
	    this.selector =  aSelector;
}  
  
  public void setSector(RecluSectores aRecluSector) { 
	    this.sector =  aRecluSector;
}  
  
  public void setOperacion(RecluOperacion aRecluOperacion) { 
	    this.operacion =  aRecluOperacion;
}  
  
  public void setSeAnuncio(Boolean aSeAnuncio) { 
	    this.seAnuncio =  aSeAnuncio;
}  
  
  public void setFecHorSeAnuncio(java.util.Date aFecHorSeAnuncio) { 
	    this.fecHorSeAnuncio =  aFecHorSeAnuncio;
}  
  
  public void setFecCompletoTipoFormulario(java.util.Date aFecCompletoTipoFormu) { 
	    this.fecCompletoTipoFormulario =  aFecCompletoTipoFormu;
}  
  
  public void setCompletoTipoFormulario(Boolean aCompletoTipoFormulario) { 
	    this.completoTipoFormulario =  aCompletoTipoFormulario;
}  
  
  public void setTipoFormulario(RecluTipoFormuProceso aTipoFormulario) { 
	    this.tipoFormulario =  aTipoFormulario;
}  
  
  public void setPostulante(RecluPostulante aRecluPostulante) { 
	    this.postulante =  aRecluPostulante;
}  
  
  public void setNroArchivo(Integer aNroArchivo) { 
	    this.nroArchivo =  aNroArchivo;
  }  

  public void setCandidato_busq(RecluCandidatoBusq aCandidato_busq) { 
    this.candidato_busq =  aCandidato_busq;
  }

  public Integer getOrden() throws BaseException { 
    supportRefresh();
    return orden;
  }

  public void setOrden(Integer aOrden) { 
    this.orden =  aOrden;
  }

  public RecluProceso getProceso() throws BaseException { 
    supportRefresh();
    return proceso;
  }

  public void setProceso(RecluProceso aProceso) { 
    this.proceso =  aProceso;
  }

  public RecluConceptoProceso getConcepto_proceso() throws BaseException { 
    supportRefresh();
    return concepto_proceso;
  }

  public void setConcepto_proceso(RecluConceptoProceso aConcepto_proceso) { 
    this.concepto_proceso =  aConcepto_proceso;
  }

  public Double getCosto() throws BaseException { 
    supportRefresh();
    return costo;
  }

  public void setCosto(Double aCosto) { 
    this.costo =  aCosto;
  }

  public RecluEstadoProceso getEstado() throws BaseException { 
    supportRefresh();
    return estado;
  }

  public void setEstado(RecluEstadoProceso aEstado) { 
    this.estado =  aEstado;
  }

  public java.util.Date getFecha_planif() throws BaseException { 
    supportRefresh();
    return fecha_planif;
  }

  public void setFecha_planif(java.util.Date aFecha_planif) { 
    this.fecha_planif =  aFecha_planif;
  }

  public String getHora_planif() throws BaseException { 
    supportRefresh();
    return hora_planif;
  }

  public void setHora_planif(String aHora_planif) { 
    this.hora_planif =  aHora_planif;
  }

  public String getPersona() throws BaseException { 
    supportRefresh();
    return persona;
  }

  public void setPersona(String aPersona) { 
    this.persona =  aPersona;
  }

  public String getObservaciones() throws BaseException { 
    supportRefresh();
    return observaciones;
  }

  public void setObservaciones(String aObservaciones) { 
    this.observaciones =  aObservaciones;
  }

  public Boolean isPuede_iniciar() throws BaseException { 
    supportRefresh();
    return puede_iniciar;
  }

  public void setPuede_iniciar(Boolean aPuede_iniciar) { 
    this.puede_iniciar =  aPuede_iniciar;
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

 public static RecluProcesoCandidato findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecluProcesoCandidato) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static RecluProcesoCandidato findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecluProcesoCandidato) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException {
	 
    Validar.noNulo(orden, "Debe ingresar el Orden");
    Validar.noNulo(proceso, "Debe ingresar el Proceso");
    Validar.noNulo(concepto_proceso, "Debe ingresar el Tipo de Examen");
    Validar.noNulo(estado, "Debe ingresar el Estado");
    
    if (this.estado.isFecPlanifOblig()) {
    	Validar.noNulo(this.fecha_planif, "Debe ingresar la fecha de Planificación");
    }
    
    if (this.fecha_planif!=null)
    	if (this.estado.isFecPlanifOblig()==false)
    		throw new ExceptionValidation(null,"El estado seleccionado no permite tener cargado una fecha de Planificación. Borre la fecha o modifique el estado.");
    
    if (this.candidato_busq == null)
    	if (this.operacion == null)
    		throw new ExceptionValidation(null,"Debe ingresar la Operación.");
    
 }
 
 public static List getProcesosCandidato(RecluCandidatoBusq aRecluCandidatoBusq,
         ISesion aSesion) throws BaseException {
	  return DBRecluProcesoCandidato.getProcesosCandidato(aRecluCandidatoBusq,aSesion);
 }
 
 public static List getRecluProcesoCandidato(RecluPostulante postulante,
         ISesion aSesion) throws BaseException {
	  return DBRecluProcesoCandidato.getRecluProcesoCandidato(postulante,aSesion);
 }
 
 public static RecluProcesoCandidato getProcesoCandidato(
		  RecluCandidatoBusq recluCandidatoBusq,
		  RecluProceso recluProceso,
         ISesion aSesion)
         throws BaseException {
	  
	  return DBRecluProcesoCandidato.getProcesoCandidato(recluCandidatoBusq,recluProceso,aSesion);
 }
 
 public static List getRecluProcesoCandidatoByCondiciones(HashTableDatos condiciones,
         ISesion aSesion) throws BaseException {
	  return DBRecluProcesoCandidato.getRecluProcesoCandidatoByCondiciones(condiciones,aSesion);
 }
 
 public static List getRecluProcesosRecepcion(HashTableDatos condiciones,
         ISesion aSesion) throws BaseException {
	  return DBRecluProcesoCandidato.getRecluProcesosRecepcion(condiciones,aSesion);
 } 
 

}
