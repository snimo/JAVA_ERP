package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBEquivalenciaEstadoCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EquivalenciaEstadoCIP extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public EquivalenciaEstadoCIP() {
	}

	public static String NICKNAME = "cip.EquivalenciaEstadoCIP";

	private EstadoCIP estado;
	private String codigo_externo;
	private Boolean activo;

	public EstadoCIP getEstado() throws BaseException {
		supportRefresh();
		return estado;
	}

	public void setEstado(EstadoCIP aEstado) {
		this.estado = aEstado;
	}

	public String getCodigo_externo() throws BaseException {
		supportRefresh();
		return codigo_externo;
	}

	public void setCodigo_externo(String aCodigo_externo) {
		this.codigo_externo = aCodigo_externo;
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

	public static EquivalenciaEstadoCIP findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EquivalenciaEstadoCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EquivalenciaEstadoCIP findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EquivalenciaEstadoCIP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(estado, "Debe ingresar el Estado");
		Validar.noNulo(codigo_externo, "Debe ingresar el Código Externo");
	}

	public static List getEquivalenciasEstado(EstadoCIP estado, ISesion aSesion) throws BaseException {
		return DBEquivalenciaEstadoCIP.getEquivalenciasEstado(estado, aSesion);
	}

}
