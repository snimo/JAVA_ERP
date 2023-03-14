package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoVisita extends ObjetoLogico { 

  public GrupoVisita() { 
  }

  public static String NICKNAME = "cip.GrupoVisita";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  private boolean antipassback;
  private GrupoPuerta grupoPuertaIngreso;
  private GrupoPuerta grupoPuertaEgreso;
  private Legajo visitaA;
  private Legajo autoriza;
  private PermisoSemanalCIP permisoSemanal;
  private boolean aplicVigencia;
  private java.util.Date fecDesdeVig;
  private java.util.Date fecHastaVig;
  private CategAccesoCIP categAcceso;
  
  private List documentacion = new ArrayList();
  private boolean readDocumentacion = true;
  
  private List rotas = new ArrayList();
  private boolean readRotas = true;
  
  private List entradasIntermedias = new ArrayList();
  private boolean readEntradasIntermedias = true;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }
  
  public boolean isAplicVigencia() throws BaseException { 
	    supportRefresh();
	    return this.aplicVigencia;
  }
  
  public CategAccesoCIP getCategoriaAcceso() throws BaseException {
		supportRefresh();
		return this.categAcceso;
  }

  public void setCategAcceso(CategAccesoCIP aCategAccesoCIP) {
		this.categAcceso = aCategAccesoCIP;
  }
	
  
  public PermisoSemanalCIP getPermisoSemanal() throws BaseException { 
	 supportRefresh();
	 return this.permisoSemanal;
  }
  
  public java.util.Date getFecDesdeVig() throws BaseException { 
		 supportRefresh();
		 return this.fecDesdeVig;
  }
  
  public java.util.Date getFecHastaVig() throws BaseException { 
		 supportRefresh();
		 return this.fecHastaVig;
  }
  
  public Legajo getVisitaA() throws BaseException { 
	    supportRefresh();
	    return this.visitaA;
  }
  
  public Legajo getAutoriza() throws BaseException { 
	    supportRefresh();
	    return this.autoriza;
}
  
  public boolean isAntipassback() throws BaseException { 
	    supportRefresh();
	    return this.antipassback;
  }
  
  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }
  
  public void setFecDesdeVig(java.util.Date aFecDesdeVig) { 
	    this.fecDesdeVig =  aFecDesdeVig;
  }
  
  public void setFecHastaVig(java.util.Date aFecHastaVig) { 
	    this.fecHastaVig =  aFecHastaVig;
  }
  
  public void setAplicVigencia(boolean aAplicVigencia) { 
	    this.aplicVigencia =  aAplicVigencia;
  }
  
  public void setPermisoSemanal(PermisoSemanalCIP aPermisoSemanal) { 
	    this.permisoSemanal =  aPermisoSemanal;
  }
  
  
  public void setVisitaA(Legajo aVisitaA) { 
	    this.visitaA =  aVisitaA;
  }

  public void setAutoriza(Legajo aAutoriza) { 
	    this.autoriza =  aAutoriza;
  }
  
  public void setAntiPassBack(boolean aAntipassback) { 
	    this.antipassback =  aAntipassback;
  }
  

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }
  
  public GrupoPuerta getGrupoPuertaIngreso() throws BaseException { 
	 supportRefresh();
	 return this.grupoPuertaIngreso;
  }

  public void setGrupoPuertaIngreso(GrupoPuerta aGrupoPuerta) { 
	    this.grupoPuertaIngreso =  aGrupoPuerta;
  }
  
  public GrupoPuerta getGrupoPuertaEgreso() throws BaseException { 
		 supportRefresh();
		 return this.grupoPuertaEgreso;
  }

  public void setGrupoPuertaEgreso(GrupoPuerta aGrupoPuerta) { 
		    this.grupoPuertaEgreso =  aGrupoPuerta;
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

 public static GrupoVisita findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (GrupoVisita) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static GrupoVisita findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (GrupoVisita) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 

 public static GrupoVisita findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (GrupoVisita) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    
    if (aplicVigencia) {
    	Validar.noNulo(this.fecDesdeVig, "Debe ingresar la Fecha Vigencia Desde");
    	Validar.noNulo(this.fecHastaVig, "Debe ingresar la Fecha Vigencia Hasta");
    }
 }
 
 public List getDocumentaciones() throws BaseException {
	    if (this.readDocumentacion) {
	      List listaDocumentaciones = DocumentacionVisitaCIP.getDocumentacion(this,getSesion());
	      this.documentacion.addAll(listaDocumentaciones);
	      this.readDocumentacion = false;
	    }
	    return documentacion;
 }

 public void addDocumentacion(DocumentacionVisitaCIP aDocumentacion) throws BaseException {
	 aDocumentacion.setGrupoVisita(this);
	 this.documentacion.add(aDocumentacion);
 }
 
 public void addEntradaIntermedia(MotEntIntVis aMotEntIntVis) throws BaseException {
	 aMotEntIntVis.setGrupoVisita(this);
	 this.entradasIntermedias.add(aMotEntIntVis);
 }
 
 public void addRotas(RotaVisita aRotaVisita) throws BaseException {
	 aRotaVisita.setGrupoVisita(this);
	 this.rotas.add(aRotaVisita);
 }
 

 public void afterSave() throws BaseException {
	 
	    Iterator iterDocumentacion = this.documentacion.iterator();
	    while (iterDocumentacion.hasNext()) {
	      DocumentacionVisitaCIP docu = (DocumentacionVisitaCIP) iterDocumentacion.next();
	      docu.save();
	      docu = null;
	    }
	    iterDocumentacion = null;
	    
	    Iterator iterRotas = this.rotas.iterator();
	    while (iterRotas.hasNext()) {
	      RotaVisita rotaVisita = (RotaVisita) iterRotas.next();
	      rotaVisita.save();
	      rotaVisita = null;
	    }
	    iterRotas = null;
	    
	    Iterator iterEntInter = this.entradasIntermedias.iterator();
	    while (iterEntInter.hasNext()) {
	      MotEntIntVis motEntIntVis = (MotEntIntVis) iterEntInter.next();
	      motEntIntVis.save();
	      motEntIntVis = null;
	    }
	    iterEntInter = null;	    	   
	    
 }
 
 public List getRotasVisita(java.util.Date fecha) throws BaseException {
	  return RotaVisita.getRotasVisita(this,fecha,this.getSesion());
 }
 
 
 public boolean isVigentaAFecHora(java.util.Date aFecHor) throws BaseException {
	 
		if (this.isAplicVigencia()==false) return true;  
		if ((this.getFecDesdeVig()==null) || (this.getFecHastaVig()==null)) return true;
		java.util.Date fecHorActual = Fecha.getFechaTruncada(aFecHor);
		if (Fecha.isFechaEntre(fecHorActual, 
				               Fecha.getFechaTruncada(this.getFecDesdeVig()), 
				               Fecha.getFechaTruncada(this.getFecHastaVig()))) return true;
		return false;
 }
 
 

}
