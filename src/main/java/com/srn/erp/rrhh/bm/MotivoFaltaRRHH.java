package com.srn.erp.rrhh.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class MotivoFaltaRRHH extends ObjetoLogico {

	public MotivoFaltaRRHH() {
	}

	public static String NICKNAME = "rh.MotivoFaltaRRHH";

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

	public static MotivoFaltaRRHH findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MotivoFaltaRRHH) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static MotivoFaltaRRHH findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (MotivoFaltaRRHH) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static MotivoFaltaRRHH findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MotivoFaltaRRHH) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

}
