package com.srn.erp.legales.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CompaniaSeguro extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getNombre();
	}

	public CompaniaSeguro() {
	}

	public static String NICKNAME = "leg.CompaniaSeguro";

	private String nombre;
	private Boolean es_caucion;
	private Boolean activo;

	public String getNombre() throws BaseException {
		supportRefresh();
		return nombre;
	}

	public void setNombre(String aNombre) {
		this.nombre = aNombre;
	}

	public Boolean isEs_caucion() throws BaseException {
		supportRefresh();
		return es_caucion;
	}

	public void setEs_caucion(Boolean aEs_caucion) {
		this.es_caucion = aEs_caucion;
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

	public static CompaniaSeguro findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CompaniaSeguro) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static CompaniaSeguro findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CompaniaSeguro) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}	

	public static CompaniaSeguro findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CompaniaSeguro) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(nombre, "Debe ingresar el Nombre");
	}

}
