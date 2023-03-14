package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBSancionesRRHH;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class SancionesRRHH extends ObjetoLogico {

	public SancionesRRHH() {
	}

	public static String NICKNAME = "rh.SancionesRRHH";

	private String codigo;
	private String descripcion;
	private Boolean activo;
	private Boolean excEnPlanifRotas;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setExcluirEnPlanifRotas(Boolean aExcluirPlanifRotas) {
		this.excEnPlanifRotas = aExcluirPlanifRotas;
	}
	
	public Boolean isExcluirEnPlanifRotas() throws BaseException {
		supportRefresh();
		return this.excEnPlanifRotas;
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

	public static SancionesRRHH findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (SancionesRRHH) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static SancionesRRHH findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (SancionesRRHH) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static SancionesRRHH findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (SancionesRRHH) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	public static List getAllSanciones(ISesion aSesion) throws BaseException {
		return DBSancionesRRHH.getAllSanciones(aSesion);
	}

}
