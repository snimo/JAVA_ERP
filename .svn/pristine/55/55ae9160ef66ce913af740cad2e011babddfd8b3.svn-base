package com.srn.erp.rrhh.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class AparatoRRHH extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AparatoRRHH() {
	}

	public static String NICKNAME = "rh.AparatoRRHH";

	private String cosigo;
	private String descripcion;
	private Boolean activo;

	public String getCosigo() throws BaseException {
		supportRefresh();
		return cosigo;
	}

	public void setCosigo(String aCosigo) {
		this.cosigo = aCosigo;
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

	public static AparatoRRHH findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AparatoRRHH) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static AparatoRRHH findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AparatoRRHH) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static AparatoRRHH findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AparatoRRHH) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

}
