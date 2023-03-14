package com.srn.erp.cip.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoCategAcceso extends ObjetoLogico {

	public GrupoCategAcceso() {
	}

	public static String NICKNAME = "cip.GrupoCategAcceso";

	private String codigo;
	private String descripcion;
	private Boolean activo;
	private Integer orden;

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

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static GrupoCategAcceso findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (GrupoCategAcceso) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoCategAcceso findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (GrupoCategAcceso) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static GrupoCategAcceso findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (GrupoCategAcceso) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(orden, "Debe ingresar el Nro. de Orden");
	}

}
