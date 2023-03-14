package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBGradoLegajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class GradoLegajo extends ObjetoLogico {

	public GradoLegajo() {
	}

	public static String NICKNAME = "rh.GradoLegajo";

	private String codigo;
	private String descripcion;
	private Boolean activo;
	private Integer cantJuegosA;
	private Integer cantJuegosB;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}
	
	public Integer getCantJuegosA() throws BaseException {
		supportRefresh();
		return this.cantJuegosA;
	}
	
	public void setCantJuegosA(Integer aCantJuegosA) throws BaseException {
		this.cantJuegosA = aCantJuegosA;
	}
	
	public Integer getCantJuegosB() throws BaseException {
		supportRefresh();
		return this.cantJuegosB;
	}
	
	public void setCantJuegosB(Integer aCantJuegosB) throws BaseException {
		this.cantJuegosB = aCantJuegosB;
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

	public static GradoLegajo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GradoLegajo) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static GradoLegajo findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (GradoLegajo) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static GradoLegajo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GradoLegajo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}
	
	public static List getAll(ISesion aSesion) throws BaseException {
		  return DBGradoLegajo.getAll(aSesion);
	}
	

}
