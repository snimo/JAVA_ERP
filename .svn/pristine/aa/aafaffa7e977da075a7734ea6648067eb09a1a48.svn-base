package com.srn.erp.mensajero.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class Maquina extends ObjetoLogico {

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return this.getNombre();
	}

	public Maquina() {
	}

	public static String NICKNAME = "me.Maquina";

	private String nombre;
	private String descripcion;
	private Boolean es_ip_dinamica;
	private String ip;
	private Boolean activa;

	public String getNombre() throws BaseException {
		supportRefresh();
		return nombre;
	}

	public void setNombre(String aNombre) {
		this.nombre = aNombre;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public Boolean isEs_ip_dinamica() throws BaseException {
		supportRefresh();
		return es_ip_dinamica;
	}

	public void setEs_ip_dinamica(Boolean aEs_ip_dinamica) {
		this.es_ip_dinamica = aEs_ip_dinamica;
	}

	public String getIp() throws BaseException {
		supportRefresh();
		return ip;
	}

	public void setIp(String aIp) {
		this.ip = aIp;
	}

	public Boolean isActiva() throws BaseException {
		supportRefresh();
		return activa;
	}

	public void setActiva(Boolean aActiva) {
		this.activa = aActiva;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static Maquina findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Maquina) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static Maquina findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (Maquina) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static Maquina findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Maquina) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

}
