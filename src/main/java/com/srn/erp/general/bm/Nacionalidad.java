package com.srn.erp.general.bm;

import java.util.List;

import com.srn.erp.general.da.DBNacionalidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Nacionalidad extends ObjetoLogico {

	public Nacionalidad() {
	}

	public static String NICKNAME = "ge.Nacionalidad";

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

	public static Nacionalidad findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Nacionalidad) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Nacionalidad findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (Nacionalidad) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Nacionalidad findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Nacionalidad) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la descripción");
	}

	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return DBNacionalidad.getAllActivos(aSesion);
	}

}
