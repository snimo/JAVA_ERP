package com.srn.erp.cip.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ProcPlanifCacheo extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ProcPlanifCacheo() {
	}

	public static String NICKNAME = "cip.ProcPlanifCacheo";

	private java.util.Date fec_proceso;
	private String tipo;
	private Usuario usuario;
	private java.util.Date fec_desde;
	private java.util.Date fec_hasta;
	private Boolean activo;

	public java.util.Date getFec_proceso() throws BaseException {
		supportRefresh();
		return fec_proceso;
	}

	public void setFec_proceso(java.util.Date aFec_proceso) {
		this.fec_proceso = aFec_proceso;
	}

	public String getTipo() throws BaseException {
		supportRefresh();
		return tipo;
	}

	public void setTipo(String aTipo) {
		this.tipo = aTipo;
	}

	public Usuario getUsuario() throws BaseException {
		supportRefresh();
		return usuario;
	}

	public void setUsuario(Usuario aUsuario) {
		this.usuario = aUsuario;
	}

	public java.util.Date getFec_desde() throws BaseException {
		supportRefresh();
		return fec_desde;
	}

	public void setFec_desde(java.util.Date aFec_desde) {
		this.fec_desde = aFec_desde;
	}

	public java.util.Date getFec_hasta() throws BaseException {
		supportRefresh();
		return fec_hasta;
	}

	public void setFec_hasta(java.util.Date aFec_hasta) {
		this.fec_hasta = aFec_hasta;
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

	public static ProcPlanifCacheo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ProcPlanifCacheo) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static ProcPlanifCacheo findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ProcPlanifCacheo) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ProcPlanifCacheo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ProcPlanifCacheo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(fec_proceso, "Debe ingresar la Fecha");
		Validar.noNulo(tipo, "Debe ingresar el Tipo");
		Validar.noNulo(usuario, "Debe ingresar el Usuario");
		Validar.noNulo(fec_desde, "Debe ingresar la Fecha Desde");
		Validar.noNulo(fec_hasta, "Debe ingresar la Fecha Hasta");
	}

}
