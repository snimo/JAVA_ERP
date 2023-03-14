package com.srn.erp.proveedoresMaterials.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CondicionPago extends ObjetoLogico {

	public CondicionPago() {
	}

	public static String NICKNAME = "ma.condicionPago";

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

	public static CondicionPago findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CondicionPago) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CondicionPago findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CondicionPago) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Ingrese un Codigo");
		Validar.noNulo(descripcion, "Ingrese una Descripcion");
	}

}
