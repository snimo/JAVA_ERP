package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBCargoLegajoExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CargoLegajoExcluido extends ObjetoLogico {

	public CargoLegajoExcluido() {
	}

	public static String NICKNAME = "exc.CargoLegajoExcluido";

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

	public static CargoLegajoExcluido findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CargoLegajoExcluido) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CargoLegajoExcluido findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CargoLegajoExcluido) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static CargoLegajoExcluido findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CargoLegajoExcluido) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

	public static List getAllAtivos(ISesion aSesion) throws BaseException {
		return DBCargoLegajoExcluido.getAllAtivos(aSesion);
	}

}
