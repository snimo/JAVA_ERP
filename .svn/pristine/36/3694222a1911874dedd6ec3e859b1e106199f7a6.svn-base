package com.srn.erp.rrhh.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CompePotencial extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public CompePotencial() {
	}

	public static String NICKNAME = "rh.CompePotencial";

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

	public static CompePotencial findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CompePotencial) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CompePotencial findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CompePotencial) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(cosigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

}
