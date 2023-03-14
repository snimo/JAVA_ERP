package com.srn.erp.legales.bm;

import java.util.List;

import com.srn.erp.legales.da.DBEstadoProcesal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class EstadoProcesal extends ObjetoLogico {

	public EstadoProcesal() {
	}

	public static String NICKNAME = "leg.EstadoProcesal";

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

	public static EstadoProcesal findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadoProcesal) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static EstadoProcesal findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadoProcesal) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static EstadoProcesal findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EstadoProcesal) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}
	
	public static List getEstadosProcesales(ISesion aSesion) throws BaseException {
		  return DBEstadoProcesal.getEstadosProcesales(aSesion);
	}
	
	public static EstadoProcesal getEstadoProcesal(String descripcion,
	          ISesion aSesion)
	          throws BaseException {
		  return DBEstadoProcesal.getEstadoProcesal(descripcion,aSesion);
	}	

}
