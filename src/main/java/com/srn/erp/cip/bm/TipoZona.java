package com.srn.erp.cip.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoZona extends ObjetoLogico {

	public TipoZona() {
	}

	public static String NICKNAME = "cip.TipoZona";

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

	public static TipoZona findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoZona) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static TipoZona findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoZona) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static TipoZona findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TipoZona) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

}
