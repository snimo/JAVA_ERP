package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class PermisosInternos extends ObjetoLogico {

	public PermisosInternos() {
	}

	public static String NICKNAME = "cip.PermisosInternos";

	private String codigo;
	private String descripcion;
	private Boolean activo;
	private Integer prioridad;
	
	private List reglas = new ArrayList();
	private boolean readReglas = true;	

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}
	
	public Integer getPrioridad() throws BaseException {
		supportRefresh();
		return prioridad;
	}	

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	public void setPrioridad(Integer aPrioridad) {
		this.prioridad = aPrioridad;
	}	

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static PermisosInternos findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PermisosInternos) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static PermisosInternos findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (PermisosInternos) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}	

	public static PermisosInternos findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PermisosInternos) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}
	
	  public List getReglas() throws BaseException {
		    if (this.readReglas) {
		      List listaReglas = ReglasPermisosInt.getReglasPermisosInt(this,getSesion());
		      reglas.addAll(listaReglas);
		      this.readReglas = false;
		    }
		    return reglas;
	  }

	  public void addRegla(ReglasPermisosInt aReglasPermisosInt) throws BaseException {
		  aReglasPermisosInt.setPermisosinternos(this);
		  this.reglas.add(aReglasPermisosInt);
	  }

	  public void afterSave() throws BaseException {
		    Iterator iterReglas = this.reglas.iterator();
		    while (iterReglas.hasNext()) {
		      ReglasPermisosInt regla = (ReglasPermisosInt) iterReglas.next();
		      regla.save();
		      regla = null;
		    }
		    iterReglas = null;
		    
		    
	  }	

}
