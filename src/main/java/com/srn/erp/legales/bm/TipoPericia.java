package com.srn.erp.legales.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoPericia extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public TipoPericia() {
	}

	public static String NICKNAME = "leg.TipoPericia";

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

	public static TipoPericia findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoPericia) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static TipoPericia findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoPericia) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}	

	public static TipoPericia findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TipoPericia) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(descripcion, "Debe ingresar la descripción");
	}

}
