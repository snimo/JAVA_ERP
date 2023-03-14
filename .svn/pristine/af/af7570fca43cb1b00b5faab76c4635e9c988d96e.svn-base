package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBTareaDesempeneada;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TareaDesempeneada extends ObjetoLogico {

	public TareaDesempeneada() {
	}

	public static String NICKNAME = "rh.TareaDesempeneada";

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

	public static TareaDesempeneada findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TareaDesempeneada) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static TareaDesempeneada findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TareaDesempeneada) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}	

	public static TareaDesempeneada findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TareaDesempeneada) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}
	
	  public static List getAllTareas(
	          ISesion aSesion) throws BaseException {
		  return DBTareaDesempeneada.getAllTareas(aSesion);
	  }	

}
