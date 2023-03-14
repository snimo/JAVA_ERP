package com.srn.erp.conciTarjeta.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CabConciAutomatica extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public CabConciAutomatica() {
	}

	public static String NICKNAME = "ctar.CabConciAutomatica";

	private Usuario usuario;
	private java.util.Date fecha;
	private String hora;
	private Boolean activo;

	public Usuario getUsuario() throws BaseException {
		supportRefresh();
		return usuario;
	}

	public void setUsuario(Usuario aUsuario) {
		this.usuario = aUsuario;
	}

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}

	public String getHora() throws BaseException {
		supportRefresh();
		return hora;
	}

	public void setHora(String aHora) {
		this.hora = aHora;
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

	public static CabConciAutomatica findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CabConciAutomatica) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static CabConciAutomatica findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CabConciAutomatica) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}	

	public static CabConciAutomatica findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CabConciAutomatica) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(usuario, "Debe ingresar el Usuario");
		Validar.noNulo(fecha, "Debe ingresar la Fecha");
		Validar.noNulo(hora, "Debe ingresar la Hora");
	}

}
