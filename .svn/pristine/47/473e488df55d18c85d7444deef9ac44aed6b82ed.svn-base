package com.srn.erp.legales.bm;

import java.util.List;

import com.srn.erp.legales.da.DBEstadoSeclo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class EstadoSeclo extends ObjetoLogico {

	public EstadoSeclo() {
	}

	public static String NICKNAME = "leg.EstadoSeclo";

	private String descripcion;
	private Boolean activo;

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

	public static EstadoSeclo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadoSeclo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EstadoSeclo findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadoSeclo) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static EstadoSeclo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EstadoSeclo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static EstadoSeclo getEstadoSeclo(String descripcion,
	          ISesion aSesion)
	          throws BaseException {
		  return DBEstadoSeclo.getEstadoSeclo(descripcion,aSesion);
	}
	
	public static List getAllEstadosSeclos(ISesion aSesion) throws BaseException {
		return DBEstadoSeclo.getAllEstadosSeclos(aSesion);
	}	
	
	

}
