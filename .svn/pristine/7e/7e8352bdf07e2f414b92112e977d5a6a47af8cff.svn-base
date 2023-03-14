package com.srn.erp.mensajero.bm;

import java.util.List;

import com.srn.erp.mensajero.da.DBGruDetUsuMens;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GruDetUsuMens extends ObjetoLogico {

	public GruDetUsuMens() {
	}

	public static String NICKNAME = "me.GruDetUsuMens";

	private GrupoUsuMens grupo_dest_cab;
	private Usuario usuario;
	private Boolean activo;

	public GrupoUsuMens getGrupo_dest_cab() throws BaseException {
		supportRefresh();
		return grupo_dest_cab;
	}

	public void setGrupo_dest_cab(GrupoUsuMens aGrupo_dest_cab) {
		this.grupo_dest_cab = aGrupo_dest_cab;
	}

	public Usuario getUsuario() throws BaseException {
		supportRefresh();
		return usuario;
	}

	public void setUsuario(Usuario aUsuario) {
		this.usuario = aUsuario;
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

	public static GruDetUsuMens findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GruDetUsuMens) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static GruDetUsuMens findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (GruDetUsuMens) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static GruDetUsuMens findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GruDetUsuMens) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(grupo_dest_cab, "Debe ingresar el Grupo");
		Validar.noNulo(usuario, "Debe ingresar el usuario");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getGrupoDetUsuarios(GrupoUsuMens grupoUsuMens, ISesion aSesion) throws BaseException {
		return DBGruDetUsuMens.getGrupoDetUsuarios(grupoUsuMens, aSesion);
	}

}
