package com.srn.erp.ventas.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MotivoEstadoPresuCliente extends ObjetoLogico {

	public MotivoEstadoPresuCliente() {
	}

	public static String NICKNAME = "ve.MotivoEstadoPresuCliente";

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

	public static MotivoEstadoPresuCliente findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MotivoEstadoPresuCliente) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MotivoEstadoPresuCliente findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (MotivoEstadoPresuCliente) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static MotivoEstadoPresuCliente findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MotivoEstadoPresuCliente) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

}
