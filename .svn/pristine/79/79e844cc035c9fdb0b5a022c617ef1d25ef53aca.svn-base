package com.srn.erp.compras.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.da.DBRolAutorizadorCompras;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RolAutorizadorCompras extends ObjetoLogico {

	public RolAutorizadorCompras() {
	}

	public static String NICKNAME = "cp.RolAutorizadorCompras";

	private String codigo;

	private String descripcion;

	private Boolean activo;

	private List usuariosRol = new ArrayList();

	private boolean readUsuariosRol = true;

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

	public static RolAutorizadorCompras findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (RolAutorizadorCompras) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RolAutorizadorCompras findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (RolAutorizadorCompras) getObjectByOidProxy(NICKNAME, oid,
				aSesion);
	}

	public static RolAutorizadorCompras findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (RolAutorizadorCompras) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

	public List getUsuariosRol() throws BaseException {
		if (readUsuariosRol) {
			List listaUsuariosRol = UsuarioRolAutorizadorCompras.getUsuariosRol(this,
					getSesion());
			usuariosRol.addAll(listaUsuariosRol);
			readUsuariosRol = false;
		}
		return usuariosRol;
	}

	public void addUsuarioRolAutorizador(UsuarioRolAutorizadorCompras usuRolAutorizCompras)
			throws BaseException {
		usuRolAutorizCompras.setRol_autorizador(this);
		usuariosRol.add(usuRolAutorizCompras);
	}

	public void afterSave() throws BaseException {
		Iterator iterUsuariosRolAutoriz = usuariosRol.iterator();
		while (iterUsuariosRolAutoriz.hasNext()) {
			UsuarioRolAutorizadorCompras usuarioRol = (UsuarioRolAutorizadorCompras) iterUsuariosRolAutoriz.next();
			usuarioRol.save();
			usuarioRol = null;
		}
		iterUsuariosRolAutoriz = null;
	}
	
	public boolean tieneElRol(Usuario usuario) throws BaseException {
		UsuarioRolAutorizadorCompras usuRolAutoriz = UsuarioRolAutorizadorCompras.getUsuarioRol(usuario,this,getSesion());
		if (usuRolAutoriz != null)
			return true;
		else
			return false;
	}
	
	public static List getRolesComprasByUsuario(Usuario usuario, ISesion aSesion) throws BaseException {
		return DBRolAutorizadorCompras.getRolesComprasByUsuario(usuario,aSesion);
	}
	

}
