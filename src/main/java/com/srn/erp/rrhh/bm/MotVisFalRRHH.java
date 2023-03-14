package com.srn.erp.rrhh.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
	
public class MotVisFalRRHH extends ObjetoLogico {

	public MotVisFalRRHH() {
	}

	public static String NICKNAME = "rh.MotVisFalRRHH";

	private String codigo;
	private String descripcion;
	private Boolean activo;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
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

	public static MotVisFalRRHH findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MotVisFalRRHH) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static MotVisFalRRHH findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (MotVisFalRRHH) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static MotVisFalRRHH findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MotVisFalRRHH) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

}
