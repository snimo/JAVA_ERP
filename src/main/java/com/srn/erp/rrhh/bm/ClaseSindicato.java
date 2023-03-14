package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBClaseSindicato;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ClaseSindicato extends ObjetoLogico {

	public ClaseSindicato() {
	}

	public static String NICKNAME = "rh.ClaseSindicato";

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

	public static ClaseSindicato findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ClaseSindicato) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static ClaseSindicato findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ClaseSindicato) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static ClaseSindicato findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ClaseSindicato) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}
	
	  public static List getAllSindicatos(
	          ISesion aSesion) throws BaseException {
		  return DBClaseSindicato.getAllSindicatos(aSesion);
	  }	

}
