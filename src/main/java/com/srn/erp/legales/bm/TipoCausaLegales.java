package com.srn.erp.legales.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoCausaLegales extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public TipoCausaLegales() {
	}

	public static String NICKNAME = "leg.TipoCausaLegales";

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

	public static TipoCausaLegales findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoCausaLegales) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static TipoCausaLegales findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoCausaLegales) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static TipoCausaLegales findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TipoCausaLegales) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

}
