package com.srn.erp.produccion.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.request.bl.Utils.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import java.util.List;

public class ProcesoProductivo extends ObjetoLogico {

	public ProcesoProductivo() {
	}

	public static String NICKNAME = "pr.ProcesoProductivo";

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

	public static ProcesoProductivo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ProcesoProductivo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ProcesoProductivo findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ProcesoProductivo) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ProcesoProductivo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ProcesoProductivo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

}
