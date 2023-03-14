package com.srn.erp.rrhh.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EstadoDesarrollo extends ObjetoLogico {

	public EstadoDesarrollo() {
	}

	public static String NICKNAME = "rh.EstadoDesarrollo";

	private String codigo;
	private String descripcion;
	private Boolean no_promocionar;
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

	public Boolean isNo_promocionar() throws BaseException {
		supportRefresh();
		return no_promocionar;
	}

	public void setNo_promocionar(Boolean aNo_promocionar) {
		this.no_promocionar = aNo_promocionar;
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

	public static EstadoDesarrollo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadoDesarrollo) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static EstadoDesarrollo findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadoDesarrollo) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static EstadoDesarrollo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EstadoDesarrollo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

}
