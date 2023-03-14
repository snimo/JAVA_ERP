package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBTipoNariz;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoNariz extends ObjetoLogico {

	public TipoNariz() {
	}

	public static String NICKNAME = "exc.TipoNariz";

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

	public static TipoNariz findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoNariz) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TipoNariz findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoNariz) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static TipoNariz findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TipoNariz) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return DBTipoNariz.getAllActivos(aSesion);
	}

}
