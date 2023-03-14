package com.srn.erp.mensajero.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class InboxMensUsu extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public InboxMensUsu() {
	}

	public static String NICKNAME = "me.InboxMensUsu";

	private Usuario usuario;
	private MensajeCab mensaje;
	private Boolean leido;
	private Boolean eliminado;
	private Boolean depurado;
	private java.util.Date fec_recibido;
	private String hora_recibido;
	private Boolean activo;

	public Usuario getUsuario() throws BaseException {
		supportRefresh();
		return usuario;
	}

	public void setUsuario(Usuario aUsuario) {
		this.usuario = aUsuario;
	}

	public MensajeCab getMensaje() throws BaseException {
		supportRefresh();
		return mensaje;
	}

	public void setMensaje(MensajeCab aMensaje) {
		this.mensaje = aMensaje;
	}

	public Boolean isLeido() throws BaseException {
		supportRefresh();
		return leido;
	}

	public void setLeido(Boolean aLeido) {
		this.leido = aLeido;
	}

	public Boolean isEliminado() throws BaseException {
		supportRefresh();
		return eliminado;
	}

	public void setEliminado(Boolean aEliminado) {
		this.eliminado = aEliminado;
	}

	public Boolean isDepurado() throws BaseException {
		supportRefresh();
		return depurado;
	}

	public void setDepurado(Boolean aDepurado) {
		this.depurado = aDepurado;
	}

	public java.util.Date getFec_recibido() throws BaseException {
		supportRefresh();
		return fec_recibido;
	}

	public void setFec_recibido(java.util.Date aFec_recibido) {
		this.fec_recibido = aFec_recibido;
	}

	public String getHora_recibido() throws BaseException {
		supportRefresh();
		return hora_recibido;
	}

	public void setHora_recibido(String aHora_recibido) {
		this.hora_recibido = aHora_recibido;
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

	public static InboxMensUsu findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (InboxMensUsu) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static InboxMensUsu findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (InboxMensUsu) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(usuario, "Debe ingresar el Usuario");
		Validar.noNulo(mensaje, "Debe ingresar el Mensaje");
		Validar.noNulo(fec_recibido, "Debe ingresar la Fecha de Recepción");
		Validar.noNulo(hora_recibido, "Debe ingresar la hora");
	}

}
