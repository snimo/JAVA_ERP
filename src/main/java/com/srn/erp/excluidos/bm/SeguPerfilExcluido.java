package com.srn.erp.excluidos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.excluidos.da.DBSeguPerfilExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class SeguPerfilExcluido extends ObjetoLogico { 

  public SeguPerfilExcluido() { 
  }

  public static String NICKNAME = "exc.SeguPerfilExcluido";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  
  private List tiposIndividuos = new ArrayList();
  private boolean readTiposIndividuos = true;  
  
  private List estadosActuales = new ArrayList();
  private boolean readEstadosActuales = true;
  
  private List peligrosidad = new ArrayList();
  private boolean readPeligrosidad = true;
  
  private List predios = new ArrayList();
  private boolean readPredios = true;  
  
  private List estadosAlgunaVez = new ArrayList();
  private boolean readEstadosAlgunaVez = true;  
  

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

 public static SeguPerfilExcluido findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (SeguPerfilExcluido) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static SeguPerfilExcluido findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (SeguPerfilExcluido) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 

 public static SeguPerfilExcluido findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (SeguPerfilExcluido) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "");
 }
 
 public List getTiposIndividuos() throws BaseException {
	if (this.readTiposIndividuos) {
	    List listaTiposIndividuos = SeguExcTipoIndi.getTiposIndividuos(this, this.getSesion());
	    this.tiposIndividuos.addAll(listaTiposIndividuos);
	    this.readTiposIndividuos = false;
	 }
	 return this.tiposIndividuos;
 }
 
 public List getEstadosActuales() throws BaseException {
	if (this.readEstadosActuales) {
	    List listaEstadosActuales = SeguExcEstadoActual.getEstados(this, this.getSesion());
	    this.estadosActuales.addAll(listaEstadosActuales);
	    this.readEstadosActuales = false;
	 }
	 return this.estadosActuales;
 } 
 
 
 public List getPeligrosidades() throws BaseException {
	if (this.readPeligrosidad) {
	    List listaPeligrosidades = SeguExcPeligrosidad.getPeligrosidades(this, this.getSesion());
	    this.peligrosidad.addAll(listaPeligrosidades);
	    this.readPeligrosidad = false;
	 }
	 return this.peligrosidad;
 } 
 
 
 public List getPredios() throws BaseException {
		if (this.readPredios) {
		    List listaPredios = SeguExcPredio.getPredios(this, this.getSesion());
		    this.predios.addAll(listaPredios);
		    this.readPredios = false;
		 }
		 return this.predios;
 } 
 
 
 public List getEstadosAlgunaVez() throws BaseException {
		if (this.readEstadosAlgunaVez) {
		    List listaEstadosAlgunaVez = SeguExcEstAlgunaVez.getExcAlgunaVez(this, this.getSesion());
		    this.estadosAlgunaVez.addAll(listaEstadosAlgunaVez);
		    this.readPredios = false;
		 }
		 return this.estadosAlgunaVez;
} 

 public void addTipoIndividuo(SeguExcTipoIndi aSeguExcTipoIndi) throws BaseException {
	 aSeguExcTipoIndi.setOid_segu_perfil(this);
	 this.tiposIndividuos.add(aSeguExcTipoIndi);
 }
 
 public void addEstadoAlgunaVez(SeguExcEstAlgunaVez aSeguExcEstAlgunaVez) throws BaseException {
	 aSeguExcEstAlgunaVez.setPerfil(this);
	 this.estadosAlgunaVez.add(aSeguExcEstAlgunaVez);
 } 
 
 public void addPredio(SeguExcPredio aSeguExcPredio) throws BaseException {
	 aSeguExcPredio.setPerfil(this);
	 this.predios.add(aSeguExcPredio);
 } 
 
 public void addEstadoActual(SeguExcEstadoActual aSeguExcEstadoActual) throws BaseException {
	 aSeguExcEstadoActual.setPerfil(this);
	 this.estadosActuales.add(aSeguExcEstadoActual);
 } 
 
 public void addPeligrosidad(SeguExcPeligrosidad aSeguExcPeligrosidad) throws BaseException {
	 aSeguExcPeligrosidad.setPerfil(this);
	 this.peligrosidad.add(aSeguExcPeligrosidad);
 } 

 public void afterSave() throws BaseException {
	 
	    Iterator iterTiposIndividuos = this.tiposIndividuos.iterator();
	    while (iterTiposIndividuos.hasNext()) {
	      SeguExcTipoIndi seguExcTipoIndi = (SeguExcTipoIndi) iterTiposIndividuos.next();
	      seguExcTipoIndi.save();
	      seguExcTipoIndi = null;
	    }
	    iterTiposIndividuos = null;
	    
	    Iterator iterEstadosActuales = this.estadosActuales.iterator();
	    while (iterEstadosActuales.hasNext()) {
	      SeguExcEstadoActual seguExcEstadoActual = (SeguExcEstadoActual) iterEstadosActuales.next();
	      seguExcEstadoActual.save();
	      seguExcEstadoActual = null;
	    }
	    iterEstadosActuales = null;	    
	    
	    Iterator iterPeligrosidades = this.peligrosidad.iterator();
	    while (iterPeligrosidades.hasNext()) {
	      SeguExcPeligrosidad seguExcPeligrosidad = (SeguExcPeligrosidad) iterPeligrosidades.next();
	      seguExcPeligrosidad.save();
	      seguExcPeligrosidad = null;
	    }
	    iterPeligrosidades = null;	    
	    
	    Iterator iterPredios = this.predios.iterator();
	    while (iterPredios.hasNext()) {
	      SeguExcPredio seguExcPredio = (SeguExcPredio) iterPredios.next();
	      seguExcPredio.save();
	      seguExcPredio = null;
	    }
	    iterPredios = null;	    
	    
	    Iterator iterEstadosAlgVez = this.estadosAlgunaVez.iterator();
	    while (iterEstadosAlgVez.hasNext()) {
	      SeguExcEstAlgunaVez seguExcEstAlgunaVez = (SeguExcEstAlgunaVez) iterEstadosAlgVez.next();
	      seguExcEstAlgunaVez.save();
	      seguExcEstAlgunaVez = null;
	    }
	    iterEstadosAlgVez = null;	    
	    
 }
 
 public static List getAllActivos(ISesion aSesion) throws BaseException {
	  return DBSeguPerfilExcluido.getAllActivos(aSesion);
 } 

}
