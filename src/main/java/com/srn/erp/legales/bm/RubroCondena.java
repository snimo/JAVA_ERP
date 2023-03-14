package com.srn.erp.legales.bm;

import com.srn.erp.legales.da.DBRubroCondena;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class RubroCondena extends ObjetoLogico {

	public RubroCondena() {
	}

	public static String NICKNAME = "leg.RubroCondena";

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

	public static RubroCondena findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RubroCondena) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static RubroCondena findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (RubroCondena) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}	

	public static RubroCondena findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RubroCondena) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}
	
	public static RubroCondena getRubroCadena(String descripcion, ISesion aSesion) throws BaseException {
		return DBRubroCondena.getRubroCadena(descripcion,aSesion);
	}
	

}
