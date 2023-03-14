package com.srn.erp.mensajero.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MensajeCab extends ObjetoLogico {

	private List destinatarios = new ArrayList();
	private boolean readDestinatarios = true;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public MensajeCab() {
	}

	public static String NICKNAME = "me.MensajeCab";

	private String identificador;
	private String asunto;
	private String cuerpo;
	private Usuario usuario;
	private java.util.Date fec_envio;
	private String hor_envio;
	private Boolean enviar_mail;
	private String importancia;
	private Boolean solicitar_conf_lec;
	private Boolean activo;
	private Boolean enviar_pop_up;
	private Integer dur_seg_pop_up;
	private Boolean enviar_mens_int;
	private Boolean enviar_chat;
	private Boolean send_to_all_connec;

	public String getIdentificador() throws BaseException {
		supportRefresh();
		return identificador;
	}

	public void setIdentificador(String aIdentificador) {
		this.identificador = aIdentificador;
	}

	public String getAsunto() throws BaseException {
		supportRefresh();
		return asunto;
	}

	public void setAsunto(String aAsunto) {
		this.asunto = aAsunto;
	}

	public String getCuerpo() throws BaseException {
		supportRefresh();
		return cuerpo;
	}

	public void setCuerpo(String aCuerpo) {
		this.cuerpo = aCuerpo;
	}

	public Usuario getUsuario() throws BaseException {
		supportRefresh();
		return usuario;
	}

	public void setUsuario(Usuario aUsuario) {
		this.usuario = aUsuario;
	}

	public java.util.Date getFec_envio() throws BaseException {
		supportRefresh();
		return fec_envio;
	}

	public void setFec_envio(java.util.Date aFec_envio) {
		this.fec_envio = aFec_envio;
	}

	public String getHor_envio() throws BaseException {
		supportRefresh();
		return hor_envio;
	}

	public void setHor_envio(String aHor_envio) {
		this.hor_envio = aHor_envio;
	}

	public Boolean isEnviar_mail() throws BaseException {
		supportRefresh();
		return enviar_mail;
	}

	public void setEnviar_mail(Boolean aEnviar_mail) {
		this.enviar_mail = aEnviar_mail;
	}

	public String getImportancia() throws BaseException {
		supportRefresh();
		return importancia;
	}

	public void setImportancia(String aImportancia) {
		this.importancia = aImportancia;
	}

	public Boolean isSolicitar_conf_lec() throws BaseException {
		supportRefresh();
		return solicitar_conf_lec;
	}

	public void setSolicitar_conf_lec(Boolean aSolicitar_conf_lec) {
		this.solicitar_conf_lec = aSolicitar_conf_lec;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public Boolean isEnviar_pop_up() throws BaseException {
		supportRefresh();
		return enviar_pop_up;
	}

	public void setEnviar_pop_up(Boolean aEnviar_pop_up) {
		this.enviar_pop_up = aEnviar_pop_up;
	}

	public Integer getDur_seg_pop_up() throws BaseException {
		supportRefresh();
		return dur_seg_pop_up;
	}

	public void setDur_seg_pop_up(Integer aDur_seg_pop_up) {
		this.dur_seg_pop_up = aDur_seg_pop_up;
	}

	public Boolean isEnviar_mens_int() throws BaseException {
		supportRefresh();
		return enviar_mens_int;
	}

	public void setEnviar_mens_int(Boolean aEnviar_mens_int) {
		this.enviar_mens_int = aEnviar_mens_int;
	}

	public Boolean isEnviar_chat() throws BaseException {
		supportRefresh();
		return enviar_chat;
	}

	public void setEnviar_chat(Boolean aEnviar_chat) {
		this.enviar_chat = aEnviar_chat;
	}

	public Boolean isSend_to_all_connec() throws BaseException {
		supportRefresh();
		return send_to_all_connec;
	}

	public void setSend_to_all_connec(Boolean aSend_to_all_connec) {
		this.send_to_all_connec = aSend_to_all_connec;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static MensajeCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MensajeCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MensajeCab findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (MensajeCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static MensajeCab findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MensajeCab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(asunto, "Debe ingresar el asunto");
		Validar.noNulo(fec_envio, "Debe ingresar la Fecha de Envío");
		Validar.noNulo(hor_envio, "Debe ingresar la Hora de Envío");
	}

	public List getDestinatarios() throws BaseException {
		if (this.readDestinatarios) {
			List listaDestinatarios = DestinoMens.getDestinatariosMens(this, getSesion());
			this.destinatarios.addAll(listaDestinatarios);
			readDestinatarios = false;
		}
		return this.destinatarios;
	}

	public void addDestinario(DestinoMens aDestinoMens) throws BaseException {
		aDestinoMens.setMensaje(this);
		this.destinatarios.add(aDestinoMens);
	}

	public void afterSave() throws BaseException {
		Iterator iterDestinatarios = this.destinatarios.iterator();
		while (iterDestinatarios.hasNext()) {
			DestinoMens destinatario = (DestinoMens) iterDestinatarios.next();
			destinatario.save();
			destinatario = null;
		}
		iterDestinatarios = null;
	}

}
