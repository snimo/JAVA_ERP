package com.srn.erp.mensajero.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoUsuMens extends ObjetoLogico {

	public GrupoUsuMens() {
	}

	public static String NICKNAME = "me.GrupoUsuMens";

	private String nombre;
	private String scope;
	private Usuario usuario_priveado;
	private Boolean activo;

	private List detallesGrupo = new ArrayList();
	private boolean readDetallesGrupo = true;

	public String getNombre() throws BaseException {
		supportRefresh();
		return nombre;
	}

	public void setNombre(String aNombre) {
		this.nombre = aNombre;
	}

	public String getScope() throws BaseException {
		supportRefresh();
		return scope;
	}

	public void setScope(String aScope) {
		this.scope = aScope;
	}

	public Usuario getUsuario_priveado() throws BaseException {
		supportRefresh();
		return usuario_priveado;
	}

	public void setUsuario_priveado(Usuario aUsuario_priveado) {
		this.usuario_priveado = aUsuario_priveado;
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

	public static GrupoUsuMens findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoUsuMens) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoUsuMens findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoUsuMens) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static GrupoUsuMens findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoUsuMens) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(nombre, "Debe ingresar el Nombre");
		Validar.noNulo(scope, "Debe ingresar el Scope");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return this.getNombre();
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getNombre();
	}

	public List getDetUsuGrupo() throws BaseException {
		if (this.readDetallesGrupo) {
			List listaDetGrupoUsu = GruDetUsuMens.getGrupoDetUsuarios(this, getSesion());
			detallesGrupo.addAll(listaDetGrupoUsu);
			this.readDetallesGrupo = false;
		}
		return detallesGrupo;
	}

	public void addDetUsuGrupo(GruDetUsuMens aGruDetUsuMens) throws BaseException {
		aGruDetUsuMens.setGrupo_dest_cab(this);
		detallesGrupo.add(aGruDetUsuMens);
	}

	public void afterSave() throws BaseException {
		Iterator iterGruposUsuMens = this.detallesGrupo.iterator();
		while (iterGruposUsuMens.hasNext()) {
			GruDetUsuMens gruDetUsuMens = (GruDetUsuMens) iterGruposUsuMens.next();
			gruDetUsuMens.save();
			gruDetUsuMens = null;
		}
		iterGruposUsuMens = null;
	}

}
