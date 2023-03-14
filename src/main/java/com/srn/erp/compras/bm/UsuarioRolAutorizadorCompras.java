package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBUsuarioRolAutorizadorCompras;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class UsuarioRolAutorizadorCompras extends ObjetoLogico {

	public UsuarioRolAutorizadorCompras() {
	}

	public static String NICKNAME = "cp.UsuarioRolAutorizadorCompras";

	private RolAutorizadorCompras rol_autorizador;

	private Usuario usuario;

	public RolAutorizadorCompras getRol_autorizador() throws BaseException {
		supportRefresh();
		return rol_autorizador;
	}

	public void setRol_autorizador(RolAutorizadorCompras aRol_autorizador) {
		this.rol_autorizador = aRol_autorizador;
	}

	public Usuario getUsuario() throws BaseException {
		supportRefresh();
		return usuario;
	}

	public void setUsuario(Usuario aUsuario) {
		this.usuario = aUsuario;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static UsuarioRolAutorizadorCompras findByOid(Integer oid,
			ISesion aSesion) throws BaseException {
		return (UsuarioRolAutorizadorCompras) getObjectByOid(NICKNAME, oid,
				aSesion);
	}

	public static UsuarioRolAutorizadorCompras findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (UsuarioRolAutorizadorCompras) getObjectByCodigo(NICKNAME,
				codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(rol_autorizador, "Debe ingresar el Rol Autorizador");
		Validar.noNulo(usuario, "Debe ingresar el Usuario");
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getUsuariosRol(RolAutorizadorCompras rolAutorizador,
			ISesion aSesion) throws BaseException {
		return DBUsuarioRolAutorizadorCompras.getUsuariosRol(rolAutorizador,
				aSesion);
	}

	public static UsuarioRolAutorizadorCompras getUsuarioRol(Usuario usuario,RolAutorizadorCompras rol,
          	ISesion aSesion)
          	throws BaseException {
	  return DBUsuarioRolAutorizadorCompras.getUsuarioRol(usuario,rol,aSesion);
    }
}
