package com.srn.erp.legales.bm;

import java.util.List;

import com.srn.erp.legales.da.DBEstadoJuicio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EstadoJuicio extends ObjetoLogico {

	public EstadoJuicio() {
	}

	public static String NICKNAME = "leg.EstadoJuicio";

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

	public static EstadoJuicio findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadoJuicio) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EstadoJuicio findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadoJuicio) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static EstadoJuicio findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EstadoJuicio) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

	public static List getAllEstados(ISesion aSesion) throws BaseException {
		return DBEstadoJuicio.getAllEstados(aSesion);
	}

	public static EstadoJuicio getEstadoJuicio(String descripcion, ISesion aSesion) throws BaseException {
		return DBEstadoJuicio.getEstadoJuicio(descripcion, aSesion);
	}

}
