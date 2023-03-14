package com.srn.erp.produccion.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.request.bl.Utils.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import java.util.List;

public class OperacionProductiva extends ObjetoLogico {

	public OperacionProductiva() {
	}

	public static String NICKNAME = "pr.OperacionProductiva";

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

	public static OperacionProductiva findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (OperacionProductiva) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static OperacionProductiva findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (OperacionProductiva) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static OperacionProductiva findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (OperacionProductiva) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

}
