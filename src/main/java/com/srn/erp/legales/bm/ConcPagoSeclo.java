package com.srn.erp.legales.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConcPagoSeclo extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ConcPagoSeclo() {
	}

	public static String NICKNAME = "leg.ConcPagoSeclo";

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

	public static ConcPagoSeclo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ConcPagoSeclo) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static ConcPagoSeclo findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ConcPagoSeclo) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static ConcPagoSeclo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ConcPagoSeclo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

}
