package com.srn.erp.mensajero.bm;

import java.util.List;

import com.srn.erp.mensajero.da.DBDestinoMens;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class DestinoMens extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public DestinoMens() {
	}

	public static String NICKNAME = "me.DestinoMens";

	private MensajeCab mensaje;
	private GrupoUsuMens grupo_dest_cab;
	private GrupoMaquina grupo_maquina;
	private Maquina maquina;
	private Usuario usuario;
	private String mail;
	private Boolean activo;

	public MensajeCab getMensaje() throws BaseException {
		supportRefresh();
		return mensaje;
	}

	public void setMensaje(MensajeCab aMensaje) {
		this.mensaje = aMensaje;
	}

	public GrupoUsuMens getGrupo_dest_cab() throws BaseException {
		supportRefresh();
		return grupo_dest_cab;
	}

	public void setGrupo_dest_cab(GrupoUsuMens aGrupo_dest_cab) {
		this.grupo_dest_cab = aGrupo_dest_cab;
	}

	public GrupoMaquina getGrupo_maquina() throws BaseException {
		supportRefresh();
		return grupo_maquina;
	}

	public void setGrupo_maquina(GrupoMaquina aGrupo_maquina) {
		this.grupo_maquina = aGrupo_maquina;
	}

	public Maquina getMaquina() throws BaseException {
		supportRefresh();
		return maquina;
	}

	public void setMaquina(Maquina aMaquina) {
		this.maquina = aMaquina;
	}

	public Usuario getUsuario() throws BaseException {
		supportRefresh();
		return usuario;
	}

	public void setUsuario(Usuario aUsuario) {
		this.usuario = aUsuario;
	}

	public String getMail() throws BaseException {
		supportRefresh();
		return mail;
	}

	public void setMail(String aMail) {
		this.mail = aMail;
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

	public static DestinoMens findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (DestinoMens) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static DestinoMens findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (DestinoMens) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(mensaje, "Debe ingresar el Mensaje");
	}
	
	public static List getDestinatariosMens(MensajeCab mensaje, ISesion aSesion) throws BaseException {
		return DestinoMens.getDestinatariosMens(mensaje,aSesion);
	}
	

}
